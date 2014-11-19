package Gerenciador;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Hashtable;
import java.util.Set;

public class DadosMemento {

	protected Hashtable<String, Usuario> usuarios;
	protected Hashtable<Calendar, ArrayList<Consulta>> consultas;
	
	@SuppressWarnings("unchecked")
	public DadosMemento(Hashtable<String, Usuario> usuarios, Hashtable<Calendar, ArrayList<Consulta>> consultas) {
		this.usuarios = (Hashtable<String, Usuario>) usuarios.clone();
		this.consultas = clonarConsultas(consultas);
	}
	
	public Hashtable<String, Usuario> getUsuariosSalvos(){
		return usuarios;
	}
	
	public Hashtable<Calendar, ArrayList<Consulta>> getConsultasSalvas(){
		return consultas;
	}
	
	@SuppressWarnings("unchecked")
	private Hashtable<Calendar, ArrayList<Consulta>> clonarConsultas(Hashtable<Calendar, ArrayList<Consulta>> consulta){
		Hashtable<Calendar, ArrayList<Consulta>> clone = new Hashtable<Calendar, ArrayList<Consulta>>();
		Set<Calendar> chaves = consulta.keySet();
		
		for(Calendar chave : chaves){
			clone.put(chave, (ArrayList<Consulta>) consulta.get(chave).clone());
		}
		return clone;
	}
	
}
