package Logica;

public class UsuarioDirector {
	protected UsuarioBuilder usuario;
	
	public UsuarioDirector(UsuarioBuilder usuario){
		this.usuario = usuario;
	}
	
	public void criarUsuario(String usuarioLogin, String senha, String nome, int ID, String especialidade){
		usuario.buildUsuario(usuarioLogin);
		usuario.buildSenha(senha);
		usuario.buildNome(nome);
		usuario.buildIdentificador(ID);
		usuario.buildEspecialidade(especialidade);
	}
	
	public InformacoesUsuario getUsuarioInfo(){
		return usuario.getUarioInfo();
	}

}
