<%@page import="Model.Model_User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%Model_User user = (Model_User) request.getSession().getAttribute("SUser");
 %>
    
	<!DOCTYPE html>
	<html>
		<head>
			<meta charset="ISO-8859-1">
			<title>My account</title>
			<link rel="stylesheet" type="text/css" href="css/style.css" />
			
		</head>
		
		<body>
			<div id="wrap">
				<%@ include file="header.jsp" %>
				<div class="center_content">
			       	<div class="left_content">
			            <div class="title"><span class="title_icon"><img src="images/bullet1.gif" alt="" title="" /></span>My account</div>
			        
			            <%if(user==null){ %>
			        	<div class="feat_prod_box_details">            
			              	<div class="contact_form">
			                <div class="form_subtitle">login into your account</div>
			                 
			                 <form method="POST" action="servletuser.do">          
			                    <div class="form_row">
			                    <label class="contact"><strong>Username:</strong></label>
			                    <input type="text"  name="username" required />
			                    </div>  
			
			
			                    <div class="form_row">
			                    <label class="contact"><strong>Password:</strong></label>
			                    <input type="password" name="password" required />
			                    </div>                     
			                    <div class="form_row">
			                    <input type="submit" class="register" value="login" />
			                    </div>   
			                    
			                  </form>
			                  <a href="register.jsp" class="view_cart">Créer nouveau compte</a>
			                       
			                    
			                </div>  
			            
			            </div>	
			            <%}else{%> 
			            </br></br></br></br></br></br>
			            <p>bonjour <%=user.getUsername() %></p>
			            <p>password <%=user.getPassword() %></p> 
			            <p>email <%=user.getEmail() %></p> 
			            <p>phone <%=user.getPhone() %></p> 
			            <p>company <%=user.getCompany() %></p> 
			            <p>salaire <%=user.getSalaire() %></p> 
			            </br></br>
			            <a href="servletlogout.do" class="view_cart">logout</a>  			             
			            <%} %>          
			        <div class="clear"></div>
			        </div><!--end of left content-->
			           <%@ include file="cartInfo.jsp" %>								
			        
			        </div>
							<%@ include file="footer.jsp" %>
			</div>
			
		</body>
	</html>

    
