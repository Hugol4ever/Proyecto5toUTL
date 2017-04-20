<?php

	class productos {

	  	function getArray() {
	  		$json = $url ='http://localhost/web_service/vistas/getDTOProducto.php';
			$json = file_get_contents($url);
		  	$array = json_decode($json, true);
		  	return $array['productos'];
	  	}
	}
?>