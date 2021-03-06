<?php
    require 'back_end/commons/Globals.php';
    session_start();
    if (!isset($_SESSION['id_usuario']) > 0){
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

    <title><?=Globals::$titulo?> | Ofertas</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet">

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

        <!-- Menu Arriba-->
        <div id="page-wrapper" class="gray-bg">
        <div class="row border-bottom">
        <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
        <div class="navbar-header">
            <a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i class="fa fa-bars"></i> </a>
        </div>
            <ul class="nav navbar-top-links navbar-right">
                <li>
                    <span class="m-r-sm text-muted welcome-message">Bienvenido <?=$_SESSION['perfil']?>.</span>
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
                <div class="col-lg-9">
                    <h2> Ofertas del Mes.</h2>
                </div>
            </div>



        <div class="wrapper wrapper-content">
            <div class="row">
               
                <div class="col-lg-12">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5>Animation and Caption</h5>
                            <div class="ibox-tools">
                                <a class="collapse-link">
                                    <i class="fa fa-chevron-up"></i>
                                </a>
                                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                    <i class="fa fa-wrench"></i>
                                </a>
                                <ul class="dropdown-menu dropdown-user">
                                    <li><a href="#">Config option 1</a>
                                    </li>
                                    <li><a href="#">Config option 2</a>
                                    </li>
                                </ul>
                                <a class="close-link">
                                    <i class="fa fa-times"></i>
                                </a>
                            </div>
                        </div>
                        <div class="ibox-content ">
                            <div class="carousel slide" id="carousel2">
                                <ol class="carousel-indicators">
                                    <li data-slide-to="0" data-target="#carousel2"  class="active"></li>
                                    <li data-slide-to="1" data-target="#carousel2"></li>
                                    <li data-slide-to="2" data-target="#carousel2" class=""></li>
                                </ol>
                                <div class="carousel-inner">
                                    <div class="item active">
                                        <img alt="image"  class="img-responsive" src="img/p_big1.jpg">
                                        <div class="carousel-caption">
                                            <p>This is simple caption 1</p>
                                        </div>
                                    </div>
                                    <div class="item ">
                                        <img alt="image"  class="img-responsive" src="img/p_big3.jpg">
                                        <div class="carousel-caption">
                                            <p>This is simple caption 2</p>
                                        </div>
                                    </div>
                                    <div class="item">
                                        <img alt="image"  class="img-responsive" src="img/p_big2.jpg">
                                        <div class="carousel-caption">
                                            <p>This is simple caption 3</p>
                                        </div>
                                    </div>
                                </div>
                                <a data-slide="prev" href="#carousel2" class="left carousel-control">
                                    <span class="icon-prev"></span>
                                </a>
                                <a data-slide="next" href="#carousel2" class="right carousel-control">
                                    <span class="icon-next"></span>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5>Big gallery carousel</h5>
                            <div class="ibox-tools">
                                <a class="collapse-link">
                                    <i class="fa fa-chevron-up"></i>
                                </a>
                                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                    <i class="fa fa-wrench"></i>
                                </a>
                                <ul class="dropdown-menu dropdown-user">
                                    <li><a href="#">Config option 1</a>
                                    </li>
                                    <li><a href="#">Config option 2</a>
                                    </li>
                                </ul>
                                <a class="close-link">
                                    <i class="fa fa-times"></i>
                                </a>
                            </div>
                        </div>
                        <div class="ibox-content">
                            <div class="carousel slide" id="carousel3">
                                <div class="carousel-inner">
                                    <div class="item gallery active left">
                                        <div class="row">
                                            <div class="col-sm-6">
                                                <img alt="image" class="img-responsive" src="img/p_big1.jpg">
                                            </div>
                                            <div class="col-sm-6">
                                                <img alt="image" class="img-responsive" src="img/p_big2.jpg">
                                            </div>
                                            <div class="col-sm-6">
                                                <img alt="image"  class="img-responsive"  src="img/p_big3.jpg">
                                            </div>
                                            <div class="col-sm-6">
                                                <img alt="image"  class="img-responsive" src="img/p_big1.jpg">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="item gallery next left">
                                        <div class="row">
                                            <div class="col-sm-6">
                                                <img alt="image"  class="img-responsive" src="img/p_big3.jpg">
                                            </div>
                                            <div class="col-sm-6">
                                                <img alt="image"  class="img-responsive" src="img/p_big1.jpg">
                                            </div>
                                            <div class="col-sm-6">
                                                <img alt="image"  class="img-responsive"  src="img/p_big2.jpg">
                                            </div>
                                            <div class="col-sm-6">
                                                <img alt="image"  class="img-responsive" src="img/p_big1.jpg">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="item gallery">
                                        <div class="row">
                                            <div class="col-sm-6">
                                                <img alt="image"  class="img-responsive" src="img/p_big2.jpg">
                                            </div>
                                            <div class="col-sm-6">
                                                <img alt="image"  class="img-responsive" src="img/p_big3.jpg">
                                            </div>
                                            <div class="col-sm-6">
                                                <img alt="image"  class="img-responsive"  src="img/p_big1.jpg">
                                            </div>
                                            <div class="col-sm-6">
                                                <img alt="image" class="img-responsive" src="img/p_big2.jpg">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <a data-slide="prev" href="#carousel3" class="left carousel-control">
                                    <span class="icon-prev"></span>
                                </a>
                                <a data-slide="next" href="#carousel3" class="right carousel-control">
                                    <span class="icon-next"></span>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="footer">
            <div class="pull-right">
                10GB of <strong>250GB</strong> Free.
            </div>
            <div>
                <strong>Copyright</strong> Example Company &copy; 2014-2015
            </div>
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


</body>

</html>
