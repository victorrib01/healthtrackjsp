package br.com.fiap.healthtrack.beans;

import java.io.Serializable;
import java.util.Date;

public class PressaoArterial implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Usuario usuario;
	private int idPressao;
	private Date dataPress;
	private double valorSistolica;
	private double valorDiastolica;
	private boolean medicamentos;
	private double pulsacao;
	
	public void cadastroPressao() {
		System.out.println("Pressao de " + usuario.getNome() + " foi inserida com sucesso!");
	}
	
	public void alterarPressao() {
		System.out.println("Pressao de " + usuario.getNome() + " foi inserida com sucesso!");
	}
	
	public void consultarPressao() {
		
	}
	
	public void excluirPressao() {
		
	}
	
	
	
	public Date getDataPress() {
		return dataPress;
	}
	
	public void setDataPress(Date dataPress) {
		this.dataPress = dataPress;
	}
	
	public double getValorSistolica() {
		return valorSistolica;
	}

	public void setValorSistolica(double valorSistolica) {
		this.valorSistolica = valorSistolica;
	}

	public double getValorDiastolica() {
		return valorDiastolica;
	}

	public void setValorDiastolica(double valorDiastolica) {
		this.valorDiastolica = valorDiastolica;
	}

	public boolean isMedicamentos() {
		return medicamentos;
	}
	public void setMedicamentos(boolean medicamentos) {
		this.medicamentos = medicamentos;
	}
	public double getPulsacao() {
		return pulsacao;
	}
	public void setPulsacao(double pulsacao) {
		this.pulsacao = pulsacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public int getIdPressao() {
		return idPressao;
	}

	public void setIdPressao(int idPressao) {
		this.idPressao = idPressao;
	}
	
	

}
