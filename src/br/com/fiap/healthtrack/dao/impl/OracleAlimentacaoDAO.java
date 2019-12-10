package br.com.fiap.healthtrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.healthtrack.beans.Alimentacao;
import br.com.fiap.healthtrack.dao.AlimentacaoDAO;
import br.com.fiap.healthtrack.singleton.DbManager;

public class OracleAlimentacaoDAO implements AlimentacaoDAO{

	private Connection conexao;
	 //Cadastra uma alimentacao do Usuario
	 
	public void cadastrarAlimentacao(Alimentacao alimentacao) {
		PreparedStatement stmt = null;
		// INSERT ORACLE
		try {
			conexao = DbManager.obterConexao();
			stmt = conexao.prepareStatement("INSERT INTO T_HTK_ALIMENTO "
					+ "(CD_ALIMENTO, CD_USUARIO, NM_ALIMENTO, DS_TIPO_ALIMENTO,NR_CALORIAS) "
					+ "VALUES (SEQ_ALIMENTO.NEXTVAL, ?, ?, ?, ?)");
			
			stmt.setLong(1, alimentacao.getUsuario().getCd_usuario()); //Primeiro parametro(cd_usuario)
			stmt.setString(2, alimentacao.getNomeAlimen()); // Segundo parametro(nome alimento)
			stmt.setString(3, alimentacao.getTipoAlimen()); // Terceiro parametro(tipo alimento)
			stmt.setDouble(4, alimentacao.getCaloriasAlimen()); // Quarto parametro (nr calorias)
			stmt.executeUpdate();

		}catch(SQLException e) {
			System.err.println("Erro ao tentar gravar o alimento!");
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conexao.close();
			}catch(SQLException e) {
				System.err.println("Erro ao tentar terminar a gravacao do alimento no banco");
				e.printStackTrace();
			}
		}
		System.out.println("Alimentação de " + alimentacao.getUsuario().getNome() +  " foi cadastrada com sucesso!");
	}
	
	
	 // Exclui uma alimentacao do Usuario
	 
	
	public void excluirAlimentacao(int idAlimentacao) {
		PreparedStatement stmt = null;
		// DELETE ORACLE
		try {
			conexao = DbManager.obterConexao();
			stmt = conexao.prepareStatement("DELETE FROM T_HTK_ALIMENTO WHERE CD_ALIMENTO=?");
			stmt.setInt(1, idAlimentacao);
			stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Alimentação de " + idAlimentacao + " foi excluida com sucesso!");
	}
	
	
	 // Altera uma alimentacao do Usuario
	public void alterarAlimentacao(Alimentacao alimentacao) {
		PreparedStatement stmt = null;
		// UPDATE ORACLE
		try {
			conexao = DbManager.obterConexao();
			stmt = conexao.prepareStatement("UPDATE T_HTK_ALIMENTO" + " SET NM_ALIMENTO= ?, DS_TIPO_ALIMENTO= ?, NR_CALORIAS=?, DT_ALTERADO_EM=?" + " WHERE CD_ALIMENTO= ?");
			stmt.setString(1, alimentacao.getNomeAlimen());
			stmt.setString(2, alimentacao.getTipoAlimen());
			stmt.setDouble(3,alimentacao.getCaloriasAlimen());
			java.sql.Date data = new java.sql.Date(new java.util.Date().getTime());
			stmt.setDate(4,data);
			stmt.setInt(5, alimentacao.getIdAlimentacao());
			stmt.executeUpdate();

		}catch(SQLException e) {
			System.err.println("Erro ao alterar alimento!");
			e.printStackTrace();
		}
		System.out.println("Alimenta\u00e7\u00e3o de " + alimentacao.getUsuario().getNome() + " foi alterada com sucesso!");
	}
	
	// GET ALL
	public List<Alimentacao> getAllAlimentacao(){
		List <Alimentacao> alimentos = new ArrayList<Alimentacao>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = DbManager.obterConexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_HTK_ALIMENTO");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				int cdAlimento = rs.getInt("CD_ALIMENTO");
				Double nrCalorias = rs.getDouble("NR_CALORIAS");
				String nmAlimento = rs.getString("NM_ALIMENTO");
				String tpAlimento = rs.getString("DS_TIPO_ALIMENTO");
				java.sql.Date data = rs.getDate("DT_CRIADO_EM");
				Calendar dataCriadoEm = Calendar.getInstance();
				dataCriadoEm.setTimeInMillis(data.getTime());
				//Cria um objeto Alimento com as informacoes encontradas
				Alimentacao alimento = new Alimentacao(dataCriadoEm,nrCalorias,cdAlimento,nmAlimento,tpAlimento);
				//Adiciona o alimento a lista
				alimentos.add(alimento);
			}
			} catch(SQLException e) {
				System.err.println("Erro ao buscar todos os registros");
				e.printStackTrace();
			}finally {
				try {
					stmt.close();
					rs.close();
					conexao.close();
				}catch(SQLException e) {
					System.err.println("Erro ao tentar finalizar de buscar todos os registros");
					e.printStackTrace();
				}
			}
		return alimentos;
	}
	
	// GET BY ID
	public Alimentacao getAlimentacaoById(int idAlimentacao){
		Alimentacao alimento = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = DbManager.obterConexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_HTK_ALIMENTO WHERE CD_USUARIO=?");
			stmt.setInt(1,idAlimentacao);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				int cdAlimento = rs.getInt("CD_ALIMENTO");
				Double nrCalorias = rs.getDouble("NR_CALORIAS");
				String nmAlimento = rs.getString("NM_ALIMENTO");
				String tpAlimento = rs.getString("DS_TIPO_ALIMENTO");
				java.sql.Date data = rs.getDate("DT_CRIADO_EM");
				Calendar dataCriadoEm = Calendar.getInstance();
				dataCriadoEm.setTimeInMillis(data.getTime());
				alimento = new Alimentacao(cdAlimento,nrCalorias,nmAlimento,tpAlimento,dataCriadoEm);
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
		System.out.println("O ID  da alimentacao foi recuperado");
		return alimento;
	}

}
