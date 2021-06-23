package services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DBQuery;
import util.ToArrayUtil;
import models.EmpresaInfos;
import models.EmpresaVagas;
import models.UsuarioCurriculo;
import models.UsuarioVagas;
import models.views.EmpresaInfosVagasView;
import models.views.EmpresaLoginInfosView;

public class EmpresaServices {
	
	
	public List<EmpresaLoginInfosView> getEmpresas(int userLogged){
		List<EmpresaLoginInfosView> dadosDaEmpresa = new ArrayList<>();
		
		ResultSet dados_empresa = this.iniciarConexao("empresainfos", new EmpresaInfos().getCamposString(),  "idEmpresa").
				selectJoin("SELECT "+ new EmpresaInfos().getCamposString() +", emailUsuario, senhaUsuario FROM empresainfos INNER JOIN usuariologin ON empresainfos.idUsuario = usuariologin.idUsuario WHERE empresainfos.idUsuario = '" + userLogged + "'");
		
		try {
			while(dados_empresa.next()) {
				dadosDaEmpresa.add(this.instanciarEmpresaLogin(dados_empresa));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dadosDaEmpresa;
	}
	
	public List<EmpresaLoginInfosView> getEmpresas(String idEmpresa){
		List<EmpresaLoginInfosView> dadosDaEmpresa = new ArrayList<>();
		
		ResultSet dados_empresa = this.iniciarConexao("empresainfos", new EmpresaInfos().getCamposString(),  "idEmpresa").
				selectJoin("SELECT "+ new EmpresaInfos().getCamposString() +", emailUsuario, senhaUsuario FROM empresainfos INNER JOIN usuariologin ON empresainfos.idUsuario = usuariologin.idUsuario WHERE empresainfos.idEmpresa = '" + idEmpresa + "'");
		
		try {
			while(dados_empresa.next()) {
				dadosDaEmpresa.add(this.instanciarEmpresaLogin(dados_empresa));
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
	
	public EmpresaInfosVagasView getVagasInfos(String idVaga){
		EmpresaInfosVagasView vagas = new EmpresaInfosVagasView();
		
		
		ResultSet vaga_da_empresa = this.iniciarConexao("empresavagas", new EmpresaVagas().getCamposString(),  "idVaga").
				selectJoin("SELECT "+ new EmpresaVagas().getCamposString() +", nomeEmpresa FROM empresavagas INNER JOIN empresainfos ON empresainfos.idEmpresa = empresavagas.idEmpresa WHERE empresavagas.idVaga = '" + idVaga + "'");
		
		try {
			if(vaga_da_empresa.next()) {
				vagas = this.instanciarVagaInfos(vaga_da_empresa);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vagas;
	}
	
	public EmpresaVagas getVagas(String idVaga) {
		EmpresaVagas vaga = new EmpresaVagas();
		
		ResultSet dados_da_vaga = this.iniciarConexao("empresavagas", new EmpresaVagas().getCamposString(), "idVaga").
				select("idVaga = '" + idVaga + "'");
		
		try {
			if(dados_da_vaga.next()) {
				vaga = this.instanciarVaga(dados_da_vaga);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vaga;
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
	
	public List<EmpresaInfosVagasView> getVagas(List<UsuarioVagas> vagasDoUsuario){
		List<EmpresaInfosVagasView> vagas = new ArrayList<>();
		
		for(UsuarioVagas uv : vagasDoUsuario) {
			ResultSet vagas_do_usuario = this.iniciarConexao("empresavagas", new EmpresaVagas().getCamposString(),  "idVaga").
					selectJoin("SELECT "+ new EmpresaVagas().getCamposString() +", nomeEmpresa FROM empresavagas INNER JOIN empresainfos ON empresainfos.idEmpresa = empresavagas.idEmpresa WHERE empresavagas.idVaga = '" + uv.getIdVaga() + "'");
			
			try {
				if(vagas_do_usuario.next()) {
					vagas.add(this.instanciarVagaInfos(vagas_do_usuario));
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
	
	public boolean deleteVaga(EmpresaVagas vagaApagada, EmpresaInfos empresaLogada) {
		int success = 0;
		
		if(vagaApagada.getIdEmpresa() == empresaLogada.getIdEmpresa()) {
			success = this.iniciarConexao("empresavagas", new EmpresaVagas().getCamposString(), "idVaga").
				delete(new ToArrayUtil().toArray(vagaApagada));
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
	
	private EmpresaInfosVagasView instanciarVagaInfos(ResultSet dadosDaVaga) {
		EmpresaInfosVagasView vaga = new EmpresaInfosVagasView();
		
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
			vaga.setNomeEmpresa(dadosDaVaga.getString("nomeEmpresa"));
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
			empresa.setContatoEmpresa(dadosEmpresa.getString("contatoEmpresa"));
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
	
	private EmpresaLoginInfosView instanciarEmpresaLogin(ResultSet dadosEmpresa) {
		EmpresaLoginInfosView empresa = new EmpresaLoginInfosView();
		
		try {
			empresa.setIdEmpresa(dadosEmpresa.getInt("idEmpresa"));
			empresa.setIdUsuario(dadosEmpresa.getInt("idUsuario"));
			empresa.setNomeEmpresa(dadosEmpresa.getString("nomeEmpresa"));
			empresa.setContatoEmpresa(dadosEmpresa.getString("contatoEmpresa"));
			empresa.setEnderecoEmpresa(dadosEmpresa.getString("enderecoEmpresa"));
			empresa.setCidadeEmpresa(dadosEmpresa.getString("cidadeEmpresa"));
			empresa.setEstadoEmpresa(dadosEmpresa.getString("estadoEmpresa"));
			empresa.setCepEmpresa(dadosEmpresa.getString("cepEmpresa"));
			empresa.setRamoEmpresa(dadosEmpresa.getString("ramoEmpresa"));
			empresa.setDescricaoEmpresa(dadosEmpresa.getString("descricaoEmpresa"));
			empresa.setEmailUsuario(dadosEmpresa.getString("emailUsuario"));
			empresa.setSenhaUsuario(dadosEmpresa.getString("senhaUsuario"));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return empresa;
	}
	
	private DBQuery iniciarConexao(String nomeTabela, String campos, String chavePrimaria) {
		return new DBQuery(nomeTabela, campos,  chavePrimaria);
	}
}
