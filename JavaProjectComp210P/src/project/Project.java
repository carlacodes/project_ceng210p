package project;

//Option Q
//Option V
import java.util.ArrayList;

///------------------------------------------------------------
///
///LOUIS NGUYEN CARLA GRIFFITHS COMP210P PROJECT, DELIVERABLE 2
///
///------------------------------------------------------------
import java.util.Scanner; //Importing the scanner tool 
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat; //Importing the decimal tool

public class Project // Class that holds menu functionality of programme
{
	ArrayList<ProjectProp> ProjectList = new ArrayList<ProjectProp>(); //This arraylist class for entering voter data 
	ArrayList<StoreVariables> importedProject = new ArrayList<StoreVariables>(); //This arraylist class is for importing previously entered user data
	private int i = 0;

	public static void main(String[] args) {
		Project run = new Project();
		run.StartMenu();
		
		

	}

	private static String option; // Declaring the strings representing the menu option buttons
	private static int NumberOfMember; // Entering the number of members
	private static int index = NumberOfMember; // used for later, declaring a square matrix
	private static String[] TeamMember; // Declaring the strings representing the names of the members
	private static int[][] Vote;
	private String[] s;

	public static String ProjectName; // Declaring the project name variable as a string
	private static boolean CorrectInput, ShowMenu; // Booleans CorrectInput, which determines whether the user has
													// entered a valid input and ShowMenu, which determines whether the
													// main menu is displayed again
	static Scanner scan = new Scanner(System.in); // Importing the scanner tool
	DecimalFormat twoDecPlcFormatter = new DecimalFormat("0.00"); // Although not used currently, having a decimal
																	// formatter could come in handy later
	// ------------------------------------------------------------------------
	// Declaration of StartMenu(): listing Menu Options and equalsIgnoreCase to
	// accept either upper or lower case
	// ------------------------------------------------------------------------

	public void StartMenu() {
		
		Scanner scan = new Scanner(System.in);
		//ArrayList<ProjectProp> ProjectList = new ArrayList<ProjectProp>();// Create a list with variable size that is
																			// capable of incorporating extra projects,
																			// allow multiple projects
		System.out.println();
		System.out.print("\nWelcome to Splitit ");
		do {
			printMenu();
			importResults();
			char input = scan.next().charAt(0); // Asking user to input a character
			option = Character.toString(input); // Converting from characters to string
			checkInput(option);
		} while (CorrectInput == false || ShowMenu == true); // Run StartMenu() while either the CorrectInput is false
																// or ShowMenu is true
	}

	private void importResults() {
		
		Scanner inputStream = null;
		try {
			inputStream = new Scanner(new FileReader("results.txt"));
		} catch (IOException e) {
			System.exit(0);
		}
		int linecounter = 0;
		while (inputStream.hasNextLine()) {
			importedProject.add(new StoreVariables());
			String line = "hello";
			line = inputStream.nextLine();
			line = line.substring(0, line.length() - 1);
			importedProject.get(linecounter).setLine(line);
			System.out.println(importedProject.get(linecounter).getLine());
			linecounter++;
		}
		
		// for line=0 to end{
		// while has next line{

		// }

		// }

		// add element to list array
		// repeat until line/file ends

		// scan each line
		// each line is a new element in this LISTARRAY

		// each line is a new element in the fucking imported user data arraylist

		// FOR STOREVARIABLES:
		// votes and names will be in storevariables
		// now storevariables is the basic read/write and has
		// later can try to make private class and use extend
		for(int runtime=0; runtime<linecounter; runtime++) {
		importedProject.get(runtime).ImportComponents();		
		}
	}

	// ----------------------------------------------
	// Declaration of checkInput(String OneInput) method
	// ----------------------------------------------
	private void checkInput(String OneInput) {
		if (OneInput.equalsIgnoreCase("A") == true) {
			About();
		} else if (OneInput.equalsIgnoreCase("C") == true) {
			CreateNewProjectArray();
		} else if (OneInput.equalsIgnoreCase("V") == true) {
			EnterVotes();
		} else if (OneInput.equalsIgnoreCase("S") == true) {
			ShowProject();
		} else if (OneInput.equalsIgnoreCase("Q") == true) {
			Quit();
		} else {
			System.out.print("\tIncorrect input. "); // If the user has entered an incorrect input, force them to enter
														// in correct input
			CorrectInput = false;
		}
	}

	// --------------------------------------------------------
	// Declaration of printMenu() method to print out menu text
	// --------------------------------------------------------
	private void printMenu() {
		System.out.println("\n\n\tAbout\t\t(A)");
		System.out.println("\tCreate Project\t(C)");
		System.out.println("\tEnter Votes\t(V)");
		System.out.println("\tShow Project\t(S)");
		System.out.println("\tQuit\t\t(Q)");
		System.out.print("\n\tPlease choose an option: ");
	}

	// ----------------------------------------------
	// Declaration of About() method
	// ----------------------------------------------
	public void About() {
		System.out.println(
				"\tThis is a program designed to assign grades for a project based on each member's \n \tparticipation developed by Carla Griffiths and Louis Nguyen. ");
	}

