<?php

class DTO_sentencias_cliente {

    function __construct() {

    }

    public static function getAll($user, $pass) {
        $consulta = "SELECT * FROM viewCliente WHERE Correo = '".$user."' AND Contrasenia = '".$pass."'";
        try {
            $comando = Database::getInstance()->getDb()->prepare($consulta);
            $comando->execute();
            return $comando->fetchAll(PDO::FETCH_ASSOC);
        } catch (PDOException $e) {
            return false;
        }
    }
    
}
?>