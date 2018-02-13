package project;

public class StoreVariables {
	
	
	
	 private int NumberOfMember;
	 private String ProjectName;
     private String[] TeamMember;
	 
	 public void setNumberofMember (int theNumberOfMember)
	   {
	      NumberOfMember = theNumberOfMember;
	   }
	 
	 public String setProjectName (String theProjectName) {
		 ProjectName = theProjectName;
		 return theProjectName;
		 
	 }
	 
	 public String[] setTeamMember (String[] theTeamMember) {
		TeamMember = theTeamMember;
		return theTeamMember;
		 
	 }
	 
	 public int getNumberofMember()
	 {
		 return NumberOfMember;
	 }
	 
	 public String getProjectName()
	 {
		 System.out.println(ProjectName);
		 return ProjectName;
	 }
	 
	 public String[] getTeamMember()
	 {
		 System.out.println(TeamMember);
		 return TeamMember;
		 
	 }
    
   
}
