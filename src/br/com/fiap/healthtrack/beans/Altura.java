package br.com.fiap.healthtrack.beans;

import java.io.Serializable;
import java.util.Calendar;

public class Altura implements Serializable{

	private static final long serialVersionUID = 1L;
	private Usuario usuario;
	private Calendar dataAltura;
	private float altura;
	private int idAltura;
	
	public Altura(float a, int idAltura) {
		super();
		this.altura = a;
		this.idAltura = idAltura;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Calendar getDataAltura() {
		return dataAltura;
	}
	public void setDataAltura(Calendar dataAltura) {
		this.dataAltura = dataAltura;
	}
	public float getAltura() {
		return altura;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}
	public int getIdAltura() {
		return idAltura;
	}
	public void setIdAltura(int idAltura) {
		this.idAltura = idAltura;
	}
}
