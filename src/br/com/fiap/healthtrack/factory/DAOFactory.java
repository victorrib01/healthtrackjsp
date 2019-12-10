package br.com.fiap.healthtrack.factory;

import br.com.fiap.healthtrack.dao.AlturaDAO;
import br.com.fiap.healthtrack.dao.PesoDAO;
import br.com.fiap.healthtrack.dao.UsuarioDAO;
import br.com.fiap.healthtrack.dao.impl.OracleAlturaDAO;
import br.com.fiap.healthtrack.dao.impl.OraclePesoDAO;
import br.com.fiap.healthtrack.dao.impl.OracleUsuarioDAO;

public class DAOFactory {
	
	public static PesoDAO getPesoDAO() {
		return new OraclePesoDAO();
	}
	
	public static UsuarioDAO getUsuarioDAO() {
		return new OracleUsuarioDAO();
	}

	public static AlturaDAO getAlturaDAO() {
		// TODO Auto-generated method stub
		return new OracleAlturaDAO();
	}

}
