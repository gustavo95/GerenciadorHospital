package Gerenciador;

import UI.JanelaErro;
import UI.JanelaLogin;

//Padrao Proxy
public class PacienteProxy extends Paciente{
	
	private String usuarioProxy, senhaProxy;
	
	public PacienteProxy(String nome, String senha, long identificador, int idade) {
		super(nome, senha, identificador, idade);
		// TODO Auto-generated constructor stub
	}
	
	public void setProxy(String usuario, String senha){
		this.usuarioProxy = usuario;
		this.senhaProxy = senha;
	}
	
	private boolean temPermissaoDeAcesso() {
		return (usuarioProxy.equals(super.nome) && senhaProxy.equals(super.senha));
    }
	
	@Override
	public void menu(Dados banco){
		if(temPermissaoDeAcesso()){
			super.menu(banco);
		}else{
			new JanelaLogin(banco);
			new JanelaErro("Usuario ou Senha incorretos");
		}
		
	}

}
