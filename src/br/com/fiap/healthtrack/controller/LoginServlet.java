package br.com.fiap.healthtrack.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.healthtrack.beans.Usuario;
import br.com.fiap.healthtrack.dao.UsuarioDAO;
import br.com.fiap.healthtrack.factory.DAOFactory;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UsuarioDAO dao;
	
    public LoginServlet() {
        dao = DAOFactory.getUsuarioDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		exitSession(request, response);
    }

	private void exitSession(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect(request.getContextPath() +"/index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		userValidation(request, response);
	}

	private void userValidation(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		Usuario usuario = new Usuario(email, senha);
		
		if(dao.validarUsuario(usuario)) {
			HttpSession session = request.getSession();
			session.setAttribute("user", email);
			response.sendRedirect("dashboard.jsp");
		}else {
			request.setAttribute("erro", "Usuario e/ou senha invalidos");
			response.sendRedirect("index.jsp");
		}
	}

}
