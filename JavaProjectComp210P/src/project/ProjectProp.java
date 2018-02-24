package project;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Scanner;

class ProjectProp {
	public static String option; //Declaring the strings representing the menu option buttons
	public  int NumberOfMember; 	//Entering the number of members
	public  int index=NumberOfMember; //used for later, declaring a square matrix
	public String[] TeamMember; //Declaring the strings representing the names of the members
	public int[][] Vote;
	public String ProjectName; 	// Declaring the project name variable as a string
	private static boolean CorrectInput, ShowMenu; 	//Booleans CorrectInput, which determines whether the user has entered a valid input and ShowMenu, which determines whether the main menu is displayed again
	static Scanner scan = new Scanner(System.in); 	// Importing the scanner tool
    DecimalFormat twoDecPlcFormatter = new DecimalFormat("0.00");
   
	  public String CreateProjectTitle()
	    {  
	    	
	    	CorrectInput = true; 										
	    	ShowMenu = true; 											//Still show Menu
	    	System.out.print("\n\tEnter the project name: "); 			//Asking user for a project name
	    	this.ProjectName = scan.next();
	    	System.out.println("You have entered in " + this.ProjectName);
	    	CreateProjectNumberofMembers();
		  
			return this.ProjectName;
			}
	  
	  public int CreateProjectNumberofMembers(){ //ENTER NUMBER OF TEAM MEMBERS
	    	System.out.print("\tEnter the number of team members: ");	//Asking user to input a number for all members count
	    	NumberOfMember = scan.nextInt();
	    	System.out.print("\n");
	    	 CreateProjectNamesofMembers();
			return NumberOfMember;			
	    }
	//----------------------------------------------
  	//Declaration of CreateProjectNamesofMembers()
  	//----------------------------------------------    
	    
	    public String[] CreateProjectNamesofMembers(){ 
	    	this.TeamMember = new String[NumberOfMember];
	    	
	    	for (int MemberCount = 1; MemberCount <= NumberOfMember; MemberCount ++) //For as long as the member count is less than the total number of members, the program will ask for the user input
	    	{
	    		//Statement of variable allocation to corresponding member position
	    		System.out.print("\tEnter the name of team member " + MemberCount + ": ");
	    		this.TeamMember[MemberCount - 1] = scan.next();
	    	}	
	    	
	    	System.out.print("Press any key to return to the main menu: ");
	    	String DummyInput = scan.next(); 	//This is a dummy variable where the input is never used again
	    	ShowMenu = true; 					//Irrespective of the input, the menu will be shown again by assigning this boolean to tr 
	  
	    	return this.TeamMember;
	    }
	    public int[][] PropVotes(){
	    CorrectInput=true;
    	this.Vote = new int [NumberOfMember][index];
    	index = this.NumberOfMember;
    	if (NumberOfMember==0) {
    		System.out.println("Please Create a Project Before Entering Votes!"); //Error Message
    		ShowMenu=true;
    	}
    	//initially assigning all values in the Vote Matrix to 0
    	for (int row = 0; row < Vote.length; row++)
    	{
    	    for (int col = 0; col < this.Vote[row].length; col++)
    	    { 
    			this.Vote[row][col] = 0;
    	        
    	        }
    	    }
    	
    	for (int row = 0; row < Vote.length; row++)
    	{
    		System.out.println("Enter "+ this.TeamMember[row]+"'s votes, points must add up to 100:");
    	    System.out.println();
    	   
    		for (int col=0; col < this.Vote[row].length; col++ )
    	    {  if (col == row) {
	        	continue;
	        }
    			System.out.println("Enter "+this.TeamMember[row]+ "'s points for "+ this.TeamMember[col]+":");
    	        this.Vote[row][col] = scan.nextInt();
    	    }
    	}    	
    	sumRow(Vote, NumberOfMember);
	   return this.Vote;
	   }
	    
	    public int[] sumRow(int[][] Vote, int NumberOfMember) 
	    {
	    	 int sum[] = new int[NumberOfMember];
	    	  
	            for (int i = 0; i < this.Vote.length; i++){
	            int total = 0;
	            for (int j = 0; j < Vote[0].length; j++)
           	    total +=Vote[i][j];
	            sum[i] = total;}
	            
	            
	            for(int i = 1; i < sum.length; i++)
	            {
	              if (sum[i] != 100) {
	            	  System.out.println("Please Make Sure the points add to 100!");
	            	  PropVotes();
	              }
	              
	            }
				return sum;
		
	    
	    }
	    public int setNumberofMember (int theNumberOfMember)
		   {
		      NumberOfMember = theNumberOfMember;
		      return theNumberOfMember;
		   }
	    public String getNumberOfMember()
	    {
	    	return Integer.toString(NumberOfMember);
	    }
	    public void callWriteOut() {
	  	   
	    	
			
			//The first line is printed out as the Project Name
			
				    	//WriteOut call = new WriteOut();
	    	//call.FirstExport(NumberOfMember, ProjectName, TeamMember);
	    //	call.SecondExport(Vote);
	    	
			
	    	
	    }

		public String[] getMember(String[] TeamMember) {
			return TeamMember;
			
		}
		
		public int[][] getMemberVotes(int[][] Vote){
			return Vote;
			
		}

		
		
}
