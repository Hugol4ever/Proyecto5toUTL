<?php  

class DetalleVenta {

	//Atributos
	private $idDetalleVenta;
    private $cantidad;
    private $precio;
    private $idProducto;
    private $idVenta;

	//Constructores
	function __construct() {

	}

	function __construct($cantidad, $precio, $idProducto, $idVenta) {
		this->$cantidad = $cantidad;
		this->$precio = $precio;
		this->$idProducto = $idProducto;
		this->$idVenta = $idVenta;
	}

	//Métodos constructores
	public static function getIdDetalleVenta() {
		return this->$idDetalleVenta;
	}

	public static function setIdDetalleVenta($idDetalleVenta) {
		this->$idDetalleVenta = $idDetalleVenta;
	}

	public static function getCantidad() {
		return this->$cantidad;
	}

	public static function setCantidad($cantidad) {
		this->$cantidad = $cantidad;
	}

	public static function getPrecio() {
		return this->$precio;
	}

	public static function setPrecio($precio) {
		this->$precio = $precio;
	}

	public static function getIdProducto() {
		return this->$idProducto;
	}

	public static function setIdProducto($idProducto) {
		this->$idProducto = $idProducto;
	}

	public static function getIdVenta() {
		return this->$idVenta;
	}

	public static function setIdVenta($idVenta) {
		this->$idVenta = $idVenta;
	}

}

?>