<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
	<!DOCTYPE html>
	<html>
		<head>
			<meta charset="ISO-8859-1">
			<title>cart info</title>
		</head>
		
		<body>
			
				<div class="right_content">
						
						<div class="languages_box">
				            <span class="red">Languages:</span>
				            <a href="#" class="selected"><img src="images/gb.gif" alt="" title="" border="0" /></a>
				            <a href="#"><img src="images/fr.gif" alt="" title="" border="0" /></a>
				            <a href="#"><img src="images/de.gif" alt="" title="" border="0" /></a>
			            </div>
		                <div class="currency">
			                <span class="red">Currency: </span>
			                <a href="#">GBP</a>
			                <a href="#">EUR</a>
			                <a href="#" class="selected">USD</a>
		                </div>                
			            <div class="cart">
			                  <div class="title"><span class="title_icon"><img src="images/cart.gif" alt="" title="" /></span>My cart</div>
			                  <div class="home_cart_content">
			                  	<%=request.getAttribute("count") %> x items | <span class="red">TOTAL: <%=request.getAttribute("somme") %>$</span>
			                  </div>
			                  <a href="servletAchat.do" class="view_cart">view cart</a>
			            </div>
			            
			            <div class="title"><span class="title_icon"><img src="images/bullet3.gif" alt="" title="" /></span>About Our Shop</div> 
			            <div class="about">
			            	<p><img src="images/about.gif" alt="" title="" class="right" />Sur notre site internet, nous vous offrons un large catalogue de produits et d'articles, rigoureusement sélectionnés, pour prendre soin de vos animaux de compagnie &#128054 &#128049 .</p>
			            </div>
             
			            
					</div>
					<div class="clear"></div>		
			
			
		</body>
	</html>

    
