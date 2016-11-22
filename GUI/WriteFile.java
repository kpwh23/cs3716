import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
	private String line;
	private String filename;
	public WriteFile() {
	}
	
	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public void writeline(){
		try {
	
		File file = new File(filename);

		// if file doesn't exists, then create it
		if (!file.exists()) {
			file.createNewFile();
		}

		FileWriter fw = new FileWriter(file,true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(line);
		bw.newLine();
		bw.close();
		line="";

	} catch (IOException e) {
		e.printStackTrace();
	}
	}
}
