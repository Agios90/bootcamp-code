package katalogos;

import java.sql.*;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Katalogos {
    
    //Κάθε φορά πριν τρέξουμε αυτό το Java αρχείο πρέπει να κάνουμε source το tilefwna.txt
    //απ'το CMD επειδή αντιμετώπισα δυσκολία για να το κάνω αυτό με κώδικα java

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/tilefwna";
 
    static final String USER = "root";
    static final String PASS = "pass";

    public static void main(String[] args) {
        
        Connection conn = null;
        Statement stmt = null;
        Statement stmt2 = null;
        //το δεύτερο statement χρειάζεται όταν θέλουμε να τρέξουμε ένα δεύτερο
        //ResultSet ενώ το αρχικό είναι μέσα στο rs.next() loop
            
        try {    
            Class.forName(JDBC_DRIVER);
        }catch(Exception e) {e.printStackTrace();}
            
            System.out.println("Connecting to database");
        try {
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        }catch(SQLException e) {e.printStackTrace();}  
            System.out.println("Creating statement...");
        try {
            stmt = conn.createStatement();
            stmt2 = conn.createStatement();
        }catch(SQLException e) {e.printStackTrace();}
               
            String sql;
            sql = "SELECT name,lastname,kinito,stathero FROM members";
            
        try {
            ResultSet rs = stmt.executeQuery(sql);
            
            System.out.println("Displaying all records: ");
            System.out.println("_______________________");
            while (rs.next()) {
                long kinito = rs.getLong("kinito");
                long stathero = rs.getLong("stathero");
                String firstname = rs.getString("name");
                String lastname = rs.getString("lastname");
                
                System.out.println("First name: " + firstname);
                System.out.println("Last Name: " + lastname);
                System.out.println("Mobile phone: " + kinito);
                System.out.println("Home phone: " + stathero);
                System.out.println();
                
            }
            
            //Βάζουμε εγγραφές στο members με τυχαία τηλέφωνα
            System.out.println("_______________________");
            int i=0;
            int minNum = 100000000;
            int maxNum = 999999999;
           
            while (i<2) {
                int randomNum1 = ThreadLocalRandom.current().nextInt(minNum, maxNum);
                int randomNum2 = ThreadLocalRandom.current().nextInt(minNum, maxNum);
               
                sql = "INSERT INTO members(name,lastname,kinito,stathero) VALUES ('SampleName" + i + "','SampleLastName" + i + "',"+randomNum1+","+randomNum2+");";
                i++;
                int rowsUpdated = stmt.executeUpdate(sql);
   
            }
            
            //Ζητάμε στοιχεία και αν βρεθούν εμφανίζουμε τα τηλέφωνα
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your last name: ");
            String lastname = scanner.nextLine();
            System.out.println("Enter your firstname");
            String firstname = scanner.nextLine();
            
            String sql1="Select * FROM members where name = '" + firstname + "' AND lastname = '" + lastname + "'";
            
            rs = stmt.executeQuery(sql1);
            if (!rs.next()) System.out.println("No results found");
            rs.previous();
            while (rs.next()) {
                
            System.out.println();
            System.out.println("Your phone numbers are: ");
            System.out.println(rs.getInt("kinito"));
            System.out.println(rs.getInt("stathero"));
            }
            
            //Ζητάμε επώνυμο και αν βρεθεί γίνεται update το κινητό τηλέφωνο
            System.out.println("_______________________");
            System.out.println("enter your last name to update your mobile phone: ");
            String lastnameupdate = scanner.nextLine();
            System.out.println("Enter your new mobile phone number");
            int newphone = scanner.nextInt();
            String sql2 = "UPDATE members SET kinito = " + newphone + " WHERE lastname = '" + lastnameupdate + "' LIMIT 1;";
            int rowsUpdated = stmt.executeUpdate(sql2);
            System.out.println(rowsUpdated + " records have been updated");
            
            System.out.println("_______________________");
            
            //Εμφανίζουμε το count των στοιχείων του table members
            System.out.println("Displaying count of records: ");
            String sql3 = "SELECT COUNT(*) FROM members;";
            rs = stmt.executeQuery(sql3);
            rs.next();
            int count = Integer.parseInt(rs.getString("Count(*)"));
            System.out.println(count);
            System.out.println("_______________________");
            
            //Φτιάχνουμε ένα νέο table birthday και για κάθε χρήστη ζητάμε την ημερομηνία γέννησης του
            String sql4 = "CREATE TABLE birthday (userid int(10) unsigned not null, birthday date not null, FOREIGN KEY (userid) REFERENCES members(id) ON UPDATE CASCADE)";
            int tableUpdated = stmt.executeUpdate(sql4);
                    
            String sql5 = "SELECT name,lastname,kinito,stathero FROM members;";
            int c = 0;
            rs = stmt.executeQuery(sql5);
            
            Scanner scanner2 = new Scanner(System.in);
            
            while (rs.next()) {
                
                c++;
                long kinito = rs.getLong("kinito");
                long stathero = rs.getLong("stathero");
                String fname = rs.getString("name");
                String lname = rs.getString("lastname");
                
                System.out.println("Enter birthdate for user (format YYYY-MM-DD): "+fname+ " "+lname);
                
                String birthD = scanner2.nextLine();
                String sql6 = "INSERT INTO birthday VALUES ("+c+",'"+birthD+"');";
                int rowsInserted = stmt2.executeUpdate(sql6);
                
            }
            
            System.out.println("_______________________");
            
            //Ζητάμε ένα date και εμφανίζουμε τους χρήστες που γεννήθηκαν εκείνη τη μέρα
            System.out.println("Enter a date (format YYYY-MM-DD) and find out if anyone was born on that day: ");
            Scanner scanner3 = new Scanner(System.in);
            String date = scanner3.nextLine();
            System.out.println();
            String sql7 = "SELECT members.name AS name,members.lastname AS lastname FROM members,birthday WHERE members.id=birthday.userid AND birthday.birthday = '"+date+"';";
            rs = stmt.executeQuery(sql7);
            System.out.println("The following members were born on "+ date +": ");
            System.out.println();
            
            while (rs.next()) {
                String fname = rs.getString("name");
                String lname = rs.getString("lastname");
                System.out.println(fname + " "+lname);
            }            
            System.out.println("_______________________");
            
            //Δημιουργία αντιγράφου του πίνακα members με απλές εντολές SQL
            System.out.println("Copying members...");
            rs = stmt.executeQuery("SHOW CREATE TABLE members");
            rs.next();
            String s = rs.getString("Create Table");
            String s2 = s.replace("members", "members2");
            stmt.executeUpdate(s2);
            rs = stmt.executeQuery("SELECT * FROM members");
            while(rs.next()) {
                String fname = rs.getString("name");
                String lname = rs.getString("lastname");
                int kinito= rs.getInt("kinito");
                int stathero= rs.getInt("stathero");
                stmt2.executeUpdate("INSERT INTO members2(name,lastname,kinito,stathero) VALUES ('"+fname+"','"+lname+"',"+kinito+","+stathero+");");
                
            }
            System.out.println("_______________________");
            
            //Δημιουργία αντιγράφου του πίνακα members με "σύνθετη" εντολή SQL
            System.out.println("Copying members again...");
            stmt.executeUpdate("CREATE TABLE members3 LIKE members2;");
            stmt.executeUpdate("INSERT members3 SELECT * FROM members;");
            
            //TODO
            //Εκτύπωση στην οθόνη του πηγαίου κώδικα για τη δημιουργία των tables και
            //της εισαγωγής δεδομένων ΧΩΡΙΣ τη χρήση mysqldump
            
            rs.close();
            
            }catch(Exception e) {e.printStackTrace();}
            
        try {
            stmt.close();
            stmt2.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        try {
            conn.close();
             } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}