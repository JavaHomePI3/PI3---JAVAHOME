<%@ page import="br.senac.sp.servlet.login.filter.JWTUtil" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Loja de jogos</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
          rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">
</head>
<body id="page-top">
<div id="wrapper">

    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

        <!-- Sidebar - Brand -->
        <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.jsp">
            <div class="sidebar-brand-icon rotate-n-15">
                <i class="fas fa-laugh-wink"></i>
            </div>
            <div class="sidebar-brand-text mx-3">JavaHome<sup>tm</sup></div>
        </a>

        <!-- Divider -->
        <hr class="sidebar-divider my-0">

        <!-- Nav Item - Dashboard -->
        <li class="nav-item active">
            <a class="nav-link" href="index.jsp">
                <i class="fas fa-fw fa-tachometer-alt"></i>
                <span>Dashboard</span></a>
        </li>

        <!-- Divider -->
        <hr class="sidebar-divider">

        <!-- Heading -->
        <div class="sidebar-heading">
            Paginas
        </div>

        <!-- Nav Item - Charts -->
        <c:if test="${sessionScope.userAuth.equals('VENDAS') || sessionScope.userAuth.equals('BACKOFFICE')}">
            <style>
                .sidebar {
                    display: none;
                }
            </style>
        </c:if>
        <c:if test="${sessionScope.userAuth.equals('ADM')}">
            <style>
                #navbarDropdownCliente{
                    display: none;
                }
                #navbarDropdownVenda{
                    display: none;
                }
            </style>
        </c:if>

        <c:if test="${sessionScope.userAuth.equals('BACKOFFICE')}">
            <style>
                #navbarDropdownVenda{
                    display: none;
                }
                #navbarDropd{
                    display: none;
                }
            </style>
        </c:if>

        <li class="nav-item">
            <a class="nav-link" href="relatorio">
                <i class="fas fa-fw fa-chart-area"></i>
                <span>Relatorio</span></a>
        </li>


        <!-- Divider -->
        <hr class="sidebar-divider d-none d-md-block">

        <!-- Sidebar Toggler (Sidebar) -->
        <div class="text-center d-none d-md-inline">
            <button class="rounded-circle border-0" id="sidebarToggle"></button>
        </div>
    </ul>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">
            <nav class="navbar navbar-expand-lg navbar-dark bg-primary container-fluid">
                <a class="navbar-brand" href="index.jsp">Home</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02"
                        aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
                    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownCliente" role="button"
                               data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Cliente
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdownCliente">
                                <a class="dropdown-item" href="CadastroCliente">Novo Cliente</a>
                                <a class="dropdown-item" href="CadastroCliente?action=listar">Editar Cliente</a>
                            </div>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownVenda" role="button"
                               data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Venda
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdownVenda">
                                <a class="dropdown-item" href="cadastraVenda">Realizar Venda</a>
                            </div>
                        </li>
                        <c:if test="${!sessionScope.userAuth.equals('VENDAS')}">
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    Produtos
                                </a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <a class="dropdown-item" href="cadastraProduto">Novo Produto</a>
                                    <a class="dropdown-item" href="ConsultaProd.jsp">Editar Produto</a>
                                </div>
                            </li>
                        </c:if>
                        <c:if test="${!sessionScope.userAuth.equals('VENDAS')}">
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropd" role="button"
                                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    Funcionario
                                </a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdownCliente">
                                    <a class="dropdown-item" href="cadastroFuncionario.jsp">Novo Funcionario</a>
                                    <a class="dropdown-item" href="CadastroFuncionario?action=listar">Editar
                                        Funcionario</a>
                                </div>
                            </li>
                        </c:if>
                    </ul>
                </div>
                <div class="form-inline">
                    <div class="topbar-divider d-none d-sm-block"></div>
                    <!-- Nav Item - User Information -->
                    <li class="nav-item dropdown no-arrow" style="list-style: none;color: white">
                        <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="color: white;">
                            <span class="mr-2 d-none d-lg-inline text-gray-600 small" style="color: white !important;">Valerie Luna</span>
                            <img class="img-profile rounded-circle" style="width: 20%;"
                                 src="https://source.unsplash.com/QAB-WJcbgJk/60x60">
                        </a>
                        <!-- Dropdown - User Information -->
                        <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                             aria-labelledby="userDropdown">
                            <a class="dropdown-item" href="#" data-toggle="modal" data-target="#exampleModal">
                                <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                Logout
                            </a>
                        </div>
                    </li>
                </div>
            </nav>