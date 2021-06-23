<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
        <div class="content-container">
            <div class="profile-container">
                <div class="main">
                    <div class="row">
                        <div class="col-md-3 mt-1" id="navBar_box">
                            <!-- NavBar do usuario -->
                        </div>
                        <div class="col-md-8 mt-1" id="vagas_box">
                   
                                <!-- Vagas do usuario -->
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
    
    <script>
    
	    $(document).ready(function(){
			
			$.getJSON("http://localhost:8080/UsuarioCurriculoServlet", {id: ""}, function(data, status){
				const dadosUsuario = data[0];
				const nomeUsuarioArr = dadosUsuario.nomeUsuario.split(" ");
				const nomeAbreviado = nomeUsuarioArr[0] + " " + nomeUsuarioArr[1];
				
				let saida = "";
				
				saida += "<div class=\"card text-center sidebar\">";
				saida += "	<div class=\"card-body\">";
				saida += "    <img src=\"assets/user-icon.png\" width=\"150\" class=\"rounded-circle\"/>";
				saida += "    <div class=\"mt-3\">";
				saida += "        <h3>"+ nomeAbreviado +"</h3>";
				saida += "        <br><br>";
				saida += "        <a href=\"user_profile.jsp\">Meu perfil</a><br>";
				saida += "        <a href=\"user_edit_profile.jsp\">Editar meu perfil</a><br>";
				saida += "        <a href=\"user_vagas.jsp\">Minhas vagas</a>";
				saida += "    </div>";
				saida += "	</div>";
				saida += "</div>";
				
				$("#navBar_box").html(saida);
			});
			
			$.getJSON("http://localhost:8080/UsuarioVagasServlet", function(data, status){
				const dadosVagas = data;
				
				let saida = "";
				saida += "<div class=\"card mb-3 content\">";
				saida += "	<h1 class=\"m-3 pt-3\">Vagas aplicadas</h1>";
				
				for(let i = 0; i < dadosVagas.length; i++){
					saida += "	<div class=\"card-body\">";
					saida += "    <div class=\"course\">";
					saida += "        <div class=\"preview\">";
					saida += "            <h6>Empresa</h6>";
					saida += "            <h2>"+dadosVagas[i].nomeEmpresa+"</h2>";
					saida += "            <a href=\"../company_profile/company_profile.jsp?id="+dadosVagas[i].idEmpresa+"\">Perfil da empresa</a>";
					saida += "       </div>";
					saida += "        <div class=\"info\">";
					saida += "            <h6>Vaga</h6>";
					saida += "            <h2>"+dadosVagas[i].tituloVaga+"</h2>";
					saida += "            <p>"+dadosVagas[i].descricaoVaga+"</p>";
					saida += "           <br>";
					saida += "            <span><b>Estado:</b> "+dadosVagas[i].estadoVaga+"</span>";
					saida += "           <br>";
					saida += "            <span><b>Cidade:</b> "+dadosVagas[i].cidadeVaga+"</span>";
					saida += "           <br>";
					saida += "            <span><b>Salário:</b> "+ parseFloat(dadosVagas[i].salarioVaga).toLocaleString('pt-br', { style: 'currency', currency: 'BRL' }) +"</span>";
					saida += "            <br><br>";
					saida += "           <a class=\"botao\" href=\"http://localhost:8080/pages/vaga_detalhe/vaga_detalhe.jsp?id="+ dadosVagas[i].idVaga +"\">Ver vaga completa</a>";
					saida += "        </div>";
					saida += "    </div>";
					saida += "	</div>";
					
				}
				
				if(dadosVagas.length == 0){
					saida += "<h3 class=\"m-3 pt-3\"> Você ainda não se candidatou para nenhuma vaga em nosso site </h3>";
				}
				
				saida += "</div>";
				
				$("#vagas_box").html(saida);
			});
			
	    });		
    
    </script>