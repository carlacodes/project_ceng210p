//Option Q
//Option V

package project;	

import java.util.ArrayList;
///------------------------------------------------------------
	///
	///LOUIS NGUYEN CARLA GRIFFITHS COMP210P PROJECT, DELIVERABLE 1
	///
	///------------------------------------------------------------
	import java.util.Scanner; 			//Importing the scanner tool 
import java.util.stream.IntStream; //for summing arrays
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat; 	//Importing the decimal tool

	public class Project
	{ArrayList<ProjectProp> ProjectList = new ArrayList <ProjectProp>();
	private static int i = 0;
		public static void main(String[] args)
	    {
			Project run = new Project();
			run.StartMenu();	
	    }
		
	    	public static String option; //Declaring the strings representing the menu option buttons
	    	private static int NumberOfMember; 	//Entering the number of members
	    	
	    	public static int index=NumberOfMember; //used for later, declaring a square matrix
	    	public static String[] TeamMember; //Declaring the strings representing the names of the members
	    	public static int[][] Vote;
	    	
	    	public static  String ProjectName; 	// Declaring the project name variable as a string
	    	private static boolean CorrectInput, ShowMenu; 	//Booleans CorrectInput, which determines whether the user has entered a valid input and ShowMenu, which determines whether the main menu is displayed again
	    	static Scanner scan = new Scanner(System.in); 	// Importing the scanner tool
	        DecimalFormat twoDecPlcFormatter = new DecimalFormat("0.00");  //Although not used currently, having a decimal formatter could come in handy later
	        //----------------------------------------------
	        //Declaration of StartMenu(): listing Menu Options and equalsIgnoreCase to accept either upper or lower case
	        //----------------------------------------------
	    	   
	        	public void StartMenu()   			
	    	    {          
	    	      Scanner scan = new Scanner(System.in);
	    	      ArrayList<ProjectProp> ProjectList = new ArrayList <ProjectProp>();
	    	      System.out.println(); 					
	    	      System.out.print("\nWelcome to Splitit ");
	    	      do
	    	      {
	    	    	  printMenu();
	    	    	  char input = scan.next().charAt(0);  			//Asking user to input a character
	    	      	  option = Character.toString(input);			//Converting from characters to string 
	    	      	  checkInput(option);    	      	  
	    	      }
	    	      while (CorrectInput == false || ShowMenu == true); //Run StartMenu() while either the CorrectInput is false or ShowMenu is true 
	    	    }
	    	    //----------------------------------------------
	        	//Declaration of checkInput(String OneInput) method
	        	//----------------------------------------------
	    	    private void checkInput(String OneInput)
	    	    {
	    	    	if (OneInput.equalsIgnoreCase("A") == true) 	
	  	          {
	  	              About();              
	  	          }
	    	    	else if (OneInput.equalsIgnoreCase("C") == true) 
	    	    		
	  	      	  {
	    	    		CreateNewProjectArray();
	  	      	  }
	    	    	else if (OneInput.equalsIgnoreCase("V") == true) 
	  	      	  {
	  	      		  EnterVotes();      		  
	  	      	  }
	    	    	else if (OneInput.equalsIgnoreCase("S") == true) 
	  	      	  {
	  	      		  ShowProject();      		  
	  	      	  }
	    	    	else if (OneInput.equalsIgnoreCase("Q") == true) 
	  	      	  {
	  	      		  Quit();
	  	      	  }
	    	    	
	    	    	else
	  	      	  {
	  	      		  System.out.print("\tIncorrect input. "); //If the user has entered an incorrect input, force them to enter in correct input
	  	      		  CorrectInput = false;
	  	      	  }
	    	    }
	    	    private void printMenu()
	    	    {
	    	    	System.out.println("\n\n\tAbout\t\t(A)"); 	
	    	    	System.out.println("\tCreate Project\t(C)");
	    	    	System.out.println("\tEnter Votes\t(V)");
	    	    	System.out.println("\tShow Project\t(S)");
	    	    	System.out.println("\tQuit\t\t(Q)");
	    	    	System.out.print("\n\tPlease choose an option: ");   
	    	    }
	    	          
	    	//----------------------------------------------
	    	//Declaration of About() method
	    	//----------------------------------------------      
	    	    public void About() 
	    	    {
	    	    	System.out.println("\tThis is a program designed to assign grades for a project based on each member's \n \tparticipation developed by Carla Griffiths and Louis Nguyen. ");	    	        
	    	    }      	
	    	    
	    	  //----------------------------------------------
		    	//Declaration of CreateProjectArray() method
		    	//----------------------------------------------    
	    	    public void CreateNewProjectArray(){
	    	    	
					ProjectList.add(new ProjectProp());
					//ProjectProp create = new ProjectProp();
					ProjectList.get(i).CreateProjectTitle();
					i++;
					
					// ProjectList.CreateProjectTitle();
					//for (int i=0; i<ProjectList.size(); i++){
					    //ProjectList.get(i).CreateProjectTitle();//this will set names in format newNameX
					    ///EXTRA--ADDED IN TO TEST THE SIZE OF THE LIST ARRAY
					    System.out.println("Number of Projects Created: " + ProjectList.size());
						//System.out.println("Number of members: " + ProjectList.CreateProjectNumberofMembers()); 
					    
					//}
	    	    }
	    	//----------------------------------------------
	    	//Declaration of ShowProject()
	    	//----------------------------------------------    
	    	    public void ShowProject()
	    	    {
	    	    	CorrectInput = true; 	
	    	    	ShowMenu = true; 
	    	    	
	    	    	StoreVariables getThings = new StoreVariables();
	
	    	    	System.out.println("Number of members: " + getThings.getNumberofMember(NumberOfMember)); 
					System.out.println("Project name: " + getThings.getProjectName(ProjectName));
					
					
	    	    	String[] abc = getThings.getTeamMember();
	    	    	for (int Counter = 1; Counter <= NumberOfMember; Counter ++) //Returning each team member's name and corresponding member number
	    	    	{
	    	    		System.out.println("Name of member " + Counter + " : " + getTeamMemberName(Counter));
	    	    	}	
	    	    	
	    	    	for (int Counter = 1; Counter <= NumberOfMember; Counter ++) //Returning each team member's name and corresponding member number
	    	    	{
	    	    		System.out.println("Votes for Member " + TeamMember[Counter-1] + " : ");
	    	    		System.out.print(getThings.getVotes(Vote));
	    	    	}	

	    	    }
	    	    
		    	//----------------------------------------------
		    	//Declaration of EnterVotes()
		    	//----------------------------------------------    
	    	    public void EnterVotes()
	    	    {   
					System.out.println("Enter the Project Name");
					String userinput = scan.nextLine();
	    	    	for (int i=0; i<ProjectList.size(); i++)
	    	    	{
	    	    		if (userinput.equals(ProjectList.get(i).ProjectName))
	    	    		{
	    	    			System.out.println("\tCorrect, there are "+ ProjectList.get(i).getNumberOfMember(ProjectList.get(i).NumberOfMember)+" Member(s)");  
	    	    			ProjectList.get(i).PropVotes();
	    	    		}
						
					}	
	    	    }
	    	       
		    	//----------------------------------------------
		    	//Declaration of Quit() method
		    	//----------------------------------------------    
	    	    public void Quit()
	    	    {   
	    	    	System.out.println(ProjectList.get(0).ProjectName);
	    	    	File fileObject = new File("results.txt");
	    	    	CorrectInput = true; 				
	    	    	ShowMenu = false; 					//if ShowMenu is false, the program's menu will terminate
	    	    	PrintWriter outputStream = null;
	    	    	try
	    		    {
	    		        outputStream =
	    		             new PrintWriter(new FileOutputStream("results.txt"));
	    		    }
	    		    catch(FileNotFoundException e)
	    		    {
	    		        System.out.println("Error opening the file" +"results.txt");
	    		        System.exit(0);
	    		    }
	    	       for (int i=0; i<ProjectList.size(); i++){
	    	    	   outputStream.print(ProjectList.get(i).ProjectName+","+ ProjectList.get(i).NumberOfMember +","); //Project Name and Number of Members exported
	    	    	   for (int Membercount = 0; Membercount < ProjectList.get(i).NumberOfMember; Membercount ++) //For as long as the member count is less than the total number of members, the program will ask for the user input
	    	    	   {   
	    	    		  
	    	    		   outputStream.print(ProjectList.get(i).TeamMember[Membercount]);
	    	    		   outputStream.print(",");
	    	               //END OF LIST OF MEMBERS
	    	    	   }
	    	 
	    	    	   for (int CountingIndex = 0; CountingIndex < ProjectList.get(i).NumberOfMember; CountingIndex ++) //For as long as the member count is less than the total number of members, the program will ask for the user input
	    	    	   {   
	    	    		   outputStream.print(ProjectList.get(i).TeamMember[CountingIndex] + ",");
	    	    		   for (int CountedIndex = 0; CountedIndex < ProjectList.get(i).NumberOfMember; CountedIndex++)
	    	    		   if(CountingIndex!=CountedIndex) {
	    	    			   outputStream.print(ProjectList.get(i).TeamMember[CountedIndex] + ",");
	    	    			   outputStream.print(ProjectList.get(i).Vote[CountingIndex][CountedIndex] + ",");}
	    	    	   }
	    	    	   //for (int CountedIndex = 0; CountedIndex < ProjectList.get(i).NumberOfMember && CountingIndex != CountedIndex; CountedIndex++)
	    	       }  
	   	    
	   	    	outputStream.close();

	    	    	
	    	    	System.out.println("\tGoodbye. ");    	
	    	    	scan.close();
	    	    }
	    	 	
		    	//--------------------------------------------------------------------------------
		    	//Declaration of toString() method to check for all variable values when necessary
		    	//--------------------------------------------------------------------------------  
	    	    
	    	    private String getProjectName(int NumberOfProjects)
	    	    {
	    	    	return ProjectName;
	    	    }
	    	    
	    	    private String getTeamMemberName(int index)
	    	    {
	    	    	return TeamMember[index - 1];
	    	    }
	    	  
	    }


