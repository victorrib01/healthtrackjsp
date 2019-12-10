package br.com.fiap.healthtrack.dao;

import br.com.fiap.healthtrack.beans.Altura;
import br.com.fiap.healthtrack.exception.DBException;

public interface AlturaDAO {

	void cadastrar(Altura altura) throws DBException;
	void alterar(Altura altura) throws DBException;
	void excluir(int idAltura) throws DBException;
}
