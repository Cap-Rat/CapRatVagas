<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<section>
	<div class="form-content">
		<div class="side-image">
		</div>
		<div class="side-form">
			<div class="cadastro">
				<h2>Cadastro</h2>
				<form>
					<h4>Usuário</h4>
					<div class="input-group">
						<div class="input-box">
							<input type="text" name="apelidoUsuario" placeholder="Nome de usuário" class="name">
							<i class="fa fa-user icon"></i>
						</div>
					</div>
					<h4>E-mail</h4>
					<div class="input-group">
						<div class="input-box">
							<input type="email" name="emailUsuario" placeholder="Endereço de E-mail" class="name">
							<i class="fa fa-envelope icon"></i>
						</div>
					</div>
					<h4>Classificação:</h4>
					<div class="input-group">
						<div class="input-box">
							<input type="radio" id="b1" name="tipoUsuario" class="radio" checked value="3"><label for="b1">Sou candidato</label>
							<input type="radio" id="b2" name="tipoUsuario" class="radio" value="2"><label for="b2">Sou empresa</label>
						</div>
					</div>
					<div class="input-group">
						<div class="input-box">
							<br>
							<button id="cadastrar-usuario" type="button">CADASTRAR</button>
						</div>
					</div>
				</form>
			</div>
	    </div>
	</div>
	<script>
		$(function() {
	        $("#cadastrar-usuario").on('click', function(e) {
	          
		        var cadastroData = {
		        	idUsuario: 0,
		       		apelidoUsuario: $("input[name='apelidoUsuario']").val(),
		  			emailUsuario: $("input[name='emailUsuario']").val(),
		  			senhaUsuario: "",
		  			tipoUsuario: $("input[name='tipoUsuario']:checked").val()
		        };
		            
		        console.log(cadastroData);
		         
		        $.post("http://localhost:8080/UsuarioLoginServlet", JSON.stringify(cadastroData), function(data, status) {
		        	console.log(data.success);
			   	    if(data.success == "true") {
						window.alert("Usuário cadastrado com sucesso!");
						window.location.replace("../login/login.jsp");
					}else{
						window.alert("Suspeitamos que este e-mail já esteja cadastrado, verifique os dados inseridos!");
					}
			    }, "json");
		      
	        });
	    });
	</script>
</section>