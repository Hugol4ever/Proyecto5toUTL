<?php


class DTO_sentencias_compra {
    
    function __construct() {

    }

    public static function getAll($id) {
        $consulta = "SELECT * FROM viewVenta WHERE Id_Cliente1 = ".$id;
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