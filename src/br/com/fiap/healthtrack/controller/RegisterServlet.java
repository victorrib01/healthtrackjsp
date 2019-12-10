package br.com.fiap.healthtrack.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.healthtrack.beans.Usuario;
import br.com.fiap.healthtrack.dao.UsuarioDAO;
import br.com.fiap.healthtrack.factory.DAOFactory;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UsuarioDAO dao;

	public RegisterServlet() {
		dao = DAOFactory.getUsuarioDAO();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		String nome = request.getParameter("nome");
		String dataNascStr = request.getParameter("dataNasc");
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date dataNasc = sdf.parse(dataNascStr);
		String sexo = request.getParameter("sexo");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");

		Usuario usuario = new Usuario(nome,dataNasc,sexo,email,senha);
		
		dao.cadastrarUsuario(usuario);
		
		request.setAttribute("msg", "Usuario cadastrado com sucesso!");
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("erro","Por favor, valide os dados");
		}
		request.getRequestDispatcher("register.jsp").forward(request, response);
	}

}
