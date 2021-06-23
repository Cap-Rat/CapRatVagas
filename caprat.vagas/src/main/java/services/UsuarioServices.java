package services;


import models.UsuarioCurriculo;
import models.UsuarioLogin;
import models.UsuarioVagas;
import models.views.UsuarioLoginCurriculoView;
import models.views.UsuarioNomeIdView;
import models.EmpresaInfos;
import util.ToArrayUtil;

import java.util.List;

import database.DBConnection;
import database.DBQuery;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioServices {
	public List<UsuarioLoginCurriculoView> getCurriculos(int userLogged){
		List<UsuarioLoginCurriculoView> curriculos = new ArrayList<>();
		
		ResultSet curriculo_usuario = this.iniciarConexao("usuariocurriculo", new UsuarioCurriculo().getCamposString(),  "idCurriculo").
				selectJoin("SELECT "+ new UsuarioCurriculo().getCamposString() +", emailUsuario, senhaUsuario FROM usuariocurriculo INNER JOIN usuariologin ON usuariocurriculo.idUsuario = usuariologin.idUsuario WHERE	usuariocurriculo.idUsuario = '" + userLogged + "'");
		
		try {
			while(curriculo_usuario.next()) {
				curriculos.add(this.instanciarCurriculo(curriculo_usuario));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return curriculos;
	}
	
	public List<UsuarioVagas> getVagasDoUsuario(int userLogged){
		List<UsuarioVagas> vagasDosUsuarios = new ArrayList<>();
		
		ResultSet vagas_do_usuario = this.iniciarConexao("usuariovagas", new UsuarioVagas().getCamposString(), "idUsuario, idVaga").
				select("idUsuario = '" + userLogged + "'");
		
		try {
			while(vagas_do_usuario.next()) {
				vagasDosUsuarios.add(this.instanciarVagas(vagas_do_usuario));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vagasDosUsuarios;
	}
	
	public UsuarioLogin getLoginUsuarios(int id) {
		UsuarioLogin dadosLoginUsuarios = null;
		
		ResultSet dados_do_usuario = this.iniciarConexao("usuariologin", new UsuarioLogin().getCamposString(), "idUsuario").
				select("idUsuario = '" + id + "'");
		
		try {
			if(dados_do_usuario.next()) {
				dadosLoginUsuarios = this.instanciarLogin(dados_do_usuario);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dadosLoginUsuarios;
	}
	
	public UsuarioLogin getLoginUsuarios(String emailUsuario, String senhaUsuario) {
		UsuarioLogin dadosLoginUsuarios = null;
	
		try {
			DBConnection dbconnection = new DBConnection();

			String loginQuery = "SELECT * FROM usuariologin WHERE emailUsuario = ? AND senhaUsuario = ?";
			PreparedStatement prepStmt = dbconnection.getConnection().prepareStatement(loginQuery);
			prepStmt.setString(1, emailUsuario);
			prepStmt.setString(2, senhaUsuario);
			
			ResultSet usuariosCadastrados = prepStmt.executeQuery();
			
			if(usuariosCadastrados.next()) {
				dadosLoginUsuarios = this.instanciarLogin(usuariosCadastrados);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return dadosLoginUsuarios;
	}
	
	public UsuarioLogin getUsuarioExistente(String emailUsuario, String apelidoUsuario) {
		UsuarioLogin dadosUsuario = new UsuarioLogin();
		
		ResultSet buscandoUsuario = this.iniciarConexao("usuariologin", new UsuarioLogin().getCamposString(), "idUsuario").
				select("emailUsuario = '" + emailUsuario + "' AND apelidoUsuario = '" + apelidoUsuario + "'");
		
		try {
			if(buscandoUsuario.next()) {
				dadosUsuario = this.instanciarLogin(buscandoUsuario);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dadosUsuario;
	}
	
	public List<UsuarioNomeIdView> getCandidatos(int idVaga){
		List<UsuarioNomeIdView> candidatosList = new ArrayList<>();
		
		ResultSet dados_candidatos = this.iniciarConexao("usuariovagas", new UsuarioVagas().getCamposString(), "idUsuario").
				selectJoin("SELECT usuariocurriculo.idUsuario, nomeUsuario from usuariovagas INNER JOIN usuariocurriculo ON usuariocurriculo.idUsuario = usuariovagas.idUsuario where idVaga = '" + idVaga + "'");
		
		try {
			while(dados_candidatos.next()) {
				candidatosList.add(this.instanciarCandidatos(dados_candidatos));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return candidatosList;
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
	
	public boolean isUsuarioCadastrado(int idUsuario, int tipoUsuario) {
		DBQuery conexao = tipoUsuario == 2 ? this.iniciarConexao("empresainfos", new EmpresaInfos().getCamposString(), "idEmpresa") : this.iniciarConexao("usuariocurriculo", new UsuarioCurriculo().getCamposString(), "idCurriculo");
		
		ResultSet rs = conexao.select("idUsuario = '" + idUsuario + "'");
		
		try {
			return rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	private UsuarioLoginCurriculoView instanciarCurriculo(ResultSet dadosDoCurriculo) {
		UsuarioLoginCurriculoView curriculo = new UsuarioLoginCurriculoView();
		
		try {
			curriculo.setContatoUsuario(dadosDoCurriculo.getString("contatoUsuario"));
			curriculo.setCursosUsuario(dadosDoCurriculo.getString("cursosUsuario"));
			curriculo.setEmailUsuario(dadosDoCurriculo.getString("emailUsuario"));
			curriculo.setSenhaUsuario(dadosDoCurriculo.getString("senhaUsuario"));
			curriculo.setEnderecoUsuario(dadosDoCurriculo.getString("enderecoUsuario"));
			curriculo.setEstadoUsuario(dadosDoCurriculo.getString("estadoUsuario"));
			curriculo.setCidadeUsuario(dadosDoCurriculo.getString("cidadeUsuario"));
			curriculo.setEscolaridadeUsuario(dadosDoCurriculo.getString("escolaridadeUsuario"));
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
	
	private UsuarioNomeIdView instanciarCandidatos(ResultSet dadosDosCandidatos) {
		UsuarioNomeIdView candidatosDaVaga = new UsuarioNomeIdView();
		
		try {
			candidatosDaVaga.setIdUsuario(dadosDosCandidatos.getInt("idUsuario"));
			candidatosDaVaga.setNomeUsuario(dadosDosCandidatos.getString("nomeUsuario"));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return candidatosDaVaga;
	}
	
	private DBQuery iniciarConexao(String nomeTabela, String campos, String chavePrimaria) {
		return new DBQuery(nomeTabela, campos,  chavePrimaria);
	}
}
