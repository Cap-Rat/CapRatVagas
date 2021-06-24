<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%
    	int tipoUsuario = 0;
    	String perfilUrl = "";
    	String vagasUrl = "";
    	String inicioUrl = "";
    	if(session.getAttribute("userTipo") != null){
    		tipoUsuario = (int) session.getAttribute("userTipo");
    		inicioUrl = tipoUsuario == 2 ? "../cadastro_vaga/cadastro_vaga.jsp" : "../feed/feed.jsp";
    		perfilUrl = tipoUsuario == 2 ? "../company_profile/company_profile.jsp" : "../user_profile/user_profile.jsp";
    		vagasUrl = tipoUsuario == 2 ? "../company_profile/company_vagas.jsp" : "../user_profile/user_vagas.jsp";
    	}
    %>
<!DOCTYPE html>
	<html>
	   <head>
	       <meta charset="UTF-8">
	       <meta http-equiv="X-UA-Compatible" content="IE=edge">
	       <meta name="viewport" content="width=device-width, initial-scale=1.0">
	       <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
	       <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
	       <link rel="stylesheet" href="css/style.css">
	       <link rel="stylesheet" type="text/css" href="../../../header/v1/css/style.css">
	       <link rel="stylesheet" type="text/css" href="../../../footer/css/style.css">
	       <link href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap" rel="stylesheet">
	       <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	       <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.11/jquery.mask.min.js"></script>
	       <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	       <title>CapRat: Vagas</title>
	   </head>
	   <body>
		    <header>
		        <div class="container">
		            <input type="checkbox" name="" id="check">
		            
		            <div class="logo-container">
		                <h3 class="logo"><span>CAP</span>RAT</h3>
		            </div>
		
		            <div class="nav-btn" id="navDeslogado">
		                <div class="nav-links">
		                    <ul>
		                        <li class="nav-link" id="main-links" style="--i: .6s">
		                            <a href="<%=inicioUrl %>">Início</a>
		                        </li>
		                        <li class="nav-link" id="main-links" style="--i: .85s">
		                            <a href="<%=vagasUrl %>" >Vagas</a>
		                        </li>
		                        <li class="nav-link" id="main-links" style="--i: 1.65s"><a href="<%=perfilUrl %>"><i id="abc"class="fa fa-user-circle" aria-hidden="true"></i></a></li>
		                        <li class="nav-link" id="main-links" style="--i: 1.85s"><a href="#" id="logout"><i id="abc" class="fa fa-sign-out" aria-hidden="true"></i></a></li>
		                    </ul>
		                </div>
		            </div>
		
		            <div class="hamburger-menu-container">
		                <div class="hamburger-menu">
		                    <div></div>
		                </div>
		            </div>
		        </div>
		    </header>
		    <body>
				<script>
				
					$(function(){
						$("#logout").on('click', function(e){
							
							$.getJSON("http://localhost:8080/UsuarioLogoutServlet", function(data, status) {
					        	if(data.success == "true") {
					        		window.location.replace("../../pages/login/login.jsp");
								}
						    });
							
						});
					});
				</script>
