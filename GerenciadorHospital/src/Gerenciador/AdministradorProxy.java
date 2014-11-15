package Gerenciador;

import UI.JanelaErro;
import UI.JanelaLogin;

//Padrao Proxy
public class AdministradorProxy extends Administrador{

	private String usuarioProxy, senhaProxy;
	
	public AdministradorProxy(String nome, String senha, long identificador) {
		super(nome, senha, identificador);
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
