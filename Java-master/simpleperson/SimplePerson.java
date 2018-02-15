/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleperson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author agios
 */
public class SimplePerson {

    /**
     * @param args the command line arguments
     */
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
     person.setName(name);
     
     System.out.println("Dwse to epwnymo sou");
     lname = in.nextLine();
     person.setLname(lname);
     
     System.out.println("Dwse to onoma tou patera sou");
     fname = in.nextLine();
     person.setFname(fname);
     
     System.out.println("Dwse imerominia gennisis xwrismeni me kena (px 13 11 1990)");
     bdate = in.nextLine();
     person.setDate(bdate);
     String[] bdatearr = bdate.split(" ");
     age = 2017 - Integer.parseInt(bdatearr[2]);
     person.setAge(age);
          
     // anaktisi timwn
     name = person.getName();
     lname = person.getLname();
     fname = person.getFname();
     bdate = person.getDate();
     age = person.getAge();
     
     line[0] = lname +" "+ name +" "+ fname;
     line[1] = bdatearr[0]+"/"+bdatearr[1]+"/"+bdatearr[2];
     line[2] = Integer.toString(age);
     
     FileWriter fw = new FileWriter("out.txt");
        int j;
	for (int i = 0; i < 3; i++) {
                j=i+1;
		fw.write("Line "+ j +": " + line[i]);
                fw.write(System.getProperty( "line.separator" ));
	}
 
	fw.close();
        
    }
    
}
