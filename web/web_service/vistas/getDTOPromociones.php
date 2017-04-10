<?php

require '../config/mysql_login.php';
require '../config/Database.php';
require '../DTO/DTO_sentencias_promociones.php';

if ($_SERVER['REQUEST_METHOD'] == 'GET') {
    $promociones = DTO_sentencias_promociones::getAll();
    if ($promociones) {
        $datos["estado"] = 1;
        $datos["promociones"] = $promociones;
        print json_encode($datos);
    } else {
        print json_encode(array(
            "estado" => 2,
            "mensaje" => "Ha ocurrido un error"
        ));
    }
}

?>