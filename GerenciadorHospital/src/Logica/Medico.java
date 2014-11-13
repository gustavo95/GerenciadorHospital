package Logica;

public class Medico extends UsuarioBuilder{

	@Override
	public void buildEspecialidade(String especialidade) {
		usuarioInfo.especialidade = especialidade;
	}

}
