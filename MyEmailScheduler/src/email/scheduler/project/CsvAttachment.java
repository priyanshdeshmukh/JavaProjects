package email.scheduler.project;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;

public class CsvAttachment {
	
	public static void writeDataForCustomSeperatorCSV(String location) 
	{ 
	   
	    File file = new File(location);  // first create file object for file placed at location specified by filepath 
	  
	    try { 
	        // create FileWriter object with file as parameter 
	        FileWriter outputfile = new FileWriter(file); 
	  
	        // create CSVWriter with '|' as separator 
	        CSVWriter writer = new CSVWriter(outputfile, '|', 
	                                         CSVWriter.NO_QUOTE_CHARACTER, 
	                                         CSVWriter.DEFAULT_ESCAPE_CHARACTER, 
	                                         CSVWriter.DEFAULT_LINE_END); 
	  
	        // create a List which contains String array 
	        List<String[]> data = new ArrayList<String[]>(); 
	        data.add(new String[] { "Name", "Class", "Marks" }); 
	        data.add(new String[] { "Aman", "10", "620" }); 
	        data.add(new String[] { "Suraj", "10", "630" }); 
	        writer.writeAll(data); 
	        
	        //writer.writeAll(result);   
	  
	        // closing writer connection 
	        writer.close(); 
	    } 
	    catch (Exception e) { 
	        // TODO Auto-generated catch block 
	        e.printStackTrace(); 
	    } 
	} 
}