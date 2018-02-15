package simpleperson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SimplePerson {

    public static void main(String[] args) throws IOException {
     
        //dilwsi object kai metavlitwn
     Person person = new Person();
    
     String[] line = new String[3];
     String name, lname, fname;
     String bdate;
     int age;
        
     Scanner in = new Scanner(System.in);
     
     // kataxwrisi kai anathesi timwn
     System.out.println("Dwse to onoma sou");
     name = in.nextLine();
     person.setString(1,name);
     
     System.out.println("Dwse to epwnymo sou");
     lname = in.nextLine();
     person.setString(2,lname);
     
     System.out.println("Dwse to onoma tou patera sou");
     fname = in.nextLine();
     person.setString(3,fname);
     
     System.out.println("Dwse imerominia gennisis xwrismeni me kena (px 13 11 1990)");
     bdate = in.nextLine();
     person.setString(4,bdate);
     
     bdate = person.getString(4);
     String[] bdatearr = bdate.split(" ");
     age = 2017 - Integer.parseInt(bdatearr[2]);
     person.setAge(age);
          
     // anaktisi timwn
     name = person.getString(1);
     lname = person.getString(2);
     fname = person.getString(3);
     age = person.getAge();
     
     line[0] = lname +" "+ name +" "+ fname;
     line[1] = bdatearr[0]+"/"+bdatearr[1]+"/"+bdatearr[2];
     line[2] = Integer.toString(age);
    
     String path = "C:\\temp\\temp1\\";
     File file = new File(path+"file.txt");
     file.getParentFile().mkdirs();
     
     System.out.println("________________________");
     System.out.println("Methodos PersonWriter: file.txt created with your info");
     System.out.println("________________________");
     PersonWriter.pWriter(file,line);
     
     System.out.println("Methodos PersonReader: reading file.txt \nand printing its contents (your input) and your age");
     System.out.println("________________________");
     String[] readarr = new String[5];
     readarr = PersonReader.pReader();
     
     System.out.println("Your name is: "+readarr[1]);
     System.out.println("Your lastname is: "+readarr[0]);
     System.out.println("Your father's name is: "+readarr[2]);
     System.out.println("Your date of birth is: "+readarr[3]);
     System.out.println("Your age is: "+readarr[4]);
        
    }
    
}
