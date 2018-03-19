package project;

import java.util.Arrays;

public class StoreVariables // This is class is to be used with ShowProject() method, which is option "S"
{
	private String line;
	private int ImportedNumberOfMember;
	private String ImportedProjectName;
	private String[] ImportedTeamMember;
	private int[][] Votes;
	private String[] EverythingArray;
	private String[][] SubVoteArray, newSubVoteArray;
	private String[] TeamMemberContent;
	private double[] Score;
	private int i;
	private int[][] FinalVotes;
	private double[][] RatioVotes;

	// next line string-1 =total string
	// first int: Number
	// scan next string: project name
	// Scan Number of memmember strings after: TeamMember
	// s
	public void setLine(String aLine) {
		line = aLine;
	}

	public String getLine() {

		// initializeVotes(SubVoteArray,ImportedNumberOfMember,ImportedNumberOfMember);
		// System.out.print(Arrays.deepToString(SubVoteArray));
		return line;
	}

	public void initializeVotes(String[][] aStringArray, int Row, int Column) {
		int secondouterplaceholder = 0;
		aStringArray = new String[Row][Column];
		for (int outermostplaceholder = 0; outermostplaceholder < ImportedNumberOfMember; outermostplaceholder++) {

			for (; secondouterplaceholder < (outermostplaceholder * (2 * (ImportedNumberOfMember - 1) + 1)
					+ 2 * (ImportedNumberOfMember - 1) + 1); secondouterplaceholder++) {
				int j = 0;

				aStringArray[outermostplaceholder][j] = "0";
				j++;
			}
		}
	}

	public int[][] ImportComponents() {
		i = 0;
		EverythingArray = line.split(",");
		ImportedProjectName = EverythingArray[i];
		i++;

		ImportedNumberOfMember = Integer.parseInt(EverythingArray[i]);
		i++;
		// convert from string to integer
		// from position 1 to number of members for loop:
		ImportedTeamMember = new String[ImportedNumberOfMember];
		for (int MemberCounter = 0; i < ImportedNumberOfMember + 2; i++, MemberCounter++) {
			ImportedTeamMember[MemberCounter] = EverythingArray[i];
			System.out.println(ImportedTeamMember[MemberCounter]);
		}
		System.out.println(ImportedProjectName);
		System.out.println(ImportedNumberOfMember);
		System.out.println("i1 = " + i);
		// for ()
		setImportedVotes(ImportedNumberOfMember);
		CreateSortedVotesMatrix(newSubVoteArray, ImportedTeamMember, ImportedNumberOfMember);
		System.out.print(Arrays.deepToString(FinalVotes));
		if(ImportedNumberOfMember==3) {
			CreateRatioMatrix(FinalVotes);
		}
		else {
			System.out.println("Cannot calculate. Current Project Doesn't have 3 Members.");
		}
		return FinalVotes;

	}

	// NEED METHOD TO EXTRACT EACH COMPONENT
	// NEED METHOD TO RETURN EACH COMPONENT

	public int[][] ReturnMemberVotes() {
		// return each person's scores
		generateScores();
		return Votes;
	}

	// public String[] returnMemberNames() {
	// return TeamMember;
	// }

	public double[] generateScores() {

		return Score;
	}

	public String getImportedProjectName() {

		// TODO Auto-generated method stub
		return ImportedProjectName;
	}

	public int getImportedNumberOfMember() {
		ImportedNumberOfMember = Integer.parseInt(EverythingArray[1]);
		// TODO Auto-generated method stub
		return ImportedNumberOfMember;
	}

	public void setImportedNumberOfMember() {
		ImportedNumberOfMember = Integer.parseInt(EverythingArray[1]);
	}

	public String[] setImportedVotes(int aImportedNumberOfMember) {
		System.out.println("i2 = " + i);
		initializeVotes(SubVoteArray, aImportedNumberOfMember, aImportedNumberOfMember);
		System.out.println("i2'' = " + i);

		// System.out.print(Arrays.deepToString(SubVoteArray));
		i = 2 + aImportedNumberOfMember;
		String[] TeamMemberContent = new String[EverythingArray.length - i];
		for (int placeholder = 0; i < EverythingArray.length; i++, placeholder++) {
			TeamMemberContent[placeholder] = EverythingArray[i];

		}
		System.out.println("i2''' = " + i);
		CreateSubString1(TeamMemberContent, aImportedNumberOfMember);
		CreateSubString2(SubVoteArray,aImportedNumberOfMember);
		
		return TeamMemberContent;
	}

