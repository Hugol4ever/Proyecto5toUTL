<?php  

class Usuario {

	//Atributos
	private $idUsuario;
    private $nomUsuario;
    private $contrasenia;
    private $foto;
    private $cliente;

	//Constructores
    function __construct() {

	}

	function Usuario($nomUsuario, $contrasenia, $foto, $cliente) {
		this::$nomUsuario = $nomUsuario;
		this::$contrasenia = $contrasenia;
		this::$foto = $foto;
		this::$cliente = $cliente;
	}

	//Métodos constructores
	public static function getIdUsuario() {
		return this::$idUsuario;
	}

	public static function setIdUsuario($idUsuario) {
		this::$idUsuario = $idUsuario;
	}

	public static function getNomUsuario() {
		return this::$nomUsuario;
	}

	public static function setNomUsuario($nomUsuario) {
		this::$nomUsuario = $nomUsuario;
	}

	public static function getContrasenia() {
		return this::$contrasenia;
	}

	public static function setContrasenia($contrasenia) {
		this::$contrasenia = $contrasenia;
	}

	public static function getFoto() {
		return this::$foto;
	}

	public static function setFoto($foto) {
		this::$foto = $foto;
	}

	public static function getCliente() {
		return this::$cliente;
	}

	public static function setCliente($cliente) {
		this::$cliente = $cliente;
	}

}

?>