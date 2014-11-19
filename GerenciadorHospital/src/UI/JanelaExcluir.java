package UI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Gerenciador.Dados;

public class JanelaExcluir {
	
	private JFrame janela;
	private JPanel painel, painelEntrada, painelBotoes;
	private JLabel nome;
	private JTextField entradaNome;
	private JButton ok, cancelar;
	
	public JanelaExcluir(Dados usuarios){
		
		janela = new JFrame("Excluir Usuario");
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		painel = new JPanel();
		painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
		
		painelEntrada = new JPanel();
		painelEntrada.setLayout(new FlowLayout());
		
		nome = new JLabel("Nome: ");
		entradaNome = new JTextField(25);
		entradaNome.setEditable(true);
		
		painelEntrada.add(nome);
		painelEntrada.add(entradaNome);
		
		painel.add(painelEntrada);
		prepararBotoes(usuarios);
		
		janela.add(painel);
		janela.pack();
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
		
	}
	
	private void prepararBotoes(Dados usuarios){
		painelBotoes = new JPanel();
		painelBotoes.setLayout(new FlowLayout());
		
		ok = new JButton("OK");
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(usuarios.usuarioExiste(entradaNome.getText())){
					usuarios.removerUsuario(entradaNome.getText());
					janela.dispose();
					new JanelaErro("Usuario excluido");
				}else{
					new JanelaErro("Usuario não encontrado");
				}
			}});
		
		cancelar = new JButton("Cancelar");
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				janela.dispose();
			}});
		
		painelBotoes.add(ok);
		painelBotoes.add(cancelar);
		
		painel.add(painelBotoes);
	}
	
}
