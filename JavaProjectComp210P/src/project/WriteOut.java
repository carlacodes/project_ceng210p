package project;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
    public class WriteOut {
    public int NumberOfMember;
   	public String ProjectName;
    public String[] TeamMember;
    public String fileName;
    public int[] Votes;
	public static void main(String[] args) {
		System.out.println("hello");
		Scanner scan = new Scanner(System.in);
	    String fileName = null;
		System.out.println("Enter a file name to hold the Project:");
	    fileName = scan.nextLine( );
	    File fileObject = new File(fileName+".txt");
	    while (fileObject.exists( ))
	    {
	        System.out.println("There already is a file named "
	        + fileName);
	        System.out.println("Enter a different file name:");
	        fileName = scan.nextLine( );
	        fileObject = new File(fileName+".txt");
	    }
   }
	  
    public int FirstExport() {
    	PrintWriter outputStream = null;
	   
		try
	    {
	        outputStream =
	             new PrintWriter(new FileOutputStream(fileName+".txt"));
	    }
	    catch(FileNotFoundException e)
	    {
	        System.out.println("Error opening the file " + fileName +".txt");
	        System.exit(0);
	    }
    	for (int MemberCount = 1; MemberCount <= NumberOfMember; MemberCount ++) //For as long as the member count is less than the total number of members, the program will ask for the user input
    	{
    		//Statement of variable allocation to corresponding member position
    		outputStream.println("Team Member"+(MemberCount-1)+ ":"+TeamMember[MemberCount - 1]);
    	}
    	outputStream.println("Number of Members:"+ NumberOfMember+ "Project Name:"+ProjectName);
    	outputStream.close();
    	return NumberOfMember;
        }
  
    }
    
   
	
    
    
    
	
	
	
	
	
	
	
	