	// ----------------------------------------------
	// Declaration of CreateProjectArray() method
	// ----------------------------------------------
	public void CreateNewProjectArray() {
		CorrectInput = true;
		ShowMenu = true;
		ProjectList.add(new ProjectProp()); // Create adding a new item to ProjectList to refer to new Project
		boolean repeat = true;
		while (repeat == true) {
			ProjectList.get(i).CreateProjectTitle();
			if (i != 0) {
				for (int counter = 0; counter < i; counter++) {
					if (ProjectList.get(counter).ProjectName.equals(ProjectList.get(i).ProjectName)) {
						System.out.println("\tThis project names has already existed. Please enter another name.");
						repeat = true;
						break;
					} else {
						repeat = false;
					}
				}
			} else {
				repeat = false;
			}
		}
		ProjectList.get(i).CreateProjectNumberofMembers();
		i++;
		System.out.println("Number of Projects Created: " + ProjectList.size());
	}

	// ----------------------------------------------
	// Declaration of ShowProject()
	// ----------------------------------------------
	public void ShowProject() {
		CorrectInput = true;
		
		boolean inputCorrect;
		System.out.print("\tEnter the Project Name: ");
		String userinput = scan.nextLine();
		
		
		for (int i = 0; i < importedProject.size(); i++) {
			
			//importedProject.get(i).ImportComponents();
			//importedProject.get(i).setImportedVotes();
		

			if (userinput.equals(importedProject.get(i).getImportedProjectName())) {
				inputCorrect = true;				
				System.out.println("\tThere are "
						+ importedProject.get(i).getImportedNumberOfMember() + " member(s)");
				
				System.out.println("The point allocation based on votes is: \n");		
			
				importedProject.get(i).PrintFinalResults();
				System.out.println("Press <Enter> to return to the main menu: ");
				scan.nextLine();
				ShowMenu = true;
				break;
				
			}
			else
			{
				System.out.println("No project found, please choose an option again. ");
				ShowMenu = true;
			}
			
		}
		
	}

	// ----------------------------------------------
	// Declaration of EnterVotes()
	// ----------------------------------------------
	public void EnterVotes() {
		boolean inputCorrect = false;

		while (inputCorrect == false) {
			if (ProjectList.size() == 0) // Check if project has been created
			{
				System.out.println("\tPlease create a project.");
				break;
			}
			System.out.print("\tEnter the Project Name: ");
			String userinput = scan.nextLine();

			for (int i = 0; i < ProjectList.size(); i++) {

				if (userinput.equals(ProjectList.get(i).ProjectName)) {
					inputCorrect = true;
					System.out.println("\tThere are "
							+ ProjectList.get(i).getNumberOfMember(ProjectList.get(i).NumberOfMember) + " member(s)");
					ProjectList.get(i).PropVotes();
					break;
				}

			}

			// System.out.println("\tProject name cannot be found. Please re-enter project
			// name. ");
		}
	}

	// -----------------------------------------------------------------------
	// Declaration of Quit() method and export the latest votes to resutls.txt
	// -----------------------------------------------------------------------
	public void Quit() {
		CorrectInput = true;
		ShowMenu = false; // if ShowMenu is false, the program's menu will terminate
		PrintWriter outputStream = null;
		try {
			outputStream = new PrintWriter(new FileOutputStream("results.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Error opening the file" + "results.txt");
			System.exit(0);
		}
		for (int i = 0; i < ProjectList.size(); i++) {
			outputStream.print(ProjectList.get(i).ProjectName + "," + ProjectList.get(i).NumberOfMember + ","); // Project
																												// Name
																												// and
																												// Number
																												// of
																												// Members
																												// exported
			for (int Membercount = 0; Membercount < ProjectList.get(i).NumberOfMember; Membercount++) // For as long as
																										// the member
																										// count is less
																										// than the
																										// total number
																										// of members,
																										// the program
																										// will ask for
																										// the user
																										// input
			{

				outputStream.print(ProjectList.get(i).TeamMember[Membercount]);
				outputStream.print(",");
				// END OF LIST OF MEMBERS
			}
			for (int CountingIndex = 0; CountingIndex < ProjectList.get(i).NumberOfMember; CountingIndex++) // For as
																											// long as
																											// the
																											// member
																											// count is
																											// less than
																											// the total
																											// number of
																											// members,
																											// the
																											// program
																											// will ask
																											// for the
																											// user
																											// input
			{
				outputStream.print(ProjectList.get(i).TeamMember[CountingIndex] + ",");
				for (int CountedIndex = 0; CountedIndex < ProjectList.get(i).NumberOfMember; CountedIndex++) {
					if (CountingIndex != CountedIndex) {
						outputStream.print(ProjectList.get(i).TeamMember[CountedIndex] + ",");
						outputStream.print(ProjectList.get(i).Vote[CountingIndex][CountedIndex] + ",");
					}
				}
			}
			outputStream.println();
		}
		outputStream.close();
		System.out.println("\tGoodbye. ");
		scan.close();
	}

	// --------------------------------------------------------------------------------
	// Declaration of getProjectName() private helper method to return project names
	// --------------------------------------------------------------------------------
	private String getProjectName(int NumberOfProjects) {
		return ProjectName;
	}

	// --------------------------------------------------------------------------------
	// Declaration of getTeamMemberName() private helper method to return member
	// names
	// --------------------------------------------------------------------------------
	private String getTeamMemberName(int index) {
		return TeamMember[index - 1];
	}
}


