package dao;
//sald
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.Candidato;

public class CandidatoDAO 
{
	private Connection con = null;
	
	public CandidatoDAO()
	{
		ConexaoMySQL.abrirConexao();
		con = ConexaoMySQL.getCon();
	}
	
	public boolean save(Candidato candidato)
	{
		String sql = "INSERT INTO Candidato (voto) VALUES (?)";
		
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, Candidato.getVoto());;
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally 
		{
			ConexaoMySQL.fecharConexao();
		}
	}
}