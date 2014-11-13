package Logica;

public abstract class UsuarioBuilder {
	protected InformacoesUsuario usuarioInfo;
	
	public UsuarioBuilder(){
		 usuarioInfo = new InformacoesUsuario();
	}
	
	public void buildUsuario(String usuario){
		usuarioInfo.usuario = usuario;
	}
	
	public void buildSenha(String senha){
		usuarioInfo.senha = senha;
	}
	
	public void buildNome(String nome){
		usuarioInfo.nome = nome;
	}
	
	public void buildIdentificador(int ID) {
		usuarioInfo.identificador = ID;
	}
	
	abstract public void buildEspecialidade(String especialidade);
	
	public InformacoesUsuario getUarioInfo(){
		return usuarioInfo;
	}
	
	
}
