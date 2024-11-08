<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    
	<!DOCTYPE html>
	<html>
		<head>
			<meta charset="ISO-8859-1">
			<title>Registrer</title>
			<link rel="stylesheet" type="text/css" href="css/style.css" />
			
		</head>
		
		<body style="background-color:beige;">
			<div id="wrap">
				<%@ include file="header.jsp" %>
				<div class="center_content">
			       	<div class="left_content">
			            <div class="title"><span class="title_icon"><img src="images/bullet1.gif" alt="" title="" /></span>Register</div>
			        
			        	<div class="feat_prod_box_details">
			            <p class="details"></p>
			            
			              	<div class="contact_form">
			                <div class="form_subtitle">create new account</div>
			                 <form action="servletregister.do" method="POST">          
			                    <div class="form_row">
			                    <label class="contact"><strong>Username:</strong></label>
			                    <input type="text" class="" name="username" required />
			                    </div>  
			
			
			                    <div class="form_row">
			                    <label class="contact"><strong>Password:</strong></label>
			                    <input type="password" class="" name="password" required />
			                    </div> 
			
			                    <div class="form_row">
			                    <label class="contact"><strong>Email:</strong></label>
			                    <input type="email" class="" name="email" required />
			                    </div>
			
			
			                    <div class="form_row">
			                    <label class="contact"><strong>Phone:</strong></label>
			                    <input type="number" class="" name="phone" required />
			                    </div>
			                    
			                    <div class="form_row">
			                    <label class="contact"><strong>Company:</strong></label>
			                    <input type="text" class="" name="company" required />
			                    </div>
			                    
			                    <div class="form_row">
			                    <label class="contact"><strong>Adress:</strong></label>
			                    <input type="text" class="" name="adress" required />
			                    </div>                   		
			                    
			                    <div class="form_row">
			                    <input type="submit" class="register" value="register" />
			                    </div>   
			                  </form>     
			                </div>  
			            
			          </div>	
			            
			              
			
			            
			
			            
			        <div class="clear"></div>
			        </div><!--end of left content-->
        
        		</div>
			</div>
			
		</body>
	</html>

    
