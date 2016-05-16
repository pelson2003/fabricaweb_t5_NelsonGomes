package br.com.fabricadeprogramador.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fabricadeprogramador.persistencia.entidade.Usuario;

public class UsuarioDAO {

	private Connection con = ConexaoFactory.getConnection();

	public void salvar(Usuario usu) {
		if (usu.getID() != null && usu.getID() != 0) {
			alterar(usu);
		} else {
			cadastrar(usu);
		}
		
		
	}

	public Usuario autenticar(Usuario usuConsulta) {

		String sql = "select * from usuario where login=? and senha=?";

		try (PreparedStatement preparador = con.prepareStatement(sql)) {

			preparador.setString(1, usuConsulta.getLogin());
			preparador.setString(2, usuConsulta.getSenha());

			ResultSet resultado = preparador.executeQuery();

			if (resultado.next()) {
				Usuario usuario = new Usuario();
				usuario.setID(resultado.getInt("id"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));

				return usuario;
			} else {
				return null;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
		
	}

	/**
	 * Busca de um Registro no banco de dados pelo número do ID do usuário
	 * 
	 * @param (o
	 *            que o parametro faz) - id é um inteiro que representa o número
	 *            do id do usuário a ser buscado
	 * @return )o que ele retorno) - nulo quando não encontra, e um objetivo
	 *         usuário quando encontra
	 */

	public List<Usuario> buscarTodos() {

		String sql = "Select * from usuario";

		List<Usuario> lista = new ArrayList<Usuario>();

		try (PreparedStatement preparador = con.prepareStatement(sql)) {

			ResultSet resultado = preparador.executeQuery();

			// Posicionando Cursos.
			while (resultado.next()) {
				Usuario usuario = new Usuario();
				usuario.setID(resultado.getInt("id"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));

				lista.add(usuario);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (lista.isEmpty()) {
			System.out.println("Sem Registros");
		} else {
			return lista;
		}

		return lista;

	}

	public Usuario buscarporID(Integer id) {

		String sql = "Select * from usuario where id=?";

		try (PreparedStatement preparador = con.prepareStatement(sql)) {

			preparador.setInt(1, id);

			ResultSet resultado = preparador.executeQuery();

			// Posicionando Cursos.
			if (resultado.next()) {
				Usuario usuario = new Usuario();
				usuario.setID(resultado.getInt("id"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));

				return usuario;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	public void cadastrar(Usuario usu) {
		String sql = "insert into usuario (nome, login, senha) values (?, ?, ?)";

		//String sql = "insert into usuario (nome, login, senha) values (?, ?, md5(?))";

		
		try (PreparedStatement preparador = con.prepareStatement(sql)) {
			preparador.setString(1, usu.getNome());
			preparador.setString(2, usu.getLogin());
			preparador.setString(3, usu.getSenha());
			preparador.execute();

			// Ele é autocloseba, entao veja a sintax diferente do try

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void alterar(Usuario usu) {

		String sql = "update usuario set nome=?, login=?, senha=? where id=? ";

		try (PreparedStatement preparador = con.prepareStatement(sql)) {
			preparador.setString(1, usu.getNome());
			preparador.setString(2, usu.getLogin());
			preparador.setString(3, usu.getSenha());
			preparador.setInt(4, usu.getID());
			preparador.execute();

			// Ele é autocloseba, entao veja a sintax diferente do try

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void excluir(Usuario usu) {

		String sql = "delete from usuario where id=? ";

		try (PreparedStatement preparador = con.prepareStatement(sql)) {
			preparador.setInt(1, usu.getID());
			preparador.execute();

			// Ele é autocloseba, entao veja a sintax diferente do try

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
