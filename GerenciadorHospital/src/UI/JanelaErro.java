package UI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JanelaErro {
	JButton botaoOk;
	JPanel painel;
	JDialog janela;
	JLabel mensagem;
	
	public JanelaErro(String mensagemErro){
		janela = new JDialog();
		janela.setName("Erro");
		painel = new JPanel();
		botaoOk = new JButton("OK");
		mensagem = new JLabel(mensagemErro);
		
		botaoOk.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
			    janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			    janela.dispose(); }});
		
		painel.setLayout(new BorderLayout());
		
		painel.add(mensagem, BorderLayout.CENTER);
		painel.add(botaoOk, BorderLayout.SOUTH);
		janela.add(painel);
		janela.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		janela.pack();
		janela.setModal(true);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
	}
	
}
