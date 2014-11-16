package Gerenciador;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Hashtable;
import UI.JanelaErro;

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
	
	public void marcarConsulta(Calendar data, Consulta c){
		if(consultas.containsKey(data)){
			consultas.get(data).add(c);
		}else{
			ArrayList<Consulta> AL = new ArrayList<Consulta>();
			AL.add(c);
			consultas.put(data, AL);
		}
	}
	
	public void desmarcarConsulta(Calendar data, Consulta c){
		if(consultas.containsKey(data)){
			Boolean b = true;
			for(Consulta consulta : consultas.get(data)){
				if(consulta.getPacienteNome().equals(c.getPacienteNome()) && 
						consulta.getMedicoNome().equals(c.getMedicoNome())){
					consultas.get(data).remove(consulta);
					b = false;
					break;
				}
			}
			if(b){
				new JanelaErro("Consulta nao encontrada");
			}
		}else{
			new JanelaErro("Consulta nao encontrada");
		}
	}
	
	public TabelaConsultas getConsultas(Calendar data){
		if(consultas.containsKey(data)){
			return new TabelaConsultas(consultas.get(data));
		}else{
			return new TabelaConsultas(new ArrayList<Consulta>());
		}
	}
	
	public TabelaConsultas getConsultasFiltro(Calendar data, String nome){
		if(consultas.containsKey(data)){
			ArrayList<Consulta> filtrada = new ArrayList<Consulta>();
			for(Consulta c : consultas.get(data)){
				if(c.getPacienteNome().equals(nome) || c.getMedicoNome().equals(nome)){
					filtrada.add(c);
				}
			}
			return new TabelaConsultas(filtrada);
		}else{
			return new TabelaConsultas(new ArrayList<Consulta>());
		}
	}
	
}
