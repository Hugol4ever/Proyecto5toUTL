<?php

require '../config/mysql_login.php';
require '../config/Database.php';
require '../DTO/DTO_sentencias_cliente.php';

if ($_SERVER['REQUEST_METHOD'] == 'GET') {
    $user = $_GET['user'];
    $pass = $_GET['password'];
    $clientes = DTO_sentencias_cliente::getAll($user, $pass);
    if ($clientes) {
        $datos["estado"] = 1;
        $datos["clientes"] = $clientes;
        print json_encode($datos);
    } else {
        print json_encode(array(
            "estado" => 2,
            "mensaje" => "No hay coincidencias"
        ));
    }
}

?>