package simpleperson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PersonWriter {
    
    public static void pWriter (File file, String[] line) throws IOException {
    FileWriter fw = new FileWriter(file);
        int j;
	for (int i = 0; i < 3; i++) {
                j=i+1;
		fw.write("Line"+ j +": " + line[i]);
                fw.write(System.getProperty( "line.separator" ));
	}
 
	fw.close();
    }
}
