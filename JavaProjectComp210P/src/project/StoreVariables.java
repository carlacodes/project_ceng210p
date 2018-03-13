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
	private String[][] SubVoteArray;
	private String[] TeamMemberContent;
	private double[] Score;
	private int i;

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

	public void ImportComponents() {
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

		return TeamMemberContent;
	}

	private String[][] CreateSubString1(String[] aTeamMemberContent, int oneImportedNumberOfMember) {
		String[][] SubVoteArray = new String[oneImportedNumberOfMember][2 * (oneImportedNumberOfMember - 1) + 1];
		System.out.println(Arrays.toString(aTeamMemberContent));
		int inner = 0;
		for (int outer = 0; outer < (oneImportedNumberOfMember); outer++) {
			System.out.println("outer change");
			System.out.println(outer);

			for (int j = 0; inner < (outer * 2 * (oneImportedNumberOfMember - 1) + 1
					+ 2 * (oneImportedNumberOfMember - 1)); j++, inner++) {

				System.out.println("j= " + j);
				System.out.println("inner= " + inner);
				System.out.println(aTeamMemberContent[inner]);
				SubVoteArray[outer][j] = aTeamMemberContent[inner];
				// System.out.println("test"+Arrays.toString(aTeamMemberContent));
			}
		}
		inner++;
		SubVoteArray[oneImportedNumberOfMember - 1][2 * (oneImportedNumberOfMember - 1)] = aTeamMemberContent[inner
				- 1];

		System.out.println(Arrays.deepToString(SubVoteArray));

		return SubVoteArray;
	}

	//Next: Remove the first assigner name from each sub string
	//Then: create the scanning mechanism to compare the team member matrix with the elements in the removed assign
	//then: if this a match, take the i+1 element and put it into the FINAL votes matrix
	//Also need to add a try/catch so the user CANNOT add integers like 100 as member names
}