	private String[][] CreateSubString1(String[] aTeamMemberContent, int oneImportedNumberOfMember) {
		SubVoteArray = new String[oneImportedNumberOfMember][2 * (oneImportedNumberOfMember - 1) + 1];
		System.out.println(Arrays.toString(aTeamMemberContent));
		int inner = 0;
		for (int outer = 0; outer < oneImportedNumberOfMember; outer++) {
			System.out.println("outer change");
			System.out.println(outer);

			for (int j = 0; j < 2 * (oneImportedNumberOfMember - 1) + 1; j++, inner++) {

				System.out.println("j= " + j);
				System.out.println("inner= " + inner);
				System.out.println(aTeamMemberContent[inner]);
				SubVoteArray[outer][j] = aTeamMemberContent[inner];
				// System.out.println("test"+Arrays.toString(aTeamMemberContent));
			}
		}
		//inner++;
		//SubVoteArray[oneImportedNumberOfMember - 1][2 * (oneImportedNumberOfMember - 1)] = aTeamMemberContent[inner
		//		- 1];

		System.out.println(Arrays.deepToString(SubVoteArray));

		return SubVoteArray;
	}

		//inner++;
		//SubVoteArray[oneImportedNumberOfMember - 1][2 * (oneImportedNumberOfMember - 1)] = aTeamMemberContent[inner- 1];

		 
	private String[][] CreateSubString2(String[][] aSubVoteArray, int oneImportedNumberOfMember)
	{
		newSubVoteArray = new String[oneImportedNumberOfMember][2 * (oneImportedNumberOfMember - 1)];
		for (int outer = 0; outer < (oneImportedNumberOfMember); outer++) {
			for (int inner = 0; inner <2*(oneImportedNumberOfMember - 1); inner++)
			{
				newSubVoteArray[outer][inner] = aSubVoteArray[outer][inner+1];						
			}
		}
		System.out.println(Arrays.deepToString(newSubVoteArray));
		
		return newSubVoteArray;
	}
	
	private int[][] CreateSortedVotesMatrix(String[][] onenewSubVoteArray, String[] oneImportedTeamMember, int oneImportedNumberOfMember){
		
		initalizetoZero(oneImportedNumberOfMember);
		for (int counter=0; counter < oneImportedNumberOfMember; counter++) {
		
			for (int counted=0; counted<onenewSubVoteArray[counter].length; counted++) {
				for (int membercounter=0; membercounter<oneImportedNumberOfMember; membercounter++){
					if(oneImportedTeamMember[membercounter].equals(onenewSubVoteArray[counter][counted])){
						FinalVotes[counter][membercounter] = Integer.parseInt(onenewSubVoteArray[counter][counted+1]);					
					}
					else {
						continue;
					}
				}
				
			}
			
		}
				
		return FinalVotes;
	}
	
	public int[][] getFinalVotes(){
		return FinalVotes;
	}

	private int[][] initalizetoZero(int anImportedNumberOfMember) {
		FinalVotes= new int[anImportedNumberOfMember][anImportedNumberOfMember];
		for (int outer = 0; outer < anImportedNumberOfMember; outer ++) {
			for (int inner = 0; inner <anImportedNumberOfMember; inner ++) {
				FinalVotes[outer][inner] = 0;
			}
		}
		return FinalVotes;
	}
	
	public double[][] CreateRatioMatrix(int[][] aFinalVotes){
		initalizetoOne(ImportedNumberOfMember);
		for (int outer = 0; outer < ImportedNumberOfMember; outer ++) {
			for (int inner = 0; inner <ImportedNumberOfMember; inner ++) {
				RatioVotes[outer][inner] = (double)FinalVotes[outer][inner] / (double)(100 - FinalVotes[outer][inner]);
			}
		}		
		return RatioVotes;
		
	}
	
	private double[][] initalizetoOne(int anImportedNumberOfMember) {
		RatioVotes= new double[anImportedNumberOfMember][anImportedNumberOfMember];
		for (int outer = 0; outer < anImportedNumberOfMember; outer ++) {
			for (int inner = 0; inner <anImportedNumberOfMember; inner ++) {
				RatioVotes[outer][inner] = 1;
			}
		}
		return RatioVotes;
	}

	//Next: Remove the first assigner name from each sub string
	//Then: create the scanning mechanism to compare the team member matrix with the elements in the removed assign
	//then: if this a match, take the i+1 element and put it into the FINAL votes matrix
	//Also need to add a try/catch so the user CANNOT add integers like 100 as member names
}
