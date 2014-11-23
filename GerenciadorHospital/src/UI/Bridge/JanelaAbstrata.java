package UI.Bridge;

import Gerenciador.Dados;

//Padrao Bridge
public abstract class JanelaAbstrata {
	JanelaInterface janela;
	
	public JanelaAbstrata(JanelaInterface janela) {
        this.janela = janela;
    }
	
	abstract public void desenharJanela(Dados usuarios, String nome);
	
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
	
	public void prepararTabela(Dados usuario, String nome){
		janela.preparaTabela(usuario, nome);
	}
	
	public void prepararAtualizarTabela(Dados usuarios, String nome){
		janela.prepararAtualizarTabela(usuarios, nome);
	}
	
	public void prepararBotoesPrincipal(Dados usuarios,String nome){
		janela.prepararBotoesPrincipal(usuarios, nome);
	}
	
}
