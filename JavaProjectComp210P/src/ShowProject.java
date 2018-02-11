
import java.util.Scanner;

public class ShowProject {
	
	
	 String option; //Declaring the strings representing the menu option buttons
	 int NumberOfMember; 	//Entering the number of members
	 String[] TeamMember; //Declaring the strings representing the names of the members
	  String ProjectName; 	// Declaring the project name variable as a string
	  boolean CorrectInput; 	//Booleans CorrectInput, which determines whether the user has entered a valid input and ShowMenu, which determines whether the main menu is displayed again
	 Scanner scan = new Scanner(System.in);	// Importing the scanner tool
    
    public void allVariables()
    {
    	CorrectInput = true; 
    	
        RunApp call = new RunApp();
        NumberOfMember= call.CreateProjectNumberofMembers();
        
        RunApp call2 = new RunApp();
        ProjectName = call2.CreateProjectTitle();
        
        RunApp call3 = new RunApp();
        TeamMember[NumberOfMember] = call3.CreateProjectNamesofMembers(); 
        
    	System.out.println("Number of members: " + NumberOfMember); 
    	System.out.println("Project name: " + ProjectName); 
    	for (int Counter = 1; Counter <= NumberOfMember; Counter ++) //Returning each team member's name and corresponding member number
    	{
    		System.out.println("Name of member " + Counter + " : " + TeamMember[Counter - 1]);
    	}
		
    }
}
    	
    

