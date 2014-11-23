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

import UI.Bridge.JanelaCriarUsuario;
import UI.Bridge.JanelaPaciente;
import Gerenciador.Dados;
import Gerenciador.Usuario;

public class JanelaLogin {
	
	private JFrame janela;
	private JPanel painel, botoes, painelUsuario, painelSenha;
	private JButton botaoEntrar, botaoUsuario, botaoSair;
	private JLabel usuario, senha;
	private JTextField entradaUsuario;
	private JPasswordField entradaSenha;
	
	private void prepararBotoes(Dados banco){
		botaoEntrar = new JButton("Entrar");
		botaoUsuario = new JButton("Novo Paciente");
		botaoSair = new JButton("Sair");
		botoes = new JPanel();
		
		botaoEntrar.addActionListener(new ActionListener() {
			  @SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				    if(banco.usuarioExiste(entradaUsuario.getText())){
				    	janela.dispose();
				    	Usuario u = banco.getUsuario(entradaUsuario.getText());
				    	u.setProxy(entradaUsuario.getText(), entradaSenha.getText());
				    	u.menu(banco);
				    	
				    }else{
				    	new JanelaErro("Usuario não encontrado");
				    }
				    	
			  }});
		
		botaoUsuario.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				    new JanelaCriarUsuario(new JanelaPaciente()).desenharJanela(banco, null); }});
		
		botaoSair.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				  janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				    System.exit(0); }});
		
		botoes.setLayout(new FlowLayout());
		botoes.add(botaoEntrar);
		botoes.add(botaoUsuario);
		botoes.add(botaoSair);
		painel.add(botoes);
		
	}
	
	private void prepararPainelUsuario(){
		painelUsuario = new JPanel();
		painelUsuario.setLayout(new FlowLayout());
		
		usuario = new JLabel("Nome: ");
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
	
	public JanelaLogin(Dados banco){
		painel = new JPanel();
		painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
		
		prepararPainelUsuario();
		prepararPainelSenha();
		prepararBotoes(banco);
		
		janela = new JFrame("Login");
		janela.add(painel);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.pack();
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
	}

}
