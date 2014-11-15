package UI;

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

import Gerenciador.AdministradorProxy;
import Gerenciador.Dados;

//Padrao Bridge
public class JanelaAdministrador implements JanelaInterface{

	private JFrame janela;
	private JPanel painel, painelAux1, painelAux2, painelAux3, painelBotoes;
	private JLabel label, senha, cpf;
	private JTextField entrada, entradaCpf;
	private JPasswordField entradaSenha;
	private JButton botao1, botao2, botao3, botao4, botao5, botao6;
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

		label = new JLabel("label: ");
		senha = new JLabel("Senha: ");
		cpf = new JLabel("CPF: ");

		entrada = new JTextField(25);
		entrada.setEditable(true);

		entradaSenha = new JPasswordField(25);
		entradaSenha.setEditable(true);

		entradaCpf = new JTextField(25);
		entradaCpf.setEditable(true);

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
		painelAux3.add(cpf);

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
						usuarios.addUsuario(entrada.getText(), new AdministradorProxy(entrada.getText(),
								entradaSenha.getText(), Long.parseLong(entradaCpf.getText())));
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
	public void preparaTabela(Dados usuarios){

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

		tabela.setModel(usuarios.getConsultas(cal));

		painel.add(scroll, BorderLayout.CENTER);
	}

	@Override
	public void prepararAtualizarTabela(Dados usuarios){

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
					tabela.setModel(usuarios.getConsultas(cal));
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
	public void prepararBotoesPrincipal(Dados usuarios){
		
		painelBotoes = new JPanel();
		painelBotoes.setLayout(new BoxLayout(painelBotoes, BoxLayout.Y_AXIS));
		
		botao2 = new JButton("Criar Usuario");
		botao2.setMinimumSize(new Dimension(170, 50));
		botao2.setMaximumSize(new Dimension(170, 50));
		botao2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SelecionarUsuario(usuarios);
			}});
		
		botao3 = new JButton("Excluir usuario");
		botao3.setMinimumSize(new Dimension(170, 50));
		botao3.setMaximumSize(new Dimension(170, 50));
		botao3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JanelaExcluir(usuarios);
			}});
		
		botao4 = new JButton("Marcar consulta");
		botao4.setMinimumSize(new Dimension(170, 50));
		botao4.setMaximumSize(new Dimension(170, 50));
		botao4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JanelaConsulta().marcarConsulta(usuarios, null, null);
			}});
		
		botao5 = new JButton("Desmarcar Consulta");
		botao5.setMinimumSize(new Dimension(170, 50));
		botao5.setMaximumSize(new Dimension(170, 50));
		botao5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}});
		
		botao6 = new JButton("Sair");
		botao6.setMinimumSize(new Dimension(170, 50));
		botao6.setMaximumSize(new Dimension(170, 50));
		botao6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				janela.dispose();
				new JanelaLogin(usuarios);
			}});
		
		painelBotoes.add(botao2);
		painelBotoes.add(botao3);
		painelBotoes.add(botao4);
		painelBotoes.add(botao5);
		painelBotoes.add(botao6);
		
		janela.add(painelBotoes, BorderLayout.WEST);
		
	}
	
}
