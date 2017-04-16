<?php
	session_start();
	session_destroy();
	echo '<script language = javascript>
                self.location = "../../login/login.php";
            </script>';
?>