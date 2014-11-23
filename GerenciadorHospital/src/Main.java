import Gerenciador.Dados;
import UI.JanelaErro;
import UI.JanelaLogin;


public class Main {

	public static void main(String[] args) {
		try{
			new JanelaLogin(new Dados());
		}catch(Exception e){
			new JanelaErro("Erro inesperado");
		}
		
	}
}
