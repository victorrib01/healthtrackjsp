package br.com.fiap.healthtrack.beans;

import java.io.Serializable;
//import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Classe que abstrai uma Alimentacao
 * @author Victor Ribeiro
 * @version 1.0
 */


public class Alimentacao implements Serializable{

	private static final long serialVersionUID = 1L;
	private Usuario usuario;
	private int idAlimentacao;
	private Calendar dataAlimen;
	private String tipoAlimen;
	private String nomeAlimen;
	private double quantidadeAlimen;
	private double caloriasAlimen;



	public Alimentacao(Calendar dataCriadoEm, Double nrCalorias, int cdAlimento, String nmAlimento, String tpAlimento) {
		// TODO Auto-generated constructor stub
	}
	public Alimentacao(int cdAlimento, Double nrCalorias, String nmAlimento, String tpAlimento, Calendar dataCriandoEm) {
		// TODO Auto-generated constructor stub
	}
	public Alimentacao() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
//		SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
		return "Alimento [codigo= " + idAlimentacao
				+ " | nomeAlimento= "+ nomeAlimen
				+ " | tipoAlimento= " + tipoAlimen
				+ " | quantidadeAlimento= " + quantidadeAlimen
				+ " | caloriaAlimento= " + caloriasAlimen
				//+ "| usuario= "+usuario
//				+ " | dataCriadoEm= "
//				+ sdf.format(dataAlimen.getTime())
				+ "]";
	}

	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Calendar getDataAlimen() {
		return dataAlimen;
	}
	public void setDataAlimen(Calendar dataAlimen) {
		this.dataAlimen = dataAlimen;
	}
	public String getTipoAlimen() {
		return tipoAlimen;
	}
	public void setTipoAlimen(String tipoAlimen) {
		this.tipoAlimen = tipoAlimen;
	}
	public String getNomeAlimen() {
		return nomeAlimen;
	}
	public void setNomeAlimen(String nomeAlimen) {
		this.nomeAlimen = nomeAlimen;
	}
	public double getQuantidadeAlimen() {
		return quantidadeAlimen;
	}
	public void setQuantidadeAlimen(double quantidadeAlimen) {
		this.quantidadeAlimen = quantidadeAlimen;
	}
	public double getCaloriasAlimen() {
		return caloriasAlimen;
	}
	public void setCaloriasAlimen(double caloriasAlimen) {
		this.caloriasAlimen = caloriasAlimen;
	}
	public int getIdAlimentacao() {
		return idAlimentacao;
	}
	public void setIdAlimentacao(int idAlimentacao) {
		this.idAlimentacao = idAlimentacao;
	}
}
