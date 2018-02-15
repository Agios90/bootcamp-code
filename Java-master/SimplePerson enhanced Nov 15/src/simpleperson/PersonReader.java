package simpleperson;

import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.System.in;
import java.util.Scanner;


public class PersonReader {
    
    public static String[] pReader() throws FileNotFoundException {
        
     String[] arr = new String[3];
     String path = "C:\\temp\\temp1\\file.txt";
     Scanner fileIn = new Scanner(new File(path));
     for (int i=0; i<3; i++) {
         arr[i] = fileIn.nextLine();
     }
     
     String name = arr[0].split(" ")[1];
     String lname = arr[0].split(" ")[2];
     String fname = arr[0].split(" ")[3];
     String date = arr[1].split(" ")[1];
     String age = arr[2].split(" ")[1];
     
     Person person = new Person();
     person.setString(1,name);
     person.setString(2,lname);
     person.setString(3,fname);
     person.setString(4,date);
     person.setAge(Integer.parseInt(age));
     
     String[] returnarray = {name,lname,fname,date,age};
     
     
     return returnarray;
    }
    
}
