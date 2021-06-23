package models;

public class EmpresaInfos {
	private int idEmpresa;
	private int idUsuario;
	private String nomeEmpresa;
	private String contatoEmpresa;
	private String enderecoEmpresa;
	private String cidadeEmpresa;
	private String estadoEmpresa;
	private String cepEmpresa;
	private String ramoEmpresa;
	private String descricaoEmpresa;
	
	public EmpresaInfos() {}
	
	public EmpresaInfos(int idEmpresa, int idUsuario, String nomeEmpresa, String contatoEmpresa, String enderecoEmpresa, String cidadeEmpresa, String estadoEmpresa, String cepEmpresa, String ramoEmpresa, String descricaoEmpresa) {
		
		this.idEmpresa = idEmpresa;
		this.idUsuario = idUsuario;
		this.nomeEmpresa = nomeEmpresa;
		this.enderecoEmpresa = enderecoEmpresa;
		this.cidadeEmpresa = cidadeEmpresa;
		this.estadoEmpresa = estadoEmpresa;
		this.cepEmpresa = cepEmpresa;
		this.ramoEmpresa = ramoEmpresa;
		this.descricaoEmpresa = descricaoEmpresa;
		this.contatoEmpresa = contatoEmpresa;
	}
	
	public int getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNomeEmpresa() {
		return nomeEmpresa;
	}
	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}
	public String getContatoEmpresa() {
		return contatoEmpresa;
	}
	public void setContatoEmpresa(String contatoEmpresa) {
		this.contatoEmpresa = contatoEmpresa;
	}
	public String getEnderecoEmpresa() {
		return enderecoEmpresa;
	}
	public void setEnderecoEmpresa(String enderecoEmpresa) {
		this.enderecoEmpresa = enderecoEmpresa;
	}
	public String getCidadeEmpresa() {
		return cidadeEmpresa;
	}
	public void setCidadeEmpresa(String cidadeEmpresa) {
		this.cidadeEmpresa = cidadeEmpresa;
	}
	public String getEstadoEmpresa() {
		return estadoEmpresa;
	}
	public void setEstadoEmpresa(String estadoEmpresa) {
		this.estadoEmpresa = estadoEmpresa;
	}
	public String getCepEmpresa() {
		return cepEmpresa;
	}
	public void setCepEmpresa(String cepEmpresa) {
		this.cepEmpresa = cepEmpresa;
	}
	public String getRamoEmpresa() {
		return ramoEmpresa;
	}
	public void setRamoEmpresa(String ramoEmpresa) {
		this.ramoEmpresa = ramoEmpresa;
	}
	public String getDescricaoEmpresa() {
		return descricaoEmpresa;
	}
	public void setDescricaoEmpresa(String descricaoEmpresa) {
		this.descricaoEmpresa = descricaoEmpresa;
	}
	public String getCamposString() {
		return "idEmpresa, empresainfos.idUsuario, nomeEmpresa, contatoEmpresa, enderecoEmpresa, cidadeEmpresa, estadoEmpresa, cepEmpresa, ramoEmpresa, descricaoEmpresa";
	}
	
	
}
