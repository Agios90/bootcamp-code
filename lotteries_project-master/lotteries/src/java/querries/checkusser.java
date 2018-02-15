/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package querries;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.sql.Timestamp;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author lefte
 */
@WebServlet(name = "checkuser", urlPatterns = {"/checkuser"})
public class checkusser extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
     // JDBC driver name and database URL
      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
      static final String DB_URL="jdbc:mysql://localhost/lottery";

      //  Database credentials
      static final String USER = "lotteryuser";
      static final String PASS = "pass";
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
          response.setContentType("text/html");
      //PrintWriter out = response.getWriter();
      String title = "apotelesma an iparxei";
      
      String docType =
         "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
      
      out.println(docType +
         "<html>\n");
      
      try {
          
Class.forName("com.mysql.jdbc.Driver");
         // Open a connection
         Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         // Register JDBC driver
        // Execute SQL query
         
         String sql;
         PreparedStatement pstmt = null;
         sql = "SELECT  `privilege`, users.username, `ticket_id`, `date`,`iswinner`  FROM users LEFT JOIN tickets ON users.username = tickets.username where users.username = ? and `password` = ?;";
         pstmt = conn.prepareStatement(sql);
        String username,password;
         username = request.getParameter("inputName");
         password = request.getParameter("inputPassword");
         pstmt.setString(1,username );
         pstmt.setString(2,password );
         ResultSet rs = pstmt.executeQuery();
//int o=0;
//out.println("<body>");         
// Extract data from result set
         if(rs.next()){
            //Retrieve by column name
           // int id  = rs.getInt("id");
            String ticket_id = rs.getString("ticket_id");
            boolean iswinner = rs.getBoolean("iswinner");
            Timestamp date = rs.getTimestamp("date");
            
            Ticket ticket = new Ticket(ticket_id, date, iswinner, username);
            User user = new User();
            user.username = username;
            user.ticketList.add(ticket);
            user.priviledge = rs.getBoolean("privilege");
            
            while (rs.next()){
                ticket_id = rs.getString("ticket_id");
                iswinner = rs.getBoolean("iswinner");
                Timestamp date2 = rs.getTimestamp("date");

                ticket = new Ticket(ticket_id, date2, iswinner, username);
                user.ticketList.add(ticket);
            }

            if (user.priviledge){
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin.jsp");
                request.setAttribute("user", user);
                rd.forward(request, response);
            }else{
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/user.jsp");
                request.setAttribute("user", user);
                rd.forward(request, response);
            }
              
              
              
            
         }
         else{
                        out.println("o xristis den iparxei"+"<br>");

         }
         out.println("</body></html>");

         // Clean-up environment
         rs.close();
         pstmt.close();
         conn.close();
      } catch(SQLException se) {
         //Handle errors for JDBC
         out.println(se.toString());
      } catch(Exception e) {
         //Handle errors for Class.forName
         out.println(e.toString());
      } 
      } //end try

      
      
      
      
      
      
        }
    


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
