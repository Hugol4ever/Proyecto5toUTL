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
                                    <span class="clear"> <span class="block m-t-xs"> <strong class="font-bold"><?= $_SESSION['perfil'] ?></strong>
                                        </span> <span class="text-muted text-xs block">Art Director <b class="caret"></b></span> </span> </a>
                                <ul class="dropdown-menu animated fadeInRight m-t-xs">
                                    <li><a href="profile.php">Profile</a></li>
                                    <li class="divider"></li>
                                    <li><a href="<?=Globals::$logout?>">Logout</a></li>
                                </ul>
                            </div>
                            <div class="logo-element">
                                <?= Globals::$empresa; ?>
                            </div>
                        </li>
                        <li>
                            <a href="index.php"><i class="fa fa-th-large"></i> <span class="nav-label">Panel Principal</span></a>
                        </li>

                        <li>
                            <a href="#"><i class="fa fa-bar-chart-o"></i> <span class="nav-label">Graficas</span><span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li><a href="graph_flot.php">Grafias Simples</a></li>
                                <li><a href="graph_chartjs.php">Graficas Avanzadas</a></li>
                            </ul>
                        </li>

                        <li class="active">
                            <a href="#"><i class="fa fa-picture-o"></i> <span class="nav-label">Productos</span><span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li><a href="basic_gallery.php">Nuestros Productos</a></li>
                                <li><a href="carousel.php">Ofertas y Destacados</a></li>

                            </ul>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-table"></i> <span class="nav-label">Tables</span><span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li><a href="table_basic.php">Static Tables</a></li>
                                <li><a href="table_data_tables.php">Data Tables</a></li>
                                <li><a href="jq_grid.php">jqGrid</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="mail_compose.php"><i class="fa fa-envelope"></i> <span class="nav-label"> Contactanos </span><span class="label label-warning pull-right">16/24</span></a>
                        <li>
                    </ul>
                </div>
            </nav>

            <!-- Menu de arriba -->
            <div id="page-wrapper" class="gray-bg">
                <div class="row border-bottom">
                    <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                        <div class="navbar-header">
                            <a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i class="fa fa-bars"></i> </a>
                            <form role="search" class="navbar-form-custom" method="post" action="search_results.php">
                                <div class="form-group">
                                    <input type="text" placeholder="Search for something..." class="form-control" name="top-search" id="top-search">
                                </div>
                            </form>
                        </div>
                        <ul class="nav navbar-top-links navbar-right">
                            <li>
                                <span class="m-r-sm text-muted welcome-message">Bienvenido <?= $_SESSION['perfil'] ?>.</span>
                            </li>
                            <li class="dropdown">
                                <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                                    <i class="fa fa-envelope"></i>  <span class="label label-warning">16</span>
                                </a>
                                <ul class="dropdown-menu dropdown-messages">
                                    <li>
                                        <div class="dropdown-messages-box">
                                            <a href="profile.php" class="pull-left">
                                                <img alt="image" class="img-circle" src="img/a7.jpg">
                                            </a>
                                            <div class="media-body">
                                                <small class="pull-right">46h ago</small>
                                                <strong>Mike Loreipsum</strong> started following <strong>Monica Smith</strong>. <br>
                                                <small class="text-muted">3 days ago at 7:58 pm - 10.06.2014</small>
                                            </div>
                                        </div>
                                    </li>
                                    <li class="divider"></li>
                                    <li>
                                        <div class="dropdown-messages-box">
                                            <a href="profile.php" class="pull-left">
                                                <img alt="image" class="img-circle" src="img/a4.jpg">
                                            </a>
                                            <div class="media-body ">
                                                <small class="pull-right text-navy">5h ago</small>
                                                <strong>Chris Johnatan Overtunk</strong> started following <strong>Monica Smith</strong>. <br>
                                                <small class="text-muted">Yesterday 1:21 pm - 11.06.2014</small>
                                            </div>
                                        </div>
                                    </li>
                                    <li class="divider"></li>
                                    <li>
                                        <div class="dropdown-messages-box">
                                            <a href="profile.php" class="pull-left">
                                                <img alt="image" class="img-circle" src="img/profile.jpg">
                                            </a>
                                            <div class="media-body ">
                                                <small class="pull-right">23h ago</small>
                                                <strong>Monica Smith</strong> love <strong>Kim Smith</strong>. <br>
                                                <small class="text-muted">2 days ago at 2:30 am - 11.06.2014</small>
                                            </div>
                                        </div>
                                    </li>
                                    <li class="divider"></li>
                                    <li>
                                        <div class="text-center link-block">
                                            <a href="mailbox.php">
                                                <i class="fa fa-envelope"></i> <strong>Read All Messages</strong>
                                            </a>
                                        </div>
                                    </li>
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                                    <i class="fa fa-bell"></i>  <span class="label label-primary">8</span>
                                </a>
                                <ul class="dropdown-menu dropdown-alerts">
                                    <li>
                                        <a href="mailbox.php">
                                            <div>
                                                <i class="fa fa-envelope fa-fw"></i> You have 16 messages
                                                <span class="pull-right text-muted small">4 minutes ago</span>
                                            </div>
                                        </a>
                                    </li>
                                    <li class="divider"></li>
                                    <li>
                                        <a href="profile.php">
                                            <div>
                                                <i class="fa fa-twitter fa-fw"></i> 3 New Followers
                                                <span class="pull-right text-muted small">12 minutes ago</span>
                                            </div>
                                        </a>
                                    </li>
                                    <li class="divider"></li>
                                    <li>
                                        <a href="grid_options.php">
                                            <div>
                                                <i class="fa fa-upload fa-fw"></i> Server Rebooted
                                                <span class="pull-right text-muted small">4 minutes ago</span>
                                            </div>
                                        </a>
                                    </li>
                                    <li class="divider"></li>
                                    <li>
                                        <div class="text-center link-block">
                                            <a href="notifications.php">
                                                <strong>See All Alerts</strong>
                                                <i class="fa fa-angle-right"></i>
                                            </a>
                                        </div>
                                    </li>
                                </ul>
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
                        <h2>Lightbox Gallery</h2>
                        <ol class="breadcrumb">
                            <li>
                                <a href="index.php">Home</a>
                            </li>
                            <li>
                                <a>Gallery</a>
                            </li>
                            <li class="active">
                                <strong>Lightbox Gallery</strong>
                            </li>
                        </ol>
                    </div>
                    <div class="col-lg-2">

                    </div>
                </div>
                <div class="wrapper wrapper-content">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="ibox float-e-margins">
                                <div class="ibox-content">
                                    <h2>Lightbox image gallery</h2>
                                    <div class="lightBoxGallery">
                                        <div id="main" class="container">
                                            <?php
                                            $cadena;
                                            $numero = 0;
                                            $p = new productos();
                                            $array = $p::getArray();
                                            for ($i = 0; $i < count($array); $i++) {
                                                $id = $array[$i]['Id_Producto'];
                                                $nombre = $array[$i]['Nombre'];
                                                $marca = $array[$i]['Marca'];
                                                $categoria = $array[$i]['Categoria'];
                                                $existencia = $array[$i]['Existencia'];
                                                $precio = $array[$i]['Precio'];
                                                $foto = $array[$i]['Foto'];

                                                $cadena = "id=" . $id . "&nombre=" . $nombre . "&marca=" . $marca . "&categoria=" . $categoria . "&existencia=" . $existencia . "&precio=" . $precio . "&foto=" . $foto;
                                                if ($numero == 0) {
                                                    ?>
                                                    <div class="row">
                                                        <?php
                                                    }
                                                    ?>
                                                    <div class="col-lg-4 col-md-6">
                                                        <div>
                                                            <section class="highlight">
                                                                <h3 class="style1">
                                                                    <a href="producto.php?<?= $cadena ?>"><?= $nombre ?></a>
                                                                </h3>
                                                                <a href="producto.php?<?= $cadena ?>" class="image featured">
                                                                    <img src="<?= Globals::$serverImagenes . $foto ?>" width="250" height="250" alt="" />
                                                                </a>
                                                                <p>$<?= $precio ?></p>
                                                                <p><?= $marca ?></p>
                                                            </section>
                                                        </div>
                                                    </div>
                                                    <?php
                                                    $numero = $numero + 1;
                                                    if ($numero == 3) {
                                                        ?>
                                                    </div>
                                                    <?php
                                                    $numero = 0;
                                                }
                                            }
                                            ?>
                                        </div>
                                    </div>

                                    <!-- The Gallery as lightbox dialog, should be a child element of the document body -->
                                    <div id="blueimp-gallery" class="blueimp-gallery">
                                        <div class="slides"></div>
                                        <h3 class="title"></h3>
                                        <a class="prev">‹</a>
                                        <a class="next">›</a>
                                        <a class="close">×</a>
                                        <a class="play-pause"></a>
                                        <ol class="indicator"></ol>
                                    </div>

                                </div>

                            </div>
                        </div>
                    </div>
                </div>
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