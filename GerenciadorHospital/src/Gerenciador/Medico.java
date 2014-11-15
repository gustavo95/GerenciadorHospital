package Gerenciador;

import UI.JanelaMedico;
import UI.JanelaPrincipal;

public abstract class Medico extends Usuario{
	
	protected String especialidade;
	
	public Medico(String nome, String senha, long identificador, String especialidade) {
		super(nome, senha, identificador);
		this.especialidade = especialidade;
	}

	@Override
	public void menu(Dados banco) {
		new JanelaPrincipal(new JanelaMedico()).desenharJanela(banco);
	}
	
	public String getEspecialidade() {
		return especialidade;
	}
	

}
