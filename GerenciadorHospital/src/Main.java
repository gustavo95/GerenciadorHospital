import Logica.Dados;
import UI.JanelaLogin;
import UI.SelecionarUsuario;


public class Main {

	public static void main(String[] args) {
		Dados bancoDados  = new Dados();
		new JanelaLogin(bancoDados);
		new SelecionarUsuario(bancoDados);
	}

}
