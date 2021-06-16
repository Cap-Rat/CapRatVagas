<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file='../../../header/v1/header.jsp'%>
<section>
	<div class="form-content">
		<div class="side-image">
		</div>
		<div class="side-form">
			<div class="cadastro">
				<h2>CADASTRO DE EMPRESA</h2>
				<form action="">
	            <h4>Nome</h4>
	            <div class="input-group">
	                <div class="input-box">
	                    <input type="text" placeholder="Nome da empresa" required class="name">
	                    <i class="fa fa-user icon"></i>
	                </div>
	            </div>
	            <h4>Endereço</h4>
	            <div class="input-group">
	                <div class="input-box">
	                    <input type="text" placeholder="Estado" required class="name">
	                    <i class="fa fa-map icon" aria-hidden="true"></i>
	                </div>
	                <div class="input-box">
	                    <input type="text" placeholder="Cidade" required class="name">
	                    <i class="fa fa-map-signs icon" aria-hidden="true"></i>
	                </div>
	            </div>
	            <div class="input-group">
	                <div class="input-box">
	                    <input type="text" placeholder="Logradouro" required class="name">
	                    <i class="fa fa-map-marker icon" aria-hidden="true"></i>
	                </div>
	            </div>
	            <div class="input-group">
	                <div class="input-box">
	                    <input type="text" placeholder="CEP " required class="name">
	                    <i class="fa fa-location-arrow icon" aria-hidden="true"></i>
	                </div>
	            </div>
	            <h4>Ramo</h4>
	            <div class="input-group">
	                <div class="input-box">
	                    <input type="text" placeholder="Ex: Alimentício" required class="name">
	                    <i class="fa fa-briefcase icon"></i>
	                </div>
	            </div>
	            <h4>Descrição</h4>
		            <div class="input-group">
		                <div class="input-box">
		                    <textarea id="descricao" name="descricao">
		                    </textarea>
		                </div>
		            </div>
	            <div class="input-group">
	                <div class="input-box">
	                    <button type="submit">CADASTRAR EMPRESA</button>
	                </div>
	            </div>
	        </form>
			</div>
	    </div>
	</div>
</section>
<%@include file='../../../footer/footer.jsp'%>