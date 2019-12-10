package br.com.fiap.healthtrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.healthtrack.beans.Atividade;
import br.com.fiap.healthtrack.dao.AtividadeDAO;
import br.com.fiap.healthtrack.singleton.DbManager;



public class OracleAtividadeDAO implements AtividadeDAO{
	
	private Connection conexao;
	
	//Cadastra uma atividade do Usuario
	@Override
	public void cadastrar(Atividade atividade) {
		// INSERT ORACLE
		PreparedStatement pstmt = null;
		try {
			conexao = DbManager.obterConexao();
			pstmt = conexao.prepareStatement("INSERT INTO T_HTK_ATV_FISICA "
					+ "(CD_ATV_FISICA, CD_USUARIO, DS_ATIVIDADE, TMP_DE_ATIVIDADE)" 
					+ "VALUES (SEQ_ATV_FISICA.NEXTVAL, ?, ?, ?)");
			pstmt.setLong(1, atividade.getUsuario().getCd_usuario());
			pstmt.setString(2, atividade.getTipoAtiv());
			pstmt.setLong(3, atividade.getDuracaoAtiv());
			System.out.println("Atividade de " + atividade.getUsuario().getNome() +  " foi cadastrada com sucesso!");
			//Executa o cadastro
			pstmt.executeUpdate();
		}catch(SQLException e) {
			System.err.println("Erro ao tentar gravar o atividade!");
			e.printStackTrace();
		}finally {
			try {
				conexao.close();
				pstmt.close();
			}catch(SQLException e) {
				System.err.println("Erro ao tentar terminar a gravacao do atividade no banco");
				e.printStackTrace();
			}
		}

	}


	// Exclui uma atividade do Usuario
	@Override
	public void excluir(int idAtividade) {
		PreparedStatement pstmt = null;
		// DELETE ORACLE
		try {
			conexao = DbManager.obterConexao();
			pstmt = conexao.prepareStatement("DELETE FROM T_HTK_ATV_FISICA WHERE CD_ATV_FISICA=?");
			pstmt.setInt(1, idAtividade);
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Atividade de " + idAtividade + " foi excluída com sucesso!");
	}


	// Altera uma atividade do Usuario
	@Override
	public void alterar(Atividade atividade) {
		PreparedStatement pstmt = null;
		// UPDATE ORACLE
		try {
			conexao = DbManager.obterConexao();
			pstmt = conexao.prepareStatement("UPDATE T_HTK_ATV_FISICA" + " SET DS_ATIVIDADE= ?, TMP_DE_ATIVIDADE=?, DT_ALTERADO_EM=?" + " WHERE CD_ATV_FISICA= ?");
			pstmt.setString(1, atividade.getTipoAtiv());
			pstmt.setLong(2, atividade.getDuracaoAtiv());
			java.sql.Date data = new java.sql.Date(new java.util.Date().getTime());
			pstmt.setDate(3, data);
			pstmt.setInt(4, atividade.getIdAtividade());
			pstmt.executeUpdate();
		}catch(SQLException e) {
			System.err.println("Erro ao alterar atividade!");
			e.printStackTrace();
		}
		System.out.println("Atividade de " + atividade.getUsuario().getNome() + " foi alterada com sucesso!");
	}

	// GET ALL
	@Override
	public List<Atividade> getAll(){
		List <Atividade> atividades = new ArrayList<Atividade>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = DbManager.obterConexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_HTK_ATV_FISICA");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				int cdAtividade = rs.getInt("CD_ATV_FISICA");
				String dsAtividade = rs.getString("DS_ATIVIDADE");
				long tmpAtividade = rs.getLong("TMP_DE_ATIVIDADE");
				java.sql.Date dtCriado = rs.getDate("DT_CRIADO_EM");
				Calendar dtCriadoEm = Calendar.getInstance();
				dtCriadoEm.setTimeInMillis(dtCriado.getTime());
				//java.sql.Date dtAlterado = rs.getDate("DT_ALTERADO_EM");
				//Calendar dtAlteradoEm = Calendar.getInstance();
				//dtAlteradoEm.setTimeInMillis(dtAlterado.getTime());
				
				Atividade atividade = new Atividade(cdAtividade, dsAtividade, tmpAtividade, dtCriadoEm);
				//Adiciona o alimento a lista
				atividades.add(atividade);
			}
			} catch(SQLException e) {
				System.err.println("Erro ao buscar todos os registros");
				e.printStackTrace();
			}finally {
				try {
					stmt.close();
					rs.close();
					conexao.close();
				} catch(SQLException e) {
					System.err.println("Erro ao tentar finalizar de buscar todos os registros");
					e.printStackTrace();
				}
			}

		return atividades;
	}
	
	// GET BY ID
	@Override
	public Atividade getById(int idAtividade){
		Atividade atividade = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = DbManager.obterConexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_HTK_ATV_FISICA WHERE CD_USUARIO=?");
			stmt.setInt(1,idAtividade);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				int cdAtividade = rs.getInt("CD_ATV_FISICA");
				String dsAtividade = rs.getString("DS_ATIVIDADE");
				long tmpAtividade = rs.getLong("TMP_DE_ATIVIDADE");
				java.sql.Date dtCriado = rs.getDate("DT_CRIADO_EM");
				java.sql.Date dtAlterado = rs.getDate("DT_ALTERADO_EM");
				Calendar dataCriandoEm = Calendar.getInstance();
				dataCriandoEm.setTimeInMillis(dtCriado.getTime());
				Calendar dtAlteradoEm = Calendar.getInstance();
				dtAlteradoEm.setTimeInMillis(dtAlterado.getTime());
				atividade = new Atividade(cdAtividade,dsAtividade,tmpAtividade,dtCriado,dtAlterado);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("O ID  da atividade foi recuperado: " + idAtividade);
		return atividade;
	}

}
