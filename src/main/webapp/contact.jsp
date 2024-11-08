<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    
	<!DOCTYPE html>
	<html>
		<head>
			<meta charset="ISO-8859-1">
			<title>Contact</title>
			<link rel="stylesheet" type="text/css" href="css/style.css" />
			
		</head>
		
		<body>
			<div id="wrap">
				<%@ include file="header.jsp" %>
				       <div class="center_content">
		       	<div class="left_content">
		            <div class="title"><span class="title_icon"><img src="images/bullet1.gif" alt="" title="" /></span>Contact Us</div>
		        
		        	<div class="feat_prod_box_details">
		            <p class="details"> </p>
		            
		              	<div class="contact_form">
		                <div class="form_subtitle">all fields are requierd</div>          
		                    
		
							<form action="servletcontact.do" method="POST">          
			                    <div class="form_row">
			                    <label class="contact"><strong>Username:</strong></label>
			                    <input type="text" class="" name="username" required />
			                    </div>  
			
			
			                    <div class="form_row">
			                    <label class="contact"><strong>Email:</strong></label>
			                    <input type="email" class="" name="email" required />
			                    </div>
			
			
			                    <div class="form_row">
			                    <label class="contact"><strong>Phone:</strong></label>
			                    <input type="number" class="" name="phone"  required />
			                    </div>
			                    
			                    <div class="form_row">
			                    <label class="contact"><strong>Company:</strong></label>
			                    <input type="text" class="" name="company" required />
			                    </div>
			                    
			                    <div class="form_row">
			                    <label class="contact"><strong>Message:</strong></label>
			                    <textarea class="contact_textarea" name="message" required ></textarea>
			                    </div>                		
			                    
			                    <div class="form_row">
			                    <input type="submit" class="register" value="send" />
			                    </div>   
			                  </form> 
		                    
		                </div>      
		             </div>  
		            <div class="clear"></div>
		            
		          </div><!--end of left content-->
		        <%@ include file="cartInfo.jsp" %>								
		        </div>
				<%@ include file="footer.jsp" %>
			</div>
			
		</body>
	</html>

    
