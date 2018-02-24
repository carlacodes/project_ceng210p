package project;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.Scanner;
    public class WriteOut {
    private int NumberOfMember;
   	private String ProjectName;
    private String[] TeamMember;
    public static String fileName;
    private int[][] Vote;
   
    public int FirstExport(int NumberOfMember, String ProjectName, String[] TeamMember) {
    	
    	
    	return NumberOfMember;
        } 
        public int[][] SecondExport(int[][] Vote)  {
        	System.out.println("hello"); //test to see if this is being called correctly
			
        	try 
            {
                String content = "This is the content to write into file"; //Test content
                BufferedWriter bw = new BufferedWriter(new FileWriter(fileName+".txt", true));
                bw.append(content);
                System.out.println("Done"); //Test to see if this is being called
                bw.flush();
                bw.close();
               
            } catch (IOException e) 
            {
                e.printStackTrace();
            }
			return Vote;
   
        }
      //outputStream.println("Votes for"+ TeamMember[i-1]+":"+Vote[i-1]);
    }
    
   
	
    
    
    
	
	
	
	
	
	
	
	

