package project;

public class StoreVariables {
	
     private int NumberOfMember;
	 private String ProjectName;
     private String[] TeamMember;
     private int[][] Votes;
     
     public StoreVariables(){ //initializing variables using a constructor
    	NumberOfMember = 1;
    	
    	ProjectName = "ha ha ha ha at my life choices"; //Test to see if the class is being called correctly
    	
    }
	 public int setNumberofMember (int theNumberOfMember)
	   {
	      NumberOfMember = theNumberOfMember;
	      return theNumberOfMember;
	   }
	 
	 public int[][] setVotes (int[][] theVotes)
	   {
	      Votes = theVotes;
	      return theVotes;
	   }
	 
	 public String setProjectName (String theProjectName) {
		 ProjectName = theProjectName;
		 return theProjectName;
		 
	 }
	 
	 public String[] setTeamMember (String[] theTeamMember) {
		TeamMember = theTeamMember;
		return theTeamMember;
		 
	 }
	 
	 public int getNumberofMember(int NumberOfMember)
	 {
		 return NumberOfMember;
	 }
	 
	 public String getProjectName(String ProjectName)
	 {
		
		 return ProjectName;
	 }
	 
	 public String[] getTeamMember()
	 {
		
		 return TeamMember;
		 
	 }
	 public int[][] getVotes (int theVotes[][])
	   {
		
	      return theVotes;
	   }
	
    
   
}
