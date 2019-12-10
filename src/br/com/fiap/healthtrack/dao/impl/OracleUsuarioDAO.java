package br.com.fiap.healthtrack.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.healthtrack.beans.Usuario;
import br.com.fiap.healthtrack.dao.UsuarioDAO;
import br.com.fiap.healthtrack.singleton.*;


public class OracleUsuarioDAO implements UsuarioDAO{

	private static final String SELECT_SQL = "SELECT * FROM T_HTK_USUARIO WHERE DS_EMAIL = ? AND SENHA = ?";
	private static final String INSERT_SQL = "INSERT INTO T_HTK_USUARIO (cd_usuario,nm_nome,dt_nascimento,sexo,ds_email,senha) VALUES (SEQ_USUARIO.NEXTVAL, ?, ?, ?, ?, ?)";
	private Connection conexao;
	
	@Override
	public boolean validarUsuario(Usuario usuario) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement(SELECT_SQL);
			pstmt.setString(1, usuario.getEmail());
			pstmt.setString(2, usuario.getSenha());
			rs = pstmt.executeQuery();
			if (rs.next()){
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				rs.close();
				conexao.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public void cadastrarUsuario(Usuario usuario) {
		try(Connection conexao = DbManager.obterConexao();
				PreparedStatement pstmt = conexao.prepareStatement(INSERT_SQL))
		{
			pstmt.setString(1, usuario.getNome());
			pstmt.setDate(2, (Date) usuario.getDataNasc());
			pstmt.setLong(3, usuario.getSexo());
			pstmt.setString(4, usuario.getEmail());
			pstmt.setString(5, usuario.getSenha());
			
			pstmt.executeUpdate();
		}catch(SQLException e) {
			System.err.println("Erro ao tentar cadastrar usuario!");
			e.printStackTrace();
		}
		
	}
}