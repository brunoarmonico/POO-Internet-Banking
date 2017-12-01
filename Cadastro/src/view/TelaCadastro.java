package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

public class TelaCadastro  implements ActionListener {
	private static TelaCadastro tela  = new TelaCadastro();
	private static JFrame janela;
	private JPanel telaLogin;
	
	public static void main (String[] args) {
		tela.telaCad();
	}
	
	public void telaCad() {
		
		JLabel lbLogin = new JLabel("Login:");
		JTextField login = new JTextField(20);
		JPanel painelLogin = new JPanel();
		painelLogin.add(lbLogin);
		painelLogin.add(login);
		
		JLabel lbSenha = new JLabel("Senha:");
		JPasswordField senha = new JPasswordField(20);
		JPanel painelSenha = new JPanel();
		painelSenha.add(lbSenha);
		painelSenha.add(senha);
		
		JLabel lbCpf = new JLabel("CPF:");
		JTextField cpf = new JTextField(16);
		JPanel painelCpf = new JPanel();
		painelCpf.add(lbCpf);
		painelCpf.add(cpf);
		
		NumberFormatter valorFormatado = new NumberFormatter();
		JLabel lbValor = new JLabel("Saldo da Conta:");
		JFormattedTextField valor = new JFormattedTextField(valorFormatado);
		valor.setColumns(10);
		JPanel painelValor = new JPanel();
		painelValor.add(lbValor);
		painelValor.add(valor);
		
		JButton btnCadastro = new JButton("Cadastrar");
		JPanel painelBotao = new JPanel();
		painelBotao.add(btnCadastro);
		
		JPanel dadosLogin = new JPanel(new GridLayout(5,1));
		dadosLogin.add(painelLogin);
		dadosLogin.add(painelSenha);
		dadosLogin.add(painelCpf);
		dadosLogin.add(painelValor);
		dadosLogin.add(painelBotao);
		
		telaLogin = new JPanel(new GridLayout(3,1));
		telaLogin.add(new JPanel());
		telaLogin.add(dadosLogin);
		telaLogin.add(new JPanel());
		
		btnCadastro.addActionListener(this);
		
		janela = new JFrame("Banco do HUE");
		janela.setContentPane(telaLogin);
		janela.setSize(550, 550);
		janela.setVisible(true);
		janela.setResizable(false);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
