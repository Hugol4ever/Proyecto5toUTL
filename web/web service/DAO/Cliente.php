<?php 

class Cliente {

	//Atributos
	private $idCliente;
	private $nombre;
	private $correo;
	private $telefono;
	private $genero;
	private $limiteSaldo;
	private $saldoDisponible;

	//Constructores
	function __construct() {

	}

	function Cliente($nombre, $correo, $telefono, $genero, $limiteSaldo, $saldoDisponible) {
		this::$nombre = $nombre;
		this::$correo = $correo;
		this::$telefono = $telefono;
		this::$genero = $genero;
		this::$limiteSaldo = $limiteSaldo;
		this::$saldoDisponible = $saldoDisponible;
	}

	//Métodos constructores
	public static function getIdCliente() {
		return this::$idCliente;
	}

	public static function setIdCliente($idCliente) {
		this::$idCliente = $idCliente;
	}

	public static function getNombre() {
		return this::$nombre;
	}

	public static function setNombre($nombre) {
		this::$nombre = $nombre;
	}

	public static function getCorreo() {
		return this::$correo;
	}

	public static function setCorreo($correo) {
		this::$correo = $correo;
	}

	public static function getTelefono() {
		return this::$telefono;
	}

	public static function setTelefono($telefono) {
		this::$telefono = $telefono;
	}

	public static function getGenero() {
		return this::$genero;
	}

	public static function setGenero($genero) {
		this::$genero = $genero;
	}

	public static function getLimiteSaldo() {
		return this::$limiteSaldo;
	}

	public static function setLimiteSaldo($limiteSaldo) {
		this::$limiteSaldo = $limiteSaldo;
	}

	public static function getSaldoDisponible() {
		return this::$saldoDisponible;
	}

	public static function setSaldoDisponible($saldoDisponible) {
		this::$saldoDisponible = $saldoDisponible;
	}

}

?>