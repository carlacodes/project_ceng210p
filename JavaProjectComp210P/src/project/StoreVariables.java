package project;
public class StoreVariables 	//This is class is to be used with ShowProject() method, which is option "S"
{
	private String line;
	private int ImportedNumberOfMember;
	private String ImportedProjectName;
	private String[] ImportedTeamMember;
	private int[][] Votes;
	private String[] EverythingArray;
	private double[] Score;
	private int i;
	//next line string-1  =total string
	//first int: Number
	//scan next string: project name 
	//Scan Number of memmember strings after: TeamMember
	//s
public void setLine(String aLine)
{
	line = aLine;
}

public String getLine()
{
	return line;
}


public void getImportedComponents() {
	i = 0;
	EverythingArray=line.split(",");
	ImportedProjectName=EverythingArray[i];
	i++;
	 
	ImportedNumberOfMember=Integer.parseInt(EverythingArray[i]);
	i++;
	
	
	//convert from string to integer
	//from position 1 to number of members for loop:
	for (int MemberCounter = 0; i<=ImportedNumberOfMember+2; i++, MemberCounter++) {
		ImportedTeamMember[MemberCounter]=EverythingArray[i];
	}
	//for ()
}


//NEED METHOD TO EXTRACT EACH COMPONENT
//NEED METHOD TO RETURN EACH COMPONENT 



public int[][] ReturnMemberVotes(){
	//return each person's scores
	generateScores();
	return Votes;
}

//public String[] returnMemberNames() {
	//return TeamMember;
//}

public double[] generateScores() {
	
	return Score;
}

public String getImportedProjectName() {
	
	// TODO Auto-generated method stub
	return ImportedProjectName;
}

public int getImportedNumberOfMember() {
	ImportedNumberOfMember=Integer.parseInt(EverythingArray[1]);
	// TODO Auto-generated method stub
	return ImportedNumberOfMember;
}

public void setImportedVotes()
{int j=i;
	String[] TeamMemberContent= new String[EverythingArray.length - i];
	for (int placeholder = 0; i<=EverythingArray.length; i++, placeholder++) {
		TeamMemberContent[placeholder]=EverythingArray[i];		
	}
	String[][] SubVoteArray= new String[ImportedNumberOfMember][2*(ImportedNumberOfMember-1)];
	for ( int placeholder2 = 0;placeholder2<SubVoteArray.length; placeholder2++ ) {
		 int index = 0;
		        for (int k = 0; k < SubVoteArray[placeholder2].length; k++) {
		            if (index == TeamMemberContent.length) {
		                break;
		            }
		            SubVoteArray[placeholder2][k] = TeamMemberContent[index];
		            index++;
		        }
		//for each 1 assigning member, at position i in the 2nd outermost, if mem==mem then 
		        //the element in Vote[] = 0;i++;
		        //if mem!=mem then score in Vote[] is following i position (i++)
		        //do this for every 2(n-1)+1 of the element in TeamMemberContent[]
		 
	}
	
}



}

