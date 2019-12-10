package br.com.fiap.healthtrack.dao;

import java.util.List;

import br.com.fiap.healthtrack.beans.Atividade;

public interface AtividadeDAO {

	void cadastrar(Atividade atividade);
	
	void excluir(int idAtividade);
	
	void alterar(Atividade atividade);
	
	List<Atividade> getAll();
	
	Atividade getById(int idAtividade);
	
}
