package sakiladb;

//import java.beans.Statement;
import java.sql.*;

public class SakilaDB {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/sakila";
    
    static final String USER = "root";
    static final String PASS = "pass";

    public static void main(String[] args) {
        
        Connection conn = null;
        Statement stmt = null;
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            
            System.out.println("Connecting to database");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT actor_id, first_name, last_name FROM actor";
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                int actor_id = rs.getInt("actor_id");
                String firstname = rs.getString ("first_name");
                String lastname = rs.getString("last_name");
                
                System.out.println("ActorID " + actor_id);
                System.out.println(", First name: " + firstname);
                System.out.println(", Last Name: " + lastname);
                
            }
                
            rs.close();
            stmt.close();
            conn.close();
            
        }
        catch(SQLException se) {
            
            se.printStackTrace();
            
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            
            
            try {
                if (stmt!=null)
                    stmt.close();
                
            }
            catch(SQLException se2){}
            
            try {
                if (conn!=null)
                    conn.close();
                
            }
            catch(SQLException se) {
                se.printStackTrace();
            }
        }
        
        System.out.println("Finished");
    }
    
}
