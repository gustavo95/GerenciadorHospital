package Logica;

public abstract class Paciente extends Usuario {
	
	protected int idade;
	
	public Paciente(String nome, String senha, long identificador, int idade) {
		super(nome, senha, identificador);
		this.idade = idade;
	}

	@Override
	public void menu(Dados banco) {
		System.out.println("login");
		
	}
	
	public int getIdade(){
		return idade;
	}

}
