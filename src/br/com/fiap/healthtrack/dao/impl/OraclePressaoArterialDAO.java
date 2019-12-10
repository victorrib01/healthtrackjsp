package br.com.fiap.healthtrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.healthtrack.beans.PressaoArterial;
import br.com.fiap.healthtrack.dao.PressaoArterialDAO;
import br.com.fiap.healthtrack.singleton.DbManager;

public class OraclePressaoArterialDAO implements PressaoArterialDAO{

	private Connection conexao;

	//Cadastra uma Pressao do Usuario
	@Override
	public void cadastrarPressao(PressaoArterial pressao) {
		// INSERT ORACLE
		PreparedStatement pstmt = null;
		try {
			conexao = DbManager.obterConexao();
			pstmt = conexao.prepareStatement("INSERT INTO T_HTK_PRESS_ARTERIAL "
					+ "(CD_PRESSAO_ARTERIAL, CD_USUARIO, NR_PRESSAO_SIS, NR_PRESSAO_DIA,DT_PRESSAO) "
					+ "VALUES (SEQ_PRESSAO.NEXTVAL, ?, ?, ?, ?)");
			
			pstmt.setObject(1, pressao.getUsuario().getCd_usuario()); //Primeiro parametro(cd_usuario)
			pstmt.setDouble(2, pressao.getValorDiastolica());  
			pstmt.setDouble(3, pressao.getValorSistolica());; //Segundo parametro(nr_peso)
			java.sql.Date data = new java.sql.Date(new java.util.Date().getTime());
			pstmt.setDate(4, data);
			pstmt.executeUpdate();

		}catch(SQLException e) {
			System.err.println("Erro ao tentar gravar a pressao!");
			e.printStackTrace();
		}finally {
			try {
				conexao.close();
				pstmt.close();
			}catch(SQLException e) {
				System.err.println("Erro ao tentar terminar a gravacao da pressao no banco");
				e.printStackTrace();
			}
		}
		
		System.out.println("Pressao de " + pressao.getUsuario().getNome() +  " foi cadastrada com sucesso!");
	}


	// Exclui uma Pressao do Usuario
	@Override
	public void excluirPressao(int idPressao) {
		// UPDATE ORACLE
		System.out.println("Pressao de " + idPressao + " foi alterada com sucesso!");
	}


	// Altera uma Pressao do Usuario
	@Override
	public void alterarPressao(PressaoArterial pressao) {
		// DELETE ORACLE
		System.out.println("Pressao de " + pressao.getUsuario().getNome() + " foi excluída com sucesso!");
	}

	// GET ALL
	@Override
	public ArrayList<PressaoArterial> getAll(){

		return null;
	}

	@Override
	public PressaoArterial getPressaoById(PressaoArterial idPressao) {
		System.out.println("O ID  do Pressao foi recuperado:" + idPressao);
		return null;
	}

}
