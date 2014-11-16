package Bridge;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import UI.JanelaConsulta;
import UI.JanelaErro;
import UI.JanelaLogin;
import Gerenciador.Dados;
import Gerenciador.PacienteProxy;

//Padrao Bridge
public class JanelaPaciente implements JanelaInterface{
	
	private JFrame janela;
	private JPanel painel, painelAux1, painelAux2, painelAux3, painelBotoes;
	private JLabel label, senha, cpf, idade;
	private JTextField entrada, entradaCpf, entradaIdade;
	private JPasswordField entradaSenha;
	private JButton botao1, botao2, botao3, botao4;
	private JTable tabela;
	
	@Override
	public void prepararJanela(String labelJanela){
		janela = new JFrame(labelJanela);
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	@Override
	public void mostrarJanela(){
		janela.add(painel);
		janela.pack();
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
	}
	
	@Override
	public void prepararEntradas() {
		painel  = new JPanel();
		painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
		
		label = new JLabel("Nome: ");
		senha = new JLabel("Senha: ");
		cpf = new JLabel("CPF: ");
		idade = new JLabel("Idade: ");
		
		entrada = new JTextField(25);
		entrada.setEditable(true);
		
		entradaSenha = new JPasswordField(25);
		entradaSenha.setEditable(true);
		
		entradaCpf = new JTextField(11);
		entradaCpf.setEditable(true);
		
		entradaIdade = new JTextField(2);
		entradaIdade.setEditable(true);
		
		painelAux1 = new JPanel();
		painelAux1.setLayout(new FlowLayout());
		painelAux1.add(label);
		painelAux1.add(entrada);
		
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
				    if(usuarios.usuarioExiste(entrada.getText())){
				    	new JanelaErro("Já existe usuario com este nome");
				    }else{
				    	try{
				    		usuarios.addUsuario(entrada.getText(), new PacienteProxy(entrada.getText(),
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
	
	@Override
	public void preparaTabela(Dados usuarios, String nomePaciente){

		painel = new JPanel();
		painel.setLayout(new BorderLayout());

		tabela = new JTable();

		tabela.setBorder(new LineBorder(Color.black));
		tabela.setGridColor(Color.black);
		tabela.setShowGrid(true);

		JScrollPane scroll = new JScrollPane(); 
		scroll.getViewport().setBorder(null);
		scroll.getViewport().add(tabela); 
		scroll.setSize(500, 500);

		Date hoje = new Date();
		Calendar cal = new GregorianCalendar();
		cal.setTime(hoje);

		tabela.setModel(usuarios.getConsultasFiltro(cal, nomePaciente));

		painel.add(scroll, BorderLayout.CENTER);
	}

	@Override
	public void prepararAtualizarTabela(Dados usuarios, String nomePaciente){

		painelAux1 = new JPanel();
		painelAux1.setLayout(new FlowLayout());

		label = new JLabel("Data(dd/mm/aaaa): ");

		Date hoje = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String dataString = format.format(hoje);

		entrada = new JTextField(10);
		entrada.setText(dataString);
		entrada.setEditable(true);

		botao1 = new JButton("Atualizar tabela");
		botao1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					Calendar cal  = Calendar.getInstance();
					cal.setTime(df.parse(entrada.getText()));
					tabela.setModel(usuarios.getConsultasFiltro(cal, nomePaciente));
				} catch (ParseException e1) {
					new JanelaErro("Formato de data invalido");
				}   
			}});

		painelAux1.add(label);
		painelAux1.add(entrada);
		painelAux1.add(botao1);
		janela.add(painelAux1, BorderLayout.NORTH);

	}
	
	@Override
	public void prepararBotoesPrincipal(Dados usuarios, String nomePaciente){
		
		painelBotoes = new JPanel();
		painelBotoes.setLayout(new BoxLayout(painelBotoes, BoxLayout.Y_AXIS));
		
		botao2 = new JButton("Marcar consulta");
		botao2.setMinimumSize(new Dimension(170, 50));
		botao2.setMaximumSize(new Dimension(170, 50));
		botao2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JanelaConsulta().marcarConsulta(usuarios, nomePaciente, null);
			}});
		
		botao3 = new JButton("Desmarcar Consulta");
		botao3.setMinimumSize(new Dimension(170, 50));
		botao3.setMaximumSize(new Dimension(170, 50));
		botao3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JanelaConsulta().desmarcarConsulta(usuarios, null, null);
			}});
		
		botao4 = new JButton("Sair");
		botao4.setMinimumSize(new Dimension(170, 50));
		botao4.setMaximumSize(new Dimension(170, 50));
		botao4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				janela.dispose();
				new JanelaLogin(usuarios);
			}});
		
		painelBotoes.add(botao2);
		painelBotoes.add(botao3);
		painelBotoes.add(botao4);
		
		janela.add(painelBotoes, BorderLayout.WEST);
		
	}

}
