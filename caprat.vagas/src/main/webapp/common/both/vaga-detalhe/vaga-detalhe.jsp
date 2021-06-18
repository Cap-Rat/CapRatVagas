<section class="content-container" id="vaga_box">
  <!-- Aqui serão carregados os dados da vaga -->
</section>

<script>
	$(document).ready(function () {
		
		const idUsuario = <%=session.getAttribute("userLogin") %>;
		const idVaga = <%=request.getParameter("id") %>;
		
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
		    saida += "<div class=\"header-left-column\">";
		    saida += "  <h1>"+data[0].tituloVaga+"</h1>";
		    saida += "  <p>Empresa</p>";
		    saida += "  <p>Nível de Experiência: "+data[0].nivelExpVaga+"</p>";
		    saida += "</div>";
		    saida += "<div class=\"header-right-column\">";
		    saida += "  <a href=\"#\" id=\"candidatar-button\" class=\"\">Candidatar</a>";
		    saida += "  <a href=\"#\" id=\"editar-button\" class=\"hide\">Editar</a>";
		    saida += "  <a href=\"#\" id=\"excluir-button\" class=\"hide\">Excluir</a>";
		    saida += "</div>";
		    saida += "</div>";
		    saida += "<div class=\"vaga-body\">";
		    saida += "<div class=\"body-left-column\">";
		    saida += "  <h3>Descrição</h3>";
		    saida += "  <p>";
		    saida +=      data[0].descricaoVaga;
		    saida += "  </p>";
		    saida += "</div>";
		    saida += "<div class=\"body-right-column\">";
		    saida += "  <div>";
		    saida += "    <h3>Requisitos</h3>";
		    saida += "    <p>"+data[0].requisitosVaga+"</p>";
		    saida += "  </div>";
		    saida += "  <div>";
		    saida += "    <h3>Salário</h3>";
		    saida += "    <p>"+parseFloat(data[0].salarioVaga).toLocaleString('pt-br', { style: 'currency', currency: 'BRL' })+"</p>";
		    saida += "  </div>";
		    saida += "  <div>";
		    saida += "    <h3>Local</h3>";
		    saida += "    <p>"+data[0].enderecoVaga+", "+data[0].cidadeVaga+", "+data[0].estadoVaga+"</p>";
		    saida += "  </div>";
		    saida += "</div>";
		    saida += "</div>";
		    
		    $("#vaga_box").html(saida);
		});
		
	})
</script>