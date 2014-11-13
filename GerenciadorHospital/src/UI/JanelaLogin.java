package UI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JanelaLogin {
	
	private JButton botaoEntrar, botaoSair, botaoUsuario;
	private JPanel painel, botoes, painelUsuario, painelSenha;
	private JFrame janela;
	private JLabel usuario, senha;
	private JTextField entradaUsuario;
	private JPasswordField entradaSenha;
	
	private void prepararBotoes(){
		botaoEntrar = new JButton("Entrar");
		botaoUsuario = new JButton("Novo Usuario");
		botaoSair = new JButton("Sair");
		botoes = new JPanel();
		
		botaoEntrar.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				    ; }});
		
		botaoUsuario.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				    ; }});
		
		botaoSair.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				  janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				    janela.dispose(); }});
		
		botoes.setLayout(new FlowLayout());
		botoes.add(botaoEntrar);
		botoes.add(botaoUsuario);
		botoes.add(botaoSair);
		painel.add(botoes);
		
	}
	
	private void prepararPainelUsuario(){
		painelUsuario = new JPanel();
		painelUsuario.setLayout(new FlowLayout());
		
		usuario = new JLabel("Usuario: ");
		entradaUsuario = new JTextField(20);
		entradaUsuario.setEditable(true);
		
		painelUsuario.add(usuario);
		painelUsuario.add(entradaUsuario);
		
		painel.add(painelUsuario);
		
	}
	
	private void prepararPainelSenha(){
		painelSenha = new JPanel();
		painelSenha.setLayout(new FlowLayout());
		
		senha = new JLabel("Senha: ");
		
		entradaSenha = new JPasswordField(20);
		entradaSenha.setEditable(true);
		
		painelSenha.add(senha);
		painelSenha.add(entradaSenha);
		
		painel.add(painelSenha);
	}
	
	public void login(){
		painel = new JPanel();
		painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
		
		prepararPainelUsuario();
		prepararPainelSenha();
		prepararBotoes();
		
		janela = new JFrame("Login");
		janela.add(painel);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.pack();
		janela.setVisible(true);
	}

}
