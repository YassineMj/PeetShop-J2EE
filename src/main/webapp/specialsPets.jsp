<%@page import="Model.Model_Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="Model.Model_Pets"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
	ArrayList<Model_Pets> listpets=(ArrayList)request.getAttribute("listpets");
%>
    
	<!DOCTYPE html>
	<html>
		<head>
			<meta charset="ISO-8859-1">
			<title>Special pets</title>
			<link rel="stylesheet" type="text/css" href="css/style.css" />
			
		</head>
		
		<body>
			<div id="wrap">
				<%@ include file="header.jsp" %>
				<div class="center_content">
       	<div class="left_content">
        	
            <div class="title"><span class="title_icon"><img src="images/bullet1.gif" alt="" title="" /></span>Special Pets</div>
        
        	<%for(Model_Pets pets : listpets) { %>
        
	        	<div class="feat_prod_box">
	            
	            	<div class="prod_img"><a href="details.jsp"><img src="images/<%=pets.getImage_pet()%>.jpeg" alt="" title="" border="0" /></a></div>
	                
	                <div class="prod_det_box">
	                	<span class="special_icon"><img src="images/special_icon.gif" alt="" title="" /></span>
	                	<div class="box_top"></div>
	                    <div class="box_center">
	                    <div class="prod_title"><%=pets.getNom_pet() %></div>
	                    <p class="details"><%=pets.getDesc_pet() %> .</p>
 						<form action="details.jsp">
					        <input type="submit"  class="" value="- more details -"/>
					        <input type="hidden" name="id" value="<%=pets.getId_pet()%>"/>
					        <input type="hidden" name="type" value="pet"/>			                   	
			            </form>
	                    <div class="clear"></div>
	                    </div>
	                    
	                    <div class="box_bottom"></div>
	                </div> 
	            
	            	<div class="clear"></div>
	            </div>	
	         <%}%>   
  
          </div>
            <%@ include file="cartInfo.jsp" %>								
            
            </div>
				<%@ include file="footer.jsp" %>
			</div>
			
		</body>
	</html>

    
