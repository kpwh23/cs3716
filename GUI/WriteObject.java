import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class WriteObject {
	private Object object;
	private String filename;
	public WriteObject() {
	}
	
	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public void writeObject(){
		try {
	
		File file = new File(filename);
		FileOutputStream fos = new FileOutputStream(filename,true);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		// if file doesn't exists, then create it
		if (!file.exists()) {
			file.createNewFile();
		}

		oos.writeObject(object);
		oos.close();
		object=null;

	} catch (IOException e) {
		e.printStackTrace();
	}
	}
	
	public static void main ( String[] args ) {
		WriteObject writer = new WriteObject();
		writer.setFilename("testFile.txt");
		
		Date date = new Date();
		Tournament tttt = new Tournament("NameA", "LocationB", date);
		Tournament abcd = new Tournament("bbb", "acd", date);
		
		writer.setObject(tttt);
		writer.writeObject();
		writer.setObject(abcd);
		writer.writeObject();
		
		ReadObject reader = new ReadObject("testFile.txt");
		ArrayList<Object> aaaa= reader.getObjects();
		ArrayList<Tournament> bbbb = new ArrayList<Tournament>();

		
		for(int i=0; i<aaaa.size();i++){
			bbbb.add((Tournament) aaaa.get(i));
			
			System.out.println(bbbb.get(i).getName());
			System.out.println(bbbb.get(i).getLocation());
		}
		
		
	}
}
