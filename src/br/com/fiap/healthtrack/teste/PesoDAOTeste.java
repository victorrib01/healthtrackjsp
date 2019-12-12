package br.com.fiap.healthtrack.teste;

import java.util.List;

//import java.util.Calendar;
//import java.util.List;

import br.com.fiap.healthtrack.beans.Peso;
import br.com.fiap.healthtrack.beans.Usuario;
import br.com.fiap.healthtrack.dao.PesoDAO;
import br.com.fiap.healthtrack.exception.DBException;
import br.com.fiap.healthtrack.factory.DAOFactory;

public class PesoDAOTeste {
	public static void main(String[] args) {
		PesoDAO dao = DAOFactory.getPesoDAO();

				//Cria e instancia o Peso
				Peso peso = new Peso();
				Usuario usuario = new Usuario();

				try {
					usuario.setNome("Victor Ribeiro");
				} catch (Exception e) {
					e.printStackTrace();
				}
				usuario.setCd_usuario(1);
				peso.setPeso(52.45);
				peso.setIdPeso(63);
				peso.setUsuario(usuario);

				//Cadastra o peso no banco de dados
				try {
					dao.cadastrar(peso);
				} catch (DBException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
		//Buscar um produto pelo código e atualizar
//				peso = dao.getById(654);
//				
//				peso.setPeso(64);
//				try {
//					dao.alterar(peso);
//					System.out.println("Produto atualizado");
//				} catch (DBException e) {
//					e.printStackTrace();
//				}
//				
				//Listar os Produtos
				List<Peso> lista = dao.getAll();
				for(Peso item : lista) {
					System.out.println(item.getPeso() + " " + item.getIdPeso() + " " + item.getDataPeso() + " " + item.getUsuario());
				}
				
				//Remover um produto
//				try {
//					dao.excluir(654);
//					System.out.println("Produto removido.");
//				} catch(DBException e) {
//					e.printStackTrace();
//				}
	}

}