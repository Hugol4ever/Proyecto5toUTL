<?php

require '../config/mysql_login.php';
require '../config/Database.php';
require '../DTO/DTO_sentencias_productos_comprados.php';

if ($_SERVER['REQUEST_METHOD'] == 'GET') {
    $id = $_GET['id'];
    $productos = DTO_sentencias_productos_comprados::getAll($id);
    if ($productos) {
        $datos["estado"] = 1;
        $datos["productos"] = $productos;
        print json_encode($datos);
    } else {
        print json_encode(array(
            "estado" => 2,
            "mensaje" => "No hay coincidencias"
        ));
    }
}

?>