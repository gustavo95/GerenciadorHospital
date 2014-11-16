package Bridge;

import Gerenciador.Dados;

//Padrao Bridge
public interface JanelaInterface {
	
	public void prepararJanela(String nomeJanela);
	public void mostrarJanela();
	public void prepararEntradas();
	public void prepararBotoesCriarUsuario(Dados usuarios);
	public void preparaTabela(Dados usuarios);
	public void prepararAtualizarTabela(Dados usuarios);
	public void prepararBotoesPrincipal(Dados usuarios, String nome);
}
