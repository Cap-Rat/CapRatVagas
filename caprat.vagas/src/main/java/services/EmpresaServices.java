package services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.toArrayUtil;
import database.DBQuery;
import models.EmpresaVagas;

public class EmpresaServices {
	private DBQuery connection = new DBQuery("empresavagas", new EmpresaVagas().getCamposString(),  "idVaga");
	
	
	public List<EmpresaVagas> getVagas(String tituloFiltro, String localFiltro, String expFiltro){
		List<EmpresaVagas> vagas = new ArrayList<>();
		
		if(tituloFiltro == null)
			tituloFiltro = "";
		if(localFiltro == null)
			localFiltro = "";
		if(expFiltro == null)
			expFiltro = "";
		
		ResultSet vagas_cadastradas = connection.select("tituloVaga LIKE '%" + tituloFiltro + "%' && localVaga LIKE '%" + localFiltro + "%' && nivelExpVaga LIKE '%" + expFiltro + "%'");
		
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
			success = connection.insert(new toArrayUtil().toArray(dadosVaga));
		}else {
			success = connection.update(new toArrayUtil().toArray(dadosVaga));
		}
		
		if(success == 0)
			return false;
		else
			return true;
	}
	
	
	private EmpresaVagas instanciarVaga(ResultSet dadosDaVaga) {
		EmpresaVagas vaga = new EmpresaVagas();
		
		try {
			vaga.setDescricaoVaga(dadosDaVaga.getString("descricaoVaga"));
			vaga.setIdEmpresa(dadosDaVaga.getInt("idEmpresa"));
			vaga.setIdVaga(dadosDaVaga.getInt("idVaga"));
			vaga.setEstadoVaga(dadosDaVaga.getString("estadoVaga"));
			vaga.setCidadeVaga(dadosDaVaga.getString("cidadeVaga"));
			vaga.setEnderecoVaga(dadosDaVaga.getString("enderecoVaga"));
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
