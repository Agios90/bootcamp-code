/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package querries;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
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
import java.util.Date;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author lefte
 */
@WebServlet(name = "inserttickets", urlPatterns = {"/inserttickets"})
public class insertlotteries extends HttpServlet {

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
      String title = "user added";
      
      String docType =
         "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
      
      out.println(docType +
         "<html>\n <h4>Tickets were probably added, go back and refresh the page to see them</h4>");

      try {
          
Class.forName("com.mysql.jdbc.Driver");

         Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         
        PreparedStatement pstmt = null;

          
          int amount = parseInt(request.getParameter("ticketAmount"));
          String username = request.getParameter("un");
          String insertion = "INSERT INTO `tickets` (`username`) VALUES ( ? );";
          pstmt = conn.prepareStatement(insertion);
          pstmt.setString(1,username);
          for (int i=0; i<amount; i++) {
              pstmt.executeUpdate();
          }
                            
         out.println("</body></html>");

         // Clean-up environment
         pstmt.close();
         conn.close();
         
         out.println("</html>");

         // Clean-up environment
         pstmt.close();
         conn.close();
         
      } catch(SQLException se) {
         //Handle errors for JDBC
         se.printStackTrace();
      } catch(Exception e) {
         //Handle errors for Class.forName
         e.printStackTrace();
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
