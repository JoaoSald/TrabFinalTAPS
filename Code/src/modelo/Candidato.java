package modelo;
//sald
public class Candidato 
{
	private int id;
	private static String voto;
		
	public Candidato() 
	{
		super();
	}

	public Candidato(String voto) 
	{
		super();
		Candidato.voto = voto;
	}

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public static String getVoto() 
	{
		return voto;
	}

	public void setVoto(String voto) 
	{
		Candidato.voto = voto;
	}	
}