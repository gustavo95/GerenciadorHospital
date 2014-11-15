package Gerenciador;

import UI.JanelaAdministrador;
import UI.JanelaPrincipal;

public abstract class Administrador extends Usuario{

	public Administrador(String nome, String senha, long identificador) {
		super(nome, senha, identificador);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void menu(Dados banco) {
		new JanelaPrincipal(new JanelaAdministrador()).desenharJanela(banco);
	}
	
}
