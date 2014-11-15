package UI;

import Gerenciador.Dados;

//Padrao Bridge
public abstract class JanelaAbstrata {
	JanelaInterface janela;
	
	public JanelaAbstrata(JanelaInterface janela) {
        this.janela = janela;
    }
	
	abstract public void desenharJanela(Dados usuarios);
	
	public void prepararJanela(String nomeJanela){
		janela.prepararJanela(nomeJanela);
	}
	
	public void mostrarJanela(){
		janela.mostrarJanela();
	}
	
	public void prepararEntradas(){
		janela.prepararEntradas();
	}
	
	public void prepararBotoesCriarUsuario(Dados usuarios){
		janela.prepararBotoesCriarUsuario(usuarios);
	}
	
	public void prepararTabela(Dados usuario){
		janela.preparaTabela(usuario);
	}
	
	public void prepararAtualizarTabela(Dados usuarios){
		janela.prepararAtualizarTabela(usuarios);
	}
	
	public void prepararBotoesPrincipal(Dados usuarios){
		janela.prepararBotoesPrincipal(usuarios);
	}
}
