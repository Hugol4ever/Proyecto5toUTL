<?php

/**
 * Representa el la estructura de las metas
 * almacenadas en la base de datos
 */
require '../config/Database.php';

class DTO_sentencias_cliente {

    function __construct() {

    }

    /**
     * Retorna en la fila especificada de la tabla 'meta'
     *
     * @param $idMeta Identificador del registro
     * @return array Datos del registro
     */
    public static function getAll() {
        $consulta = "SELECT * FROM viewCliente";
        try {
            // Preparar sentencia
            $comando = Database::getInstance()->getDb()->prepare($consulta);
            // Ejecutar sentencia preparada
            $comando->execute();

            return $comando->fetchAll(PDO::FETCH_ASSOC);

        } catch (PDOException $e) {
            return false;
        }
    }
}
?>