package br.com.fiap.healthtrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.healthtrack.beans.Peso;
import br.com.fiap.healthtrack.beans.Usuario;
import br.com.fiap.healthtrack.dao.PesoDAO;
import br.com.fiap.healthtrack.singleton.DbManager;


public class OraclePesoDAO implements PesoDAO {
	
	private static final String INSERT_SQL = "INSERT INTO T_HTK_PESO " + "(CD_PESO,DT_ALTERADO_EM, CD_USUARIO,NR_PESO) "+ "VALUES (SEQ_PESO.NEXTVAL, ?, ?, ?)";
	
	private static final String DELETE_SQL = "DELETE FROM T_HTK_PESO WHERE CD_PESO=?";
	
	private static final String UPDATE_SQL = "UPDATE T_HTK_PESO" + " SET NR_PESO= ?, DT_ALTERADO_EM=?" + " WHERE CD_PESO= ?";
	
	private static final String SELECT_SQL = "SELECT * FROM T_HTK_PESO WHERE CD_USUARIO=?";

	//private static final String SELECTALL_SQL = "SELECT * FROM T_HTK_PESO";

	@Override
	//Cadastra um Peso do Usuario
	public void cadastrar(Peso peso) {
		// INSERT ORACLE
		try (Connection conexao = DbManager.obterConexao();PreparedStatement pstmt = conexao.prepareStatement(INSERT_SQL)) {
			peso.setUsuario(new Usuario());
			peso.getUsuario().setNome("Teste");
			peso.getUsuario().setCd_usuario(1);
			java.sql.Date data = new java.sql.Date(new java.util.Date().getTime()); //peso.getDataPeso().getTimeInMillis()
			pstmt.setDate(1, data);
			pstmt.setLong(2, peso.getUsuario().getCd_usuario());
			pstmt.setDouble(3, peso.getPeso());
			pstmt.executeUpdate();
			System.out.println("Peso de " + peso.getUsuario().getNome() +  " foi cadastrada com sucesso!");
		}catch(SQLException e) {
			System.err.println("Erro ao tentar gravar o peso!");
			e.printStackTrace();
		}
	}


	@Override
	// Exclui um peso do Usuario
	public void excluir(int idPeso) {
		// DELETE ORACLE
		try (Connection conexao = DbManager.obterConexao();PreparedStatement pstmt = conexao.prepareStatement(DELETE_SQL)) {
			pstmt.setInt(1, idPeso);
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Peso de " + idPeso + " foi excluída com sucesso!");
	}


	@Override
	// Altera um peso do Usuario
	public void alterar(Peso peso) {
		// UPDATE ORACLE
		try (Connection conexao = DbManager.obterConexao();PreparedStatement pstmt = conexao.prepareStatement(UPDATE_SQL)) {
			pstmt.setDouble(1, peso.getPeso());
			java.sql.Date data = new java.sql.Date(new java.util.Date().getTime());
			pstmt.setDate(2, data);
			pstmt.setInt(3, peso.getIdPeso());
			pstmt.executeUpdate();
		}catch(SQLException e) {
			System.err.println("Erro ao alterar peso!");
			e.printStackTrace();
		}
		System.out.println("Peso de " + peso.getUsuario().getNome() + " foi alterada com sucesso!");
	}

	@Override
	// GET ALL
	public List<Peso> getAll(){
		List <Peso> pesos = new ArrayList<Peso>();
		try (Connection conexao = DbManager.obterConexao();PreparedStatement pstmt = conexao.prepareStatement(SELECT_SQL); ResultSet rs = pstmt.executeQuery()) {
			while(rs.next()) {
				int cdPeso = rs.getInt("CD_PESO");
				Double nrPeso = rs.getDouble("NR_PESO");
				java.sql.Date data = rs.getDate("DT_CRIADO_EM");
				Calendar dataCriadoEm = Calendar.getInstance();
				dataCriadoEm.setTimeInMillis(data.getTime());
				//Cria um objeto Peso com as informacoes encontradas
				Peso peso = new Peso(dataCriadoEm,nrPeso,cdPeso);
				//Adiciona o peso a lista
				pesos.add(peso);
			}
			} catch(SQLException e) {
				System.err.println("Erro ao buscar todos os registros");
				e.printStackTrace();
			}
		return pesos;
	}

	@Override
	public Peso getById(int idPeso){
		Peso peso = null;
		try (Connection conexao = DbManager.obterConexao();PreparedStatement pstmt = conexao.prepareStatement(SELECT_SQL); ResultSet rs = pstmt.executeQuery()){
			pstmt.setInt(1,idPeso);	
			if(rs.next()) {
				//int cdUsuario = rs.getInt("CD_USUARIO");
				//int cdPeso = rs.getInt("CD_PESO");
				//double nrPeso = rs.getDouble("NR_PESO");
				java.sql.Date data = rs.getDate("DT_CRIADO_EM");
				Calendar dataCriandoEm = Calendar.getInstance();
				dataCriandoEm.setTimeInMillis(data.getTime());
				//peso = new Peso(cdUsuario,cdPeso,nrPeso,dataCriandoEm);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		System.out.println("O ID  do Peso foi recuperado:" + idPeso);
		return peso;
	}


}