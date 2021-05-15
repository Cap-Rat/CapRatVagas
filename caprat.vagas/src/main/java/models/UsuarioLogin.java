package models;

public class UsuarioLogin {
	private int idUsuario;
	private String apelidoUsuario;
	private String emailUsuario;
	private String senhaUsuario;
	private int tipoUsuario;
	
	public UsuarioLogin() {}
	
	public UsuarioLogin(int idUsuario, String emailUsuario, String senhaUsuario, int tipoUsuario) {
		this.idUsuario = idUsuario;
		this.emailUsuario = emailUsuario;
		this.senhaUsuario = senhaUsuario;
		this.tipoUsuario = tipoUsuario;
	}
	
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getEmailUsuario() {
		return emailUsuario;
	}
	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}
	public String getSenhaUsuario() {
		return senhaUsuario;
	}
	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}
	public int getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	public String getApelidoUsuario() {
		return apelidoUsuario;
	}
	public void setApelidoUsuario(String apelidoUsuario) {
		this.apelidoUsuario = apelidoUsuario;
	}
	public String getCamposString() {
		return "idUsuario, apelidoUsuario, emailUsuario, senhaUsuario, tipoUsuario";
	}
	
}
