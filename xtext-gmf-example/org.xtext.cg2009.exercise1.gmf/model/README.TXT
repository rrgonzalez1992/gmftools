How to get the Xtext / GMF example running:

0) Prerequisites: 
	- JRE 6 or higher
	- Eclipse Galileo distribution including
	  Xtext 0.7.1, GMF 
1) Checkout the source code
2) Generate the Xtext code by running the workflow
	/org.xtext.cg2009.exercise1.solution/src/org/xtext/cg2009/GenerateEntities.mwe
   as an MWE Workflow
3) Generate the EMF Edit plug-in by opening 
	/org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/Entities.genmodel
   And choosing "Generate Edit Code" from the context menu of the root element.
4) Generate the GMF code by choosing "Generate diagram code" on
 	/org.xtext.cg2009.exercise1.gmf/model/Entities.transformed.gmfgen
   Even though I used GMFTools (http://code.google.com/p/gmftools/) for creating the example, it is neither necessary to generate the code nor to run the example. 
5) Run a new Eclipse instance
	- Create a project with an new .entity file
	- Define some entity and save
	- Right-click on the file in the navigator and choose "Initialize new Entities diagram..." 

Known limitations
- Due to GMF bug 
	http://bugs.eclipse.org/bugs/show_bug.cgi?id=281014
  the diagram lacks canoncial elements after restart
- Due to bug
    https://bugs.eclipse.org/bugs/show_bug.cgi?id=284850
  you cannot start from an empty diagram. This is partly fixed in the CVS HEAD version.
