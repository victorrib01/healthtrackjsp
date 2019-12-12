package br.com.fiap.healthtrack.beans;

import java.util.Date;

public abstract class Pessoa {
	
	private String nome;
	private Date dataNasc;
	private String sexo;
	
	public Pessoa() {
	}

	public Pessoa(String nome, Date dataNasc, String sexo) {
		super();
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.sexo = sexo;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if(nome.length() < 2) {
			throw new RuntimeException("Tamanho do nome inválido");
		}
		
		this.nome = nome;
	}
	public Date getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
}
