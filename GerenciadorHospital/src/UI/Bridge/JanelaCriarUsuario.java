package UI.Bridge;

import Gerenciador.Dados;

//Padrao Bridge
public class JanelaCriarUsuario extends JanelaAbstrata{

	public JanelaCriarUsuario(JanelaInterface janela) {
		super(janela);
	}

	@Override
	public void desenharJanela(Dados usuarios, String nome) {
		prepararJanela("Criar Usuario");
		prepararEntradas();
		prepararBotoesCriarUsuario(usuarios);
		mostrarJanela();
		
	}

}
