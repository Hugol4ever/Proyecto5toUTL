<?php  

class Producto {

	//Atributos
	private $idProducto;
    private $nombre;
    private $marca;
    private $categoria;
    private $existencia;
	private $precio;
    private $foto;

	//Constructores
	function __construct() {

	}

	function Producto($nombre, $marca, $categoria, $existencia, $precio, $foto) {
		this::$nombre = $nombre;
		this::$marca = $marca;
		this::$categoria = $categoria;
		this::$existencia = $existencia;
		this::$precio = $precio;
		this::$foto = $foto;
	}

	public static function getIdProducto() {
		return this::$idProducto;
	}

	public static function setIdProducto($idProducto) {
		this::$idProducto = $idProducto;
	}

	public static function getNombre() {
		return this::$nombre;
	}

	public static function setNombre($nombre) {
		this::$nombre = $nombre;
	}

	public static function getMarca() {
		return this::$marca;
	}

	public static function setMarca($marca) {
		this::$marca = $marca;
	}

	public static function getCategoria() {
		return this::$categoria;
	}

	public static function setCategoria($categoria) {
		this::$categoria = $categoria;
	}

	public static function getExistencia() {
		return this::$existencia;
	}

	public static function setExistencia($existencia) {
		this::$existencia = $existencia;
	}

	public static function getPrecio() {
		return this::$precio;
	}

	public static function setPrecio($precio) {
		this::$precio = $precio;
	}

	public static function getFoto() {
		return this::$foto;
	}

	public static function setFoto($foto) {
		this::$foto = $foto;
	}

	//Métodos constructores

}

?>