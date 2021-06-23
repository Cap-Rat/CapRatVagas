package models.views;

public class EmpresaInfosVagasView {
	private int idVaga;
	private int idEmpresa;
	private String tituloVaga;
	private String requisitosVaga;
	private String descricaoVaga;
	private String estadoVaga;
	private String cidadeVaga;
	private String enderecoVaga;
	private String salarioVaga;
	private String nivelExpVaga;
	private String nomeEmpresa;
	
	public EmpresaInfosVagasView() {
	}

	public EmpresaInfosVagasView(int idVaga, int idEmpresa, String tituloVaga, String requisitosVaga,
			String descricaoVaga, String estadoVaga, String cidadeVaga, String enderecoVaga, String salarioVaga,
			String nivelExpVaga, String nomeEmpresa) {
		this.idVaga = idVaga;
		this.idEmpresa = idEmpresa;
		this.tituloVaga = tituloVaga;
		this.requisitosVaga = requisitosVaga;
		this.descricaoVaga = descricaoVaga;
		this.estadoVaga = estadoVaga;
		this.cidadeVaga = cidadeVaga;
		this.enderecoVaga = enderecoVaga;
		this.salarioVaga = salarioVaga;
		this.nivelExpVaga = nivelExpVaga;
		this.nomeEmpresa = nomeEmpresa;
	}
	
	public int getIdVaga() {
		return idVaga;
	}
	public void setIdVaga(int idVaga) {
		this.idVaga = idVaga;
	}
	public int getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public String getTituloVaga() {
		return tituloVaga;
	}
	public void setTituloVaga(String tituloVaga) {
		this.tituloVaga = tituloVaga;
	}
	public String getRequisitosVaga() {
		return requisitosVaga;
	}
	public void setRequisitosVaga(String requisitosVaga) {
		this.requisitosVaga = requisitosVaga;
	}
	public String getDescricaoVaga() {
		return descricaoVaga;
	}
	public void setDescricaoVaga(String descricaoVaga) {
		this.descricaoVaga = descricaoVaga;
	}
	public String getEstadoVaga() {
		return estadoVaga;
	}
	public void setEstadoVaga(String estadoVaga) {
		this.estadoVaga = estadoVaga;
	}
	public String getCidadeVaga() {
		return cidadeVaga;
	}
	public void setCidadeVaga(String cidadeVaga) {
		this.cidadeVaga = cidadeVaga;
	}
	public String getEnderecoVaga() {
		return enderecoVaga;
	}
	public void setEnderecoVaga(String enderecoVaga) {
		this.enderecoVaga = enderecoVaga;
	}
	public String getSalarioVaga() {
		return salarioVaga;
	}
	public void setSalarioVaga(String salarioVaga) {
		this.salarioVaga = salarioVaga;
	}
	public String getNivelExpVaga() {
		return nivelExpVaga;
	}
	public void setNivelExpVaga(String nivelExpVaga) {
		this.nivelExpVaga = nivelExpVaga;
	}
	public String getNomeEmpresa() {
		return nomeEmpresa;
	}
	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}
	
	
}
