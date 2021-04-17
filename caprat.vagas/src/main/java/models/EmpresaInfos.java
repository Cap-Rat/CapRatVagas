package models;

public class EmpresaInfos {
	private int idEmpresa;
	private int idUsuario;
	private String enderecoEmpresa;
	private String ramoEmpresa;
	private String tamanhoEmpresa;
	private String descricaoEmpresa;
	
	public EmpresaInfos() {}
	
	public EmpresaInfos(int idEmpresa, int idUsuario, String enderecoEmpresa, String ramoEmpresa, String tamanhoEmpresa,
			String descricaoEmpresa) {
		
		this.idEmpresa = idEmpresa;
		this.idUsuario = idUsuario;
		this.enderecoEmpresa = enderecoEmpresa;
		this.ramoEmpresa = ramoEmpresa;
		this.tamanhoEmpresa = tamanhoEmpresa;
		this.descricaoEmpresa = descricaoEmpresa;
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
	public String getEnderecoEmpresa() {
		return enderecoEmpresa;
	}
	public void setEnderecoEmpresa(String enderecoEmpresa) {
		this.enderecoEmpresa = enderecoEmpresa;
	}
	public String getRamoEmpresa() {
		return ramoEmpresa;
	}
	public void setRamoEmpresa(String ramoEmpresa) {
		this.ramoEmpresa = ramoEmpresa;
	}
	public String getTamanhoEmpresa() {
		return tamanhoEmpresa;
	}
	public void setTamanhoEmpresa(String tamanhoEmpresa) {
		this.tamanhoEmpresa = tamanhoEmpresa;
	}
	public String getDescricaoEmpresa() {
		return descricaoEmpresa;
	}
	public void setDescricaoEmpresa(String descricaoEmpresa) {
		this.descricaoEmpresa = descricaoEmpresa;
	}
	
	
}
