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
    	<header>
    		<div class="container">
    			<div class="logo-container">
	                <h3 class="logo"><span>CAP</span>RAT</h3>
	            </div>
    		</div>
    	</header>
		<section>
			
			<div class="form-content">
				<div class="side-image">
				</div>
				<div class="side-form">
					<div class="cadastro">
						<h2>CADASTRO DE EMPRESA</h2>
						<form id="cadastrar-empresa-form">
				            <h4>Nome</h4>
				            <div class="input-group">
				                <div class="input-box">
				                    <input name="nomeEmpresa" type="text" placeholder="Nome da empresa" required class="name">
				                    <i class="fa fa-user icon"></i>
				                </div>
				            </div>
				            <h4>Contato</h4>
				            <div class="input-group">
				                <div class="input-box">
				                    <input name="contatoEmpresa" type="text" placeholder="Ex: (11) 99276-1231" required class="name">
				                    <i class="fa fa-phone icon" aria-hidden="true"></i>
				                </div>
				            </div>
				            <h4>Endereço</h4>
				            <div class="input-group">
				                <div class="input-box">
				                    <input name="estadoEmpresa" type="text" placeholder="Estado" required class="name">
				                    <i class="fa fa-map icon" aria-hidden="true"></i>
				                </div>
				                <div class="input-box">
				                    <input name="cidadeEmpresa" type="text" placeholder="Cidade" required class="name">
				                    <i class="fa fa-map-signs icon" aria-hidden="true"></i>
				                </div>
				            </div>
				            <div class="input-group">
				                <div class="input-box">
				                    <input name="enderecoEmpresa" type="text" placeholder="Logradouro" required class="name">
				                    <i class="fa fa-map-marker icon" aria-hidden="true"></i>
				                </div>
				            </div>
				            <div class="input-group">
				                <div class="input-box">
				                    <input name="cepEmpresa" type="text" placeholder="CEP " required class="name">
				                    <i class="fa fa-location-arrow icon" aria-hidden="true"></i>
				                </div>
				            </div>
				            <h4>Ramo</h4>
				            <div class="input-group">
				                <div class="input-box">
				                    <input name="ramoEmpresa" type="text" placeholder="Ex: Alimentício" required class="name">
				                    <i class="fa fa-briefcase icon"></i>
				                </div>
				            </div>
				            <h4>Descrição</h4>
					            <div class="input-group">
					                <div class="input-box">
					                    <textarea id="descricao" name="descricaoEmpresa">
					                    </textarea>
					                </div>
					            </div>
				            <div class="input-group">
				                <div class="input-box">
				                    <button type="button" id="cadastrar-empresa">CADASTRAR EMPRESA</button>
				                </div>
				            </div>
			        	</form>
					</div>
			    </div>
			</div>
		</section>

<script>

	$("input[name='contatoEmpresa']").mask('(00) 90000-0000');
	$("input[name='cepEmpresa']").mask("99.999-999");

	$(function(){
		$("#cadastrar-empresa").on('click', function(e){
			
			var cadastroData = {
				idEmpresa: 0,
				idUsuario: <%=session.getAttribute("userLogin") %>,
				nomeEmpresa: $("input[name='nomeEmpresa']").val(),
				estadoEmpresa: $("input[name='estadoEmpresa']").val(),
				cidadeEmpresa: $("input[name='cidadeEmpresa']").val(),
				contatoEmpresa: $("input[name='contatoEmpresa']").val(),
				enderecoEmpresa: $("input[name='enderecoEmpresa']").val(),
				cepEmpresa: $("input[name='cepEmpresa']").val(),
				ramoEmpresa: $("input[name='ramoEmpresa']").val(),
				descricaoEmpresa: $("textarea[name='descricaoEmpresa']").val()
			};
			
			$.post("http://localhost:8080/EmpresaInfosServlet", {empresa: JSON.stringify(cadastroData)}, function(data, status) {
		   	    if(data.success) {
					window.alert("Dados cadastrados com sucesso!");

					window.location.replace("../cadastro_vaga/cadastro_vaga.jsp");
				}
		    }, "json");
		});
	});

</script>
