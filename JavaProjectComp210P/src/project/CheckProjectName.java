package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

class CheckProjectName {
	    private int NumberOfMember;
	   	private String ProjectName;
	    private String[] TeamMember;
	    public static String fileName;
	    public static String project_User_Input;
	    private int[][] Vote;
	    public int CheckName(int NumberOfMember, String ProjectName, String[] TeamMember) {
	    	Scanner scan = new Scanner(System.in);
	    	System.out.println("Enter the project name:");
	    	project_User_Input=scan.next();
	    	File fileObject = new File(fileName+".txt");
		  
		    if (fileObject.exists( ))
		    {
		       System.out.println("There are X members");
		    }
	    	PrintWriter outputStream = null;
			try
		    {
		        outputStream =
		             new PrintWriter(new FileOutputStream(fileName+".txt"));
		    }
		    catch(FileNotFoundException e)
		    {
		        System.out.println("Error opening the file " + ProjectName +".txt");
		        System.exit(0);
		    }
			
			return NumberOfMember;
			
	    }
}
