package UI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JanelaErro {
	JButton botaoOk;
	JPanel painel;
	JFrame janela;
	JLabel mensagem;
	
	public void erro(String mensagemErro){
		
		botaoOk = new JButton("OK");
		painel = new JPanel();
		janela = new JFrame("Erro");
		mensagem = new JLabel(mensagemErro);
		
		botaoOk.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
			    janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			    janela.dispose(); }});
		
		painel.setLayout(new BorderLayout());
		
		painel.add(mensagem, BorderLayout.CENTER);
		painel.add(botaoOk, BorderLayout.SOUTH);
		janela.add(painel);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.pack();
		janela.setVisible(true);
	}
	
}
