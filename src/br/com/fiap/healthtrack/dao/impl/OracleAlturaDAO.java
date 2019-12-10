package br.com.fiap.healthtrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fiap.healthtrack.beans.Altura;
import br.com.fiap.healthtrack.beans.Usuario;
import br.com.fiap.healthtrack.dao.AlturaDAO;
import br.com.fiap.healthtrack.exception.DBException;
import br.com.fiap.healthtrack.singleton.DbManager;

public class OracleAlturaDAO implements AlturaDAO{

	private static final String INSERT_SQL="INSERT INTO T_HTK_ALTURA (CD_ALTURA,CD_USUARIO,NR_ALTURA,DT_ALTERADO_EM) VALUES (SEQ_ALTURA.NEXTVAL,?,?,?)";
	
	@Override
	public void cadastrar(Altura altura) throws DBException {
		try(Connection conexao = DbManager.obterConexao();PreparedStatement pstmt = conexao.prepareStatement(INSERT_SQL)){
			altura.setUsuario(new Usuario());
			altura.getUsuario().setNome("Teste");
			altura.getUsuario().setCd_usuario(1);
			java.sql.Date data = new java.sql.Date(new java.util.Date().getTime());
			pstmt.setLong(1, altura.getUsuario().getCd_usuario());
			pstmt.setFloat(2, altura.getAltura());
			pstmt.setDate(3, data);
			pstmt.executeUpdate();
			System.out.println("Altura de " + altura.getUsuario().getNome() + " foi cadastrada com sucesso!");
		}catch(SQLException e) {
			System.err.println("Erro ao tentar gravar a altura!");
			e.printStackTrace();
		}
	}
		

	@Override
	public void alterar(Altura altura) throws DBException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(int idAltura) throws DBException {
		// TODO Auto-generated method stub
		
	}



}
