package services;


import models.UsuarioCurriculo;
import models.UsuarioLogin;
import models.UsuarioVagas;
import database.DBQuery;
import util.ToArrayUtil;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioServices {
	public List<UsuarioCurriculo> getCurriculos(){
		List<UsuarioCurriculo> curriculos = new ArrayList<UsuarioCurriculo>();
		
		ResultSet curriculos_cadastrados = this.iniciarConexao("usuariocurriculo", new UsuarioCurriculo().getCamposString(),  "idCurriculo").
				select("");
		
		try {
			while(curriculos_cadastrados.next()) {
				curriculos.add(this.instanciarCurriculo(curriculos_cadastrados));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return curriculos;
	}
	
	public List<UsuarioVagas> getVagasDoUsuario(){
		List<UsuarioVagas> vagasDosUsuarios = new ArrayList<>();
		
		ResultSet vagas_do_usuario = this.iniciarConexao("usuariovagas", new UsuarioVagas().getCamposString(), "idUsuario, idVaga").
				select("");
		
		try {
			while(vagas_do_usuario.next()) {
				vagasDosUsuarios.add(this.instanciarVagas(vagas_do_usuario));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vagasDosUsuarios;
	}
	
	public List<UsuarioLogin> getLoginUsuarios() {
		List<UsuarioLogin> dadosLoginUsuarios = new ArrayList<>();
		
		ResultSet usuariosCadastrados = this.iniciarConexao("usuariologin", new UsuarioLogin().getCamposString(), "idUsuario").
				select("");
		
		try {
			
			while(usuariosCadastrados.next()) {
				dadosLoginUsuarios.add(this.instanciarLogin(usuariosCadastrados));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dadosLoginUsuarios;
	}
	
	public boolean saveLogin(UsuarioLogin dadosLogin) {
		int success = 0;
		
		if(dadosLogin.getIdUsuario() == 0) {
			success = this.iniciarConexao("usuariologin", new UsuarioLogin().getCamposString(), "idUsuario").
					insert(new ToArrayUtil().toArray(dadosLogin));
		}else {
			success = this.iniciarConexao("usuariologin", new UsuarioLogin().getCamposString(), "idUsuario").
					update(new ToArrayUtil().toArray(dadosLogin));
		}
		
		return success != 0;
	}
	
	public boolean saveCurriculo(UsuarioCurriculo dadosCurriculo){
		int success = 0;
		
		if(dadosCurriculo.getIdCurriculo() == 0) {
			success = this.iniciarConexao("usuariocurriculo", new UsuarioCurriculo().getCamposString(),  "idCurriculo").
					insert(new ToArrayUtil().toArray(dadosCurriculo));
		}else {
			success = this.iniciarConexao("usuariocurriculo", new UsuarioCurriculo().getCamposString(),  "idCurriculo").
					update(new ToArrayUtil().toArray(dadosCurriculo));
		}
		
		return success != 0;
	}
	
	public boolean saveUsuarioVagas(UsuarioVagas dadosUsuarioVaga){
		int success = 0;
		
		if(dadosUsuarioVaga.getIdUsuario() == 0 || dadosUsuarioVaga.getIdVaga() == 0) {
			return false;
		}else {
			success = this.iniciarConexao("usuariovagas", new UsuarioVagas().getCamposString(), "idUsuario, idVaga").
					insert(new ToArrayUtil().toArray(dadosUsuarioVaga));
		}
		
		return success != 0;
	}
	
	private UsuarioCurriculo instanciarCurriculo(ResultSet dadosDoCurriculo) {
		UsuarioCurriculo curriculo = new UsuarioCurriculo();
		
		try {
			curriculo.setContatoUsuario(dadosDoCurriculo.getString("contatoUsuario"));
			curriculo.setCursosUsuario(dadosDoCurriculo.getString("cursosUsuario"));
			curriculo.setDescricaoUsuario(dadosDoCurriculo.getString("descricaoUsuario"));
			curriculo.setEnderecoUsuario(dadosDoCurriculo.getString("enderecoUsuario"));
			curriculo.setEscolaridadeUsuario(dadosDoCurriculo.getString("escolaridadeUsuario"));
			curriculo.setEstadoCivilUsuario(dadosDoCurriculo.getString("estadoCivilUsuario"));
			curriculo.setExpTrabUsuario(dadosDoCurriculo.getString("expTrabUsuario"));
			curriculo.setFaixaSalarialUsuario(dadosDoCurriculo.getString("faixaSalarialUsuario"));
			curriculo.setIdCurriculo(dadosDoCurriculo.getInt("idCurriculo"));
			curriculo.setIdUsuario(dadosDoCurriculo.getInt("idUsuario"));
			curriculo.setNascimentoUsuario(dadosDoCurriculo.getString("nascimentoUsuario"));
			curriculo.setNomeUsuario(dadosDoCurriculo.getString("nomeUsuario"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return curriculo;
	}
	
	private UsuarioVagas instanciarVagas(ResultSet dadosDasVagasDosUsuarios) {
		UsuarioVagas vagasDosUsuarios = new UsuarioVagas();
		
		try {
			vagasDosUsuarios.setIdUsuario(dadosDasVagasDosUsuarios.getInt("idUsuario"));
			vagasDosUsuarios.setIdVaga(dadosDasVagasDosUsuarios.getInt("idVaga"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vagasDosUsuarios;
	}
	
	private UsuarioLogin instanciarLogin(ResultSet dadosDoLoginDoUsuario) {
		UsuarioLogin usuariosCadastrados = new UsuarioLogin();
		
		try {
			usuariosCadastrados.setIdUsuario(dadosDoLoginDoUsuario.getInt("idUsuario"));
			usuariosCadastrados.setApelidoUsuario(dadosDoLoginDoUsuario.getString("apelidoUsuario"));
			usuariosCadastrados.setEmailUsuario(dadosDoLoginDoUsuario.getString("emailUsuario"));
			usuariosCadastrados.setSenhaUsuario(dadosDoLoginDoUsuario.getString("senhaUsuario"));
			usuariosCadastrados.setTipoUsuario(dadosDoLoginDoUsuario.getInt("tipoUsuario"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usuariosCadastrados;
	}
	
	private DBQuery iniciarConexao(String nomeTabela, String campos, String chavePrimaria) {
		return new DBQuery(nomeTabela, campos,  chavePrimaria);
	}
}
