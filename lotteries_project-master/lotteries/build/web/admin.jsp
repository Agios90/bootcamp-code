<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="querries.*"%>

<%
User user = (User) request.getAttribute("user");
ArrayList<Ticket> resultlist = user.ticketList;
%>

<%
      String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
      String DB_URL="jdbc:mysql://localhost/lottery";

      String USER = "lotteryuser";
      String PASS = "pass";
      Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         
         PreparedStatement pstmt = null;

          String username = request.getParameter("un");
          String sql = "SELECT * FROM tickets WHERE iswinner=true;";
          pstmt = conn.prepareStatement(sql);
          ResultSet rs = pstmt.executeQuery();   

          PreparedStatement pstmt2 = null;

          String sql2 = "SELECT COUNT(*) FROM tickets";
          pstmt = conn.prepareStatement(sql2);
          ResultSet rs2 = pstmt.executeQuery(); 
          rs2.next();
          int count=rs2.getInt("COUNT(*)");
%>
    
<!DOCTYPE html>
<html>
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="validate.js"></script>
	
	<link rel=stylesheet type="text/css" href="css.css">
	<link rel=stylesheet type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
	<title>Administration</title>
</head>
<body>

    <div class="container">

        <div class="card2 card-container2">
		
		
		
		<p><h4> Welcome, administrator. Press the button below to finish today's draw and view the winning ticket's details.</h4></p>
		
                  <form action="finishlottery" method="post">
		<button id="doDrawbtn" name="doDrawbtn" class="btn btn-lg btn-success btn-block btn-signin" type="submit">Finish today's Draw</button>
                </form>
                    
		<div class="table-responsive">
            		<table class="table table-striped table-bordered table-hover table-condensed">
              			<tr class="warning">
              				<th>Tickets Sold</th>
              				<th>Winning Ticket ID</th>
              				<th>Date</th>
              				<th>Winner's Earnings</th>
							<th>Winner's Username</th>
              			</tr>

			<% if (!rs.next()) { %>
						<tr>
							<td colspan="5" class="text-center">
								No winning tickets found</b>
							</td>
						</tr>
			<% } else {
					
			%>
						<tr>
              				<td><%=count%></td>
              				<td><%=rs.getString("ticket_id") %></td>
							<td><%=rs.getString("date") %></td>
							<td>1000</td>
							<td><%=rs.getString("username") %></td>
              			</tr>	
						
			<% } %>              			
          			</table>
          		</div> <br/>
                        <p><h4> Select a start date and an end date, then press the button to view the winning tickets of past draws.&nbsp;<span style="color: red">This does not do anything right now.</span></h4></p>
				
				
		<form class="form-signin" action="datePLACEHOLDER" method="post">
		
			<input type="text" name ="startDate" id="startDate" class="form-control" placeholder="Start Date" required>
			
			<input type="text" name ="endDate" id="endDate" class="form-control" placeholder="End Date" required>
			
			
			<button id="SearchPastDrawsbtn" name="SearchPastDrawsbtn" class="btn btn-lg btn-success btn-block btn-signin" type="submit" style="size:100px !important;">Search Past Draws</button>
		</form>
		
		<div class="table-responsive">
            		<table class="table table-striped table-bordered table-hover table-condensed">
              			<tr class="warning">
              				<th>Tickets Sold</th>
              				<th>Ticket Number</th>
              				<th>Ticket Date</th>
              				<th>Earnings</th>
							<th>Username</th>
              			</tr>

			<% if (rs == null || resultlist.size() == 0) { %>
						<tr>
							<td colspan="5" class="bg-danger text-center">
								No tickets found</b>
							</td>
						</tr>
			<% } else {
					
					for (Ticket ticket : resultlist) {
			%>
						<tr>
              				<td></td>
              				<td></td>
							<td></td>
							<td></td>
							<td></td>
              			</tr>	
				<%  } %>
						
			<% } %>              			
          			</table>
          		</div> 
		
		</div>
	</div>
</body>
</html>