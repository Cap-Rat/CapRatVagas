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
	
	public List<EmpresaVagas> getVagas(String tituloFiltro, String localFiltro, String expFiltro){
		List<EmpresaVagas> vagas = new ArrayList<>();
		
		if(tituloFiltro == null)
			tituloFiltro = "";
		if(expFiltro == null)
			expFiltro = "";
		
		ResultSet vagas_cadastradas = this.iniciarConexao("empresavagas", new EmpresaVagas().getCamposString(), "idVaga").
				select("tituloVaga LIKE '%" + tituloFiltro + "%' && nivelExpVaga LIKE '%" + expFiltro + "%'");
		
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
	
	private EmpresaInfos instanciarEmpresa(ResultSet dadosEmpresa) {
		EmpresaInfos empresa = new EmpresaInfos();
		
		try {
			empresa.setIdEmpresa(dadosEmpresa.getInt("idEmpresa"));
			empresa.setIdUsuario(dadosEmpresa.getInt("idUsuario"));
			empresa.setEnderecoEmpresa(dadosEmpresa.getString("enderecoEmpresa"));
			empresa.setCidadeEmpresa(dadosEmpresa.getString("cidadeEmpresa"));
			empresa.setCepEmpresa(dadosEmpresa.getString("cepEmpresa"));
			empresa.setRamoEmpresa(dadosEmpresa.getString("ramoEmpresa"));
			empresa.setTamanhoEmpresa(dadosEmpresa.getString("tamanhoEmpresa"));
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
