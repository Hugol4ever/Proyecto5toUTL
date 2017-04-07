<?php

require '../config/mysql_login.php';
require '../config/Database.php';
require '../DTO/DTO_sentencias_cliente.php';

if ($_SERVER['REQUEST_METHOD'] == 'GET') {
    $clientes = DTO_sentencias_cliente::getAll();
    if ($clientes) {
        $datos["estado"] = 1;
        $datos["clientes"] = $clientes;
        print json_encode($datos);
    } else {
        print json_encode(array(
            "estado" => 2,
            "mensaje" => "Ha ocurrido un error"
        ));
    }
}

?>