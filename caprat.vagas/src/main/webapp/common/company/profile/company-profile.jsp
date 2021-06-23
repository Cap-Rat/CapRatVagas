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
		
		const idEmpresa = <%=request.getParameter("id") %>;
		
		$.getJSON("http://localhost:8080/EmpresaInfosServlet", {id: idEmpresa}, function(data, status){
			const dadosEmpresa = data[0];
			let saida = "";
			
			saida += "<div class=\"col-md-3 mt-1\">";
			saida += "	<div class=\"card text-center sidebar\">";
			saida += "    	<div class=\"card-body\">";
			saida += "       	<img src=\"assets/company-icon.png\" width=\"150\" class=\"rounded-circle\"/>";
			saida += "        	<div class=\"mt-3\">";
			saida += "            	<h3>"+dadosEmpresa.nomeEmpresa+"</h3>";
			saida += "            	<br><br>";
			if(idEmpresa == null){
				saida += "            	<a href=\"company_profile.jsp\">Meu perfil</a><br>";
				saida += "            	<a href=\"company_edit_profile.jsp\">Editar meu perfil</a><br>";
				saida += "  			<a href=\"company_vagas.jsp\">Minhas vagas</a><br>";
			}
			saida += "			</div>";
			saida += "		</div>";
			saida += "	</div>";
			saida += "</div>";
			saida += "<div class=\"col-md-8 mt-1\">";
			saida += "<div class=\"card mb-3 content\">";
			saida += "    <h1 class=\"m-3 pt-3\">Informações Gerais</h1>";
			saida += "    <div class=\"card-body\">";
			saida += "       <div class=\"row\">";
			saida += "           <div class=\"col-md-3\">";
			saida += "                <h5>Nome da empresa:</h5>";
			saida += "           </div>";
			saida += "            <div class=\"col-md-9 text-secondary\">";
			saida += 				dadosEmpresa.nomeEmpresa;
			saida += "            </div>";
			saida += "        </div>";
			saida += "       <hr>";
			saida += "        <div class=\"row\">";
			saida += "           <div class=\"col-md-3\">";
			saida += "               <h5>Email:</h5>";
			saida += "           </div>";
			saida += "            <div class=\"col-md-9 text-secondary\">";
			saida += 				dadosEmpresa.emailUsuario;
			saida += "           </div>";
			saida += "       </div>";
			saida += "        <hr>";
			saida += "        <div class=\"row\">";
			saida += "            <div class=\"col-md-3\">";
			saida += "                <h5>Contato:</h5>";
			saida += "            </div>";
			saida += "            <div class=\"col-md-9 text-secondary\">";
			saida += 				dadosEmpresa.contatoEmpresa;
			saida += "            </div>";
			saida += "        </div>";
			saida += "        <hr>";
			saida += "        <div class=\"row\">";
			saida += "           <div class=\"col-md-3\">";
			saida += "               <h5>Endereço:</h5>";
			saida += "           </div>";
			saida += "           <div class=\"col-md-9 text-secondary\">";
			saida += 				dadosEmpresa.enderecoEmpresa + " - " + dadosEmpresa.estadoEmpresa + ", " + dadosEmpresa.cidadeEmpresa;
			saida += "           </div>";
			saida += "        </div>";
			saida += "        <div class=\"row\">";
			saida += "           <div class=\"col-md-3\">";
			saida += "               <h5>CEP:</h5>";
			saida += "           </div>";
			saida += "           <div class=\"col-md-9 text-secondary\">";
			saida += 				dadosEmpresa.cepEmpresa;
			saida += "           </div>";
			saida += "        </div>";
			saida += "    </div>";
			saida += "</div>";
			saida += "<div class=\"card mb-3 content\">";
			saida += "   <h1 class=\"m-3\">Informações Adicionais</h1>";
			saida += "   <div class=\"card-body\">";
			saida += "        <div class=\"row\">";
			saida += "            <div class=\"col-md-3\">";
			saida += "                <h5>Área de atuação:</h5>";
			saida += "            </div>";
			saida += "            <div class=\"col-md-9 text-secondary\">";
			saida += 				dadosEmpresa.ramoEmpresa;
			saida += "            </div>";
			saida += "        </div>";
			saida += "        <hr>";
			saida += "        <div class=\"row\">";
			saida += "            <div class=\"col-md-3\">";
			saida += "               <h5>Sobre:</h5>";
			saida += "            </div>";
			saida += "            <div class=\"col-md-9 text-secondary\">";
			saida += 				dadosEmpresa.descricaoEmpresa;
			saida += "            </div>";
			saida += "        </div>";
			saida += "   </div>";
			saida += "	</div>";
			saida += "</div>";
			
			$("#company_content_box").html(saida);
		});
	
	});
	
</script>