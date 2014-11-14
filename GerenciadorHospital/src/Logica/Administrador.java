package Logica;

public class Administrador extends Usuario{

	public Administrador(String nome, String senha, long identificador) {
		super(nome, senha, identificador);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void menu(Dados banco) {
		System.out.println("login");
	}
	
}
