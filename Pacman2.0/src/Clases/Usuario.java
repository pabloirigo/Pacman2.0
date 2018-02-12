package Clases;

import java.io.Serializable;

public class Usuario  implements Serializable{
	private int puntuacion;
	private String nombre;
	
	public Usuario(int puntuacion, String nombre) {
		this.puntuacion = puntuacion;
		this.nombre = nombre;
	}
	
	public Usuario(){
		
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



}
