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
	private double[] Scores;
	private double[] ScoresDenominator;
	private int[] IntScores;

	// next line string-1 =total string
	// first int: Number
	// scan next string: project name
	// Scan Number of member strings after: TeamMember
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
			
		}
		
		// for ()
		setImportedVotes(ImportedNumberOfMember);
		CreateSortedVotesMatrix(newSubVoteArray, ImportedTeamMember, ImportedNumberOfMember);
		
		if(ImportedNumberOfMember==3) {
			CreateRatioMatrix(FinalVotes);
		}
		
		return FinalVotes;

	}

	

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
		
		initializeVotes(SubVoteArray, aImportedNumberOfMember, aImportedNumberOfMember);
		

		// System.out.print(Arrays.deepToString(SubVoteArray));
		i = 2 + aImportedNumberOfMember;
		String[] TeamMemberContent = new String[EverythingArray.length - i];
		for (int placeholder = 0; i < EverythingArray.length; i++, placeholder++) {
			TeamMemberContent[placeholder] = EverythingArray[i];

		}
		
		CreateSubString1(TeamMemberContent, aImportedNumberOfMember);
		CreateSubString2(SubVoteArray,aImportedNumberOfMember);
		
		return TeamMemberContent;
	}

	private String[][] CreateSubString1(String[] aTeamMemberContent, int oneImportedNumberOfMember) {
		SubVoteArray = new String[oneImportedNumberOfMember][2 * (oneImportedNumberOfMember - 1) + 1];
		
		int inner = 0;
		for (int outer = 0; outer < oneImportedNumberOfMember; outer++) {
			

			for (int j = 0; j < 2 * (oneImportedNumberOfMember - 1) + 1; j++, inner++) {

				
				SubVoteArray[outer][j] = aTeamMemberContent[inner];
				// System.out.println("test"+Arrays.toString(aTeamMemberContent));
			}
		}
		//inner++;
		//SubVoteArray[oneImportedNumberOfMember - 1][2 * (oneImportedNumberOfMember - 1)] = aTeamMemberContent[inner
		//		- 1];

		
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
		RatioVotes= new double[ImportedNumberOfMember][ImportedNumberOfMember];
		initalizetoOne(ImportedNumberOfMember);
		for (int outer = 0; outer < ImportedNumberOfMember; outer ++) {
			for (int inner = 0; inner <ImportedNumberOfMember; inner ++) {
				if (outer==inner) {
					continue;
				}	
				RatioVotes[outer][inner] = (double)FinalVotes[outer][inner] / (double)(100 - FinalVotes[outer][inner]);
				
			}
			
		}
		
		MakeScoreDenominator(RatioVotes);
		return RatioVotes;
		
	}
	
	public double[] MakeScoreDenominator(double[][] aRatioVotes){	
		ScoresDenominator=new double[ImportedNumberOfMember];
		
		for (int i=0; i<ImportedNumberOfMember; i++) {
			for (int counterIndex = 0; counterIndex < ImportedNumberOfMember; counterIndex++)
			{
				if (counterIndex == i)
				{
					ScoresDenominator[i]++;
				}
				else
				{
					for (int countedIndex=0; countedIndex < ImportedNumberOfMember; countedIndex ++)
					{
						if (i==countedIndex)
						{
							continue;
						}
						else
						{
							ScoresDenominator[i]+=aRatioVotes[counterIndex][countedIndex];
						}
					}
				}
			}		
		}
		
		MakeFinalScore(ScoresDenominator);
		return ScoresDenominator;
		
	}
	
	public double[] MakeFinalScore(double[] aScoresDenominator){	
		Scores = new double[ImportedNumberOfMember];
		for (int outer = 0; outer < ImportedNumberOfMember; outer ++) {
			
				Scores[outer]=(100/ScoresDenominator[outer]);
					
		}
		
		MakeScoresInt(Scores);
		return Scores;
		
	}
	
	public int[] MakeScoresInt(double[] aScores){
		IntScores= new int[ImportedNumberOfMember];
		for (int outer = 0; outer < ImportedNumberOfMember; outer ++) {
			
				IntScores[outer]=(int) Math.round(Scores[outer]);
					
		}
		
		
		return IntScores;
		
	}
	
	private double[][] initalizetoOne(int anImportedNumberOfMember) {
		
		for (int outer = 0; outer < anImportedNumberOfMember; outer ++) {
			for (int inner = 0; inner <anImportedNumberOfMember; inner ++) {
				RatioVotes[outer][inner] = 0;
				
			}
		}
		
		return RatioVotes;
	}
	
	public void PrintFinalResults() {
		for (int outer = 0; outer < ImportedNumberOfMember; outer ++) {
			System.out.println("\t" + ImportedTeamMember[outer] + ":\t" +IntScores[outer]);
		}
	}
	
	public int[] getIntScores()
	{
		return IntScores;
	}
	
	public String[] getImportedTeamMember()
	{
		return ImportedTeamMember;
	}


	//Next: Remove the first assigner name from each sub string
	//Then: create the scanning mechanism to compare the team member matrix with the elements in the removed assign
	//then: if this a match, take the i+1 element and put it into the FINAL votes matrix
	//Also need to add a try/catch so the user CANNOT add integers like 100 as member names
}
