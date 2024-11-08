<%@page import="Model.Model_Achat_User"%>
<%@page import="Model.Model_User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Model_Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
        

<%
	ArrayList<Model_Achat_User> listAchatUserPets=(ArrayList)request.getAttribute("listAchatUserPets");
	ArrayList<Model_Achat_User> listAchatUserProduct=(ArrayList)request.getAttribute("listAchatUserProduct");
	String nomuser=request.getAttribute("nomuser").toString();
	String solde=request.getAttribute("soldeuser").toString();
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
    <h2>About <%=nomuser %></h2>
    <h4>Pets</h4>
    <table>
      <thead>
        <tr>
          <th>Nom Pets</th>
          <th>Quantite</th>
          <th></th>
        </tr>
      </thead>
      <tbody>
      
      <%for (Model_Achat_User u: listAchatUserPets){ %>
        <tr>
          <td><%=u.nomP%></td>
          <td><%=u.quantiteP%></td>
        </tr>
	   <%} %>
      </tbody>
    </table>
    
    <h4>Product</h4>
    <table>
      <thead>
        <tr>
          <th>Nom Product</th>
          <th>Quantite</th>
          <th></th>
        </tr>
      </thead>
      <tbody>
      
      <%for (Model_Achat_User u: listAchatUserProduct){ %>
        <tr>
          <td><%=u.nomP%></td>
          <td><%=u.quantiteP%></td>
        </tr>
	   <%} %>
      </tbody>
    </table>
    <h3>Solde <%=solde%></h3>
    
  </div>
</body>
</html>