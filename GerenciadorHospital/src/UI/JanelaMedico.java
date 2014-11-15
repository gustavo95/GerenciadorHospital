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
import Logica.MedicoProxy;

//Padrao Bridge
public class JanelaMedico implements JanelaInterface{

	private JFrame janela;
	private JPanel painel, painelAux1, painelAux2, painelAux3, painelAux4 ,painelBotoes;
	private JLabel nome, senha, crm, especialidade;
	private JTextField entradaNome, entradaCrm, entradaEspecialidade;
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
		crm = new JLabel("Crm: ");
		especialidade = new JLabel("Especialidade: ");

		entradaNome = new JTextField(25);
		entradaNome.setEditable(true);

		entradaSenha = new JPasswordField(25);
		entradaSenha.setEditable(true);

		entradaCrm = new JTextField(25);
		entradaCrm.setEditable(true);
		
		entradaEspecialidade = new JTextField(25);
		entradaEspecialidade.setEditable(true);

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
		painelAux3.add(crm);
		painelAux3.add(entradaCrm);
		
		painelAux4 = new JPanel();
		painelAux4.setLayout(new FlowLayout());
		painelAux4.add(especialidade);
		painelAux4.add(entradaEspecialidade);

		painel.add(painelAux1);
		painel.add(painelAux2);
		painel.add(painelAux3);
		painel.add(painelAux4);
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
						usuarios.addUsuario(entradaNome.getText(), new MedicoProxy(entradaNome.getText(),
											entradaSenha.getText(), Long.parseLong(entradaCrm.getText()), 
											entradaEspecialidade.getText()));
						janela.dispose();
					}catch(NumberFormatException e1){
						new JanelaErro("Formato do CRM invalido");
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
