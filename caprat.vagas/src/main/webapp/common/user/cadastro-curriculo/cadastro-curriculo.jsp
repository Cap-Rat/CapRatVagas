<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta charset="UTF-8">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="../../../header/v1/css/style.css">
        <link rel="stylesheet" type="text/css" href="../../../footer/css/style.css">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <title>CapRat: Vagas</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.11/jquery.mask.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    </head>
    <body>     
		<section>
			<div class="content">
				
			</div>
			<div class="wave">
				<div class="custom-shape-divider-top-1618457940">
				    <svg data-name="Layer 1" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1200 120" preserveAspectRatio="none">
				        <path d="M985.66,92.83C906.67,72,823.78,31,743.84,14.19c-82.26-17.34-168.06-16.33-250.45.39-57.84,11.73-114,31.07-172,41.86A600.21,600.21,0,0,1,0,27.35V120H1200V95.8C1132.19,118.92,1055.71,111.31,985.66,92.83Z" class="shape-fill"></path>
				    </svg>
				</div>
			</div>
			<div class="form-content">
				<div class="side-image">
				</div>
				<div class="side-form">
					<div class="cadastro">
				        <h2>Cadastro de currículo</h2>
				        <form id="cadastrar-curriculo-form">
				            <h4>Nome</h4>
				            <div class="input-group">
				                <div class="input-box">
				                    <input type="text" name="nomeUsuario" placeholder="Nome completo" required class="name">
				                    <i class="fa fa-user icon"></i>
				                </div>
				            </div>
				            <h4>Data de Nascimento</h4>
				            <div class="input-group">
				                <div class="input-box">
				                     <input type="date" name="nascimentoUsuario" class="name">
				                     <i class="fa fa-calendar-o icon" aria-hidden="true"></i>
				                 </div>
				             </div>
				            <h4>Contato</h4>
				            <div class="input-group">
				                <div class="input-box">
				                    <div class="input-box">
				                        <input type="text" name="contatoUsuario" placeholder="Ex: (11) 99276-1231" required class="name">
				                        <i class="fa fa-phone icon" aria-hidden="true"></i>
				                    </div>
				                </div>
				            </div>
				            <h4>Endereço</h4>
				            <div class="input-group">
				                <div class="input-box">
				                    <input type="text" name="estadoUsuario" placeholder="Estado" required class="name">
				                    <i class="fa fa-map icon" aria-hidden="true"></i>
				                </div>
				                <div class="input-box">
				                    <input type="text" name="cidadeUsuario" placeholder="Cidade" required class="name">
				                    <i class="fa fa-map-signs icon" aria-hidden="true"></i>
				                </div>
				            </div>
				            <div class="input-group">
				                <div class="input-box">
				                    <input type="text" name="enderecoUsuario" placeholder="Logradouro" required class="name">
				                    <i class="fa fa-map-marker icon" aria-hidden="true"></i>
				                </div>
				            </div>
				            <h4>Preteção salarial</h4>
				            <div class="input-group">
				                <div class="input-box">
				                    <input type="number" name="faixaSalarialUsuario" placeholder="Ex: R$1.500,00 " required class="name">
				                    <i class="fa fa-money icon" aria-hidden="true"></i>
				                </div>
				            </div>
				            <h4>Grau de escolaridade</h4>
				            <div class="input-group">
				                <div class="input-box">
				                    <input type="text" name="escolaridadeUsuario" placeholder="Ex: Superior completo " required class="name">
				                    <i class="fa fa-graduation-cap icon" aria-hidden="true"></i>
				                </div>
				            </div>
				            <div class="input-group">
				                <div class="input-box">
				                    <button type="button" id="cadastrar-curriculo">CADASTRAR CURRÍCULO</button>
				                </div>
				            </div>
				        </form>
			    	</div>
				</div>
			</div>
		</section>

<script>
	
	$("input[name='contatoUsuario']").mask('(00) 90000-0000');
	
	$(function() {
        $("#cadastrar-curriculo").on('click', function(e) {
          
	        var cadastroData = {
	        	idCurriculo: 0,
	        	idUsuario: <%=session.getAttribute("userLogin") %>,
	       		cidadeUsuario: $("input[name='cidadeUsuario']").val(),
	  			contatoUsuario: $("input[name='contatoUsuario']").val(),
	  			cursosUsuario: "",
	  			enderecoUsuario: $("input[name='enderecoUsuario']").val(),
	  			escolaridadeUsuario: $("input[name='escolaridadeUsuario']").val(),
	  			estadoUsuario: $("input[name='estadoUsuario']").val(),
	  			expTrabUsuario: "",
	  			faixaSalarialUsuario: $("input[name='faixaSalarialUsuario']").val(),
	  			nascimentoUsuario: $("input[name='nascimentoUsuario']").val(),
	  			nomeUsuario: $("input[name='nomeUsuario']").val()
	        };
	         
	        $.post("http://localhost:8080/UsuarioCurriculoServlet", {curriculo: JSON.stringify(cadastroData)}, function(data, status) {
		   	    if(data.success) {
					window.alert("Curriculo cadastrado com sucesso!");
					window.location.replace("../feed/feed.jsp");
				}
		    }, "json");
	      
        });
    });

</script>