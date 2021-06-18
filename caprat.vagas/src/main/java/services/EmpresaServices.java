package services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DBQuery;
import util.ToArrayUtil;
import models.EmpresaInfos;
import models.EmpresaVagas;
import models.UsuarioVagas;

public class EmpresaServices {
	
	
	public List<EmpresaInfos> getEmpresas(){
		List<EmpresaInfos> dadosDaEmpresa = new ArrayList<>();
		
		ResultSet empresa_logada = this.iniciarConexao("empresainfos", new EmpresaInfos().getCamposString(), "idEmpresa").
				select("");
		
		try {
			while(empresa_logada.next()) {
				dadosDaEmpresa.add(this.instanciarEmpresa(empresa_logada));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dadosDaEmpresa;
	}
	
	public EmpresaInfos getEmpresa(int idUsuarioLogado){
		EmpresaInfos dadosDaEmpresa = new EmpresaInfos();
		
		ResultSet empresa_logada = this.iniciarConexao("empresainfos", new EmpresaInfos().getCamposString(), "idEmpresa").
				select("idUsuario = '" + idUsuarioLogado + "'");
		
		try {
			if(empresa_logada.next()) {
				dadosDaEmpresa = this.instanciarEmpresa(empresa_logada);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dadosDaEmpresa;
	}
	
	public List<EmpresaVagas> getVagas(String idVaga){
		List<EmpresaVagas> vagas = new ArrayList<>();
		
		
		ResultSet vagas_cadastradas = this.iniciarConexao("empresavagas", new EmpresaVagas().getCamposString(), "idVaga").
				select("idVaga = '" + idVaga + "'");
		
		try {
			while(vagas_cadastradas.next()) {
				vagas.add(this.instanciarVaga(vagas_cadastradas));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vagas;
	}
	
	public List<EmpresaVagas> getVagas(String nivelExpFiltro, String regiaoFiltro, String faixaFiltro, String buscaFiltro){
		List<EmpresaVagas> vagas = new ArrayList<>();
		String sql = "";
		
		if(nivelExpFiltro != null)
			sql += "nivelExpVaga = '" + nivelExpFiltro + "' && ";
		
		if(faixaFiltro != null) 
			sql += "salarioVaga " + faixaFiltro + " && ";
		
		if(regiaoFiltro != null)
			sql += "(estadoVaga = '" + regiaoFiltro + "' || cidadeVaga = '" + regiaoFiltro + "') && ";
		
		if(buscaFiltro != null)
			sql += "(tituloVaga LIKE '%" + buscaFiltro + "%' || descricaoVaga LIKE '%" + buscaFiltro + "%' || requisitosVaga LIKE '%" + buscaFiltro + "%') && ";
			
		sql += "1 = 1";
		ResultSet vagas_cadastradas = this.iniciarConexao("empresavagas", new EmpresaVagas().getCamposString(), "idVaga").
				select(sql);
		
		try {
			while(vagas_cadastradas.next()) {
				vagas.add(this.instanciarVaga(vagas_cadastradas));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vagas;
	}
	
	public List<EmpresaVagas> getVagas(EmpresaInfos EmpresaLogada){
		List<EmpresaVagas> vagas = new ArrayList<>();
		
		ResultSet vagas_da_empresa = this.iniciarConexao("empresavagas", new EmpresaVagas().getCamposString(), "idVaga").
				select("idEmpresa = '" + EmpresaLogada.getIdEmpresa() + "'");
		
		try {
			while(vagas_da_empresa.next()) {
				vagas.add(this.instanciarVaga(vagas_da_empresa));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vagas;
	}
	
	public List<EmpresaVagas> getVagas(List<UsuarioVagas> vagasDoUsuario){
		List<EmpresaVagas> vagas = new ArrayList<>();
		
		for(UsuarioVagas uv : vagasDoUsuario) {
			ResultSet vagas_do_usuario = this.iniciarConexao("empresavagas", new EmpresaVagas().getCamposString(), "idVaga").
					select("idVaga = '" + uv.getIdVaga() + "'");
			
			try {
				if(vagas_do_usuario.next()) {
					vagas.add(this.instanciarVaga(vagas_do_usuario));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return vagas;
	}
	
	public boolean saveVaga(EmpresaVagas dadosVaga){
		int success = 0;
		
		if(dadosVaga.getIdVaga() == 0) {
			success = this.iniciarConexao("empresavagas", new EmpresaVagas().getCamposString(), "idVaga").
					insert(new ToArrayUtil().toArray(dadosVaga));
		}else {
			success = this.iniciarConexao("empresavagas", new EmpresaVagas().getCamposString(), "idVaga").
					update(new ToArrayUtil().toArray(dadosVaga));
		}
		
		return success != 0;
	}
	
	public boolean saveEmpresa(EmpresaInfos dadosEmpresa) {
		int success = 0;
		
		if(dadosEmpresa.getIdEmpresa() == 0) {
			success = this.iniciarConexao("empresainfos", new EmpresaInfos().getCamposString(), "idEmpresa").
					insert(new ToArrayUtil().toArray(dadosEmpresa));
		}else {
			success = this.iniciarConexao("empresainfos", new EmpresaInfos().getCamposString(), "idEmpresa").
					update(new ToArrayUtil().toArray(dadosEmpresa));
		}
		
		return success != 0;
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
	
	private EmpresaInfos instanciarEmpresa(ResultSet dadosEmpresa) {
		EmpresaInfos empresa = new EmpresaInfos();
		
		try {
			empresa.setIdEmpresa(dadosEmpresa.getInt("idEmpresa"));
			empresa.setIdUsuario(dadosEmpresa.getInt("idUsuario"));
			empresa.setNomeEmpresa(dadosEmpresa.getString("nomeEmpresa"));
			empresa.setEnderecoEmpresa(dadosEmpresa.getString("enderecoEmpresa"));
			empresa.setCidadeEmpresa(dadosEmpresa.getString("cidadeEmpresa"));
			empresa.setEstadoEmpresa(dadosEmpresa.getString("estadoEmpresa"));
			empresa.setCepEmpresa(dadosEmpresa.getString("cepEmpresa"));
			empresa.setRamoEmpresa(dadosEmpresa.getString("ramoEmpresa"));
			empresa.setDescricaoEmpresa(dadosEmpresa.getString("descricaoEmpresa"));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return empresa;
	}
	
	private DBQuery iniciarConexao(String nomeTabela, String campos, String chavePrimaria) {
		return new DBQuery(nomeTabela, campos,  chavePrimaria);
	}
}
