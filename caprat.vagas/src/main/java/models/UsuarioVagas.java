package models;

public class UsuarioVagas {
	private int idUsuario;
	private int idVaga;
	
	public UsuarioVagas() {}
	
	public UsuarioVagas(int idUsuario, int idVaga) {
		super();
		this.idUsuario = idUsuario;
		this.idVaga = idVaga;
	}
	
	public String getCamposString() {
		return "idUsuario, idVaga";
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public int getIdVaga() {
		return idVaga;
	}
	public void setIdVaga(int idVaga) {
		this.idVaga = idVaga;
	}
	
	
}
