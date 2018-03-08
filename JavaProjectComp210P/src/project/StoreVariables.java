package project;
public class StoreVariables 	//This is class is to be used with ShowProject() method, which is option "S"
{
	private String line;
	private int NumberOfMember;
	private String ProjectName;
	private String[] TeamMember;
	private int[][] Votes;
	//next line string-1  =total string
	//first int: Number
	//scan next string: project name 
	//Scan Number of memmember strings after: TeamMember
	//s
public void setLine(String aLine)
{
	line = aLine;
}

}
