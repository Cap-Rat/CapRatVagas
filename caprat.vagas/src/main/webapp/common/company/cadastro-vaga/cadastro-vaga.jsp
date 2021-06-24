<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<section>
	<div class="content">
	</div>
	<div class="wave">
		<div class="custom-shape-divider-top-1618457940">
			<svg data-name="Layer 1" xmlns="http://www.w3.org/2000/svg"
				viewBox="0 0 1200 120" preserveAspectRatio="none">
		        <path
					d="M985.66,92.83C906.67,72,823.78,31,743.84,14.19c-82.26-17.34-168.06-16.33-250.45.39-57.84,11.73-114,31.07-172,41.86A600.21,600.21,0,0,1,0,27.35V120H1200V95.8C1132.19,118.92,1055.71,111.31,985.66,92.83Z"
					class="shape-fill"></path>
		    </svg>
		</div>
	</div>
	<div class="form-content">
		<div class="side-image"></div>
		<div class="side-form">
			<div class="cadastro">
				<h2 id="titulo">Criar uma vaga</h2>
				<form id="cadastrar-vaga-form">
					<input type="hidden" name="idVaga" value="0">
					<input type="hidden" name="idEmpresa" value="0">
					<h4>Título</h4>
					<div class="input-group">
						<div class="input-box">
							<input name="tituloVaga" type="text" placeholder="Título da vaga"
								required class="name"> <i class="fa fa-etsy icon"
								aria-hidden="true"></i>
						</div>
					</div>
					<h4>Descrição</h4>
					<div class="input-group">
						<div class="input-box">
							<textarea name="descricaoVaga">
		                    </textarea>
						</div>
					</div>
					<h4>Endereço</h4>
					<div class="input-group">
						<div class="input-box">
							<input name="estadoVaga" type="text" placeholder="Estado"
								required class="name"> <i class="fa fa-map icon"
								aria-hidden="true"></i>
						</div>
						<div class="input-box">
							<input name="cidadeVaga" type="text" placeholder="Cidade"
								required class="name"> <i class="fa fa-map-signs icon"
								aria-hidden="true"></i>
						</div>
					</div>
					<div class="input-group">
						<div class="input-box">
							<input name="enderecoVaga" type="text" placeholder="Logradouro"
								required class="name"> <i class="fa fa-map-marker icon"
								aria-hidden="true"></i>
						</div>
					</div>
					<h4>Requisitos</h4>
					<div class="input-group">
						<div class="input-box">
							<textarea name="requisitosVaga">
		                    </textarea>
						</div>
					</div>
					<h4>Salário</h4>
					<div class="input-group">
						<div class="input-box">
							<input name="salarioVaga" type="number"
								placeholder="Ex: R$1.500,00 " required class="name"> <i
								class="fa fa-money icon" aria-hidden="true"></i>
						</div>
					</div>
					<h4>Nível de experiência</h4>
					<div class="input-group">
						<div class="input-box">
							<select name="nivelExpVaga" class="name" required>
								<option value="" disabled="disabled" selected="selected"> Escolha </option>
								<option value="Experiência"> Experiência </option>
								<option value="Estagiário"> Estagiário </option>
								<option value="Júnior/Treinee"> Júnior/Treinee </option>
								<option value="Pleno"> Pleno </option>
								<option value="Sênior"> Sênior </option>
							</select>
							<i class="fa fa-plus icon" aria-hidden="true"></i>
						</div>
					</div>
					<div class="input-group">
						<div class="input-box">
							<button type="button" id="cadastrar-vaga">CADASTRAR VAGA</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	<script>

		$(function() {
			const idVaga = <%=request.getParameter("id") %>;
			
			if(idVaga != null){
				$.getJSON("http://localhost:8080/EmpresaVagasServlet", {id: idVaga}, function(data, status){
					$("#titulo").html("ATUALIZANDO VAGA");
					$("#cadastrar-vaga").html("ATUALIZAR VAGA");
					$("input[name='tituloVaga']").val(data.tituloVaga);
					$("textarea[name='requisitosVaga']").val(data.requisitosVaga);
		  			$("textarea[name='descricaoVaga']").val(data.descricaoVaga);
		  			$("input[name='estadoVaga']").val(data.estadoVaga);
		  			$("input[name='cidadeVaga']").val(data.cidadeVaga);
		  			$("input[name='enderecoVaga']").val(data.enderecoVaga);
		  			$("input[name='salarioVaga']").val(data.salarioVaga);
		  			$("select[name='nivelExpVaga']").val(data.nivelExpVaga);
		  			$("input[name='idVaga']").val(data.idVaga);
		        	$("input[name='idEmpresa']").val(data.idEmpresa);
				});
			}
			
	        $("#cadastrar-vaga").on('click', function(e) {
	         
		        var cadastroData = {
		        	idVaga: $("input[name='idVaga']").val(),
		        	idEmpresa: $("input[name='idEmpresa']").val(),
		       		tituloVaga: $("input[name='tituloVaga']").val(),
		  			requisitosVaga: $("textarea[name='requisitosVaga']").val(),
		  			descricaoVaga: $("textarea[name='descricaoVaga']").val(),
		  			estadoVaga: $("input[name='estadoVaga']").val(),
		  			cidadeVaga: $("input[name='cidadeVaga']").val(),
		  			enderecoVaga: $("input[name='enderecoVaga']").val(),
		  			salarioVaga: $("input[name='salarioVaga']").val(),
		  			nivelExpVaga: $("select[name='nivelExpVaga']").val()
		        };
		        
		       
		        $.post("http://localhost:8080/EmpresaVagasServlet", JSON.stringify(cadastroData), function(data, status) {
			   	    if(data.success == "true"){ 
			   	    	if(idVaga != null)
			   	    		window.alert("Vaga alterada com sucesso!");
			   	    	else
							window.alert("Vaga cadastrada com sucesso!");
					}else{
						window.alert("Esta vaga não pertence à sua empresa!");
					}
			   	 	window.location.replace("../company_profile/company_profile.jsp");
			    }, "json");
		      	
	        });
	    });

	</script>
</section>