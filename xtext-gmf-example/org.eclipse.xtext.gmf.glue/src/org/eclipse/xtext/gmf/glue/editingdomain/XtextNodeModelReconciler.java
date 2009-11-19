package org.eclipse.xtext.gmf.glue.editingdomain;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomainEvent;
import org.eclipse.emf.transaction.TransactionalEditingDomainListener;
import org.eclipse.emf.transaction.TransactionalEditingDomain.Lifecycle;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.xtext.gmf.glue.Activator;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.NodeAdapter;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.parsetree.reconstr.SerializerUtil;
import org.eclipse.xtext.resource.XtextResource;

/**
 * Reconciles the node models of all XtextResources in a
 * TransactionalEditingDomain with semantic changes.
 * 
 * @author koehnlein
 */
public class XtextNodeModelReconciler extends AdapterImpl implements
		TransactionalEditingDomainListener {

	private TransactionalEditingDomain editingDomain;

	private ChangeAggregatorAdapter changeAggregator;

	// Oh my god: GMF opens another root transaction for the post commit
	// listeners before closing the last one. As no changes are neither
	// recorded nor rolled back in this transaction, we just ignore it
	private List<Transaction> openTransactions = new ArrayList<Transaction>();

	private XtextNodeModelReconciler(TransactionalEditingDomain editingDomain) {
		this.editingDomain = editingDomain;
		Lifecycle lifecycle = TransactionUtil.getAdapter(editingDomain,
				Lifecycle.class);
		lifecycle.addTransactionalEditingDomainListener(this);
		changeAggregator = new ChangeAggregatorAdapter();
		editingDomain.getResourceSet().eAdapters().add(changeAggregator);
	}

	public void editingDomainDisposing(TransactionalEditingDomainEvent event) {
		changeAggregator.endRecording();
		editingDomain.getResourceSet().eAdapters().remove(changeAggregator);
		Lifecycle lifecycle = TransactionUtil.getAdapter(editingDomain,
				Lifecycle.class);
		lifecycle
				.removeTransactionalEditingDomainListener(XtextNodeModelReconciler.this);
	}

	public void transactionClosed(TransactionalEditingDomainEvent event) {
		openTransactions.remove(openTransactions.size() - 1);
		if (openTransactions.isEmpty()) {
			changeAggregator.endRecording();
			IStatus status = event.getTransaction().getStatus();
			if (status.isOK()) {
				for (EObject modificationRoot : changeAggregator
						.getModificationRoots()) {
					try {
						XtextResource xtextResource = (XtextResource) modificationRoot
								.eResource();
						NodeAdapter nodeAdapter = NodeUtil
								.getNodeAdapter(modificationRoot);
						CompositeNode parserNode = nodeAdapter.getParserNode();
						SerializerUtil serializer = xtextResource
								.getSerializer();
						String newText = serializer.serialize(modificationRoot);
						UpdateXtextResourceTextCommand.createICommand(
								xtextResource, parserNode.getOffset(),
								parserNode.getLength(), newText).execute(null,
								null);
					} catch (ExecutionException exc) {
						Activator.logError(exc);
					}
				}
			}
		}
	}

	public void transactionClosing(TransactionalEditingDomainEvent event) {
		// ignore
	}

	public void transactionInterrupted(TransactionalEditingDomainEvent event) {
		openTransactions.remove(openTransactions.size() - 1);
		if (openTransactions.isEmpty()) {
			changeAggregator.endRecording();
		}
	}

	public void transactionStarted(TransactionalEditingDomainEvent event) {
		openTransactions.add(event.getTransaction());
		if (openTransactions.size() == 1) {
			changeAggregator.beginRecording();
		}
	}

	public void transactionStarting(TransactionalEditingDomainEvent event) {
		// ignore
	}

	public static XtextNodeModelReconciler adapt(
			TransactionalEditingDomain editingDomain) {
		XtextNodeModelReconciler adapter = (XtextNodeModelReconciler) EcoreUtil
				.getAdapter(editingDomain.getResourceSet().eAdapters(),
						XtextNodeModelReconciler.class);
		if (adapter == null) {
			adapter = new XtextNodeModelReconciler(editingDomain);
		}
		return adapter;
	}

}
