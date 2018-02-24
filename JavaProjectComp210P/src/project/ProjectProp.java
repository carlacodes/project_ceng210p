package project;
import java.text.DecimalFormat;
import java.util.Scanner;

class ProjectProp {
	public static String option; //Declaring the strings representing the menu option buttons
	public static int NumberOfMember; 	//Entering the number of members
	
	public static int index=NumberOfMember; //used for later, declaring a square matrix
	public static String[] TeamMember; //Declaring the strings representing the names of the members
	public static int[][] Vote;
	public static  String ProjectName; 	// Declaring the project name variable as a string
	private static boolean CorrectInput, ShowMenu; 	//Booleans CorrectInput, which determines whether the user has entered a valid input and ShowMenu, which determines whether the main menu is displayed again
	public static String List; 
	public String fileName;
	static Scanner scan = new Scanner(System.in); 	// Importing the scanner tool
    DecimalFormat twoDecPlcFormatter = new DecimalFormat("0.00");
	  public String CreateProjectTitle()
	    {  
	    	
	    	CorrectInput = true; 										
	    	ShowMenu = true; 											//Still show Menu
	    	System.out.print("\n\tEnter the project name: "); 			//Asking user for a project name
	    	ProjectName = scan.next();
	    	System.out.println("You have entered in" + ProjectName);
	    	CreateProjectNumberofMembers();
		  
			return ProjectName;
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
	    	
	    	//for (ProjectProp elem: ProjectList) {
	    		//System.out.print(elem+" ");
	    	//}
	    	
	    	return TeamMember;
	    }
	    public int[][] PropVotes(){
	    CorrectInput=true;
    	Vote = new int [NumberOfMember][index];
    	index=NumberOfMember;
    	if (NumberOfMember==0) {
    		System.out.println("Please Create a Project Before Entering Votes!"); //Error Message
    		ShowMenu=true;
    	}
    	//CheckProjectName check = new CheckProjectName();
    	//check.CheckName(NumberOfMember, ProjectName, TeamMember);
    	for (int row=0; row < Vote.length; row++)
    	{
    		System.out.println("Enter "+ TeamMember[row]+"'s votes, points must add up to 100:");
    	    System.out.println();
    		for (int col=0; col < Vote[row].length; col++)
    	    { 
    	        System.out.println("Enter "+TeamMember[row]+ "'s points for"+ TeamMember[col]+":");
    	        Vote[row][col] = scan.nextInt(); 
    	    }
    	}
       sumRow(Vote, NumberOfMember);
	   return Vote;}
	    
	    public int[] sumRow(int[][] Vote, int NumberOfMember) 
	    {
	    	 int sum[] = new int[NumberOfMember];
	    	  
	            for (int i = 0; i < Vote.length; i++){
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
	    	WriteOut call = new WriteOut();
	    	call.FirstExport(NumberOfMember, ProjectName, TeamMember);
	    	call.SecondExport(Vote);
			
	    	
	    }
		
		
}
