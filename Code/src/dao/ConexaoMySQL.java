package dao;
//Sald
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL 
{
	private static Connection con;
	private static String status;

	public ConexaoMySQL() {

	}

	public static void abrirConexao() 
	{
		// Carregando o JDBC Driver padrão
		String driverName = "com.mysql.cj.jdbc.Driver";
		// Faz o registro do driver jdbc
		try 
		{
			Class.forName(driverName);
		} 
		catch (ClassNotFoundException e1) 
		{
			e1.printStackTrace();
			System.out.println("O driver especificado nao foi encontrado.");
		}
		// Configurando a nossa conexão com um banco de dados
		@SuppressWarnings("unused")
		String serverName = "localhost";
		@SuppressWarnings("unused")
		String database = "votacao";
		String url = "jdbc:mysql://localhost:3306/votacao";
		String userName = "root";
		String password = "password";

		try {
			con = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Nao foi possivel conectar ao Banco de Dados.");
		}

		if (con != null) {
			status = "STATUS -----> Conectado com sucesso!";
		} else {
			status = "STATUS -----> Não foi possível realizar a conexão :(";
		}
	}

	public static boolean fecharConexao() {
		try {
			con.close();
			System.out.println("Conexao encerrada!");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public static void obterStatusConexao() {
		System.out.println(status);
	}

	public static Connection getCon() {
		return con;
	}

	public static void setCon(Connection con) {
		ConexaoMySQL.con = con;
	}

	public static void main(String[] args) {
		ConexaoMySQL.abrirConexao();
		ConexaoMySQL.obterStatusConexao();
		ConexaoMySQL.fecharConexao();
	}
}