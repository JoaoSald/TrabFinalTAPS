package controle;
//sald
import visao.JanelaPrincipal;
import modelo.Candidato;

public class ProgramaPrincipal 
{
public static void main(String[] args) {
		
		JanelaPrincipal janelaPrincipal = new JanelaPrincipal();
		janelaPrincipal.setVisible(true);
		
		@SuppressWarnings("unused")
		Candidato candidato = new Candidato();
		
	}
}
