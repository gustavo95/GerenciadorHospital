package Gerenciador;

import Bridge.JanelaPaciente;
import Bridge.JanelaPrincipal;

public abstract class Paciente extends Usuario {
	
	protected int idade;
	
	public Paciente(String nome, String senha, long identificador, int idade) {
		super(nome, senha, identificador);
		this.idade = idade;
	}

	@Override
	public void menu(Dados banco) {
		new JanelaPrincipal(new JanelaPaciente()).desenharJanela(banco, super.nome);
	}
	
	public int getIdade(){
		return idade;
	}

}
