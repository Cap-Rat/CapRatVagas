<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<section>
	<div class="content">
		<div class="wrapper">
		    <div class="search_box">
		        <div class="dropdown1">
		            <div class="default_option1">Categoria</div>  
		            <ul>
		              <li>TI</li>
		              <li>Saúde</li>
		              <li>Educação</li>
					  <li>Gestão</li>
					  <li>Gestão</li>
		            </ul>
		        </div>
				<div class="dropdown2">
		            <div class="default_option2">Região</div>  
		            <ul>
		              <li>São Paulo</li>
		              <li>Rio de Janeiro</li>
		              <li>Guarulhos</li>
		            </ul>
		        </div>
				<div class="dropdown3">
		            <div class="default_option3">Faixa Salarial</div>  
		            <ul>
		              <li>Até R$1.200,00</li>
		              <li>Até R$2.500,00</li>
		              <li>Acima de R$3.000,00</li>
		            </ul>
		        </div>
		        <div class="search_field">
		          <input type="text" class="input" placeholder="Busque aqui">
		          <i class="fa fa-search"></i>
		      </div>
		    </div>
		</div>
		<div class="vaga-container">
	        <div class="vagas" id="vagas_box">
	            <!-- Aqui serao carregadas as vagas -->
	        </div>
	    </div>
	</div>
</section>

<script>

	$(document).ready(function(){
		$.getJSON("http://localhost:8080/EmpresaVagasServlet", function(data, status){
			let qtdVagas = data.length;
			let saida = "";
			
			for(let i = 0; i < qtdVagas; i++){
				saida += "<div class=\"card\">";
	            saida += "  <div class=\"box\">";
	            saida += "    <div class=\"card-content\">";
	            saida += "       <h3>"+ data[i].tituloVaga +"</h3>";
	            saida += "       <p>"+ data[i].descricaoVaga +"</p>";
	            saida += "       <a href=\"http://localhost:8080/pages/vaga_detalhe/vaga_detalhe.jsp?id="+ data[i].idVaga +"\">Saiba Mais</a>";
	            saida += "    </div>";
	            saida += "  </div>";
	            saida+=  "</div>";
			}
			
			$("#vagas_box").html(saida);
		});
	});

</script>