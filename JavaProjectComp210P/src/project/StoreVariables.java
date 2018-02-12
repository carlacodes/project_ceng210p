package project;

public class StoreVariables {
	
	
	 RunApp call0 = new RunApp();
	 int NumberOfMember = call0.CreateProjectNumberofMembers();
	 String ProjectName = call0.CreateProjectTitle();
     String[] TeamMember = call0.CreateProjectNamesofMembers(); 
	 
	 public void setNumberofMember (int theNumberOfMember)
	   {
	      NumberOfMember = theNumberOfMember;
	   }
	 
	 public void setProjectName (String theProjectName) {
		 ProjectName = theProjectName;
		 
	 }
	 
	 public void setTeamMember (String[] theTeamMember) {
		TeamMember = theTeamMember;
		 
	 }
    
   
}
