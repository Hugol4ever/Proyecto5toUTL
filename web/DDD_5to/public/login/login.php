<?php
  if (!isset($_SESSION['id_usuario']) > 0){
    if (isset($_GET['err']) != null) {
      echo '<script language = javascript>
                  alert("hola");
              </script>';
    }
  } else {
    echo '<script language = javascript>
            self.location = "../index.php";
          </script>';
  }
?>

<!DOCTYPE html>
<html lang="es">
  <head>
  	<meta charset="UTF-8">
  	<title>DDD-Market login</title>
  	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  	<link rel="stylesheet" href="estilos.css">
  	<link href='http://fonts.googleapis.com/css?family=Oswald:400,700' rel='stylesheet' type='text/css'>

  	<link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../font-awesome/css/font-awesome.css" rel="stylesheet">

    <link href="../css/animate.css" rel="stylesheet">
    <link href="../css/style.css" rel="stylesheet">

  </head>
  <body  class="gray-bg">
    <div id="particles-js"></div>
    <div class="middle-box text-center loginscreen  animated fadeInDown">
      <div>
        <h1 class="logo-name"><img src="logo1.png"></h1>
      </div>
      <h3>Bienvenido a DDD-Admin.</h3>
      <!--Continually expanded and constantly improved Inspinia Admin Them (IN+)-->
      <h3>Porfavor introdusca sus datos para iniciar sesi&oacute;n.</h3>
      <form class="m-t" role="form" action="../back_end/controllers/login.php" method="post">
        <div class="form-group">
          <input type="email" class="form-control" placeholder="Username" required="" name="usuario">
        </div>
        <div class="form-group">
          <input type="password" class="form-control" placeholder="Password" required="" name="pass">
        </div>
        <button type="submit" class="btn btn-primary block full-width m-b">Login</button>
        <a href="#"><small>Forgot password?</small></a> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<a href="register.html"><small>Create an account</small></a>
      </form>
            <!-- <p class="m-t"> <small>Inspinia we app framework base on Bootstrap 3 &copy; 2014</small> </p> -->
		</div>
      <!-- Mainly scripts -->
    <script src="../js/jquery-2.1.1.js"></script>
    <script src="../js/bootstrap.min.js"></script>
  	<script src="main.js"></script>
  	<script src="particles.min.js"></script>
  	<script src="particulas.js"></script>
  </body>
</html>