package project;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class WriteOut 
{
    public static String fileName;
	// ------------------------------------------------------------------------------------------------------
	// Declaration of FirstExport() method to return number of members
	// ------------------------------------------------------------------------------------------------------		
	public int FirstExport(int NumberOfMember, String ProjectName, String[] TeamMember) 
	{
		return NumberOfMember;
	}

	// ------------------------------------------------------------------------------------------------------
	// Declaration of SecondExport() method to return member votes
	// ------------------------------------------------------------------------------------------------------			
	public int[][] SecondExport(int[][] Vote) 
	{
		try 
		{
			String content = "This is the content to write into file"; // Test content
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileName + ".txt", true));
			bw.append(content);
			System.out.println("Done"); // Test to see if this is being called
			bw.flush();
			bw.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return Vote;
	}
}
