package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TelaPrincipal implements ActionListener {
	private static TelaPrincipal tela  = new TelaPrincipal();
	private static JFrame janela;
	private JPanel telaLogin;
	
	public static void main (String[] args) {
		tela.telaLogin();
	}
	
	public void telaLogin() {
		
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
		
		JButton btnLogin = new JButton("Login");
		JButton btnCadastro = new JButton("Cadastro");
		JPanel painelBotao = new JPanel();
		painelBotao.add(btnLogin);
		painelBotao.add(btnCadastro);
		
		JPanel dadosLogin = new JPanel(new GridLayout(3,1));
		dadosLogin.add(painelLogin);
		dadosLogin.add(painelSenha);
		dadosLogin.add(painelBotao);
		
		telaLogin = new JPanel(new GridLayout(3,1));
		telaLogin.add(new JPanel());
		telaLogin.add(dadosLogin);
		telaLogin.add(new JPanel());
		
		btnLogin.addActionListener(this);
		btnCadastro.addActionListener(this);
		
		janela = new JFrame("Banco do HUE");
		janela.setContentPane(telaLogin);
		janela.setSize(900, 550);
		janela.setVisible(true);
		janela.setResizable(false);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void telaEscolha() {
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		String cmd = event.getActionCommand();
		if ("Login".equals(cmd)) {
			
		}
	}
}
