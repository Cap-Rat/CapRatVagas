package models.views;

public class UsuarioNomeIdView {
	private int idUsuario;
	private String nomeUsuario;
	
	
	public UsuarioNomeIdView() {
	}
	
	public UsuarioNomeIdView(int idUsuario, String nomeUsuario) {
		this.idUsuario = idUsuario;
		this.nomeUsuario = nomeUsuario;
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
	
	
}
