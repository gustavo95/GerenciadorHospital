package UI;

import Gerenciador.Dados;

//Padrao Bridge
public class JanelaPrincipal extends JanelaAbstrata{
	
	public JanelaPrincipal(JanelaInterface janela) {
		super(janela);
	}

	@Override
	public void desenharJanela(Dados usuarios) {
		prepararJanela("Gerenciador");
		prepararTabela(usuarios);
		prepararAtualizarTabela(usuarios);
		prepararBotoesPrincipal(usuarios);
		mostrarJanela();
		
	}
	
}
