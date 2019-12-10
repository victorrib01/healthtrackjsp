package br.com.fiap.healthtrack.dao;

import java.util.List;

import br.com.fiap.healthtrack.beans.Alimentacao;

public interface AlimentacaoDAO {
	
	void cadastrarAlimentacao(Alimentacao alimentacao);
	
	void excluirAlimentacao(int idAlimentacao);
	
	public void alterarAlimentacao(Alimentacao alimentacao);
	
	List<Alimentacao> getAllAlimentacao();
	
	Alimentacao getAlimentacaoById(int idAlimentacao);

}
