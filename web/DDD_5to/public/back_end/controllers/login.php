<?php 
	$usuario = $_POST['usuario'];
	$pass = $_POST['pass'];

	$json = $url ='http://192.168.1.7/web_service/vistas/getDTOCliente.php?user='.$usuario.'&password='.$pass;
	$json = file_get_contents($url);
  	$array = json_decode($json, true);
  	if ($array['estado'] == 1) {
  		session_start();
  		$_SESSION['id_usuario'] = $array['clientes'][0]['Id_Usuario'];
  		$_SESSION['perfil'] = $array['clientes'][0]['Nombre'];
  		echo '<script language = javascript>
                self.location = "../../index.php";
            </script>';
  	} else {
  		session_destroy();
  		echo '<script language = javascript>
                self.location = "../../login/login.php?err=err";
            </script>';
  	}
?>