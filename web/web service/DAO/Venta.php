<?php  

class Venta {

	//Atributos
	private $idVenta;
    private $fecha;
    private $hora;
    private $idCliente;

	//Constructores
	function __construct() {

	}

	function __construct($fecha, $hora, $idCliente) {
		this->$fecha = $fecha;
		this->$hora = $hora;
		this->$idCliente = $idCliente;
	}

	//Métodos constructores
	public static function getIdVenta() {
		return this->$idVenta;
	}

	public static function setIdVenta($idVenta) {
		this->$idVenta = $idVenta;
	}

	public static function getFecha() {
		return this->$fecha;
	}

	public static function setFecha($fecha) {
		this->$fecha = $fecha;
	}

	public static function getHora() {
		return this->$hora;
	}

	public static function setHora($hora) {
		this->$hora = $hora;
	}

	public static function getIdCliente() {
		return this->$idCliente;
	}

	public static function setIdCliente($idCliente) {
		this->$idCliente = $idCliente;
	}

}

?>