package br.com.fiap.healthtrack.beans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Atividade implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Usuario usuario;
	private int idAtividade;
	private Calendar dataAtiv;
	private String tipoAtiv;
	private long duracaoAtiv;
	//private long distanciaAtiv;
	private double caloriasAtiv;
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
		return "Peso [codigo= " + idAtividade
				+ " | tipoAtividade= "+ tipoAtiv
				+ " | duracaoAtividade= "+ duracaoAtiv
				+ " | dataCriadoEm= "
				+ sdf.format(dataAtiv.getTime())
				+ "]";
	}
	
	public Atividade() {
		super();
	}
	
	public Atividade(int cdAtividade, String dsAtividade, long tmpAtividade, Calendar dtCriadoEm) {
		// TODO Auto-generated constructor stub
	}
	public Atividade(int cdAtividade, String dsAtividade, long tmpAtividade, java.sql.Date dtCriado,
			java.sql.Date dtAlterado) {
		// TODO Auto-generated constructor stub
	}
	public void cadastrarAtividade() {
		System.out.println("Atividade de " + usuario.getNome() + " foi cadastrada com sucesso!");
	}
	public void alterarAtividade() {
		System.out.println("Atividade de " + usuario.getNome() + " foi alterada com sucesso!");
	}
	public void excluirAtividade() {
		System.out.println("Atividade de " + usuario.getNome() + " foi excluída com sucesso!");
	}
	
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Calendar getDataAtiv() {
		return dataAtiv;
	}
	public void setDataAtiv(Calendar dataAtiv) {
		this.dataAtiv = dataAtiv;
	}
	public String getTipoAtiv() {
		return tipoAtiv;
	}
	public void setTipoAtiv(String tipoAtiv) {
		this.tipoAtiv = tipoAtiv;
	}
	public long getDuracaoAtiv() {
		return duracaoAtiv;
	}
	public void setDuracaoAtiv(long duracaoAtiv) {
		this.duracaoAtiv = duracaoAtiv;
	}
	/*
	public long getDistanciaAtiv() {
		return distanciaAtiv;
	}
	public void setDistanciaAtiv(long distanciaAtiv) {
		this.distanciaAtiv = distanciaAtiv;
	}
	*/
	public double getCaloriasAtiv() {
		return caloriasAtiv;
	}
	public void setCaloriasAtiv(double caloriasAtiv) {
		this.caloriasAtiv = caloriasAtiv;
	}
	public int getIdAtividade() {
		return idAtividade;
	}
	public void setIdAtividade(int idAtividade) {
		this.idAtividade = idAtividade;
	}
}