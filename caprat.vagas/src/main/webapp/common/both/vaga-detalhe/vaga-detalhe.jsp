<section class="content-container">
  <div class="vaga-header">
    <div class="header-left-column">
      <h1>Nome da Vaga</h1>
      <p>Empresa</p>
      <p>Nivel de Experiência</p>
    </div>
    <div class="header-right-column">
      <a href="" id="candidatar-button" class="hide">Candidatar</a>
      <a href="" id="editar-button" class="">Editar</a>
      <a href="" id="excluir-button" class="">Excluir</a>
    </div>
  </div>
  <div class="vaga-body">
    <div class="body-left-column">
      <h3>Descrição</h3>
      <p>
        Lorem ipsum dolor sit amet consectetur adipisicing elit. Ipsa,
        explicabo. Et enim, illum commodi sunt unde vero quam assumenda eum
        molestiae facilis neque? Eligendi illum assumenda nesciunt deleniti,
        natus nihil.
      </p>
    </div>
    <div class="body-right-column">
      <div>
        <h3>Requisitos</h3>
        <p>Tem que ser pica, tlg?</p>
      </div>
      <div>
        <h3>Salário</h3>
        <p>R$ 100,00</p>
      </div>
      <div>
        <h3>Local</h3>
        <p>Av. Tamanduá Roxo, 603, Biriti-SP</p>
      </div>
    </div>
  </div>
</section>

<script>
	$(document).ready(function () {
		
		$("#excluir-button").click(function () {
          res = window.confirm("Quer mesmo excluir esse cara?");
          console.log(res)
        });
		
	})
</script>