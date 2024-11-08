<%@page import="Model.Model_User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Model_Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
        
<%Model_Admin admin = (Model_Admin) request.getSession().getAttribute("Admin");%>

<%
	ArrayList<Model_User> listuser=(ArrayList)request.getAttribute("listuser");
%>


<!DOCTYPE html>
<html>
<head>
  <title>Tableau d'informations administrateur</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f2f2f2;
    }

    .container {
      width: 1400px;
      margin: 0 auto;
      margin-top: 100px;
      background-color: #fff;
      padding: 20px;
      border-radius: 5px;
      box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
    }

    h2 {
      text-align: center;
      margin-bottom: 30px;
      font-size: 32px;
      color: #4CAF50;
      text-transform: uppercase;
      letter-spacing: 2px;
    }

    table {
      width: 100%;
      border-collapse: collapse;
      margin-bottom: 20px;
    }

    th, td {
      padding: 10px;
      text-align: left;
      border-bottom: 1px solid #ddd;
    }

    th {
      background-color: #4CAF50;
      color: white;
    }

    .submit-button {
      padding: 5px 10px;
      background-color: #4CAF50;
      color: white;
      border: none;
      border-radius: 3px;
      cursor: pointer;
      transition: background-color 0.3s ease;
    }

    .submit-button:hover {
      background-color: #45a049;
    }
  </style>
</head>
<body>
  <div class="container">
    <h2>Hello <%=admin.getUserAdmin() %></h2>
    <table>
      <thead>
        <tr>
          <th>Nom</th>
          <th>Mot de passe</th>
          <th>Email</th>
          <th>Téléphone</th>
          <th>Company</th>
          <th>Adresse</th>
          <th>Salaire</th>
          <th></th>
        </tr>
      </thead>
      <tbody>
      
      <%for (Model_User user: listuser){ %>
        <tr>
          <td><%=user.getUsername() %></td>
          <td><%=user.getPassword() %></td>
          <td><%=user.getEmail() %></td>
          <td><%=user.getPhone()%></td>
          <td><%=user.getCompany() %></td>
          <td><%=user.getAdresse() %></td>
          <td><%=user.getSalaire() %></td>
          
          <td>
          	<form action="servletcontrollerachatuser.do" method="POST">
				<input type="submit"  class="submit-button" value="Achat(s)"/>
				<input type="hidden" name="iduser" value="<%=user.getId_user()%>"/>
		    </form>
          </td>
          
        </tr>
		<%} %>
      </tbody>
    </table>
  </div>
</body>
</html>