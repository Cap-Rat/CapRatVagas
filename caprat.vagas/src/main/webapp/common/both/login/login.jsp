<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<section>
	<div class="form-content">
		<div class="side-image">
		</div>
		<div class="side-form">
			<div class="cadastro">
				<h2>LOGIN</h2>
				<form>
					<h4>E-mail</h4>
					<div class="input-group">
						<div class="input-box">
							<input name="emailUsuario" type="email" placeholder="Endereço de E-mail" required class="name">
							<i class="fa fa-envelope icon"></i>
						</div>
					</div>
					<h4>Senha</h4>
					<div class="input-group">
						<div class="input-box">
							<input name="senhaUsuario" type="password" placeholder="Senha" required class="name">
							<i class="fa fa-lock icon"></i>
						</div>
					</div>
					<h4><a id="forgot-pass" href="../pass_recover/pass_recover.jsp">Esqueceu sua senha?</a></h4>
					<h4>Não possui uma conta? <a id="h4" href="../cadastro_usuario/cadastro_usuario.jsp">Cadastre-se</a></h4>
					<div class="input-group">
						<div class="input-box">
							<br>
							<button type="button" id="login">LOGIN</button>
						</div>
					</div>
				</form>
			</div>
	    </div>
	</div>
	
	<script>
		$(function() {
	        $("#login").on('click', function(e) {
	          
		        var cadastroData = {
		  			emailUsuario: $("input[name='emailUsuario']").val(),
		  			senhaUsuario: $("input[name='senhaUsuario']").val()
		        };
		         
		        $.getJSON("http://localhost:8080/UsuarioLoginServlet", cadastroData, function(data, status) {
		        	if(data.success == "true") {
						window.alert("Usuário logado com sucesso!");
						
						if(data.tipo == 3){
							
							if(data.isCadastrado)
								window.location.replace("../feed/feed.jsp");
							else
								window.location.replace("../cadastro_curriculo/cadastro_curriculo.jsp");
							
						}
						if(data.tipo == 2){
							
							if(data.isCadastrado)
								window.location.replace("../cadastro_vaga/cadastro_vaga.jsp");
							else
								window.location.replace("../cadastro_empresa/cadastro_empresa.jsp");
							
						}
					}else{
						window.alert("Dados incorretos");
						location.reload();
					}
			    });
		      
	        });
	    });
	</script>
	
</section>


