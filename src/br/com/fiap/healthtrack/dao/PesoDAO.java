package br.com.fiap.healthtrack.dao;

import java.util.List;

import br.com.fiap.healthtrack.beans.Peso;
import br.com.fiap.healthtrack.exception.DBException;


public interface PesoDAO {

	void cadastrar(Peso peso) throws DBException;

	void alterar(Peso peso) throws DBException;

	void excluir(int idPeso) throws DBException;

	List<Peso> getAll();

	Peso getById(int idPeso);


}
