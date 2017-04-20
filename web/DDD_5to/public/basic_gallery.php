<?php
require 'back_end/commons/Globals.php';
require 'back_end/controllers/productos.php';
session_start();
if (!isset($_SESSION['id_usuario']) > 0) {
    echo '<script language = javascript>
                self.location = "login/login.php";
            </script>';
}
?>

<!DOCTYPE html>
<html>

    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title><?= Globals::$titulo ?> | Lightbox Gallery</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="font-awesome/css/font-awesome.css" rel="stylesheet">
        <link href="css/plugins/blueimp/css/blueimp-gallery.min.css" rel="stylesheet">
        <link href="css/animate.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">

    </head>

    <body>

       <!-- Menu lateral -->
    <div id="wrapper">
        <nav class="navbar-default navbar-static-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="side-menu">
                    <li class="nav-header">
                        <div class="dropdown profile-element"> <span>
                            <img alt="image" class="img-circle" src="img/profile_small.jpg" />
                             </span>
                            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <span class="clear"> <span class="block m-t-xs"> <strong class="font-bold"><?=$_SESSION['perfil']?></strong>
                             </span> <span class="text-muted text-xs block">Art Director <b class="caret"></b></span> </span> </a>
                            <ul class="dropdown-menu animated fadeInRight m-t-xs">
                                <li><a href="<?=Globals::$Pprofile?>">Profile</a></li>
                                <li class="divider"></li>
                                <li><a href="<?=Globals::$logout?>">Logout</a></li>
                            </ul>
                        </div>
                        <div class="logo-element">
                            <?=Globals::$empresa;?>
                        </div>
                    </li>
                    <li class="active">
                        <a href="<?=Globals::$Pindex?>"><i class="fa fa-th-large"></i> <span class="nav-label">Panel Principal</span></a>
                   </li>
                
                    <li>
                        <a href="#"><i class="fa fa-bar-chart-o"></i> <span class="nav-label">Graficas</span><span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li><a href="<?=Globals::$PgraficasS?>">Grafias Simples</a></li>
                        </ul>
                    </li>

                    <li>
                        <a href="#"><i class="fa fa-picture-o"></i> <span class="nav-label">Productos</span><span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li><a href="<?=Globals::$Pproductos?>">Nuestros Productos</a></li>
                            <li><a href="<?=Globals::$Pofertas?>">Ofertas y Destacados</a></li>

                        </ul>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-table"></i> <span class="nav-label">Tables</span><span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li><a href="<?=Globals::$Ptabla?>">Static Tables</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="<?=Globals::$Pcontactanos?>"><i class="fa fa-envelope"></i> <span class="nav-label"> Contactanos </span><a>
                    <li>

            </div>
        </nav>

            <!-- Menu de arriba -->
            <div id="page-wrapper" class="gray-bg">
                <div class="row border-bottom">
                    <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                        <div class="navbar-header">
                            <a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i class="fa fa-bars"></i> </a>
                        </div>
                        <ul class="nav navbar-top-links navbar-right">
                            <li>
                                <span class="m-r-sm text-muted welcome-message">Bienvenido <?= $_SESSION['perfil'] ?>.</span>
                            </li>
                            <li>
                                <a href="<?=Globals::$logout?>">
                                    <i class="fa fa-sign-out"></i> Log out
                                </a>
                            </li>
                        </ul>

                    </nav>
                </div>
                <div class="row wrapper border-bottom white-bg page-heading">
                    <div class="col-lg-10">
                        <h2>Nuestros Productos</h2>
                    </div>
                    <div class="col-lg-2">

                    </div>
                </div>
   
                <div class="wrapper wrapper-content ">

                <?php
                    $numero = 0;
                    $p = new productos();
                    $array = $p::getArray();
                    for ($i = 0; $i < count($array); $i++) {
                        $id = $array[$i]['Id_Producto'];
                        $nombre = $array[$i]['Nombre'];
                        if (strlen($nombre) > 15) {
                            $nombre = substr($nombre, 0, 15);
                            $nombre = $nombre."...";
                        }
                        $marca = $array[$i]['Marca'];
                        $categoria = $array[$i]['Categoria'];
                        $existencia = $array[$i]['Existencia'];
                        $precio = $array[$i]['Precio'];
                        $foto = $array[$i]['Foto'];

                        $cadena = "id=" . $id . "&nombre=" . $nombre . "&marca=" . $marca . "&categoria=" . $categoria . "&existencia=" . $existencia . "&precio=" . $precio . "&foto=" . $foto;
                        ?>
                <div class="col-md-4">
                    <div class="ibox">
                        <div class="ibox-content product-box">

                            <div class="product-imitation">
                                <?= $foto ?>
                            </div>
                            <div class="product-desc">
                                <span class="product-price">
                                    <?= $precio ?>
                                </span>
                                <small class="text-muted"><?= $categoria ?></small>
                                <a href="#" class="product-name"><?= $nombre ?></a>



                                <div class="small m-t-xs">
                                    Many desktop publishing packages and web page editors now.
                                </div>
                                <div class="m-t text-righ">

                                    <a href="#" class="btn btn-xs btn-outline btn-primary" data-toggle="modal" data-target="#<?=$id?>">Info <i class="fa fa-long-arrow-right"></i> </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal inmodal" id="<?=$id?>" tabindex="-1" role="dialog" aria-hidden="true">
                     <div class="modal-dialog">
                        <div class="modal-content animated bounceInRight">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                                            <h4 class="modal-title"><?= $foto ?></h4>
                                        </div>
                                        <div class="modal-body">
                                            <p><strong><center>Nombre: <?= $nombre ?></center></p>
                                            <p><strong><center>Precio: $<?= $precio ?></center></p>
                                            <p><center>Categoria: <?= $categoria ?></center></p>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-white" data-dismiss="modal">Cerrar</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
            
                <?php } ?>


                        </div>
            
            <div class="footer">
                <div>
                    <strong>Copyright</strong> Example Company &copy; 2014-2015
                </div>
            </div>

        </div>



        <!-- Mainly scripts -->
        <script src="js/jquery-2.1.1.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>
        <script src="js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

        <!-- Custom and plugin javascript -->
        <script src="js/inspinia.js"></script>
        <script src="js/plugins/pace/pace.min.js"></script>

        <!-- blueimp gallery -->
        <script src="js/plugins/blueimp/jquery.blueimp-gallery.min.js"></script>


    </body>

</html>