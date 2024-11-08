<%@page import="java.util.ArrayList"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="Model.Model_Pets"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	ArrayList<Model_Pets> listpetsFeatured=(ArrayList)request.getAttribute("listpetsFeatured");
%>

<%
	ArrayList<Model_Pets> listNewpets=(ArrayList)request.getAttribute("listNewpets");
%>
   	<!DOCTYPE html>
	<html>
		<head>
			<meta charset="ISO-8859-1">
			<title>Home</title>
			<link rel="stylesheet" type="text/css" href="css/style.css" />
			
		</head>
		
		<body>
			<div id="wrap">
				<%@ include file="header.jsp" %>
				<div class="center_content">
					<div class="left_content">
						<div class="title"><span class="title_icon"><img src="images/bullet1.gif" alt="" title="" /></span>Featured 2 pets</div>
        					<!-- ---------------------------------------- -->
        				<%for (Model_Pets pet : listpetsFeatured) {%>
				        	<div class="feat_prod_box">
				            	<div class="prod_img"><a><img src="images/<%=pet.getImage_pet() %>.jpeg" alt="" title="" border="0" /></a></div>
				                <div class="prod_det_box">
				                	<div class="box_top"></div>
				                    <div class="box_center">
					                    <div class="prod_title"><%=pet.getNom_pet()%></div>
					                    <p class="details"><%=pet.getDesc_pet() %></p>
					               		<p class="details">Nombre de ventes : <%=pet.getQuantite() %></p>
					                    <form action="details.jsp">
					                    	<input type="submit"  class="" value="- more details -"/>
					                    	<input type="hidden" name="id" value="<%=pet.getId_pet()%>"/>
					                    	<input type="hidden" name="type" value="pet"/>
					                    	
					                    </form>
					                    <div class="clear"></div>
				                    </div>
				                    <div class="box_bottom"></div>
				                </div>    
				            	<div class="clear"></div>
				            </div>
			            <%} %>
			                  
			            
			                  <!-- ---------------------------------------- -->
			            <div class="title"><span class="title_icon"><img src="images/bullet2.gif" alt="" title="" /></span>New 3 pets</div> 

			                  <!-- ---------------------------------------- -->
			           <div class="new_products">

							<%for (Model_Pets pet : listNewpets) {%>						
				                    <div class="new_prod_box">
				                        <a><%=pet.getNom_pet() %></a>
				                        <div class="new_prod_bg">
					                        <span class="new_icon"><img src="images/new_icon.gif" alt="" title="" /></span>
					                        <a><img src="images/<%=pet.getImage_pet() %>.jpeg" alt="" title="" class="thumb" border="0" /></a>
				                        </div>			                        
				                        <form action="details.jsp">
						                    	<input class="btn_submit" type="submit"  class="" value="- more details -"/>
						                    	<input type="hidden" name="id" value="<%=pet.getId_pet()%>"/>
						                    	<input type="hidden" name="type" value="pet"/>
						                </form>           
				                    </div>  		                       			            
				            
				            <%} %>
			            </div> 

            			<div class="clear"></div> 
			            
					</div>
					<%@ include file="cartInfo.jsp" %>			
							
        		</div>	
        		
        		<%@ include file="footer.jsp" %>			
        		
			</div>
		</body>
	</html>

    
