package models;

public class UsuarioCurriculo {
	private int idCurriculo;
	private int idUsuario;
	private String nomeUsuario;
	private String nascimentoUsuario;
	private String enderecoUsuario;
	private String estadoCivilUsuario;
	private String escolaridadeUsuario;
	private String descricaoUsuario;
	private String contatoUsuario;
	private String cursosUsuario;
	private String expTrabUsuario;
	private String faixaSalarialUsuario;
	private String camposString = "idCurriculo, idUsuario, nomeUsuario, nascimentoUsuario, enderecoUsuario, estadoCivilUsuario, escolaridadeUsuario, descricaoUsuario, contatoUsuario, cursosUsuario, expTrabUsuario, faixaSalarialUsuario";
	
	public UsuarioCurriculo() {}
	
	public UsuarioCurriculo(int idCurriculo, int idUsuario, String nomeUsuario, String nascimentoUsuario,
			String enderecoUsuario, String estadoCivilUsuario, String escolaridadeUsuario, String descricaoUsuario,
			String contatoUsuario, String cursosUsuario, String expTrabUsuario, String faixaSalarialUsuario) {
		
		this.idCurriculo = idCurriculo;
		this.idUsuario = idUsuario;
		this.nomeUsuario = nomeUsuario;
		this.nascimentoUsuario = nascimentoUsuario;
		this.enderecoUsuario = enderecoUsuario;
		this.estadoCivilUsuario = estadoCivilUsuario;
		this.escolaridadeUsuario = escolaridadeUsuario;
		this.descricaoUsuario = descricaoUsuario;
		this.contatoUsuario = contatoUsuario;
		this.cursosUsuario = cursosUsuario;
		this.expTrabUsuario = expTrabUsuario;
		this.faixaSalarialUsuario = faixaSalarialUsuario;
	}

	public int getIdCurriculo() {
		return idCurriculo;
	}

	public void setIdCurriculo(int idCurriculo) {
		this.idCurriculo = idCurriculo;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getNascimentoUsuario() {
		return nascimentoUsuario;
	}

	public void setNascimentoUsuario(String nascimentoUsuario) {
		this.nascimentoUsuario = nascimentoUsuario;
	}

	public String getEnderecoUsuario() {
		return enderecoUsuario;
	}

	public void setEnderecoUsuario(String enderecoUsuario) {
		this.enderecoUsuario = enderecoUsuario;
	}

	public String getEstadoCivilUsuario() {
		return estadoCivilUsuario;
	}

	public void setEstadoCivilUsuario(String estadoCivilUsuario) {
		this.estadoCivilUsuario = estadoCivilUsuario;
	}

	public String getEscolaridadeUsuario() {
		return escolaridadeUsuario;
	}

	public void setEscolaridadeUsuario(String escolaridadeUsuario) {
		this.escolaridadeUsuario = escolaridadeUsuario;
	}

	public String getDescricaoUsuario() {
		return descricaoUsuario;
	}

	public void setDescricaoUsuario(String descricaoUsuario) {
		this.descricaoUsuario = descricaoUsuario;
	}

	public String getContatoUsuario() {
		return contatoUsuario;
	}

	public void setContatoUsuario(String contatoUsuario) {
		this.contatoUsuario = contatoUsuario;
	}

	public String getCursosUsuario() {
		return cursosUsuario;
	}

	public void setCursosUsuario(String cursosUsuario) {
		this.cursosUsuario = cursosUsuario;
	}

	public String getExpTrabUsuario() {
		return expTrabUsuario;
	}

	public void setExpTrabUsuario(String expTrabUsuario) {
		this.expTrabUsuario = expTrabUsuario;
	}

	public String getFaixaSalarialUsuario() {
		return faixaSalarialUsuario;
	}

	public void setFaixaSalarialUsuario(String faixaSalarialUsuario) {
		this.faixaSalarialUsuario = faixaSalarialUsuario;
	}
	
	public String getCamposString() {
		return camposString;
	}
	
	
}
