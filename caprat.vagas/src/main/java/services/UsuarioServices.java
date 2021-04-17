package services;


import models.UsuarioCurriculo;
import database.DBQuery;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioServices {
	private DBQuery connection = new DBQuery("usuariocurriculo", new UsuarioCurriculo().getCamposString(),  "idCurriculo");
	
	public List<UsuarioCurriculo> getCurriculos(){
		List<UsuarioCurriculo> curriculos = new ArrayList<>();
		
		ResultSet curriculos_cadastrados = connection.select("");
		
		try {
			while(curriculos_cadastrados.next()) {
				curriculos.add(this.instanciarCurriculo(curriculos_cadastrados));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return curriculos;
	}
	
	public boolean saveCurriculo(UsuarioCurriculo dadosCurriculo){
		int success = 0;
		
		if(dadosCurriculo.getIdCurriculo() == 0) {
			success = connection.insert(this.toArray(dadosCurriculo));
		}else {
			success = connection.update(this.toArray(dadosCurriculo));
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
}
