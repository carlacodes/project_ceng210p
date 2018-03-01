package project;
import java.text.DecimalFormat;
import java.util.Scanner;
class ProjectProp 
{
	public static String option; // Declaring the strings representing the menu option buttons
	public int NumberOfMember; // Entering the number of members
	public int index = NumberOfMember; // used for later, declaring a square matrix
	public String[] TeamMember; // Declaring the strings representing the names of the members
	public int[][] Vote;
	public String ProjectName; // Declaring the project name variable as a string
	private static boolean CorrectInput, ShowMenu; // Booleans CorrectInput, which determines whether the user has
													// entered a valid input and ShowMenu, which determines whether the
													// main menu is displayed again
	static Scanner scan = new Scanner(System.in); // Importing the scanner tool
	DecimalFormat twoDecPlcFormatter = new DecimalFormat("0.00");
	public String[] s;
	// --------------------------------------------------------------------------------
	// Declaration of CreateProjectTitle() method to create project names
	// --------------------------------------------------------------------------------
	public String CreateProjectTitle() 
	{
		CorrectInput = true;
		ShowMenu = true; 
		System.out.print("\n\tEnter the project name: "); // Asking user for a project name
		ProjectName = scan.next();
		System.out.println("\tYou have entered in " + ProjectName);
		CreateProjectNumberofMembers();
		return ProjectName;
	}
	
	// ----------------------------------------------------------------------------------------
	// Declaration of CreateProjectNumberofMembers() method to return number of the new project
	// ----------------------------------------------------------------------------------------
	public int CreateProjectNumberofMembers() 
	{
		System.out.print("\tEnter the number of team members: "); // Asking user to input a number for all members count
		NumberOfMember = scan.nextInt();
		System.out.print("\n");
		CreateProjectNamesofMembers();
		return NumberOfMember;
	}
	
	// ------------------------------------------------------------------------------------------------------
	// Declaration of CreateProjectNamesofMembers() method to return String array containing names of members
	// ------------------------------------------------------------------------------------------------------
	public String[] CreateProjectNamesofMembers() 
	{
		TeamMember = new String[NumberOfMember];
		for (int MemberCount = 1; MemberCount <= NumberOfMember; MemberCount++) // For as long as the member count is
																				// less than the total number of
																				// members, the program will ask for the
																				// user input
		{
			System.out.print("\tEnter the name of team member " + MemberCount + ": ");
			TeamMember[MemberCount - 1] = scan.next();
		}
		System.out.print("Press any key to return to the main menu: ");
		String DummyInput = scan.next(); // This is a dummy variable where the input is never used again
		ShowMenu = true; // Irrespective of the input, the menu will be shown again by assigning this
							// boolean to tr
		return TeamMember;
	}

	// ------------------------------------------------
	// Declaration of PropVotes() method to enter votes
	// ------------------------------------------------	
	public int[][] PropVotes() {
		CorrectInput = true;
		Vote = new int[NumberOfMember][NumberOfMember];
		index = NumberOfMember;
		if (NumberOfMember == 0) 
		{
			System.out.println("\tPlease Create a Project Before Entering Votes!"); // Error Message
			ShowMenu = true;
		}		
		for (int row = 0; row < Vote.length; row++)	// initially assigning all values in the Vote Matrix to 0 
		{
			for (int col = 0; col < Vote[row].length; col++) 
			{
				Vote[row][col] = 0;
			}
		}

		for (int row = 0; row < Vote.length; row++) 
		{
			System.out.println("\tEnter " + TeamMember[row] + "'s votes, points must add up to 100:");
			for (int col = 0; col < Vote[row].length; col++) 
			{
				if (col == row) 
				{
					continue;
				}
				System.out.print("\tEnter " + TeamMember[row] + "'s points for " + TeamMember[col] + ":");
				Vote[row][col] = scan.nextInt();
			}
		}
		sumRow(Vote, NumberOfMember);
		return Vote;
	}

	// ------------------------------------------------------------------
	// Declaration of sumRow() method to check if all votes add up to 100 
	// ------------------------------------------------------------------
	public int[] sumRow(int[][] Vote, int NumberOfMember) 
	{
		int sum[] = new int[NumberOfMember];
		for (int i = 0; i < Vote.length; i++) 
		{
			int total = 0;
			for (int j = 0; j < Vote[0].length; j++) 
			{
				total += Vote[i][j];
				sum[i] = total;
			}
		}
		for (int i = 0; i < sum.length; i++) 
		{
			if (sum[i] != 100) 
			{
				System.out.println("\n\tPlease Make Sure the points add to 100!");
				PropVotes();
			}
		}
		return sum;
	}

	// --------------------------------------------------------------------
	// Declaration of setNumberofMember() method to change number of member
	// --------------------------------------------------------------------
	public int setNumberofMember(int theNumberOfMember) 
	{
		NumberOfMember = theNumberOfMember;
		return theNumberOfMember;
	}

	// --------------------------------------------------------------------
	// Declaration of getNumberOfMember() method to return number of member
	// --------------------------------------------------------------------	
	public String getNumberOfMember(int NumberOfMember) 
	{
		return Integer.toString(NumberOfMember);
	}

	// --------------------------------------------------------------------
	// Declaration of getMember() method to return member names
	// --------------------------------------------------------------------
	public String[] getMember(String[] TeamMember) 
	{
		return TeamMember;
	}

	// --------------------------------------------------------------------
	// Declaration of getMemberVotes() method to return member votes
	// --------------------------------------------------------------------	
	public int[][] getMemberVotes(int[][] Vote) 
	{
		return Vote;
	}
}
