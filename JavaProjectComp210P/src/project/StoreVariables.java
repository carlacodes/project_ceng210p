package project;
public class StoreVariables 	//This is class is to be used with ShowProject() method, which is option "S"
{
	private int NumberOfMember;
	private String ProjectName;
	private String[] TeamMember;
	private int[][] Votes;

	// ------------------------------------------------------------------------------------------------------
	// Constructor of StoreVariables() to initiate ProjectName and NumberOfMember values
	// ------------------------------------------------------------------------------------------------------	
	public StoreVariables() 
	{
		NumberOfMember = 1;
		ProjectName = "Null";
	}
	
	// ------------------------------------------------------------------------------------------------------
	// Declaration of setNumberofMember() method to change number of member
	// ------------------------------------------------------------------------------------------------------
	public int setNumberofMember(int theNumberOfMember) 
	{
		NumberOfMember = theNumberOfMember;
		return theNumberOfMember;
	}

	// ------------------------------------------------------------------------------------------------------
	// Declaration of setVotes() method to change votes of members
	// ------------------------------------------------------------------------------------------------------	
	public int[][] setVotes(int[][] theVotes) 
	{
		Votes = theVotes;
		return theVotes;
	}

	// ------------------------------------------------------------------------------------------------------
	// Declaration of setProjectName() method to change change project name
	// ------------------------------------------------------------------------------------------------------		
	public String setProjectName(String theProjectName) 
	{
		ProjectName = theProjectName;
		return theProjectName;
	}

	// ------------------------------------------------------------------------------------------------------
	// Declaration of setTeamMember() method to change team member names
	// ------------------------------------------------------------------------------------------------------		
	public String[] setTeamMember(String[] theTeamMember) 
	{
		TeamMember = theTeamMember;
		return theTeamMember;
	}

	// ------------------------------------------------------------------------------------------------------
	// Declaration of getNumberofMember() method to get number of member
	// ------------------------------------------------------------------------------------------------------			
	public int getNumberofMember(int NumberOfMember) 
	{
		return NumberOfMember;
	}

	// ------------------------------------------------------------------------------------------------------
	// Declaration of getProjectName() method to get project names
	// ------------------------------------------------------------------------------------------------------				
	public String getProjectName(String ProjectName) 
	{
		return ProjectName;
	}

	// ------------------------------------------------------------------------------------------------------
	// Declaration of getTeamMember() method to get team member names
	// ------------------------------------------------------------------------------------------------------					
	public String[] getTeamMember() 
	{
		return TeamMember;
	}

	// ------------------------------------------------------------------------------------------------------
	// Declaration of getVotes() method return member votes
	// ------------------------------------------------------------------------------------------------------				
	public int[][] getVotes(int theVotes[][]) 
	{
		return theVotes;
	}
}
