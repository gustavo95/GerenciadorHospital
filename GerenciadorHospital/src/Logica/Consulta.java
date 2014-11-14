package Logica;

public class Consulta {
	private Paciente paciente;
	private Medico medico;
	String sala;
	
	public Consulta(Paciente paciente, Medico medico, String sala){
		this.paciente = paciente;
		this.medico = medico;
		this.sala = sala;
	}
	
	public String getPacienteNome(){
		return paciente.getNome();
	}
	
	public String getMedicoNome(){
		return medico.getNome();
	}
	
}
