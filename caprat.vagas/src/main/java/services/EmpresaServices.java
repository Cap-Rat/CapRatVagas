package services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DBQuery;
import models.EmpresaVagas;

public class EmpresaServices {
	private DBQuery connection = new DBQuery("empresavagas", new EmpresaVagas().getCamposString(),  "idVaga");
	
	
	public List<EmpresaVagas> getVagas(){
		List<EmpresaVagas> vagas = new ArrayList<>();
		
		ResultSet vagas_cadastradas = connection.select("");
		
		try {
			while(vagas_cadastradas.next()) {
				vagas.add(this.instanciarVaga(vagas_cadastradas));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vagas;
	}
	
	public boolean saveVaga(EmpresaVagas dadosVaga){
		int success = 0;
		
		if(dadosVaga.getIdVaga() == 0) {
			success = connection.insert(this.toArray(dadosVaga));
		}else {
			success = connection.update(this.toArray(dadosVaga));
		}
		
		if(success == 0)
			return false;
		else
			return true;
	}
	
	private String[] toArray(EmpresaVagas vaga) {
		return(
				new String [] {
						""+vaga.getIdVaga(),
						""+vaga.getIdEmpresa(),
						""+vaga.getTituloVaga(),
						""+vaga.getRequisitosVaga(),
						""+vaga.getDescricaoVaga(),
						""+vaga.getLocalVaga(),
						""+vaga.getSalarioVaga(),
						""+vaga.getNivelExpVaga()
				}
			);
	}
	
	
	private EmpresaVagas instanciarVaga(ResultSet dadosDaVaga) {
		EmpresaVagas vaga = new EmpresaVagas();
		
		try {
			vaga.setDescricaoVaga(dadosDaVaga.getString("descricaoVaga"));
			vaga.setIdEmpresa(dadosDaVaga.getInt("idEmpresa"));
			vaga.setIdVaga(dadosDaVaga.getInt("idVaga"));
			vaga.setLocalVaga(dadosDaVaga.getString("localVaga"));
			vaga.setNivelExpVaga(dadosDaVaga.getString("nivelExpVaga"));
			vaga.setRequisitosVaga(dadosDaVaga.getString("requisitosVaga"));
			vaga.setSalarioVaga(dadosDaVaga.getString("salarioVaga"));
			vaga.setTituloVaga(dadosDaVaga.getString("tituloVaga"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vaga;
	}
}
