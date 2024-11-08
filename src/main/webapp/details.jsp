<%@page import="Model.Model_Product"%>
<%@page import="Controller.Servlet_Controller_Pets"%>
<%@page import="Controller.Servlet_Controller_User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="Model.Model_Pets"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<!DOCTYPE html>

<%
Model_Pets p=new Model_Pets();;
Model_Product pr=new Model_Product();;
if(request.getParameter("type").equals("pet"))
{
	
	try{
	
		for(Model_Pets pet: Servlet_Controller_Pets.listpets){
			if(pet.getId_pet()==Integer.parseInt(request.getParameter(("id").toString()))){
				p=pet;
			}
		}
		
	}catch(Exception e){
		   response.sendRedirect("servletcategory.do");
	}%>
	
	<html>
		<head>
			<meta charset="ISO-8859-1">
			<title>Details</title>
			<link rel="stylesheet" type="text/css" href="css/style.css" />
			
		</head>
		
		<body>
			<div id="wrap">
				<%@ include file="header.jsp" %>
				<div class="center_content">
				
				<div class="left_content">
		            </br>
		            </br>
		            </br>
		            </br>
		            <div class="title"><span class="title_icon"><img src="" alt="" title="" /></span><%=p.getNom_pet() %></div>
		        
		        	<div class="feat_prod_box_details">
		            
		            	<div class="prod_img"><img src="images/<%=p.getImage_pet() %>.jpeg" alt="" title="" border="0" /></a>
			                <br /><br />
			                <a href="" rel="lightbox"><img src="" alt="" title="" border="0" /></a>
		                </div>
		                
		                <div class="prod_det_box">
		                	<div class="box_top"></div>
		                    <div class="box_center">
		                    <div class="prod_title">Details</div>
		                    <p class="details"><%=p.getDesc_pet() %><div class="price"><strong>PRICE : </strong> <span class="red"><%=p.getPrix_pet() %> $</span></div>
		                    <div class="price"><strong>COLORS:</strong> 
								<span class="colors"><img src="images/color3.gif" alt="" title="" border="0" /></span>                    
							</div>
							<form action="servletordernow.do" method="GET">
									<label> Quantite : <input type="number" name="quantite" required/></label>
						           	<input type="hidden" name="id" value="<%=p.getId_pet()%>"/>
			                     	<input type="hidden" name="type" value="pet"/>
			                     	<input type="submit" class="btn_submit" value="- order now -"/>		                     	
					         </form>  
		                    
		                    <div class="clear"></div>
		                    </div>
		                    
		                    <div class="box_bottom"></div>
		                </div>    
			            <div class="clear"></div>
			         </div>	       
		            
		        	<div class="clear"></div>
		        </div><!--end of left content-->
				<%@ include file="cartInfo.jsp" %>			
		        
		      </div>
				
				<%@ include file="footer.jsp" %>
			</div>
			
		</body>
	</html>
	
<%}else
{
	try{
		for(Model_Product product: Servlet_Controller_Pets.listProduct){
			if(product.getId_product()==Integer.parseInt(request.getParameter(("id").toString()))){
				pr=product;
			}
		}
	}catch(Exception e){
		   response.sendRedirect("servletcategory.do.do");
	}
	
	%>
	
	<html>
		<head>
			<meta charset="ISO-8859-1">
			<title>Details</title>
			<link rel="stylesheet" type="text/css" href="css/style.css" />
			
		</head>
		
		<body>
			<div id="wrap">
				<%@ include file="header.jsp" %>
				<div class="center_content">
				
				<div class="left_content">
		            </br>
		            </br>
		            </br>
		            </br>
		            <div class="title"><span class="title_icon"><img src="" alt="" title="" /></span><%=pr.getNom_product() %></div>
		        
		        	<div class="feat_prod_box_details">
		            
		            	<div class="prod_img"><img src="images/<%=pr.getImage_product() %>.jpeg" alt="" title="" border="0" /></a>
			                <br /><br />
			                <a href="" rel="lightbox"><img src="" alt="" title="" border="0" /></a>
		                </div>
		                
		                <div class="prod_det_box">
		                	<div class="box_top"></div>
		                    <div class="box_center">
		                    <div class="prod_title">Details</div>
		                    <p class="details"><%=pr.getDesc_product() %><div class="price"><strong>PRICE : </strong> <span class="red"><%=pr.getPrix_product() %> $</span></div>
		                    <div class="price"><strong>COLORS:</strong> 
							<span class="colors"><img src="images/color3.gif" alt="" title="" border="0" /></span>                    </div>	                    
							<form action="servletordernow.do" method="GET">
									<label> Quantite : <input type="number" name="quantite" required/></label>
						           	<input type="hidden" name="id" value="<%=pr.getId_product()%>"/>
			                     	<input type="hidden" name="type" value="product"/>
			                     	<input type="submit" class="btn_submit" value="- order now -"/>		                     	
					         </form>		                    
		                    <div class="clear"></div>
		                    </div>
		                    
		                    <div class="box_bottom"></div>
		                </div>    
			            <div class="clear"></div>
			         </div>	       
		            
		        	<div class="clear"></div>
		        </div><!--end of left content-->
				<%@ include file="cartInfo.jsp" %>			
		        
		      </div>
				
				<%@ include file="footer.jsp" %>
			</div>
			
		</body>
	</html>
<%}
%>

    

    
