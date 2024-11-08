<%@page import="Controller.Servlet_Controller_Home"%>
<%@page import="Model.Model_Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="Model.Model_Pets"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
	ArrayList<Model_Pets> listpets=(ArrayList)request.getAttribute("listpets");
%>   
<%
	ArrayList<Model_Product> listProduct=(ArrayList)request.getAttribute("listProduct");
%>  
    
	<!DOCTYPE html>
	<html>
		<head>
			<meta charset="ISO-8859-1">
			<title>Pets</title>
			<link rel="stylesheet" type="text/css" href="css/style.css" />
			
		</head>
		
		<body>
			<div id="wrap">
				<%@ include file="header.jsp" %>
				       <div class="center_content">
					       	<div class="left_content">
					        	<div class="crumb_nav">
					            </div>
					            <div class="title"><span class="title_icon"><img src="images/bullet1.gif" alt="" title="" /></span>Category Dogs</div>
					           
					           <div class="new_products">   
					           		<%for(Model_Pets pets : listpets) { 
					           			if(pets.getId_category()==1){%>      
					                    <div class="new_prod_box">
					                        <a><%=pets.getNom_pet() %></a>
					                        <div class="new_prod_bg">
					                        <%if(pets.isPromontion_pet()==true){ %>
					                         <span class="new_icon"><img src="images/promo_icon.gif" alt="" title="" /></span>
					                         <%}else if(pets.getId_pet()==listpets.get(listpets.size()-1).getId_pet() || pets.getId_pet()==listpets.get(listpets.size()-2).getId_pet() || pets.getId_pet()==listpets.get(listpets.size()-3).getId_pet()){%>
					                          <span class="new_icon"><img src="images/new_icon.gif" alt="" title="" /></span>					                         
					                        <%}else {%>
					                          <span class="new_icon"><img src="" alt="" title="" /></span>
					                          <%} %>
					                        <a><img src="images/<%=pets.getImage_pet() %>.jpeg" alt="" title="" class="thumb" border="0" /></a>
					                        
					                        </div>  
					                        <form action="details.jsp">
					                    	<input type="submit"  class="btn_submit" value="- more details -"/>
					                    	<input type="hidden" name="id" value="<%=pets.getId_pet()%>"/>
					                    	<input type="hidden" name="type" value="pet"/>	
					                    	</form>         
					                    </div>	
					               		<%} %>					            				                    
					                 <%} %>				            
					            </div> 
					            <div class="clear"></div>
					            
					            <!-- ------------------------------------------------- -->
					            <div class="title"><span class="title_icon"><img src="images/bullet2.gif" alt="" title="" /></span>Category Cats</div>
					           
					           <div class="new_products">         
					                 <%for(Model_Pets pets : listpets) { 
					           			if(pets.getId_category()==2){%>      
					                    <div class="new_prod_box">
					                        <a><%=pets.getNom_pet() %></a>
					                        <div class="new_prod_bg">
											<%if(pets.isPromontion_pet()==true){ %>
					                         <span class="new_icon"><img src="images/promo_icon.gif" alt="" title="" /></span>
					                         <%}else if(pets.getId_pet()==listpets.get(listpets.size()-1).getId_pet() || pets.getId_pet()==listpets.get(listpets.size()-2).getId_pet() || pets.getId_pet()==listpets.get(listpets.size()-3).getId_pet()){%>
					                          <span class="new_icon"><img src="images/new_icon.gif" alt="" title="" /></span>					                         
					                        <%}else {%>
					                          <span class="new_icon"><img src="" alt="" title="" /></span>
					                          <%} %>				                        
						                          <a><img src="images/<%=pets.getImage_pet() %>.jpeg" alt="" title="" class="thumb" border="0" /></a>					                        
					                        </div>   
					                        <form action="details.jsp">
						                    	<input type="submit"  class="btn_submit" value="- more details -"/>
						                    	<input type="hidden" name="id" value="<%=pets.getId_pet()%>"/>
						                    	<input type="hidden" name="type" value="pet"/>
					                    	</form>        
					                    </div>	
					               		<%} %>					            				                    
					                 <%} %>				            
					            </div> 
					            <div class="clear"></div>
					            
					            <!-- ------------------------------------------------- -->
					            <div class="title"><span class="title_icon"><img src="images/bullet6.gif" alt="" title="" /></span>Category Accessoire</div>
					           
					           <div class="new_products">         
					                <%for(Model_Product product : listProduct) { %>      
					                    <div class="new_prod_box">
					                        <a><%=product.getNom_product() %></a>
					                        <div class="new_prod_bg">
					                        <%if(product.isPromotion()==true){ %>
					                         <span class="new_icon"><img src="images/promo_icon.gif" alt="" title="" /></span>
					                         <%}else {%>
					                          <span class="new_icon"><img src="" alt="" title="" /></span>
					                          <%} %>
					                        <a><img src="images/<%=product.getImage_product()%>.jpeg" alt="" title="" class="thumb" border="0" /></a>
					                        
					                        </div> 
					                        <form action="details.jsp">
						                    	<input type="submit"  class="btn_submit" value="- more details -"/>
						                    	<input type="hidden" name="id" value="<%=product.getId_product()%>"/>
						                    	<input type="hidden" name="type" value="product"/>					                    	
					                    	</form>          
					                    </div>	
					                 <%}%>			            
					            </div> 
					          
					            
					        <div class="clear"></div>
					        </div><!--end of left content-->
        		<%@ include file="cartInfo.jsp" %>								
        
        </div>
				<%@ include file="footer.jsp" %>
			</div>
			
		</body>
	</html>

    
