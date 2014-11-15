package Logica;

public abstract class Usuario {
	
	protected String nome;
	protected String senha; 
	protected long identificador;
	
	public Usuario(String nome, String senha, long identificador){
		this.nome = nome;
		this.senha = senha;
		this.identificador = identificador;
	}
	
	abstract public void setProxy(String usuario, String senha);
	
	abstract public void menu(Dados banco);

	public String getNome() {
		return nome;
	}
	
}
