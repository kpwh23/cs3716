import java.io.*;
import java.util.ArrayList;

public class ReadObject {
	private ArrayList<Object> lines;
	private String filename;

	public ReadObject(String f) {
		filename = f;		
		lines = new ArrayList<Object>();		
		
		try
		  {
			
			FileInputStream fis = new FileInputStream(filename);
			ObjectInputStream ois = new ObjectInputStream(fis);

			Object object = new Object();
			
			// if file doesn't exists, then create it
			while ((object = ois.readObject()) != null)
			{
				lines.add(object);
			}
			ois.close();
			fis.close();
			
		  }
		  catch (IOException | ClassNotFoundException e)
		  {
		   // System.err.format("Exception occurred trying to read '%s'.", filename);
		    //e.printStackTrace();
		   
		  }
		  
	}
	
	
	public ArrayList<Object> getObjects(){
		return lines;
	}
	
	

}
