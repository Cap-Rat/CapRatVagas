<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<section>
	<div class="form-content">
		<div class="side-image">
		</div>
		<div class="side-form">
			<div class="cadastro">
				<h2>RECUPERAR SENHA</h2>
				<form >
					<h4>Usuário</h4>
					<div class="input-group">
						<div class="input-box">
							<input type="text" name="nomeUsuario" placeholder="Nome de usuário" required class="name">
							<i class="fa fa-user icon"></i>
						</div>
					</div>
					<h4>E-mail</h4>
					<div class="input-group">
						<div class="input-box">
							<input type="email" name="emailUsuario" placeholder="Endereço de E-mail" required class="name">
							<i class="fa fa-envelope icon"></i>
						</div>
					</div>
					<div class="input-group">
						<div class="input-box" id="botao_box">
							<br>
							<button type="button" id="recuperar" >RECUPERAR</button>
						</div>
					</div>
				</form>
			</div>
	    </div>
	</div>
</section>

<script>

	function isEmail(email) {
		
	  var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	  return regex.test(email);
	  
	}
	
		$(function() {
	        $("#recuperar").on('click', function(e) {
	        	
		        var cadastroData = {
		  			emailUsuario: $("input[name='emailUsuario']").val(),
		  			apelidoUsuario: $("input[name='nomeUsuario']").val()
		        };
		        
		        if(isEmail($("input[name='emailUsuario']").val())){
			        window.alert("Estamos preparando a sua nova senha!"); 
			       	$("#botao_box").html("<br> <h3> Carregando... </h3>");
			        $.getJSON("http://localhost:8080/PassRecoverServlet", cadastroData, function(data, status) {
			        	if(data.success=="true") {
							window.alert("Senha recuperada com sucesso! Cheque o e-mail cadastrado");
							
							window.location.replace("../login/login.jsp");
							
						}else{
							window.alert("Dados incorretos");
						}
				    });
		      	}else{
		      		window.alert("Por favor, insira um email válido");
		      	}
	        });
	    });
	</script>
