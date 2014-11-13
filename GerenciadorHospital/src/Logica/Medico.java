package Logica;

public class Medico extends Usuario{
	protected String especialidade;
	
	public Medico(String usuario, String senha, String nome, int identificador, String especialidade) {
		super(usuario, senha, nome, identificador);
		this.especialidade = especialidade;
	}

}
