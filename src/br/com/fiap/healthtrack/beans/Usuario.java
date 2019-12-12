package br.com.fiap.healthtrack.beans;

import java.util.Date;

import br.com.fiap.healthtrack.util.CriptografiaUtils;

public class Usuario extends Pessoa implements Autenticavel {
	
		private long cd_usuario;
		private String email;
		private Date dtUltimoAcess;
		private String login;
		private String senha;
		
		public Usuario(String email, String senha) {
			super();
			this.email = email;
			setSenha(senha);
		}
		
		public Usuario() {
			super();
		}
		
		public Usuario(String nome, Date dataNasc, String sexo, String email, String senha) {
			super(nome, dataNasc, sexo);
			this.email = email;
			setSenha(senha);
		}

		public long getCd_usuario() {
			return cd_usuario;
		}
		public void setCd_usuario(long cd_usuario) {
			this.cd_usuario = cd_usuario;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public Date getDtUltimoAcess() {
			return dtUltimoAcess;
		}
		public void setDtUltimoAcess(Date dtUltimoAcess) {
			this.dtUltimoAcess = dtUltimoAcess;
		}
		public String getLogin() {
			return login;
		}
		public void setLogin(String login) {
			this.login = login;
		}
		public String getSenha() {
			return senha;
		}
		public void setSenha(String senha) {
			try {
				this.senha = CriptografiaUtils.criptografar(senha);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

		@Override
		public boolean login(String usuario, String senha) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void logou() {
			// TODO Auto-generated method stub
			
		}
		
		
		
		
	}
