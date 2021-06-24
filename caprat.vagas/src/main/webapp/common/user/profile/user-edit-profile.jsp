<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <div class="content-container">
        <div class="profile-container">
            <div class="main">
                <div class="row" id="user_content_box">
                    <!-- Conteudo do usuario -->
                </div>
            </div>
        </div>
    </div>
    
    <script>
		
		$(document).ready(function(){
			
			$("#user_content_box").on("focus", "input", function(){
				$("input[name='contatoUsuario']").mask('(00) 90000-0000');
			});
			
			$("#user_content_box").on("click", "button#atualizarUsuario", function(){
				
				var atualizarData = {
			        	idCurriculo: $("input[name='idCurriculo']").val(),
			        	idUsuario: <%=session.getAttribute("userLogin") %>,
			       		cidadeUsuario: $("input[name='cidadeUsuario']").val(),
			  			contatoUsuario: $("input[name='contatoUsuario']").val(),
			  			cursosUsuario:  $("textarea[name='cursosUsuario']").val(),
			  			enderecoUsuario: $("input[name='enderecoUsuario']").val(),
			  			escolaridadeUsuario: $("textarea[name='escolaridadeUsuario']").val(),
			  			estadoUsuario: $("input[name='estadoUsuario']").val(),
			  			expTrabUsuario:  $("textarea[name='expTrabUsuario']").val(),
			  			faixaSalarialUsuario: $("input[name='faixaSalarialUsuario']").val(),
			  			nascimentoUsuario: $("input[name='nascimentoUsuario']").val(),
			  			nomeUsuario: $("input[name='nomeUsuario']").val()
			        };
				
				$.post("http://localhost:8080/UsuarioCurriculoServlet", {curriculo: JSON.stringify(atualizarData), email: $("input[name='emailUsuario']").val(), senha: $("input[name='senhaUsuario']").val()}, function(data, status) {
			   	    if(data.success) {
						window.alert("Dados alterados com sucesso!");
						window.location.replace("../user_profile/user_profile.jsp");
					}
			    }, "json");
				
			});
			
			$.getJSON("http://localhost:8080/UsuarioCurriculoServlet", {id: ""}, function(data, status){
				const dadosUsuario = data[0];
				const nomeUsuarioArr = dadosUsuario.nomeUsuario.split(" ");
				const nomeAbreviado = nomeUsuarioArr[0] + " " + nomeUsuarioArr[1];
				
				let saida = "";
				
				saida += "<div class=\"col-md-3 mt-1\">";
				saida += "<div class=\"card text-center sidebar\">";
				saida += "    <div class=\"card-body\">";
				saida += "        <img src=\"assets/user-icon.png\" width=\"150\" class=\"rounded-circle\" />";
				saida += "        <div class=\"mt-3\">";
				saida += "            <h3>"+nomeAbreviado+"</h3>";
				saida += "           <br><br>";
				saida += "           <a href=\"user_profile.jsp\">Meu perfil</a><br>";
				saida += "            <a href=\"user_edit_profile.jsp\">Editar meu perfil</a><br>";
				saida += "            <a href=\"user_vagas.jsp\">Minhas vagas</a>";
				saida += "        </div>";
				saida += "    </div>";
				saida += "</div>";
				saida += "</div>";
				saida += "<div class=\"col-md-8 mt-1\">";
				saida += "<form id=\"userDataForm\">";
				saida += "	<input type=\"hidden\" name=\"idCurriculo\" value=\""+dadosUsuario.idCurriculo+"\">";
				saida += "	<input type=\"hidden\" name=\"nascimentoUsuario\" value=\""+dadosUsuario.nascimentoUsuario+"\">";
				saida += "    <div class=\"card mb-3 content\">";
				saida += "        <h1 class=\"m-3 pt-3\">Informações Gerais</h1>";
				saida += "       <div class=\"card-body\">";
				saida += "            <div class=\"row\">";
				saida += "               <div class=\"col-md-3\">";
				saida += "                   <h5>Nome completo:</h5>";
				saida += "               </div>";
				saida += "                <div class=\"col-md-9 text-secondary\">";
				saida += "                    <input name=\"nomeUsuario\" type=\"text\" placeholder=\""+dadosUsuario.nomeUsuario+"\" value=\""+dadosUsuario.nomeUsuario+"\" class=\"name\">";
				saida += "                </div>";
				saida += "           </div>";
				saida += "            <hr>";
				saida += "           <div class=\"row\">";
				saida += "                <div class=\"col-md-3\">";
                saida += "                    <h5>Email:</h5>";
                saida += "               </div>";
                saida += "                <div class=\"col-md-9 text-secondary\">";
                saida += "                    <input name=\"emailUsuario\" type=\"text\" placeholder=\""+dadosUsuario.emailUsuario+"\" value=\""+dadosUsuario.emailUsuario+"\" class=\"name\">";
                saida += "                </div>";
                saida += "            </div>";
				saida += "           <div class=\"row\">";
				saida += "                <div class=\"col-md-3\">";
                saida += "                    <h5>Senha:</h5>";
                saida += "               </div>";
                saida += "                <div class=\"col-md-9 text-secondary\">";
                saida += "                    <input name=\"senhaUsuario\" type=\"text\" placeholder=\""+dadosUsuario.senhaUsuario+"\" value=\""+dadosUsuario.senhaUsuario+"\" class=\"name\">";
                saida += "                </div>";
                saida += "            </div>";
                saida += "            <hr>";
                saida += "            <div class=\"row\">";
                saida += "                <div class=\"col-md-3\">";
                saida += "                   <h5>Contato:</h5>";
                saida += "               </div>";
                saida += "                <div class=\"col-md-9 text-secondary\">";
                saida += "                    <input name=\"contatoUsuario\" type=\"text\" placeholder=\""+dadosUsuario.contatoUsuario+"\" value=\""+dadosUsuario.contatoUsuario+"\" class=\"name\">";
                saida += "                </div>";
                saida += "           </div>";
                saida += "            <hr>";
                saida += "           <div class=\"row\">";
                saida += "                <div class=\"col-md-3\">";
                saida += "                    <h5>Endereço:</h5>";
                saida += "                </div>";
                saida += "                <div class=\"col-md-9 text-secondary\">";
                saida += "                    <input name=\"enderecoUsuario\" type=\"text\" placeholder=\""+dadosUsuario.enderecoUsuario+"\" value=\""+dadosUsuario.enderecoUsuario+"\" class=\"name\">";
                saida += "                </div>";
                saida += "            </div>";
                saida += "            <div class=\"row\">";
                saida += "                <div class=\"col-md-3\">";
                saida += "                    <h5>Cidade:</h5>";
                saida += "                </div>";
                saida += "                <div class=\"col-md-9 text-secondary\">";
                saida += "                    <input name=\"cidadeUsuario\" type=\"text\" placeholder=\""+dadosUsuario.cidadeUsuario+"\" value=\""+dadosUsuario.cidadeUsuario+"\" ";
                saida += "                        class=\"name\">";
                saida += "               </div>";
                saida += "           </div>";
               	saida += "           <div class=\"row\">";
               	saida += "               <div class=\"col-md-3\">";
               	saida += "                   <h5>Estado:</h5>";
               	saida += "                </div>";
               	saida += "                <div class=\"col-md-9 text-secondary\">";
               	saida += "                   <input name=\"estadoUsuario\" type=\"text\" placeholder=\""+dadosUsuario.estadoUsuario+"\" value=\""+dadosUsuario.estadoUsuario+"\" ";
               	saida += "                        class=\"name\">";
               	saida += "                </div>";
               	saida += "            </div>";
				saida += "            <hr>";
               	saida += "           <div class=\"row\">";
               	saida += "               <div class=\"col-md-3\">";
               	saida += "                   <h5>Pretenção salarial:</h5>";
               	saida += "                </div>";
               	saida += "                <div class=\"col-md-9 text-secondary\">";
               	saida += "                   <input name=\"faixaSalarialUsuario\" type=\"number\" placeholder=\""+dadosUsuario.faixaSalarialUsuario+"\" value=\""+dadosUsuario.faixaSalarialUsuario+"\" ";
               	saida += "                        class=\"name\">";
               	saida += "                </div>";
               	saida += "            </div>";
                saida += "        </div>";
                saida += "    </div>";
                saida += "    <div class=\"card mb-3 content\">";
                saida += "        <h1 class=\"m-3\">Informações Adicionais</h1>";
                saida += "        <div class=\"card-body\">";
                saida += "           <div class=\"row\">";
                saida += "                <div class=\"col-md-3\">";
                saida += "                   <h5>Conhecimentos:</h5>";
                saida += "               </div>";
                saida += "                <div class=\"col-md-9 text-secondary\">";
                saida += "                    <textarea id=\"descricao\" name=\"cursosUsuario\">";
                saida += 						dadosUsuario.cursosUsuario;
                saida += "                    </textarea>";
                saida += "                </div>";
                saida += "            </div>";
                saida += "           <hr>";
                saida += "            <div class=\"row\">";
                saida += "                <div class=\"col-md-3\">";
                saida += "                    <h5>Experiências:</h5>";
                saida += "                </div>";
                saida += "                <div class=\"col-md-9 text-secondary\">";
                saida += "                    <textarea id=\"descricao\" name=\"expTrabUsuario\">";
                saida += 						dadosUsuario.expTrabUsuario;
                saida += "                    </textarea>";
                saida += "                </div>";
                saida += "            </div>";
                saida += "            <hr>";
                saida += "            <div class=\"row\">";
                saida += "                <div class=\"col-md-3\">";
                saida += "                    <h5>Formação acadêmica:</h5>";
                saida += "                </div>";
                saida += "                <div class=\"col-md-9 text-secondary\">";
                saida += "                    <textarea id=\"descricao\" name=\"escolaridadeUsuario\">";
                saida += 						dadosUsuario.escolaridadeUsuario
                saida += "                    </textarea>";
                saida += "               </div>";
                saida += "            </div>";
                saida += "            <hr>";
                saida += "            <div class=\"row\">";
                saida += "                <div class=\"col-md-5\">";
                saida += "                   <button type=\"button\" id=\"atualizarUsuario\">SALVAR</button>";
                saida += "                </div>";
                saida += "           </div>";
                saida += "        </div>";
                saida += "    </div>";
                saida += "</form>";
                saida += "</div>";
                
                $("#user_content_box").html(saida);
			});
			
		});
			
	</script>