package services;


import models.UsuarioCurriculo;
import models.UsuarioVagas;
import database.DBQuery;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioServices {
	private DBQuery connectionUsuarioCurriculo = new DBQuery("usuariocurriculo", new UsuarioCurriculo().getCamposString(),  "idCurriculo");
	private DBQuery connectionUsuarioVagas = new DBQuery("usuariovagas", new UsuarioVagas().getCamposString(), "idUsuario, idVaga");
	
	public List<UsuarioCurriculo> getCurriculos(){
		List<UsuarioCurriculo> curriculos = new ArrayList<>();
		
		ResultSet curriculos_cadastrados = connectionUsuarioCurriculo.select("");
		
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
		
		ResultSet vagas_do_usuario = connectionUsuarioVagas.select("");
		
		try {
			while(vagas_do_usuario.next()) {
				vagasDosUsuarios.add(this.instanciarVagas(vagas_do_usuario));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vagasDosUsuarios;
	}
	
	public boolean saveCurriculo(UsuarioCurriculo dadosCurriculo){
		int success = 0;
		
		if(dadosCurriculo.getIdCurriculo() == 0) {
			success = connectionUsuarioCurriculo.insert(this.toArray(dadosCurriculo));
		}else {
			success = connectionUsuarioCurriculo.update(this.toArray(dadosCurriculo));
		}
		
		if(success == 0)
			return false;
		else
			return true;
	}
	
	public boolean saveUsuarioVagas(UsuarioVagas dadosUsuarioVaga){
		int success = 0;
		
		if(dadosUsuarioVaga.getIdUsuario() == 0 || dadosUsuarioVaga.getIdVaga() == 0) {
			return false;
		}else {
			success = connectionUsuarioVagas.insert(this.toArray(dadosUsuarioVaga));
		}
		
		if(success == 0)
			return false;
		else
			return true;
	}
	
	private String[] toArray(UsuarioCurriculo curriculo) {
		return (
				new String[] {
						""+curriculo.getIdCurriculo(),
						""+curriculo.getIdUsuario(),
						""+curriculo.getNomeUsuario(),
						""+curriculo.getNascimentoUsuario(),
						""+curriculo.getEnderecoUsuario(),
						""+curriculo.getCidadeUsuario(),
						""+curriculo.getEstadoUsuario(),
						""+curriculo.getEstadoCivilUsuario(),
						""+curriculo.getEscolaridadeUsuario(),
						""+curriculo.getDescricaoUsuario(),
						""+curriculo.getContatoUsuario(),
						""+curriculo.getCursosUsuario(),
						""+curriculo.getExpTrabUsuario(),
						""+curriculo.getFaixaSalarialUsuario()
				}
		); 
	}
	
	private String[] toArray(UsuarioVagas vagasDoUsuario) {
		return (
				new String[] {
					""+vagasDoUsuario.getIdUsuario(),
					""+vagasDoUsuario.getIdVaga()
				}
 			);
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
}
