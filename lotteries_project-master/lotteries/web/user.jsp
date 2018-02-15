<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="querries.User"%>
<%@ page import="querries.Ticket"%>

<%
User user = (User) request.getAttribute("user");
ArrayList<Ticket> resultlist = user.ticketList;
String username = user.username;
%>

<!DOCTYPE html>
<html>
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="validate.js"></script>
	
	<link rel=stylesheet type="text/css" href="css.css">
	<link rel=stylesheet type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
	<title>My tickets</title>
</head>
<body>

    <div class="container">

        <div class="card2 card-container2">
		
            <h4> Welcome user <%=username%> </h4>
		
            <div class="table-responsive">
            		<table class="table table-striped table-bordered table-hover table-condensed">
              			<tr class="warning">
              				<th>Ticket Number</th>
              				<th>Ticket Date</th>
              				<th>Is a winning ticket</th>
              			</tr>

			<% if (resultlist == null || resultlist.size() == 0) { %>
						<tr>
							<td colspan="3" class="bg-danger text-center">
								No tickets found</b>
							</td>
						</tr>
			<% } else {
					
					for (Ticket ticket : resultlist) {
			%>
						<tr>
              				<td><%=ticket.ticket_id %></td>
							<td><%=ticket.date %></td>
							<td><%=ticket.iswinner %></td>
                                                       
              			</tr>	
				<%  } %>
						
			<% } %>              			
          			</table>
          		</div>
  

	<div class="" >  
            <form action="inserttickets" method="post"> <p><h4>Purchase more tickets</h4></p>
	  <div class="form-group">
		<label for="amount">Number of tickets</label>
		<input type="text" name="ticketAmount" class="form-control" id="ticketAmount" placeholder="Enter number of tickets">
		</div>
            
            
            
            
            <div class="form-group" style="display:none !important;">
            <label for="credit">hidden username field</label>
            <input type="text" name="un" class="form-control" id="hiddenusername" placeholder="Enter Credit Card Number" value="<%=username%>">
            </div>           
            
            
            
            
          <div class="form-group">
            <label for="credit">Credit Card Number</label>
            <input type="text" class="form-control" id="credit" placeholder="Enter Credit Card Number">
          </div>
          <div class="form-group">
            <label for="cvc">CVC</label>
            <input type="password" class="form-control" id="cvc" placeholder="CVC">
          </div>
          <div class="form-group">
             <label class="col-sm-12 control-label" for="expiry-month">Expiration Date</label>
                <div class="row" style="margin-left:0px !important;">
                   <select class="form-control col-sm-4" name="expiry-month" id="expiry-month">
                     <option value="01">Jan (01)</option>
                     <option value="02">Feb (02)</option>
                     <option value="03">Mar (03)</option>
                     <option value="04">Apr (04)</option>
                     <option value="05">May (05)</option>
                     <option value="06">June (06)</option>
                     <option value="07">July (07)</option>
                     <option value="08">Aug (08)</option>
                     <option value="09">Sep (09)</option>
                     <option value="10">Oct (10)</option>
                     <option value="11">Nov (11)</option>
                     <option value="12">Dec (12)</option>
                   </select>
                   <select class="form-control col-sm-4" name="expiry-year">
                     <option value="18" selected="selected">2018</option>
                     <option value="19">2019</option>
                     <option value="20">2020</option>
                     <option value="21">2021</option>
                     <option value="22">2022</option>
                     <option value="23">2023</option>
                     <option value="24">2024</option>
                     <option value="25">2025</option>
                     <option value="26">2026</option>
                   </select>
                 </div>
           </div>
          <button type="submit" class="btn btn-primary" id="submit-button" >Submit</button>

        </form>
       </div>
        
      </div>
</div>
</body>
</html>