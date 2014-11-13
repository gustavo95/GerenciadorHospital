import UI.JanelaErro;
import UI.JanelaLogin;


public class Main {

	public static void main(String[] args) {
		JanelaLogin login = new JanelaLogin();
		login.login();
		
		JanelaErro erro = new JanelaErro();
		erro.erro("erro");

	}

}
