package br.com.fiap.healthtrack.dao;

import java.util.ArrayList;

import br.com.fiap.healthtrack.beans.PressaoArterial;

public interface PressaoArterialDAO {
	
	void cadastrarPressao(PressaoArterial pressao);
	
	void excluirPressao(int idPressao);
	
	void alterarPressao(PressaoArterial pressao);
	
	ArrayList<PressaoArterial> getAll();
	

	PressaoArterial getPressaoById(PressaoArterial idPressao);

}
