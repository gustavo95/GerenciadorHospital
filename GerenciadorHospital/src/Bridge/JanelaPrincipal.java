package Bridge;

import Gerenciador.Dados;

//Padrao Bridge
public class JanelaPrincipal extends JanelaAbstrata{
	
	public JanelaPrincipal(JanelaInterface janela) {
		super(janela);
	}

	@Override
	public void desenharJanela(Dados usuarios, String nome) {
		prepararJanela("Gerenciador");
		prepararTabela(usuarios);
		prepararAtualizarTabela(usuarios);
		prepararBotoesPrincipal(usuarios, nome);
		mostrarJanela();
		
	}
	
}
