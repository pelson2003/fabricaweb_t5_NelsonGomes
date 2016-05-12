package br.com.fabricadeprogramador;

import br.com.fabricadeprogramador.persistencia.entidade.Usuario;
import br.com.fabricadeprogramador.persistencia.jdbc.UsuarioDAO;

public class TesteUsuarioDAO {

	public static void main(String[] args) {
//		testCadastrar();
//		testAlterar();
		testExcluir();
	}

	
	public static void testAlterar() {

		// Criando Usuario
		Usuario usu = new Usuario();
		usu.setID(4);
		usu.setNome("NewJaozao");
		usu.setLogin("jzao");
		usu.setSenha("123");

		// Cadastrando usuario no banco de dados.
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.alterar(usu);

		System.out.println("sucessso");

	}
	
	public static void testCadastrar() {

		// Criando Usuario
		Usuario usu = new Usuario();
		usu.setNome("Jaozao");
		usu.setLogin("jzao");
		usu.setSenha("123");

		// Cadastrando usuario no banco de dados.
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.cadastrar(usu);

		System.out.println("sucessso");

	}

	
	public static void testExcluir() {

		// Criando Usuario
		Usuario usu = new Usuario();
		usu.setID(4);

		// Cadastrando usuario no banco de dados.
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.excluir(usu);

		System.out.println("Excluido com sucesso");

	}
	
	
}
