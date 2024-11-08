<!DOCTYPE html>
<html>
<head>
  <title>Connexion Administrateur</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f2f2f2;
    }

    .container {
      width: 300px;
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
    }

    .form-group {
      margin-bottom: 20px;
    }

    .form-group label {
      display: block;
      margin-bottom: 5px;
    }

    .form-group input {
      width: 100%;
      padding: 10px;
      border-radius: 3px;
      border: 1px solid #ccc;
    }

    .form-group button {
      width: 100%;
      padding: 10px;
      border: none;
      background-color: #4CAF50;
      color: #fff;
      cursor: pointer;
      border-radius: 3px;
    }
  </style>
</head>
<body>
  <div class="container">
    <h2>Connexion Administrateur</h2>
    <form method="POST" action="servletadmin.do">
      <div class="form-group">
        <label for="username">Nom d'utilisateur :</label>
        <input type="text" id="username" name="usernameadmin" required>
      </div>
      <div class="form-group">
        <label for="password">Mot de passe :</label>
        <input type="password" id="password" name="passwordadmin" required>
      </div>
      <div class="form-group">
        <button type="submit">Se connecter</button>
      </div>
    </form>
  </div>
</body>
</html>