package Logica;

import java.util.Hashtable;

public class Dados {
	Hashtable<String, Usuario> usuarios;
	
	public Dados(){
		usuarios = new Hashtable<String, Usuario>();
		usuarios.put("admin", new AdministradorProxy("admin", "admin00", 0000));
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
}
