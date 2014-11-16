package UI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Gerenciador.Consulta;
import Gerenciador.Dados;
import Gerenciador.Medico;
import Gerenciador.MedicoProxy;
import Gerenciador.Paciente;
import Gerenciador.PacienteProxy;
import Gerenciador.Usuario;

public class JanelaConsulta{
	
	private JFrame janela;
	private JPanel painel, painelBotoes, painelPaciente, painelMedico, painelData;
	private JLabel paciente, medico, data;
	private JTextField entradaPaciente, entradaMedico, entradaData;
	private JButton ok, cancelar;
	
	public void marcarConsulta(Dados usuarios, String nomePaciente, String nomeMedico){
		janela = new JFrame("Marcar Consulta");
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		painel = new JPanel();
		painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
		
		prepararEntradaPaciente(nomePaciente);
		prepararEntradaMedico(nomeMedico);
		prepararEntradaData();
		prepararBotaoMarcar(usuarios);
		prepararBotaoCancelar();
		
		janela.add(painel);
		janela.pack();
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
	}
	
	public void desmarcarConsulta(Dados usuarios, String nomePaciente, String nomeMedico){
		janela = new JFrame("Desmarcar Consulta");
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		painel = new JPanel();
		painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
		
		prepararEntradaPaciente(nomePaciente);
		prepararEntradaMedico(nomeMedico);
		prepararEntradaData();
		prepararBotaoDesmarcar(usuarios);
		prepararBotaoCancelar();
		
		janela.add(painel);
		janela.pack();
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
	}
	
	private void prepararEntradaPaciente(String nomePaciente){
		paciente = new JLabel("Nome do Paciente");
		
		entradaPaciente = new JTextField(25);
		if(nomePaciente == null){
			entradaPaciente.setEditable(true);
		}else{
			entradaPaciente.setEditable(false);
			entradaPaciente.setText(nomePaciente);
		}
		
		painelPaciente = new JPanel();
		painelPaciente.setLayout(new FlowLayout());
		painelPaciente.add(paciente);
		painelPaciente.add(entradaPaciente);
		
		painel.add(painelPaciente);
	}
	
	private void prepararEntradaMedico(String nomeMedico){
		medico = new JLabel("Nome do Medico");
		
		entradaMedico = new JTextField(25);
		if(nomeMedico == null){
			entradaMedico.setEditable(true);
		}else{
			entradaMedico.setEditable(false);
			entradaMedico.setText(nomeMedico);
		}
		
		painelMedico = new JPanel();
		painelMedico.setLayout(new FlowLayout());
		painelMedico.add(medico);
		painelMedico.add(entradaMedico);
		
		painel.add(painelMedico);
	}
	
	private void prepararEntradaData(){
		data = new JLabel("Data(dd/mm/aaaa): ");
		
		entradaData = new JTextField(10);
		entradaData.setEditable(true);
		
		painelData = new JPanel();
		painelData.setLayout(new FlowLayout());
		painelData.add(data);
		painelData.add(entradaData);
		
		painel.add(painelData);
	}
	
	private void prepararBotaoCancelar(){
		cancelar = new JButton("Cancelar");
		
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				janela.dispose();
			}});
		
		painelBotoes.add(cancelar);
		painel.add(painelBotoes);
	}
	
	private void prepararBotaoMarcar(Dados usuarios){
		painelBotoes = new JPanel();
		painelBotoes.setLayout(new FlowLayout());
		
		ok = new JButton("Marcar");
		
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(usuarios.usuarioExiste(entradaPaciente.getText()) && usuarios.usuarioExiste(entradaMedico.getText())){
					
					Usuario p = usuarios.getUsuario(entradaPaciente.getText());
					Usuario m = usuarios.getUsuario(entradaMedico.getText());
					
					if(p instanceof PacienteProxy && m instanceof MedicoProxy){
						try {
							SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
							Calendar cal  = Calendar.getInstance();
							cal.setTime(df.parse(entradaData.getText()));
							
							usuarios.marcarConsulta(cal, new Consulta((Paciente)p, (Medico)m));
							janela.dispose();
							
						} catch (ParseException e1) {
							new JanelaErro("Formato de data invalido");
						} 
					}else{
						new JanelaErro("Tipos de usuario incoreos");
					}
				}else{
					new JanelaErro("Usuario não encontrado");
				}
			}});
		
		painelBotoes.add(ok);
	}
	
	private void prepararBotaoDesmarcar(Dados usuarios){
		painelBotoes = new JPanel();
		painelBotoes.setLayout(new FlowLayout());
		
		ok = new JButton("Desmarcar");
		
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(usuarios.usuarioExiste(entradaPaciente.getText()) && usuarios.usuarioExiste(entradaMedico.getText())){
					
					Usuario p = usuarios.getUsuario(entradaPaciente.getText());
					Usuario m = usuarios.getUsuario(entradaMedico.getText());
					
					if(p instanceof PacienteProxy && m instanceof MedicoProxy){
						try {
							SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
							Calendar cal  = Calendar.getInstance();
							cal.setTime(df.parse(entradaData.getText()));
							
							usuarios.desmarcarConsulta(cal, new Consulta((Paciente)p, (Medico)m));
							janela.dispose();
							
						} catch (ParseException e1) {
							new JanelaErro("Formato de data invalido");
						} 
					}else{
						new JanelaErro("Tipos de usuario incoreos");
					}
				}else{
					new JanelaErro("Usuario não encontrado");
				}
			}});
		
		painelBotoes.add(ok);
	}
	
}
