package models;

public class UsuarioTipo {
	private int idTipo;
	private String nomeTipo;
	
	public UsuarioTipo() {}
	
	public UsuarioTipo(int idTipo, String nomeTipo){
		this.idTipo = idTipo;
		this.nomeTipo = nomeTipo;
	}

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public String getNomeTipo() {
		return nomeTipo;
	}

	public void setNomeTipo(String nomeTipo) {
		this.nomeTipo = nomeTipo;
	}
	
	
}
