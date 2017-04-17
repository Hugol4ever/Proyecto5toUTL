<?php


class DTO_sentencias_detalle_compra {
    
    function __construct() {

    }

    public static function getAll($id) {
        $consulta = "SELECT * FROM viewDetaVenta WHERE Id_Venta = ".$id;
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