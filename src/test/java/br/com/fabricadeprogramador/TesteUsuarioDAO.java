
package br.com.fabricadeprogramador;

import java.util.List;

import br.com.fabricadeprogramador.persistencia.entidade.Usuario;
import br.com.fabricadeprogramador.persistencia.jdbc.UsuarioDAO;

public class TesteUsuarioDAO {

	public static void main(String[] args) {
//		testCadastrar();
//		testAlterar();
//		testExcluir();
//		testSalvar();
//		testBuscarporID();
//		testBuscarTodos();
		testautenticar();
		
	}

	public static void testautenticar(){
		UsuarioDAO usuDAO = new UsuarioDAO();
		
		Usuario usu = new Usuario();
		usu.setLogin("jj");
		usu.setSenha("123");
		
		Usuario usuretorno = usuDAO.autenticar(usu);
		
		System.out.println(usuretorno);
		
	}
	
	public static void testBuscarTodos(){
		
		UsuarioDAO usuDAO = new UsuarioDAO();
		List<Usuario> resultado = usuDAO.buscarTodos();

		for(Usuario usu: resultado){
			System.out.println(usu);
			
			
		}
	}
	
	public static void testBuscarporID(){
		
		UsuarioDAO usuDAO = new UsuarioDAO();
		Usuario usu = usuDAO.buscarporID(1);

		System.out.println(usu);
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

	
	public static void testSalvar(){
		Usuario usu = new Usuario();
		usu.setID(2);
		usu.setNome("Maria de Souza");
		usu.setLogin("mar");
		usu.setSenha("123");
		
		// Cadastrando usuario no banco de dados.
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.salvar(usu);

		System.out.println("Salvo");
		
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
