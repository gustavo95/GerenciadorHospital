package UI;

import Logica.Dados;

//Padrao Bridge
public interface JanelaInterface {
	
	public void prepararJanela(String nomeJanela);
	public void mostrarJanela();
	public void prepararEntradas();
	public void prepararBotoesCriarUsuario(Dados usuarios);
}
