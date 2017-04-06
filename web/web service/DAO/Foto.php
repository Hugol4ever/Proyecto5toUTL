<?php  

class Foto {

	//Atributos
	private $idFoto;
	private $foto;

	//Constructores
	function __construct() {

	}

	function Foto($foto) {
		this::$foto = $foto;
	}

	//Métodos constructores
	public static function getIdFoto() {
		return this::$idFoto;
	}

	public static function setIdFoto($idFoto) {
		this::$idFoto = $idFoto;
	}

	public static function getFoto() {
		return this::$foto;
	}

	public static function setFoto($foto) {
		this::$foto = $foto;
	}
}

?>