<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<section>
	<div class="content">
		<div class="depoimento">
			<h1>Depoimentos</h1>
			<div class="card">
				<div class="membro">
					<div class="user_img">
						<img src="../common/company/cadastro-vaga/assets/team2.png"
							alt="user_image">
					</div>
					<h3>Empresa</h3>
					<p class="cargo">Ramo</p>
					<p class="depoimento">texto foda sobre como minha empresa
						conseguiu empregados fodas com esse site foda de vagas
						incrivelmente foda</p>
				</div>
				<div class="membro">
					<div class="user_img">
						<img src="../common/company/cadastro-vaga/assets/team1.png"
							alt="user_image">
					</div>
					<h3>Empresa</h3>
					<p class="cargo">Ramo</p>
					<p class="depoimento">texto foda sobre como minha empresa
						conseguiu empregados fodas com esse site foda de vagas
						incrivelmente foda</p>
				</div>
				<div class="membro">
					<div class="user_img">
						<img src="../common/company/cadastro-vaga/assets/team3.png"
							alt="user_image">
					</div>
					<h3>Empresa</h3>
					<p class="cargo">Ramo</p>
					<p class="depoimento">texto foda sobre como minha empresa
						conseguiu empregados fodas com esse site foda de vagas
						incrivelmente foda</p>
				</div>
			</div>
		</div>
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
				<h2>Cadastro</h2>
				<form>
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
							<input name="salarioVaga" type="text"
								placeholder="Ex: R$1.500,00 " required class="name"> <i
								class="fa fa-money icon" aria-hidden="true"></i>
						</div>
					</div>
					<h4>Nível de experiência</h4>
					<div class="input-group">
						<div class="input-box">
							<input name="nivelExpVaga" type="text"
								placeholder="Ex: Desenvolvedor Pleno" required class="name">
							<i class="fa fa-plus icon" aria-hidden="true"></i>
						</div>
					</div>
					<div class="input-group">
						<div class="input-box">
							<button id="cadastrar-vaga">CADASTRAR VAGA</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	<script>

		$(function() {
	        $("#cadastrar-vaga").on('click', function(e) {
	          
		        var cadastroData = {
		        	idVaga: 0,
		        	idEmpresa: 2,
		       		tituloVaga: $("input[name='tituloVaga']").val(),
		  			requisitosVaga: $("textarea[name='requisitosVaga']").val(),
		  			descricaoVaga: $("textarea[name='descricaoVaga']").val(),
		  			estadoVaga: $("input[name='estadoVaga']").val(),
		  			cidadeVaga: $("input[name='cidadeVaga']").val(),
		  			enderecoVaga: $("input[name='enderecoVaga']").val(),
		  			salarioVaga: $("input[name='salarioVaga']").val(),
		  			nivelExpVaga: $("input[name='nivelExpVaga']").val()
		        };
		            
		        console.log(cadastroData);
		         
		        $.post("http://localhost:8080/EmpresaVagasServlet", JSON.stringify(cadastroData), function(data, status) {
			   	    if(data.success) {
					    console.log(data.success);
						window.alert("Vaga cadastrada com sucesso!");
						//window.location.replace("../index.jsp");
					}
			    }, "json");
		      
	        });
	    });

	</script>
</section>