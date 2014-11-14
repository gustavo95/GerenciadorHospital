package Logica;

public class Paciente extends Usuario {

	public Paciente(String nome, String senha, long identificador) {
		super(nome, senha, identificador);
	}

	@Override
	public void menu(Dados banco) {
		System.out.println("login");
		
	}

}
