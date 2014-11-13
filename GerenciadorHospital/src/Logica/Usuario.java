package Logica;

public abstract class Usuario {
	protected String usuario;
	protected String senha; 
	protected String nome;
	protected int identificador;
	
	public Usuario(String usuario, String senha, String nome, int identificador){
		this.usuario = usuario;
		this.senha = senha;
		this.nome = nome;
		this.identificador = identificador;
	}
	
}
