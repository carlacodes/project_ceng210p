package project;	
import java.util.ArrayList;
import java.util.Arrays;
///------------------------------------------------------------
	///
	///LOUIS NGUYEN CARLA GRIFFITHS COMP210P PROJECT, DELIVERABLE 1
	///
	///------------------------------------------------------------
	import java.util.Scanner; 			//Importing the scanner tool 
	import java.text.DecimalFormat; 	//Importing the decimal tool

	public class Project
	{
		public static void main(String[] args)
	    {
			Project run = new Project();
			run.StartMenu();
			 
			
	    }
		
	    	public static String option; //Declaring the strings representing the menu option buttons
	    	private static int NumberOfMember; 	//Entering the number of members
	    	private static int NumberOfProjects; //The number of projects a user can enter
	    	public static int index; //the 
	    	private static String[] TeamMember; //Declaring the strings representing the names of the members
	    	private static  ArrayList<String> ProjectName; 	// Declaring the project name variable as a string
	    	private static boolean CorrectInput, ShowMenu; 	//Booleans CorrectInput, which determines whether the user has entered a valid input and ShowMenu, which determines whether the main menu is displayed again
	    	 String SubProjectName;
	    	static Scanner scan = new Scanner(System.in); 	// Importing the scanner tool
	        DecimalFormat twoDecPlcFormatter = new DecimalFormat("0.00");  //Although not used currently, having a decimal formatter could come in handy later
	        //----------------------------------------------
	        //Declaration of StartMenu(): listing Menu Options and equalsIgnoreCase to accept either upper or lower case
	        //----------------------------------------------
	    	    Project(){
	    	    	int index=0;
	    	    }
	    	    
	        	public void StartMenu()   			
	    	    {          
	    	      Scanner scan = new Scanner(System.in);
	    	      NumberOfProjects=1;
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
	    	    		CreateProjectTitle();
	  	      		  	CreateProjectNumberofMembers();
	  	      		  	CreateProjectNamesofMembers();
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
	    	    	for (int Counter = 0; Counter < NumberOfMember; Counter ++) //Returning each team member's name and corresponding member number
	    	    	{
	    	    		System.out.println("Name of member " + (Counter +1) + " : " + TeamMember[Counter]);
	    	    	}
	    	    }
	    	    
		    	//----------------------------------------------
		    	//Declaration of EnterVotes()
		    	//----------------------------------------------    
	    	    public void EnterVotes()
	    	    {
	    	    	CorrectInput = true; 
	    	    	ShowMenu = true;    	//Still show the menu	
	    	    }
	    	    
		    	//----------------------------------------------
		    	//Declaration of CreateProject()
		    	//----------------------------------------------    
	    	    
	    	    public ArrayList<String> CreateProjectTitle()
	    	    {
	    	    	CorrectInput = true; 										
	    	    	ShowMenu = true; 	//Still show Menu
	    	    	//String[] ProjectName = new String[NumberOfProjects];
	    	    	//ProjectName= Arrays.copyOf(ProjectName, ProjectName.length+1); //extend the LENGTH of the ProjectNamearray by one 
					
	    	    	 ArrayList<String> ProjectName = new ArrayList<String>();
	    	    	 System.out.print("\n\tEnter the project name: "); 	
	    	    	 String SubProjectName=scan.next();
	    	         ProjectName.add(SubProjectName);
	    	        
					 System.out.println("you entered the project name"+ProjectName.get(index));
					 return ProjectName;
					
	    	    } 
	    	    
	    	    public int CreateProjectNumberofMembers(){
	    	    	System.out.print("\tEnter the number of team members: ");	//Asking user to input a number for all members count
	    	    	NumberOfMember = scan.nextInt();
	    	    	System.out.print("\n");
					return NumberOfMember;			
	    	    }
	    	    
	    	    public String[] CreateProjectNamesofMembers(){
	    	    	TeamMember = new String[NumberOfMember];
	    	    	for (int MemberCount = 1; MemberCount <= NumberOfMember; MemberCount ++) //For as long as the member count is less than the total number of members, the program will ask for the user input
	    	    	{
	    	    		//Statement of variable allocation to corresponding member position
	    	    		System.out.print("\tEnter the name of team member " + MemberCount + ": ");
	    	    		TeamMember[MemberCount - 1] = scan.next();
	    	    	}
	    	    	System.out.print("Press any key to return to the main menu: ");
	    	    	String DummyInput = scan.next(); 	//This is a dummy variable where the input is never used again
	    	    	ShowMenu = true; 					//Irrespective of the input, the menu will be shown again by assigning this boolean to true
					return TeamMember;
			
	    	    }
	    	    
		    	//----------------------------------------------
		    	//Declaration of Quit() method
		    	//----------------------------------------------    
	    	    public void Quit()
	    	    {
	    	    	CorrectInput = true; 				
	    	    	ShowMenu = false; 					//if ShowMenu is false, the program's menu will terminate
	    	    	System.out.println("\tGoodbye. ");    	
	    	    }
		    	//--------------------------------------------------------------------------------
		    	//Declaration of toString() method to check for all variable values when necessary
		    	//--------------------------------------------------------------------------------
	    	    
	    	    
	    	    private String getNumberOfMember()
	    	    {
	    	    	return Integer.toString(NumberOfMember);
	    	    }
	    	    
	    	    private ArrayList<String> getProjectName(int NumberOfProjects)
	    	    {
	    	    	return ProjectName;
	    	    }
	    	    
	    	    private String getTeamMemberName(int index)
	    	    {
	    	    	return TeamMember[index - 1];
	    	    }
	    	  
	    }

