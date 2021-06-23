<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <div class="content-container">
        <div class="profile-container">
            <div class="main">
                <div class="row" id="user_content_box">
                  <!--  Conteudo do usuario  -->
                </div>
            </div>
        </div>
    </div>
        
		<script>
		
			$(document).ready(function(){
				
				const idUsuario = <%=request.getParameter("id") %>;
				
				$.getJSON("http://localhost:8080/UsuarioCurriculoServlet", {id: idUsuario}, function(data, status){
					const dadosUsuario = data[0];
					console.log(dadosUsuario);
					const dataUsuarioArr = dadosUsuario.nascimentoUsuario.split("-");
					const nomeUsuarioArr = dadosUsuario.nomeUsuario.split(" ");
					let nomeAbreviado = nomeUsuarioArr.length >= 2 ? nomeUsuarioArr[0] + " " + nomeUsuarioArr[1] : nomeUsuarioArr[0];
					const nascimentoUsuario = dataUsuarioArr[2] + "/" + dataUsuarioArr[1] + "/" + dataUsuarioArr[0];
					
					let saida = "";
					
					saida += "<div class=\"col-md-3 mt-1\">";
					saida += "<div class=\"card text-center sidebar\">";
					saida += "    <div class=\"card-body\">";
					saida += "        <img src=\"assets/user-icon.png\" width=\"150\" class=\"rounded-circle\"/>";
					saida += "        <div class=\"mt-3\">";
					saida += "            <h3>"+ nomeAbreviado +"</h3>";
					saida += "            <br><br>";
					if(idUsuario == null){
						saida += "            <a href=\"user_profile.jsp\">Meu perfil</a><br>";
						saida += "            <a href=\"user_edit_profile.jsp\">Editar meu perfil</a><br>";
						saida += "            <a href=\"user_vagas.jsp\">Minhas vagas</a>";
					}
					saida += "        </div>";
					saida += "    </div>";
					saida += "</div>";
					saida += "</div>";
					saida += "<div class=\"col-md-8 mt-1\">";
					saida += "<div class=\"card mb-3 content\">";
					saida += "    <h1 class=\"m-3 pt-3\">Informações Gerais</h1>";
					saida += "    <div class=\"card-body\">";
					saida += "        <div class=\"row\">";
					saida += "            <div class=\"col-md-3\">";
					saida += "                <h5>Nome completo:</h5>";
					saida += "           </div>";
					saida += "            <div class=\"col-md-9 text-secondary\">";
					saida += 				dadosUsuario.nomeUsuario;
					saida += "            </div>";
					saida += "        </div>";
					saida += "        <hr>";
					saida += "        <div class=\"row\">";
					saida += "            <div class=\"col-md-3\">";
					saida += "                <h5>Data de nascimento:</h5>";
					saida += "           </div>";
					saida += "            <div class=\"col-md-9 text-secondary\">";
					saida += 				nascimentoUsuario;
					saida += "            </div>";
					saida += "        </div>";
					saida += "        <hr>";
					saida += "        <div class=\"row\">";
					saida += "            <div class=\"col-md-3\">";
					saida += "                <h5>Email:</h5>";
					saida += "           </div>";
					saida += "            <div class=\"col-md-9 text-secondary\">";
					saida += 				dadosUsuario.emailUsuario;
					saida += "            </div>";
					saida += "        </div>";
					saida += "       <hr>";
					saida += "        <div class=\"row\">";
					saida += "            <div class=\"col-md-3\">";
					saida += "               <h5>Contato:</h5>";
					saida += "           </div>";
					saida += "            <div class=\"col-md-9 text-secondary\">";
					saida += 				dadosUsuario.contatoUsuario;
					saida += "            </div>";
					saida += "        </div>";
					saida += "        <hr>";
					saida += "        <div class=\"row\">";
					saida += "            <div class=\"col-md-3\">";
					saida += "                <h5>Endereço:</h5>";
					saida += "            </div>";
					saida += "            <div class=\"col-md-9 text-secondary\">";
					saida += 			    dadosUsuario.enderecoUsuario + " - " + dadosUsuario.estadoUsuario+ ", " + dadosUsuario.cidadeUsuario;
					saida += "            </div>";
					saida += "       </div>";
					saida += "        <hr>";
					saida += "        <div class=\"row\">";
					saida += "            <div class=\"col-md-3\">";
					saida += "                <h5>Pretenção salarial:</h5>";
					saida += "            </div>";
					saida += "            <div class=\"col-md-9 text-secondary\">";
					saida += 			    parseFloat(dadosUsuario.faixaSalarialUsuario).toLocaleString('pt-br', { style: 'currency', currency: 'BRL' });
					saida += "            </div>";
					saida += "       </div>";
					saida += "    </div>";
					saida += "</div>";
					saida += "<div class=\"card mb-3 content\">";
					saida += "   <h1 class=\"m-3\">Informações Adicionais</h1>";
					saida += "   <div class=\"card-body\">";
					saida += "        <div class=\"row\">";
					saida += "            <div class=\"col-md-3\">";
					saida += "                <h5>Conhecimentos:</h5>";
					saida += "            </div>";
					saida += "            <div class=\"col-md-9 text-secondary\">";
					saida += 				dadosUsuario.cursosUsuario;
					saida += "            </div>";
					saida += "        </div>";
					saida += "        <hr>";
					saida += "        <div class=\"row\">";
					saida += "            <div class=\"col-md-3\">";
					saida += "                <h5>Experiências:</h5>";
					saida += "            </div>";
					saida += "            <div class=\"col-md-9 text-secondary\">";
					saida += 				dadosUsuario.expTrabUsuario;
					saida += "            </div>";
					saida += "        </div>";
					saida += "        <hr>";
					saida += "        <div class=\"row\">";
					saida += "           <div class=\"col-md-3\">";
					saida += "               <h5>Formação acadêmica:</h5>";
					saida += "           </div>";
					saida += "           <div class=\"col-md-9 text-secondary\">";
					saida += 				dadosUsuario.escolaridadeUsuario;
					saida += "           </div>";
					saida += "       </div>";
					saida += "   </div>";
					saida += "</div>";
					saida += "</div>";
					
					$("#user_content_box").html(saida);
				});
				
			});
		
		</script>