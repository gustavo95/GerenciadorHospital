package Logica;

public class Paciente extends UsuarioBuilder {

	@Override
	public void buildEspecialidade(String especialidade) {
		usuarioInfo.especialidade = "";
	}
	
}
