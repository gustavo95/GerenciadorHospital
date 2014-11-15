package Gerenciador;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Hashtable;

public class Dados {
	private Hashtable<String, Usuario> usuarios;
	private Hashtable<Calendar, ArrayList<Consulta>> consultas; 
	
	public Dados(){
		usuarios = new Hashtable<String, Usuario>();
		usuarios.put("admin", new AdministradorProxy("admin", "admin00", 0000));
		consultas = new Hashtable<Calendar, ArrayList<Consulta>>();
	}
	
	public boolean usuarioExiste(String nome){
		return usuarios.containsKey(nome);
	}
	
	public void addUsuario(String nome, Usuario novoUsuario){
		usuarios.put(nome, novoUsuario);
	}
	
	public Usuario getUsuario(String usuario){
		return usuarios.get(usuario);
	}
	
	public void removerUsuario(String nome){
		usuarios.remove(nome);
	}
	
	public void marcarConsulta(Calendar data,Consulta c){
		if(consultas.containsKey(data)){
			consultas.get(data).add(c);
		}else{
			ArrayList<Consulta> AL = new ArrayList<Consulta>();
			AL.add(c);
			consultas.put(data, AL);
		}
	}
	
	public TabelaConsultas getConsultas(Calendar data){
		if(consultas.containsKey(data)){
			return new TabelaConsultas(consultas.get(data));
		}else{
			return new TabelaConsultas(new ArrayList<Consulta>());
		}
	}
}
