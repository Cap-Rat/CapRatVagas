<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<section>
	<div class="content">
		<div class="wrapper">
		    <div class="search_box">
		        <div class="dropdown1">
		            <div class="default_option1" id="experienciaDiv">Experiência</div>  
		            <ul>
		              <li class="experiencia">Experiência</li>
		              <li class="experiencia">Estagiário</li>
		              <li class="experiencia">Júnior/Treinee</li>
		              <li class="experiencia">Pleno</li>
					  <li class="experiencia">Sênior</li>
		            </ul>
		        </div>
				<div class="dropdown2">
		            <div class="default_option2" id="regiaoDiv">Região</div>  
		            <ul>
		              <li class="regiao">Região</li>
		              <li class="regiao">São Paulo</li>
		              <li class="regiao">Rio de Janeiro</li>
		              <li class="regiao">Guarulhos</li>
		              <li class="regiao">Bangu</li>
		            </ul>
		        </div>
				<div class="dropdown3">
		            <div class="default_option3" id="faixaDiv">Faixa Salarial</div>  
		            <ul>
		              <li class="faixa">Faixa Salarial</li>
		              <li class="faixa">Até R$2.500,00</li>
		              <li class="faixa">Até R$3.000,00</li>
		              <li class="faixa">Acima de R$3.000,00</li>
		            </ul>
		        </div>
		        <div class="search_field">
		          <input type="text" class="input" placeholder="Busque aqui" id="busca">
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
	function coletarDadosFiltro(JSONdados, exp, regiao, faixa, busca){
		if(exp[0].innerHTML != "Experiência")
			JSONdados.experiencia = exp[0].innerHTML;
		
		if(regiao[0].innerHTML != "Região")
			JSONdados.regiao = regiao[0].innerHTML;
		
		if(faixa[0].innerHTML != "Faixa Salarial"){
			switch(faixa[0].innerHTML){
				case "Até R$2.500,00":
					JSONdados.faixa = "<= 2500";
					break;
				case "Até R$3.000,00":
					JSONdados.faixa = "<= 3000";
					break;
				case "Acima de R$3.000,00":
					JSONdados.faixa = "> 3000";
					break;
			}
		}
		
		if(busca[0].value != "")
			JSONdados.busca = busca[0].value;
	}
	
	function carregarVagas(vagasBox, dadosVagas){
		let qtdVagas = dadosVagas.length;
		let saida = "";
		
		for(let i = 0; i < qtdVagas; i++){
			saida += "<div class=\"card\">";
            saida += "  <div class=\"box\">";
            saida += "    <div class=\"card-content\">";
            saida += "       <h3>"+ dadosVagas[i].tituloVaga +"</h3>";
            saida += "       <p>"+ dadosVagas[i].descricaoVaga +"</p>";
            saida += "       <br><br>";
            saida += "       <p> <b>Estado:</b> "+ dadosVagas[i].estadoVaga +"</p>";
            saida += "       <p> <b>Cidade:</b> "+ dadosVagas[i].cidadeVaga +"</p>"; 
            saida += "       <br>";
            saida += "       <p> <b>Salário:</b> "+ parseFloat(dadosVagas[i].salarioVaga).toLocaleString('pt-br', { style: 'currency', currency: 'BRL' }) +"</p>";
            saida += "       <a href=\"http://localhost:8080/pages/vaga_detalhe/vaga_detalhe.jsp?id="+ dadosVagas[i].idVaga +"\">Saiba Mais</a>";
            saida += "    </div>";
            saida += "  </div>";
            saida+=  "</div>";
		}
		
		vagasBox.html(saida);
	}

	$(document).ready(function(){
		
		$.getJSON("http://localhost:8080/EmpresaVagasServlet", function(data, status){
			carregarVagas($("#vagas_box"), data);
		});
		
		const exp = $("#experienciaDiv");
		const regiao = $("#regiaoDiv");
		const faixa = $("#faixaDiv");
		const busca = $("#busca");
		
		$(".experiencia").click(function(e) { 
			const dadosFiltro = { };
			
			coletarDadosFiltro(dadosFiltro, exp, regiao, faixa, busca);
			
			$.getJSON("http://localhost:8080/EmpresaVagasServlet", dadosFiltro, function(data, status){
				carregarVagas($("#vagas_box"), data);
			});
		});
		
		$(".regiao").click(function(e) {
			const dadosFiltro = { };
			
			coletarDadosFiltro(dadosFiltro, exp, regiao, faixa, busca);
			
			$.getJSON("http://localhost:8080/EmpresaVagasServlet", dadosFiltro, function(data, status){
				carregarVagas($("#vagas_box"), data);
			});
		});
		
		$(".faixa").click(function(e) {
			const dadosFiltro = { };
			
			coletarDadosFiltro(dadosFiltro, exp, regiao, faixa, busca);
			
			$.getJSON("http://localhost:8080/EmpresaVagasServlet", dadosFiltro, function(data, status){
				carregarVagas($("#vagas_box"), data);
			});
			
		});
		
		$("#busca").on("input", function(e){ 
			const dadosFiltro = { };
			
			coletarDadosFiltro(dadosFiltro, exp, regiao, faixa, busca);
			
			$.getJSON("http://localhost:8080/EmpresaVagasServlet", dadosFiltro, function(data, status){
				carregarVagas($("#vagas_box"), data);
			});
		})
	});

</script>