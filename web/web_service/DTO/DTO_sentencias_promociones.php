<?php

class DTO_sentencia_promociones {
    
    function __construct() {

    }

    public static function getAll() {
        $consulta = "SELECT * FROM viewPromocion";
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