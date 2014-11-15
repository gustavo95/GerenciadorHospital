package UI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import Logica.Dados;

public class SelecionarUsuario {
	
	private JFrame janela;
	private JPanel painel, botoes;
	private JRadioButton paciente, medico, administrador;
	private JButton ok, cancelar;
	private JLabel label;
	
	private void prepararBotoes(Dados usuarios){
		ok = new JButton("OK");
		cancelar = new JButton("Cancelar");
		botoes = new JPanel();
		
		ok.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				  JanelaAbstrata criarUsuario = null;
				  
				  if(paciente.isSelected()){
					 criarUsuario = new JanelaCriarUsuario(new JanelaPaciente());
				  }
				  if(medico.isSelected()){
					  criarUsuario = new JanelaCriarUsuario(new JanelaMedico());
				  }
				  if(administrador.isSelected()){
					  criarUsuario = new JanelaCriarUsuario(new JanelaAdministrador());
				  }
				  
				  janela.dispose();
				  criarUsuario.desenharJanela(usuarios);
				  }});
		
		cancelar.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				  janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				    janela.dispose(); }});
		
		botoes.setLayout(new FlowLayout());
		botoes.add(ok);
		botoes.add(cancelar);
		painel.add(botoes);
		
	}
	
	public SelecionarUsuario(Dados usuarios){
		janela = new JFrame("Criar usuario");
		painel = new JPanel();
		painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
		
		label = new JLabel("Selecione o tipo de usuario");
		
		paciente = new JRadioButton("Paciente");
		paciente.setSelected(true);
		paciente.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				  paciente.setSelected(true);
				  medico.setSelected(false);
				  administrador.setSelected(false);}});
		
		medico = new JRadioButton("Medico");
		medico.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				  paciente.setSelected(false);
				  medico.setSelected(true);
				  administrador.setSelected(false);}});
		
		administrador = new JRadioButton("Adiministrador");
		administrador.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				  paciente.setSelected(false);
				  medico.setSelected(false);
				  administrador.setSelected(true);}});
		
		painel.add(label);
		painel.add(paciente);
		painel.add(medico);
		painel.add(administrador);
		prepararBotoes(usuarios);
		
		janela.add(painel);
		janela.pack();
		janela.setVisible(true);
	}
	
}
