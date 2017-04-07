<?php


class DTO_sentencias_producto {
    
    function __construct() {

    }

    public static function getAll() {
        $consulta = "SELECT * FROM viewProducto";
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