package services;


import models.UsuarioCurriculo;
import database.DBQuery;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioServices {
	
	public List<UsuarioCurriculo> getCurriculos(){
		List<UsuarioCurriculo> curriculos = new ArrayList<>();
		
		DBQuery connection = new DBQuery("usuariocurriculo", "idCurriculo, idUsuario, nomeUsuario, nascimentoUsuario, enderecoUsuario, estadoCivilUsuario, escolaridadeUsuario, descricaoUsuario, contatoUsuario, cursosUsuario, expTrabUsuario, faixaSalarialUsuario",  "idCurriculo");
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
