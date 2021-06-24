<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="content-container">
    <div class="profile-container">
        <div class="main">
            <div class="row">
                <div class="col-md-3 mt-1" id="navBar_box">
                    <!-- Dados da empresa -->
                </div>
                <div class="col-md-8 mt-1" id="vagas_box">
                    <!-- Dados das vagas -->
                </div>
            </div>
        </div>
    </div>
</div>

<script>

	$(document).ready(function(){
		
		$.getJSON("http://localhost:8080/EmpresaInfosServlet", {id: ""}, function(data, status){
			const dadosEmpresa = data[0];
			let saida = "";
			
			saida += "<div class=\"card text-center sidebar\">";
			saida += "	<div class=\"card-body\">";
			saida += "    <img src=\"assets/company-icon.png\" width=\"150\" class=\"rounded-circle\"/>";
			saida += "    <div class=\"mt-3\">";
			saida += "        <h3>"+dadosEmpresa.nomeEmpresa+"</h3>";
			saida += "        <br><br>";
			saida += "        <a href=\"company_profile.jsp\">Meu perfil</a><br>";
			saida += "        <a href=\"company_edit_profile.jsp\">Editar meu perfil</a><br>";
			saida += "        <a href=\"company_vagas.jsp\">Minhas vagas</a><br>";
			saida += "    </div>";
			saida += "	</div>";
			saida += "</div>";
			
			$("#navBar_box").html(saida);
		});
		
		$.getJSON("http://localhost:8080/VagasDaEmpresaServlet", function(data, status){
			const dadosVagas = data;
			
			let saida = "";
			
			saida += "<div class=\"card mb-3 content\">";
			saida += "	<h1 class=\"m-3 pt-3\">Minhas vagas</h1>";
			
			for(let i = 0; i < dadosVagas.length; i++){
				let dadosCandidatos = data[i].usuariosData;
				saida += "	<div class=\"card-body\">";
				saida += "		<div class=\"course\">";
				saida += "      	<div class=\"preview\">";
				saida += "          	<h2>Candidatos:</h2>";
				for(let j = 0; j < dadosCandidatos.length; j++){
					let nomeUsuarioArr = dadosCandidatos[j].nomeUsuario.split(" ");
					let nomeAbreviado = nomeUsuarioArr.length >= 2 ? nomeUsuarioArr[0] + " " + nomeUsuarioArr[1] : nomeUsuarioArr[0];
					saida += "      	<a href=\"../user_profile/user_profile.jsp?id="+dadosCandidatos[j].idUsuario+"\">"+nomeAbreviado+"</a><br>";
				}
	            saida += "      	</div>";
	            saida += "      	<div class=\"info\">";
	            saida += "          	<h6>Vaga</h6>";
	            saida += "       		<h2>"+dadosVagas[i].tituloVaga+"</h2>";
	            saida += "          	<p>"+dadosVagas[i].descricaoVaga+"</p>";
	            saida += "          	<br>";
	            saida += "          	<span><b>Estado:</b> "+dadosVagas[i].estadoVaga+"</span>";
	            saida += "          	<br>";
	            saida += "          	<span><b>Cidade:</b> "+dadosVagas[i].cidadeVaga+"</span>";
	            saida += "          	<br>";
	            saida += "          	<span><b>Salário:</b> "+ parseFloat(dadosVagas[i].salarioVaga).toLocaleString('pt-br', { style: 'currency', currency: 'BRL' }) +"</span>";
	            saida += "          	<br><br>";
	            saida += "           <a class=\"botao\" href=\"http://localhost:8080/pages/vaga_detalhe/vaga_detalhe.jsp?id="+ dadosVagas[i].idVaga +"\">Ver vaga completa</a>";
	            saida += "			</div>";
	            saida += "		</div>";
	            saida += "	</div>";
			}
			
			if(dadosVagas.length == 0){
				saida += "<h3 class=\"m-3 pt-3\"> Você ainda não cadastrou nenhuma vaga em nosso site </h3>";
			}
			
            saida += "</div>";
			
			$("#vagas_box").html(saida);
		});
		
	});

</script>