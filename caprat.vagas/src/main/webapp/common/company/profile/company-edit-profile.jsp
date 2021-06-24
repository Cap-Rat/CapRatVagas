<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="content-container">
    <div class="profile-container">
        <div class="main">
            <div class="row" id="company_content_box">
                <!-- Dados da empresa -->
            </div>
        </div>
    </div>
</div>

<script>

	$(document).ready(function(){
		
		$("#company_content_box").on("focus", "input", function(){
			$("input[name='contatoEmpresa']").mask('(00) 90000-0000');
			$("input[name='cepEmpresa']").mask("99.999-999");
		});
		
		$("#company_content_box").on("click", "button#atualizarEmpresa", function(){
			var atualizarData = {
					idEmpresa:  $("input[name='idEmpresa']").val(),
					idUsuario: <%=session.getAttribute("userLogin") %>,
					nomeEmpresa: $("input[name='nomeEmpresa']").val(),
					contatoEmpresa: $("input[name='contatoEmpresa']").val(),
					estadoEmpresa: $("input[name='estadoEmpresa']").val(),
					cidadeEmpresa: $("input[name='cidadeEmpresa']").val(),
					enderecoEmpresa: $("input[name='enderecoEmpresa']").val(),
					cepEmpresa: $("input[name='cepEmpresa']").val(),
					ramoEmpresa: $("textarea[name='ramoEmpresa']").val(),
					descricaoEmpresa: $("textarea[name='descricaoEmpresa']").val()
				};
			
			$.post("http://localhost:8080/EmpresaInfosServlet", {empresa: JSON.stringify(atualizarData), email: $("input[name='emailUsuario']").val(), senha: $("input[name='senhaUsuario']").val()}, function(data, status) {
		   	    if(data.success) {
					window.alert("Dados alterados com sucesso!");
					window.location.replace("../company_profile/company_profile.jsp");
				}
		    }, "json");
		});
		
		$.getJSON("http://localhost:8080/EmpresaInfosServlet", {id: ""}, function(data, status){
			const dadosEmpresa = data[0];
			let saida = "";
			
			saida += "<div class=\"col-md-3 mt-1\">";
			saida += "	<div class=\"card text-center sidebar\">";
			saida += "		<div class=\"card-body\">";
			saida += "			<img src=\"assets/company-icon.png\" width=\"150\" class=\"rounded-circle\"/>";
            saida += "       	<div class=\"mt-3\">";
            saida += "          	<h3>"+dadosEmpresa.nomeEmpresa+"</h3>";
            saida += "           	<br><br>";
            saida += "           	<a href=\"company_profile.jsp\">Meu perfil</a><br>";
            saida += "           	<a href=\"company_edit_profile.jsp\">Editar meu perfil</a><br>";
            saida += "           	<a href=\"company_vagas.jsp\">Minhas vagas</a><br>";
            saida += "			</div>";
            saida += "		</div>";
            saida += "	</div>";
            saida += "</div>";
            saida += "<div class=\"col-md-8 mt-1\">";
            saida += "	<form>";
            saida += "		<input type=\"hidden\" name=\"idEmpresa\" value=\""+dadosEmpresa.idEmpresa+"\">";
            saida += "		<div class=\"card mb-3 content\">";
            saida += "			<h1 class=\"m-3 pt-3\">Informações Gerais</h1>";
            saida += "			<div class=\"card-body\">";
            saida += "  			<div class=\"row\">";
            saida += "      			<div class=\"col-md-3\">";
            saida += "          			<h5>Nome da empresa:</h5>";
            saida += "      			</div>";
            saida += "              	<div class=\"col-md-9 text-secondary\">";
            saida += "              		<input name=\"nomeEmpresa\" type=\"text\" value=\""+dadosEmpresa.nomeEmpresa+"\" placeholder=\""+dadosEmpresa.nomeEmpresa+"\" class=\"name\">";
            saida += "      			</div>";
            saida += "  			</div>";
            saida += "         		<hr>";
            saida += "          	<div class=\"row\">";
            saida += "          		<div class=\"col-md-3\">";
            saida += "              		<h5>Email:</h5>";
            saida += "      			</div>";
            saida += "              	<div class=\"col-md-9 text-secondary\">";
            saida += "              		<input name=\"emailUsuario\" type=\"text\" value=\""+dadosEmpresa.emailUsuario+"\" placeholder=\""+dadosEmpresa.emailUsuario+"\" class=\"name\">";
            saida += "      			</div>";
            saida += "  			</div>";
            saida += "          	<div class=\"row\">";
            saida += "          		<div class=\"col-md-3\">";
            saida += "              		<h5>Senha:</h5>";
            saida += "      			</div>";
            saida += "              	<div class=\"col-md-9 text-secondary\">";
            saida += "              		<input name=\"senhaUsuario\" type=\"text\" value=\""+dadosEmpresa.senhaUsuario+"\" placeholder=\""+dadosEmpresa.senhaUsuario+"\" class=\"name\">";
            saida += "      			</div>";
            saida += "  			</div>";
            saida += "          	<hr>";
            saida += "          	<div class=\"row\">";
            saida += "          		<div class=\"col-md-3\">";
            saida += "          			<h5>Contato:</h5>";
            saida += "      			</div>";
            saida += "          		<div class=\"col-md-9 text-secondary\">";
            saida += "              		<input name=\"contatoEmpresa\" type=\"text\" value=\""+dadosEmpresa.contatoEmpresa+"\" placeholder=\""+dadosEmpresa.contatoEmpresa+"\" class=\"name\">";
            saida += "      			</div>";
            saida += "  			</div>";
            saida += "          	<hr>";
            saida += "         		<div class=\"row\">";
            saida += "          		<div class=\"col-md-3\">";
            saida += "          			<h5>Endereço:</h5>";
            saida += "      			</div>";
            saida += "              	<div class=\"col-md-9 text-secondary\">";
            saida += "              		<input name=\"enderecoEmpresa\" type=\"text\" value=\""+dadosEmpresa.enderecoEmpresa+"\" placeholder=\""+dadosEmpresa.enderecoEmpresa+"\" class=\"name\">";
            saida += "      			</div>";
            saida += "  			</div>";
            saida += "         		<div class=\"row\">";
            saida += "          		<div class=\"col-md-3\">";
            saida += "          			<h5>Estado:</h5>";
            saida += "      			</div>";
            saida += "              	<div class=\"col-md-9 text-secondary\">";
            saida += "              		<input name=\"estadoEmpresa\" type=\"text\" value=\""+dadosEmpresa.estadoEmpresa+"\" placeholder=\""+dadosEmpresa.estadoEmpresa+"\" class=\"name\">";
            saida += "      			</div>";
            saida += "  			</div>";
            saida += "         		<div class=\"row\">";
            saida += "          		<div class=\"col-md-3\">";
            saida += "          			<h5>Cidade:</h5>";
            saida += "      			</div>";
            saida += "              	<div class=\"col-md-9 text-secondary\">";
            saida += "              		<input name=\"cidadeEmpresa\" type=\"text\" value=\""+dadosEmpresa.cidadeEmpresa+"\" placeholder=\""+dadosEmpresa.cidadeEmpresa+"\" class=\"name\">";
            saida += "      			</div>";
            saida += "  			</div>";
            saida += "         		<div class=\"row\">";
            saida += "          		<div class=\"col-md-3\">";
            saida += "          			<h5>CEP:</h5>";
            saida += "      			</div>";
            saida += "              	<div class=\"col-md-9 text-secondary\">";
            saida += "              		<input name=\"cepEmpresa\" type=\"text\" value=\""+dadosEmpresa.cepEmpresa+"\" placeholder=\""+dadosEmpresa.cepEmpresa+"\" class=\"name\">";
            saida += "      			</div>";
            saida += "  			</div>";
            saida += "        	</div>";
            saida += "    	</div>";
            saida += "    	<div class=\"card mb-3 content\">";
            saida += "      	<h1 class=\"m-3\">Informações Adicionais</h1>";
            saida += "			<div class=\"card-body\">";
            saida += "  			<div class=\"row\">";
            saida += "      			<div class=\"col-md-3\">";
            saida += "          			<h5>Área de atuação:</h5>";
            saida += "      			</div>";
            saida += "                	<div class=\"col-md-9 text-secondary\">";
            saida += "                  	<textarea id=\"descricao\" name=\"ramoEmpresa\">";
            saida += 							dadosEmpresa.ramoEmpresa;
            saida += "              		</textarea>";
            saida += "                	</div>";
            saida += "            	</div>";
            saida += "            	<hr>";
            saida += "           	<div class=\"row\">";
            saida += "              	<div class=\"col-md-3\">";
            saida += "          			<h5>Sobre:</h5>";
            saida += "      			</div>";
            saida += "                	<div class=\"col-md-9 text-secondary\">";
            saida += "                  	<textarea id=\"descricao\" name=\"descricaoEmpresa\">";
            saida += 							dadosEmpresa.descricaoEmpresa;
            saida += "                  	</textarea>";
            saida += "                	</div>";
            saida += "            	</div>";
            saida += "            	<hr>";
            saida += "            	<div class=\"row\">";
            saida += "                	<div class=\"col-md-5\">";
            saida += "          			<button type=\"button\" id=\"atualizarEmpresa\">SALVAR</button>";
            saida += "      			</div>";
            saida += "  			</div>";
            saida += "			</div>";
            saida += "		</div>";
            saida += "	</form>";
            saida += "</div>";
			
			$("#company_content_box").html(saida);
		});
		
	});

</script>