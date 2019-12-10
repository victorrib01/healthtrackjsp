package br.com.fiap.healthtrack.dao;

import br.com.fiap.healthtrack.beans.Usuario;

public interface UsuarioDAO {

	boolean validarUsuario(Usuario usuario);
	void cadastrarUsuario (Usuario usuario);
}
