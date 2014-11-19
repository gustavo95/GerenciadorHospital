package Gerenciador;

import java.util.ArrayList;

import UI.JanelaErro;

public class DadosCareTaker {
	protected ArrayList<DadosMemento> estados;
	
	public DadosCareTaker(){
		estados = new ArrayList<DadosMemento>();
	}
	
	public void adicionarMemento(DadosMemento memento){
		estados.add(memento);
	}
	
	 public DadosMemento getUltimoEstado() {
	        DadosMemento estadoSalvo = estados.get(estados.size() - 1);
	        if (estados.size() > 1) {
	        	estados.remove(estados.size() - 1);
	        	new JanelaErro("Acao desfeita");
	        }else{
	        	new JanelaErro("Nao ha acao para ser desfeita");
	        }
	        return estadoSalvo;
	    }

}
