
package project;
import java.util.ArrayList;
import java.util.Scanner; 

public class StoreVariables {
	
     private int NumberOfMember;
	 private ArrayList<String> ProjectName;
	 public int index;
     private String[] TeamMember;
     private int NumberOfProjects;
     Scanner scan = new Scanner(System.in);
    StoreVariables(){
    	NumberOfMember = 1;
    	index=0;
    	
    	//ProjectName[1] = "ha ha ha ha at my life choices"; //Test to see if the class is being called correctly
    	
    }
	 public int setNumberofMember (int theNumberOfMember)
	   {
	      NumberOfMember = theNumberOfMember;
	      return theNumberOfMember;
	   }
	 
	 public ArrayList<String> setProjectName (ArrayList<String> theProjectName) {
		 //ProjectName[NumberOfProjects] = theProjectName[NumberOfProjects];
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
	 
	 public ArrayList<String> getProjectName(ArrayList<String> theProjectName)
	 {
		 
		//ProjectName=theProjectName;
		 return theProjectName;
	 }
	 
	 public String[] getTeamMember()
	 {
		
		 return TeamMember;
		 
	 }
}
    
   


