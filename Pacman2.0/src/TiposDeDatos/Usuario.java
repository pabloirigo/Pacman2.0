package TiposDeDatos;

import java.io.Serializable;

public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String nombreUsuario;
	private String contrasenia;
	
	public Usuario(String nombreUsuario, String contrasenia) {
		this.nombreUsuario = nombreUsuario;
		this.contrasenia = contrasenia;
	}
	
	public Usuario(){
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	@Override
	public String toString() {
		return "Usuario [nombreUsuario=" + nombreUsuario + ", contrasenia=" + contrasenia + "]";
	}
	
}
