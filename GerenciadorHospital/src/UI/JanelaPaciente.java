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

import Logica.Dados;
import Logica.PacienteProxy;

//Padrao Bridge
public class JanelaPaciente implements JanelaInterface{
	
	private JFrame janela;
	private JPanel painel, painelAux1, painelAux2, painelAux3, painelBotoes;
	private JLabel nome, senha, cpf, idade;
	private JTextField entradaNome, entradaCpf, entradaIdade;
	private JPasswordField entradaSenha;
	private JButton botao1, botao2;
	
	@Override
	public void prepararJanela(String nomeJanela){
		janela = new JFrame(nomeJanela);
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	@Override
	public void mostrarJanela(){
		janela.add(painel);
		janela.pack();
		janela.setVisible(true);
	}
	
	@Override
	public void prepararEntradas() {
		painel  = new JPanel();
		painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
		
		nome = new JLabel("Nome: ");
		senha = new JLabel("Senha: ");
		cpf = new JLabel("CPF: ");
		idade = new JLabel("Idade: ");
		
		entradaNome = new JTextField(25);
		entradaNome.setEditable(true);
		
		entradaSenha = new JPasswordField(25);
		entradaSenha.setEditable(true);
		
		entradaCpf = new JTextField(11);
		entradaCpf.setEditable(true);
		
		entradaIdade = new JTextField(2);
		entradaIdade.setEditable(true);
		
		painelAux1 = new JPanel();
		painelAux1.setLayout(new FlowLayout());
		painelAux1.add(nome);
		painelAux1.add(entradaNome);
		
		painelAux2 = new JPanel();
		painelAux2.setLayout(new FlowLayout());
		painelAux2.add(senha);
		painelAux2.add(entradaSenha);
		
		painelAux3 = new JPanel();
		painelAux3.setLayout(new FlowLayout());
		painelAux3.add(cpf);
		painelAux3.add(entradaCpf);
		painelAux3.add(idade);
		painelAux3.add(entradaIdade);
		
		painel.add(painelAux1);
		painel.add(painelAux2);
		painel.add(painelAux3);
	}
	
	@Override
	public void prepararBotoesCriarUsuario(Dados usuarios){
		painelBotoes = new JPanel();
		painelBotoes.setLayout(new FlowLayout());
		
		botao1 = new JButton("Criar");
		botao1.addActionListener(new ActionListener() {
			  @SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				    if(usuarios.usuarioExiste(entradaNome.getText())){
				    	new JanelaErro("Já existe usuario com este nome");
				    }else{
				    	try{
				    		usuarios.addUsuario(entradaNome.getText(), new PacienteProxy(entradaNome.getText(),
		    									entradaSenha.getText(), Long.parseLong(entradaCpf.getText()),
		    									Integer.parseInt(entradaIdade.getText())));
				    		janela.dispose();
				    	}catch(NumberFormatException e1){
				    		new JanelaErro("Formato do CPF invalido");
				    	}
				    }
			  }});
		
		botao2 = new JButton("Cancelar");
		botao2.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				   janela.dispose(); }});
		
		painelBotoes.add(botao1);
		painelBotoes.add(botao2);
		painel.add(painelBotoes);
	}
	

}
