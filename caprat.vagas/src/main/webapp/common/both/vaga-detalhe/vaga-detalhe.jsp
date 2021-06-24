<section class="content-container" id="vaga_box">
  <!-- Aqui serão carregados os dados da vaga -->
</section>

<script>
	$(document).ready(function () {
		
		const idUsuario = <%=session.getAttribute("userLogin") %>;
		const tipoUsuario = <%=session.getAttribute("userTipo") %>;
		const idVaga = <%=request.getParameter("id") %>;
		
		$("#vaga_box").on("click", "a#excluir-button", function () {
			if(window.confirm("Tem certeza que deseja excluir a vaga?")){
				$.ajax({
				    url: "http://localhost:8080/EmpresaVagasServlet",
				    data: {id: idVaga},
				    dataType: "json",
				    type: 'DELETE',
				    success: function(data, status) {
				    	if(data.success)
				    		window.alert("Vaga apagada com sucesso!");
				    	else
				    		window.alert("Esta vaga não pertence a sua empresa!");
				    	window.location.replace("../company_profile/company_profile.jsp");	
				    }
				});
			}
		});
		
		$("#vaga_box").on("click", "a#candidatar-button", function () {
		  let candidaturaString = {idUsuario: idUsuario, idVaga: idVaga};
		  
          $.post("http://localhost:8080/UsuarioVagasServlet", JSON.stringify(candidaturaString), function(data, status){
        	  if(data.success){
	        	  window.alert("Candidatura feita com sucesso! Fique esperto para futuros contatos da empresa.");
	        	  window.location.replace("../feed/feed.jsp");
        	  }else{
        		  window.alert("Você já se candidatou para esta vaga!");
	        	  window.location.replace("../feed/feed.jsp");
        	  }
          });
        });
		
		$.getJSON("http://localhost:8080/EmpresaVagasServlet", {id: idVaga}, function(data, status){
			let saida = "";
			
			saida += "<div class=\"vaga-header\">";
		    saida += "	<div class=\"header-left-column\">";
		    saida += "  	<h1>"+data.tituloVaga+"</h1>";
		    saida += "  	<a href=\"../company_profile/company_profile.jsp?id="+data.idEmpresa+"\">"+data.nomeEmpresa+"</a>";
		    saida += "  	<p>Nível de Experiência: "+data.nivelExpVaga+"</p>";
		    saida += "	</div>";
		    saida += "	<div class=\"header-right-column\">";
		    
		    if(tipoUsuario == 2){
		    	saida += "  <a href=\"#\" id=\"candidatar-button\" class=\"hide\">Candidatar</a>";
			    saida += "  <a href=\"../cadastro_vaga/cadastro_vaga.jsp?id="+idVaga+"\" id=\"editar-button\" >Editar</a>";
			    saida += "  <a href=\"#\" id=\"excluir-button\" >Excluir</a>";
		    }else{
		    	saida += "  <a href=\"#\" id=\"candidatar-button\" class=\"\">Candidatar</a>";
			    saida += "  <a href=\"#\" class=\"hide\" id=\"editar-button\">Editar</a>";
			    saida += "  <a href=\"#\" id=\"excluir-button\" class=\"hide\">Excluir</a>";
		    }
		    
		    saida += "	</div>";
		    saida += "</div>";
		    saida += "<div class=\"vaga-body\">";
		    saida += "	<div class=\"body-left-column\">";
		    saida += "  	<h3>Descrição</h3>";
		    saida += "  	<p>";
		    saida +=      		data.descricaoVaga;
		    saida += "  	</p>";
		    saida += "	</div>";
		    saida += "	<div class=\"body-right-column\">";
		    saida += "  	<div>";
		    saida += "    		<h3>Requisitos</h3>";
		    saida += "    		<p>"+data.requisitosVaga+"</p>";
		    saida += "  	</div>";
		    saida += "  	<div>";
		    saida += "    		<h3>Salário</h3>";
		    saida += "    		<p>"+parseFloat(data.salarioVaga).toLocaleString('pt-br', { style: 'currency', currency: 'BRL' })+"</p>";
		    saida += "  	</div>";
		    saida += "  	<div>";
		    saida += "    		<h3>Local</h3>";
		    saida += "    		<p>"+data.enderecoVaga+", "+data.cidadeVaga+", "+data.estadoVaga+"</p>";
		    saida += "  	</div>";
		    saida += "	</div>";
		    saida += "</div>";
		    
		    $("#vaga_box").html(saida);
		});
		
	})
</script>