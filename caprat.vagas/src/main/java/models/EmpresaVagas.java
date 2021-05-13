package models;

public class EmpresaVagas {
	private int idVaga;
	private int idEmpresa;
	private String tituloVaga;
	private String requisitosVaga;
	private String descricaoVaga;
	private String localVaga;
	private String salarioVaga;
	private String nivelExpVaga;
	
	public EmpresaVagas() {}
	
	public EmpresaVagas(int idVaga, int idEmpresa, String tituloVaga, String requisitosVaga, String descricaoVaga,
			String localVaga, String salarioVaga, String nivelExpVaga) {
		
		this.idVaga = idVaga;
		this.idEmpresa = idEmpresa;
		this.tituloVaga = tituloVaga;
		this.requisitosVaga = requisitosVaga;
		this.descricaoVaga = descricaoVaga;
		this.localVaga = localVaga;
		this.salarioVaga = salarioVaga;
		this.nivelExpVaga = nivelExpVaga;
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

	public String getLocalVaga() {
		return localVaga;
	}

	public void setLocalVaga(String localVaga) {
		this.localVaga = localVaga;
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
	
	public String getCamposString() {
		return "idVaga, idEmpresa, tituloVaga, requisitosVaga, descricaoVaga, localVaga, salarioVaga, nivelExpVaga";
	}
	
}
