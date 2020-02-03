package br.com.fiap.healthtrack.beans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Peso implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Usuario usuario;
	private Calendar dataPeso;
	private double peso;
	private int idPeso;
	
	
	/*
	public void cadastrarPeso() {
		System.out.println("Peso de " + usuario.getNome() + " foi cadastrado com sucesso!");
	}
	public void alterarPeso() {
		System.out.println("Peso de " + usuario.getNome() + " foi alterado com sucesso!");
	}
	public void excluirPeso() {
		System.out.println("Peso de" + usuario.getNome() + " foi excluído com sucesso!");
	}
	*/
	
	public Peso(double peso, Usuario user) {
		super();
		this.peso = peso;
		this.usuario = user;
	}
	
	public Peso(double peso, int idPeso) {
		super();
		this.peso = peso;
		this.idPeso = idPeso;
	}
	
	public Peso(Calendar dataPeso, double peso, int idPeso) {
		super();
		this.dataPeso = dataPeso;
		this.peso = peso;
		this.idPeso = idPeso;
	}
	
	public Peso(Usuario usuario, Calendar dataPeso, double peso, int idPeso) {
		super();
		this.usuario = usuario;
		this.dataPeso = dataPeso;
		this.peso = peso;
		this.idPeso = idPeso;
	}

	public Peso() {}
	
	public Peso(Double p, Object user) {
		// TODO Auto-generated constructor stub
	}

	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Calendar getDataPeso() {
		return dataPeso;
	}
	public void setDataPeso(Calendar dataPeso) {
		this.dataPeso = dataPeso;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
		return "Peso [codigo= " + idPeso
				+ " | peso= "+ peso
				//+ "| usuario= "+usuario
				+ " | dataCriadoEm= "
				+ sdf.format(dataPeso.getTime())
				+ "]";
	}
	public int getIdPeso() {
		return idPeso;
	}
	public void setIdPeso(int idPeso) {
		this.idPeso = idPeso;
	}

}
