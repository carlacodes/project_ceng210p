import java.util.Scanner; //Importing the scanner tool 
import java.text.DecimalFormat; //Importing the decimal tool 
///LOUIS NYUGEN CARLA GRIFFITHS CENG210P PROJECT // 
public class Project
{
	public static String About = "A", EnterVotes = "V", ShowProject = "S", Quit = "Q", option; //Declaring the strings representing the menu option buttons
	public static int NumberOfMember; //Entering the number of members
	public static String[] TeamMember; //Declaring the strings representing the names of the members and the project name
	public static String ProjectName; // declaring the project name as a string
	public static boolean CorrectInput, ShowMenu; //Booleans CorrectInput, which determines whether the user has entered a valid input and ShowMenu, which determines whether the main menu is displayed again
    static Scanner scan = new Scanner(System.in); // importing the scanner tool
    DecimalFormat twoDecPlcFormatter = new DecimalFormat("0.00");  //Although not used currently, having a decimal formatter could come in handy later
    public static void main(String[] args)
   {
    	MenuText();    	
   }
    
//----------------------------------------------
//Declaration of MenuText()
//----------------------------------------------
    public static void MenuText()   //start of the basic MenuText method
    {    
           
      Scanner scan = new Scanner(System.in); // importing the scanner tool
      System.out.println(); //printing a new line 
      System.out.print("\nWelcome to Splitit ");
      do
      {
    	  System.out.println("\n\n\tAbout\t\t(A)"); //Giving Information About the Program 
    	  System.out.println("\tCreate Project\t(C)"); //Create a new project
          System.out.println("\tEnter Votes\t(V)"); //Enter Votes
          System.out.println("\tShow Project\t(S)"); //show project text 
          System.out.println("\tQuit\t\t(Q)"); //quit option 
          System.out.print("\n\tPlease choose an option:"); //printing out each menu option      
    	  char input = scan.next().charAt(0);  //asking user to input a character
      	  option = Character.toString(input);
      	  if (option.equalsIgnoreCase("A") == true) //If A is true, run About()
          {
              About();              
          }
      	  else if (option.equalsIgnoreCase("C") == true) //If C is true run Create Project()
      	  {
      		  CreateProject();
      	  }
      	  else if (option.equalsIgnoreCase("V") == true) //If V is true, run EnterVotes()
      	  {
      		  EnterVotes();      		  
      	  }
      	  else if (option.equalsIgnoreCase("S") == true) //If S is true, run ShowProject()
      	  {
      		  ShowProject();      		  
      	  }
      	  else if (option.equalsIgnoreCase("Q") == true) //If Q is true, run Quit()
      	  {
      		  Quit();      		  
      	  }
      	  else
      	  {
      		  System.out.print("\tIncorrect input. "); //If the user has entered an incorrect input, force them to enter in correct input
      		  CorrectInput = false;
      	  }
      }
      while (CorrectInput == false || ShowMenu == true);
    }
          
//----------------------------------------------
//Declaration of About()
//----------------------------------------------      
    public static void About() 
    {
    	CorrectInput = true; //Boolean indicating this a correct input type 
    	ShowMenu = false; //End the show menu, do not show menu text
    	System.out.println("\tThis is a program designed to assign grades for a project based on each member's participation developed by Carla Griffiths and Louis Nguyen. ");    	
    }

//----------------------------------------------
//Declaration of ShowProject()
//----------------------------------------------    
    public static void ShowProject()
    {
    	CorrectInput = true; //Boolean indicating correct input
    	ShowMenu = true; //Still show the menu
    	
    }
    
//----------------------------------------------
//Declaration of EnterVotes()
//----------------------------------------------    
    public static void EnterVotes()
    {
    	CorrectInput = true; //Boolean indicating correct input
    	ShowMenu = true;    //Still show the menu	
    }
    
//----------------------------------------------
//Declaration of CreateProject()
//----------------------------------------------    
    public static void CreateProject()
    {
    	CorrectInput = true; //Boolean indicating correct input
    	ShowMenu = true; //Still show Menu
    	System.out.print("\nEnter the project name: "); //Asking user for a project name and team member names
    	ProjectName = scan.nextLine();
    	System.out.println("Enter the number of team members: \n");
    	NumberOfMember = scan.nextInt();
    	TeamMember = new String[NumberOfMember];
    	for (int MemberCount = 1; MemberCount <= NumberOfMember; MemberCount ++) //For as long as the member count is less than the total number of members, the program will ask for the user input
    	{
    		//Statement of variable allocation to corresponding member position
    		System.out.println("\tEnter the name of team member " + MemberCount);
    		TeamMember[NumberOfMember -1] = scan.nextLine();
    	}
    	System.out.print("Press any key to return to the main menu: ");
    	String DummyInput = scan.nextLine(); //This is a dummy variable where the input is never used again
    	ShowMenu = true; //Irrespective of the input, the menu will be shown again by assigning this boolean to true
    }
    
//----------------------------------------------
//Declaration of Quit()
//----------------------------------------------    
    public static void Quit()
    {
    	CorrectInput = true; //Boolean indicating this a correct input type 
    	ShowMenu = false; //if ShowMenu is false, the program's menu will terminate
    	System.out.println("\tGoodbye. "); //Printing a goodbye message 
    	
    }
}




