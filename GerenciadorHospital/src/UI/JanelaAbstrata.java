package UI;

import Logica.Dados;

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
}
