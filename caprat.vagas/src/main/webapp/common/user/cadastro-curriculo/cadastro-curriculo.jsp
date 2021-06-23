<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<section>
	<div class="content">
		<div class="depoimento">
	        <h1>Depoimentos</h1>
	        <div class="card">
	            <div class="membro">
	                <div class="user_img">
	                    <img src="../../common/user/cadastro-curriculo/assets/team2.png" alt="user_image">
	                </div>
	                <h3>Juliana Ferreira</h3>
	                <p class="cargo">Analista de Marketing</p>
	                <p class="depoimento">O CapRat proporciona uma experiencia incrível, com diversas oportunidades. Depois que cadastrei meu currículo recebi propostas sensacionais. Em apenas dois meses estou contrata numa empresa maravilhosa.</p>
	            </div>
	            <div class="membro">
	                <div class="user_img">
	                    <img src="../../common/user/cadastro-curriculo/assets/team1.png" alt="user_image">
	                </div>
	                <h3>Henry Rodrigues</h3>
	                <p class="cargo">Agente de tráfego</p>
	                <p class="depoimento">Super recomendo o CapRat para quem está procurando uma possibilidade no mercado de trabalho, eles oferecem vagas em diversas empresas de renome, além de possuir um suporte incrível. O primeiro site que realmente se preocupa com o cliente.</p>
	            </div>
	            <div class="membro">
	                <div class="user_img">
	                    <img src="../../common/user/cadastro-curriculo/assets/team3.png" alt="user_image">
	                </div>
	                <h3>Thiago Marcondes</h3>
	                <p class="cargo">Desenvolvedor Mobile</p>
	                <p class="depoimento">Eu já utilizei várias plataformas que trabalham oferecendo vagas, em nenhuma delas eu encontrei um atendimento tão atencioso e rápido. Quando realizei meu cadastro  tive um pequeno problema de forma bastante rápida.</p>
	            </div>
	        </div>
	    </div>
	</div>
	<div class="wave">
		<div class="custom-shape-divider-top-1618457940">
		    <svg data-name="Layer 1" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1200 120" preserveAspectRatio="none">
		        <path d="M985.66,92.83C906.67,72,823.78,31,743.84,14.19c-82.26-17.34-168.06-16.33-250.45.39-57.84,11.73-114,31.07-172,41.86A600.21,600.21,0,0,1,0,27.35V120H1200V95.8C1132.19,118.92,1055.71,111.31,985.66,92.83Z" class="shape-fill"></path>
		    </svg>
		</div>
	</div>
	<div class="form-content">
		<div class="side-image">
		</div>
		<div class="side-form">
			<div class="cadastro">
		        <h2>Cadastro de currículo</h2>
		        <form id="cadastrar-curriculo-form">
		            <h4>Nome</h4>
		            <div class="input-group">
		                <div class="input-box">
		                    <input type="text" name="nomeUsuario" placeholder="Nome completo" required class="name">
		                    <i class="fa fa-user icon"></i>
		                </div>
		            </div>
		            <h4>Data de Nascimento</h4>
		            <div class="input-group">
		                <div class="input-box">
		                     <input type="date" name="nascimentoUsuario" class="name">
		                     <i class="fa fa-calendar-o icon" aria-hidden="true"></i>
		                 </div>
		             </div>
		            <h4>Contato</h4>
		            <div class="input-group">
		                <div class="input-box">
		                    <div class="input-box">
		                        <input type="text" name="contatoUsuario" placeholder="Ex: (11) 9-9276-1231" required class="name">
		                        <i class="fa fa-phone icon" aria-hidden="true"></i>
		                    </div>
		                </div>
		            </div>
		            <h4>Endereço</h4>
		            <div class="input-group">
		                <div class="input-box">
		                    <input type="text" name="estadoUsuario" placeholder="Estado" required class="name">
		                    <i class="fa fa-map icon" aria-hidden="true"></i>
		                </div>
		                <div class="input-box">
		                    <input type="text" name="cidadeUsuario" placeholder="Cidade" required class="name">
		                    <i class="fa fa-map-signs icon" aria-hidden="true"></i>
		                </div>
		            </div>
		            <div class="input-group">
		                <div class="input-box">
		                    <input type="text" name="enderecoUsuario" placeholder="Logradouro" required class="name">
		                    <i class="fa fa-map-marker icon" aria-hidden="true"></i>
		                </div>
		            </div>
		            <h4>Preteção salarial</h4>
		            <div class="input-group">
		                <div class="input-box">
		                    <input type="text" name="faixaSalarialUsuario" placeholder="Ex: R$1.500,00 " required class="name">
		                    <i class="fa fa-money icon" aria-hidden="true"></i>
		                </div>
		            </div>
		            <h4>Grau de escolaridade</h4>
		            <div class="input-group">
		                <div class="input-box">
		                    <input type="text" name="escolaridadeUsuario" placeholder="Ex: Superior completo " required class="name">
		                    <i class="fa fa-graduation-cap icon" aria-hidden="true"></i>
		                </div>
		            </div>
		            <div class="input-group">
		                <div class="input-box">
		                    <button type="button" id="cadastrar-curriculo">CADASTRAR CURRÍCULO</button>
		                </div>
		            </div>
		        </form>
	    	</div>
		</div>
	</div>
</section>

<script>

	/*$.fn.serializeObject = function() {
	    var o = {};
	    var a = this.serializeArray();
	    $.each(a, function() {
	        if (o[this.name]) {
	            if (!o[this.name].push) {
	                o[this.name] = [o[this.name]];
	            }
	            o[this.name].push(this.value || '');
	        } else {
	            o[this.name] = this.value || '';
	        }
	    });
	    return o;
	};*/
	
	$(function() {
        $("#cadastrar-curriculo").on('click', function(e) {
          
	        var cadastroData = {
	        	idCurriculo: 0,
	        	idUsuario: <%=session.getAttribute("userLogin") %>,
	       		cidadeUsuario: $("input[name='cidadeUsuario']").val(),
	  			contatoUsuario: $("input[name='contatoUsuario']").val(),
	  			cursosUsuario: "",
	  			enderecoUsuario: $("input[name='enderecoUsuario']").val(),
	  			escolaridadeUsuario: $("input[name='escolaridadeUsuario']").val(),
	  			estadoUsuario: $("input[name='estadoUsuario']").val(),
	  			expTrabUsuario: "",
	  			faixaSalarialUsuario: $("input[name='faixaSalarialUsuario']").val(),
	  			nascimentoUsuario: $("input[name='nascimentoUsuario']").val(),
	  			nomeUsuario: $("input[name='nomeUsuario']").val()
	        };
	         
	        $.post("http://localhost:8080/UsuarioCurriculoServlet", {curriculo: JSON.stringify(cadastroData)}, function(data, status) {
		   	    if(data.success) {
					window.alert("Curriculo cadastrado com sucesso!");
					window.location.replace("../feed/feed.jsp");
				}
		    }, "json");
	      
        });
    });

</script>