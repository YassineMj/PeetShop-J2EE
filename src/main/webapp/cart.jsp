<%@page import="Model.Model_Cart"%>
<%@page import="Controller.Servlet_Controller_Cart"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    
	<!DOCTYPE html>
	<html>
		<head>
			<meta charset="ISO-8859-1">
			<title>Cart</title>
			<link rel="stylesheet" type="text/css" href="css/style.css" />
			
		</head>
		<%
		float somme=0;
		%>
		<body>
			<div id="wrap">
				<%@ include file="header.jsp" %>
				<div class="center_content">
			       	<div class="left_content">
			         <div class="title"><span class="title_icon"><img src="images/bullet1.gif" alt="" title="" /></span>My cart</div>
        				<div class="feat_prod_box_details">
            
				                <table class="cart_table">
				                    <tr class="cart_title">
				                        <td>Image</td>
				                        <td>Nom</td>
				                        <td>Prix</td>
				                        <td>Quantite</td>
				                        <td>Total</td>               
				                    </tr>
				                        
				                    <%
				                        				                    if(Servlet_Controller_Cart.cartPets!=null){
				                        				                    		                    	for(Model_Cart c:Servlet_Controller_Cart.cartPets){
				                        				                    %>
				                    		<tr>
						                        <td><a><img src="images/<%=c.getImage()%>.jpeg" alt="" title="" border="0" class="cart_thumb" /></a></td>
						                        <td><%=c.getNom()%></td>
						                        <td><%=c.getPrix()%>$</td>
						                        <td><%=c.getQuantite()%></td>
						                        <td><%=c.getPrix()*c.getQuantite()%>$</td> 
						                        <td>
							                        <form action="servletAchat.do" method="post">
								                    	<input class="btn_submit" type="submit"  class="" value="Annuler"/>
								                    	<input type="hidden" name="id_cart" value="<%=c.getId_cart()%>"/>
							                		</form>
						                		</td>              
					                    	</tr>
					                    	<%
					                    	somme=somme+(c.getPrix()*c.getQuantite());
					                    	%>
					                    	
				                    	<%
					                    					                    	}
					                    					                    	%>
				                    	        
				                    <%
				                    	        				                    }
				                    	        				                    %>
				                    
				                    <%
				                    				                    if(Servlet_Controller_Cart.cartProduct!=null){
				                    				                    		                    	for(Model_Cart c:Servlet_Controller_Cart.cartProduct){
				                    				                    %>
				                    		<tr>
						                        <td><a><img src="images/<%=c.getImage() %>.jpeg" alt="" title="" border="0" class="cart_thumb" /></a></td>
						                        <td><%=c.getNom() %></td>
						                        <td><%=c.getPrix() %>$</td>
						                        <td><%=c.getQuantite() %></td>
						                        <td><%=c.getPrix()*c.getQuantite() %></td> 
						                        <td>
							                        <form action="servletAchat.do" method="post">
								                    	<input class="btn_submit" type="submit"  class="" value="Annuler"/>
								                    	<input type="hidden" name="id_cart" value="<%=c.getId_cart()%>"/>
							                		</form>
						                		</td>              
					                    	</tr>
					                    	<%somme=somme+(c.getPrix()*c.getQuantite()); %>
					                    	
				                    	<%}%>
				                    	        
				                    <%}%>
				                    
				
				                    <tr>
				                    <td colspan="4" class="cart_total"><span class="red">TOTAL SHIPPING:</span></td>
				                    <td> <%=somme %>$</td>                
				                    </tr>                 
				                
				                </table>
				                <form action="servletachatPetsProduct.do" method="post">
								       <input class="btn_submit" type="submit"  class="" value="Valider"/>
								       <input type="hidden" name="somme" value="<%=somme%>"/>
								       
							    </form>            
				
				            </div>	
				            
				        <div class="clear"></div>
        			</div>
        			<%@ include file="cartInfo.jsp" %>			
        			
        		</div>
				<%@ include file="footer.jsp" %>
			</div>
			
		</body>
	</html>

    
