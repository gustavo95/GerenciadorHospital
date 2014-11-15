package UI;

import Logica.Dados;

//Padrao Bridge
public class JanelaCriarUsuario extends JanelaAbstrata{

	public JanelaCriarUsuario(JanelaInterface janela) {
		super(janela);
	}

	@Override
	public void desenharJanela(Dados usuarios) {
		prepararJanela("Criar Usuario");
		prepararEntradas();
		prepararBotoesCriarUsuario(usuarios);
		mostrarJanela();
		
	}

}
