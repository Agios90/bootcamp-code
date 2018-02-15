package simple_java_application_1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Simple_java_application_1 {

    
    public static void main(String[] args) throws IOException {
        
        String[] line = new String[3];
        String name, sname, fname;
        String bdate;
        int age;
        
        Scanner in = new Scanner(System.in);
        System.out.println("Dwse to onoma sou");
        name = in.nextLine();
        System.out.println("Dwse to epwnymo sou");
        sname = in.nextLine();
        System.out.println("Dwse to onoma tou patera sou");
        fname = in.nextLine();
        
        line[0] = sname +" "+ name +" "+ fname;
        
        System.out.println("Dwse imerominia gennisis xwrismeni me kena (px 13 11 1990)");
        bdate = in.nextLine();
        String[] bdatearr = bdate.split(" ");
        
        age = 2017 - Integer.parseInt(bdatearr[2]);
        
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
