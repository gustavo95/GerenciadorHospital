package Logica;

public class Consulta {
	private Paciente paciente;
	private Medico medico;
	
	public Consulta(Paciente paciente, Medico medico){
		this.paciente = paciente;
		this.medico = medico;
	}
	
	public String getPacienteNome(){
		return paciente.getNome();
	}
	
	public int getPacienteIdade(){
		return paciente.getIdade();
	}
	
	public String getMedicoNome(){
		return medico.getNome();
	}
	
	public String getMedicoEspecialidade(){
		return medico.getEspecialidade();
	}
	
}
