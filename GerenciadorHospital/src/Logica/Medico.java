package Logica;

public abstract class Medico extends Usuario{
	
	protected String especialidade;
	
	public Medico(String nome, String senha, long identificador, String especialidade) {
		super(nome, senha, identificador);
		this.especialidade = especialidade;
	}

	@Override
	public void menu(Dados banco) {
		System.out.println("login");
		
	}
	
	public String getEspecialidade() {
		return especialidade;
	}
	

}
