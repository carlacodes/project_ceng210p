package project;	

///------------------------------------------------------------
	///
	///LOUIS NGUYEN CARLA GRIFFITHS COMP210P PROJECT, DELIVERABLE 1
	///
	///------------------------------------------------------------
	import java.util.Scanner; 			//Importing the scanner tool 
import java.util.stream.IntStream; //for summing arrays
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
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
	    	public String fileName = null;
	    	
	    	public static int index; //used for later 
	    	public static String[] TeamMember; //Declaring the strings representing the names of the members
	    	public static int[] Vote; 
	    	public static  String ProjectName; 	// Declaring the project name variable as a string
	    	private static boolean CorrectInput, ShowMenu; 	//Booleans CorrectInput, which determines whether the user has entered a valid input and ShowMenu, which determines whether the main menu is displayed again
	    	
	    	static Scanner scan = new Scanner(System.in); 	// Importing the scanner tool
	        DecimalFormat twoDecPlcFormatter = new DecimalFormat("0.00");  //Although not used currently, having a decimal formatter could come in handy later
	        //----------------------------------------------
	        //Declaration of StartMenu(): listing Menu Options and equalsIgnoreCase to accept either upper or lower case
	        //----------------------------------------------
	    	    Project(){
	    	    	
	    	    }
	    	    
	        	public void StartMenu()   			
	    	    {          
	    	      Scanner scan = new Scanner(System.in);
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
	    	    public int[] EnterVotes()
	    	    {
	    	    	PrintWriter outputStream = null;
	    	    	try
	    	         {
	    	             outputStream =
	    	                  new PrintWriter(new FileOutputStream(fileName+".txt"));
	    	         }
	    	         catch(FileNotFoundException e)
	    	         {
	    	             System.out.println("Error opening the file " + fileName +".txt");
	    	             System.exit(0);
	    	         }
	    	    	
	    	    	Vote = new int [NumberOfMember];
	    	    	CorrectInput = true; 
	    	    	ShowMenu = true;    	//Still show the menu
	    	    	if (NumberOfMember==0) {
	    	    		System.out.println("Please Create a Project Before Entering Votes!"); //Error Message
	    	    		
	    	    	}
	    	    	for (int i = 1; i <= NumberOfMember; i ++) //For as long as the member count is less than the total number of members, the program will ask for the user input
	    	    	{
	    	    		//Statement of variable allocation to corresponding member position
	    	    		System.out.print("\tEnter the votes for team member " + TeamMember[i-1] + ": ");
	    	    		Vote[i-1] = scan.nextInt();
	    	    		outputStream.println("Votes for"+ TeamMember[i-1]+":"+Vote[i-1]);
	    	    	}
	    	    	outputStream.close();
	    	    	int sum = IntStream.of(Vote).sum();
	    	    	
	    	    	//DECLARING ERROR MESSAGE//
	    	    	if (sum!=100) {
	    	    		System.out.println("Error. Please make sure all votes add up to 100.");
	    	    		EnterVotes();
	    	    	}
	    	    	
					return Vote;
	    	    }
	    	    
		    	//----------------------------------------------
		    	//Declaration of CreateProject()
		    	//----------------------------------------------    
	    	    
	    	    public String CreateProjectTitle()
	    	    {
	    	    	 System.out.println("Enter a file name to hold the Project:");
	    	         fileName = scan.nextLine( );
	    	         File fileObject = new File(fileName+".txt");
	    	         while (fileObject.exists( ))
	    	         {
	    	             System.out.println("There already is a file named "
	    	             + fileName);
	    	             System.out.println("Enter a different file name:");
	    	             fileName = scan.nextLine( );
	    	             fileObject = new File(fileName+".txt");
	    	         }
	    	         
	    	         PrintWriter outputStream = null;
	    	         try
	    	         {
	    	             outputStream =
	    	                  new PrintWriter(new FileOutputStream(fileName+".txt"));
	    	         }
	    	         catch(FileNotFoundException e)
	    	         {
	    	             System.out.println("Error opening the file " + fileName +".txt");
	    	             System.exit(0);
	    	         }

	    	         
	    	    	CorrectInput = true; 										
	    	    	ShowMenu = true; 											//Still show Menu
	    	    	System.out.print("\n\tEnter the project name: "); 			//Asking user for a project name
	    	    	ProjectName = scan.next();
	    	    	outputStream.println(ProjectName);
	    	    	outputStream.close();
	    	    	CreateProjectNumberofMembers(); //calling methods within the resulting methods
  	      		  	CreateProjectNamesofMembers();
					return ProjectName;
					}
	    	    
	    	    public int CreateProjectNumberofMembers(){ //ENTER NUMBER OF TEAM MEMBERS
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
	    	    	ShowMenu = true; 					//Irrespective of the input, the menu will be shown again by assigning this boolean to tr 
	    	    	return TeamMember;
			
	    	    }
	    	    
		    	//----------------------------------------------
		    	//Declaration of Quit() method
		    	//----------------------------------------------    
	    	    public void Quit()
	    	    {
	    	    	CorrectInput = true; 				
	    	    	ShowMenu = false; 					//if ShowMenu is false, the program's menu will terminate
	    	    	WriteOut();
	    	    	System.out.println("\tGoodbye. ");    	
	    	    	scan.close();
	    	    }
	    	    public void WriteOut() {
	    	    	PrintWriter outputStream = null;
	    	    	try
	    	         {
	    	             outputStream =
	    	                  new PrintWriter(new FileOutputStream(fileName+".txt"));
	    	         }
	    	         catch(FileNotFoundException e)
	    	         {
	    	             System.out.println("Error opening the file " + fileName +".txt");
	    	             System.exit(0);
	    	         }
	    	         
	    	    	for (int MemberCount = 1; MemberCount <= NumberOfMember; MemberCount ++) //For as long as the member count is less than the total number of members, the program will ask for the user input
	    	    	{
	    	    		//Statement of variable allocation to corresponding member position
	    	    		outputStream.println("Team Member"+(MemberCount-1)+ ":"+TeamMember[MemberCount - 1]);
	    	    	}
	    	    	outputStream.println("Number of Members:"+ NumberOfMember+ "Project Name:"+ProjectName);
	    	        outputStream.close();
	    	    }
	    	    
   	    	
		    	//--------------------------------------------------------------------------------
		    	//Declaration of toString() method to check for all variable values when necessary
		    	//--------------------------------------------------------------------------------
	    	    private String getNumberOfMember()
	    	    {
	    	    	return Integer.toString(NumberOfMember);
	    	    }
	    	    private String getProjectName(int NumberOfProjects)
	    	    {
	    	    	return ProjectName;
	    	    }
	    	    
	    	    private String getTeamMemberName(int index)
	    	    {
	    	    	return TeamMember[index - 1];
	    	    }
	    	  
	    }


