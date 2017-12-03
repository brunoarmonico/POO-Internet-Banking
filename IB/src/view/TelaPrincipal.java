package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

import controller.ControleIB;
import model.Conta;

public class TelaPrincipal implements ActionListener {
	private static TelaPrincipal tela = new TelaPrincipal();
	private static JFrame janela;
	private JPanel telaLogin;
	private JPanel telaCadastro;
	private JPanel telaEscolha;
	private JPanel telaTransferencia;
	private ControleIB controle = new ControleIB();
	private JTextField login;
	private JPasswordField senha;
	Conta conta = new Conta();

	public static void main(String[] args) {
		janela = new JFrame("Banco do HUE");
		tela.telaLogin();
		janela.setVisible(true);
		janela.setResizable(false);
		janela.setSize(900, 550);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void telaLogin() {
		telaLogin = new JPanel(new GridLayout(3, 1));
		
		Font fonte = new Font("Segoe UI", Font.PLAIN, 12);

		JLabel lbLogin = new JLabel("Login:");
		lbLogin.setFont(fonte);
		login = new JTextField(20);
		login.setFont(fonte);
		JPanel painelLogin = new JPanel();
		painelLogin.add(lbLogin);
		painelLogin.add(login);

		JLabel lbSenha = new JLabel("Senha:");
		lbSenha.setFont(fonte);
		senha = new JPasswordField(20);
		senha.setFont(fonte);
		JPanel painelSenha = new JPanel();
		painelSenha.add(lbSenha);
		painelSenha.add(senha);

		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(fonte);
		JButton btnCadastro = new JButton("Primeiro Acesso");
		btnCadastro.setFont(fonte);
		JPanel painelBotao = new JPanel();
		painelBotao.add(btnLogin);
		painelBotao.add(btnCadastro);

		JPanel dadosLogin = new JPanel(new GridLayout(3, 1));
		dadosLogin.add(painelLogin);
		dadosLogin.add(painelSenha);
		dadosLogin.add(painelBotao);

		telaLogin.add(new JPanel());
		telaLogin.add(dadosLogin);
		telaLogin.add(new JPanel());
		
		btnLogin.addActionListener(this);
		btnCadastro.addActionListener(this);
		janela.setContentPane(telaLogin);
	}

	public void telaCadastro() {
		telaCadastro = new JPanel();
		
		JLabel lbNome = new JLabel("Nome Completo:");
		JTextField nome = new JTextField(20);
		JPanel painelNome = new JPanel();
		painelNome.add(lbNome);
		painelNome.add(nome);

		JLabel lbLogin = new JLabel("Login:");
		login = new JTextField(20);
		JPanel painelLogin = new JPanel();
		painelLogin.add(lbLogin);
		painelLogin.add(login);

		JLabel lbSenha = new JLabel("Senha:");
		senha = new JPasswordField(20);
		JPanel painelSenha = new JPanel();
		painelSenha.add(lbSenha);
		painelSenha.add(senha);

		JLabel lbCpf = new JLabel("CPF:");
		JTextField cpf = new JTextField(16);
		JPanel painelCpf = new JPanel();
		painelCpf.add(lbCpf);
		painelCpf.add(cpf);

		// JLabel lbBanco = new JLabel("Banco:");
		// JTextField banco = new JTextField(5);
		JPanel painelBanco = new JPanel(new GridLayout(1, 2));
		// painelBanco.add(lbBanco);
		// painelBanco.add(banco);

		JLabel lbConta = new JLabel("Conta:");
		JTextField conta = new JTextField(10);
		JPanel painelConta = new JPanel();
		painelConta.add(lbConta);
		painelConta.add(conta);

		JLabel lbAgencia = new JLabel("Agencia:");
		JTextField agencia = new JTextField(5);
		JPanel painelAgencia = new JPanel();
		painelAgencia.add(lbAgencia);
		painelAgencia.add(agencia);

		painelBanco.add(painelAgencia);
		painelBanco.add(painelConta);

		NumberFormatter valorFormatado = new NumberFormatter();
		JLabel lbValor = new JLabel("Saldo da Conta:");
		JFormattedTextField valor = new JFormattedTextField(valorFormatado);
		valor.setColumns(10);
		JPanel painelValor = new JPanel();
		painelValor.add(lbValor);
		painelValor.add(valor);

		JButton btnCadastro = new JButton("Cadastrar");
		JButton btnVoltar = new JButton("Voltar");
		JPanel painelBotao = new JPanel(new GridLayout(1, 2));
		painelBotao.add(btnCadastro);
		painelBotao.add(btnVoltar);

		JPanel dadosLogin = new JPanel(new GridLayout(10, 1));
		dadosLogin.add(painelNome);
		dadosLogin.add(painelLogin);
		dadosLogin.add(painelSenha);
		dadosLogin.add(painelCpf);
		dadosLogin.add(painelBanco);
		// dadosLogin.add(painelAgencia);
		// dadosLogin.add(painelConta);
		dadosLogin.add(painelValor);
		dadosLogin.add(painelBotao);

		telaCadastro.add(new JPanel());
		telaCadastro.add(dadosLogin);
		telaCadastro.add(new JPanel());

		btnCadastro.addActionListener(this);
	}

	public void telaEscolha() {
		telaEscolha = new JPanel(new GridLayout(3,1));

		JLabel titulo = new JLabel("Bem vindo ao banco HUE");
		titulo.setFont(new Font("Segoe UI", Font.BOLD, 28));
		JPanel painelTitulo = new JPanel();
		painelTitulo.add(titulo);

		JPanel painelGeral = new JPanel(new GridLayout(1,4));
		JPanel painelTransferencia = new JPanel(new GridLayout(2,1));
		JButton btnTranferencia = new JButton("Transferencia");
		JLabel lbTransferencia = new JLabel("Transferencia DOC ou TED \nentre contas HUE ou outros bancos");
		painelTransferencia.add(btnTranferencia);
		painelTransferencia.add(lbTransferencia);
		
		JPanel painelExtrato = new JPanel(new GridLayout(2,1));
		JButton btnExtrato = new JButton("Extrato");
		JLabel lbExtrato = new JLabel("Extrato de suas movimentações da conta");
		painelExtrato.add(btnExtrato);
		painelExtrato.add(lbExtrato);

		JPanel painelPagamento = new JPanel(new GridLayout(2,1));
		JButton btnPagamento = new JButton("Pagamento");
		JLabel lbPagamento = new JLabel("Pagamentos por codigo de barra");
		painelPagamento.add(btnPagamento);
		painelPagamento.add(lbPagamento);
		
		JPanel painelDeposito = new JPanel(new GridLayout(2,1));
		JButton btnDeposito = new JButton("Recarga");
		JLabel lbDeposito = new JLabel("Recarga pré pago");
		painelDeposito.add(btnDeposito);
		painelDeposito.add(lbDeposito);
		
		
		JPanel painelInferior = new JPanel();
		JButton btnSair = new JButton("Sair");
		painelInferior.add(btnSair);
		btnSair.addActionListener(this);
		
		btnTranferencia.addActionListener(this);

		painelGeral.add(painelTransferencia);
		painelGeral.add(painelExtrato);
		painelGeral.add(painelPagamento);
		painelGeral.add(painelDeposito);
		
		telaEscolha.add(painelTitulo);
		telaEscolha.add(painelGeral);
	}
	
	public void telaTransferencia() {
		telaTransferencia = new JPanel(new BorderLayout());

		JPanel dadosTransferencia = new JPanel(new GridLayout(8, 1));

		JLabel lbBanco = new JLabel ("Banco: ");
		JTextField banco = new JTextField(10);
		JPanel painelBanco = new JPanel();
		painelBanco.add(lbBanco);
		painelBanco.add(banco);
		
		JLabel lbAgencia = new JLabel ("Agencia e Conta: ");
		JTextField agencia = new JTextField(4);
		JTextField conta = new JTextField(10);
		JPanel painelAgenciaConta = new JPanel();
		painelAgenciaConta.add(lbAgencia);
		painelAgenciaConta.add(agencia);
		painelAgenciaConta.add(conta);
		
		JLabel lbNomeBeneficiario = new JLabel("Nome: ");
		JTextField nomeBeneficiario = new JTextField(20);
		JPanel painelNomeBeneficiario = new JPanel();
		painelNomeBeneficiario.add(lbNomeBeneficiario);
		painelNomeBeneficiario.add(nomeBeneficiario);
		
		JLabel lbCpf = new JLabel("CPF: ");
		JTextField cpf = new JTextField(10);
		JPanel painelCpfTransf = new JPanel();
		painelCpfTransf.add(lbCpf);
		painelCpfTransf.add(cpf);
		
		JLabel lbFinalidade = new JLabel("Finalidade: ");
		JComboBox cbxFinalidade = new JComboBox <String> ();
		cbxFinalidade.addItem("01 - Credito em conta corrente");
		cbxFinalidade.addItem("07 - Pagamentos em geral");
		cbxFinalidade.addItem("12 - Transferencia Internacional");
		cbxFinalidade.addItem("22 - DOC para Poupança");
		cbxFinalidade.addItem("50 - Outros");
		JPanel painelFinalidade = new JPanel();
		painelFinalidade.add(lbFinalidade);
		painelFinalidade.add(cbxFinalidade);
		
		JLabel lbIdenfificacao = new JLabel("Idenficação: ");
		JTextArea idenficacao = new JTextArea(4,20);
		JPanel painelIdentificacao = new JPanel();
		painelIdentificacao.add(lbIdenfificacao);
		painelIdentificacao.add(idenficacao);
		
		JLabel lbValor = new JLabel("Valor: ");
		NumberFormatter valorFormatado = new NumberFormatter();
		JFormattedTextField valor = new JFormattedTextField(valorFormatado);
		valor.setColumns(10);
		JPanel painelValor = new JPanel();
		painelValor.add(lbValor);
		painelValor.add(valor);
		
		JButton btnTransferir = new JButton("Transferir");
		JButton btnCancelar = new JButton("Cancelar");
		JPanel painelBotao = new JPanel();
		painelBotao.add(btnTransferir);
		painelBotao.add(btnCancelar);
		
		dadosTransferencia.add(painelBanco);
		dadosTransferencia.add(painelAgenciaConta);
		dadosTransferencia.add(painelNomeBeneficiario);
		dadosTransferencia.add(painelCpfTransf);
		dadosTransferencia.add(painelFinalidade);
		dadosTransferencia.add(painelIdentificacao);
		dadosTransferencia.add(painelValor);
		dadosTransferencia.add(painelBotao);
		
		JScrollPane scroll = new JScrollPane(dadosTransferencia);
		
		telaTransferencia.add(painelSuperior(), BorderLayout.NORTH);
		telaTransferencia.add(scroll, BorderLayout.CENTER);
	}
	
	public void telaPagamento() {
		
	}
	
	public JPanel painelSuperior() {
		JPanel superior = new JPanel(new GridLayout(3,1));
		JLabel user = new JLabel("Ola, " + conta.getNome());
		JLabel saldo = new JLabel("Saldo: " + String.valueOf(conta.getSaldo()));
		JLabel acc = new JLabel ("Agencia: "+ conta.getAgencia() +" Conta: " + conta.getConta());
		superior.add(user);
		superior.add(acc);
		superior.add(saldo);
		
		return superior;
	}
	
	public boolean fazerLogin() {
		
//		System.out.println("TESTE LOGIN " +login.getText());
		conta.setLogin(login.getText());
//		System.out.println("TESTE senha " +senha.getPassword());
		conta.setSenha(senha.toString());
		return controle.acessoConta(conta);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		String cmd = event.getActionCommand();
		if ("Login".equals(cmd)) {
			boolean aprovado = fazerLogin();
			if (aprovado == false) {
				JOptionPane.showMessageDialog(null, "LOGIN OU SENHA INVALIDO");
			} else {
				telaEscolha();
				telaLogin.setVisible(false);
				janela.setContentPane(telaEscolha);
				telaEscolha.setVisible(true);
				janela.invalidate();
				janela.revalidate();
				janela.repaint();
			}
		} else if ("Primeiro Acesso".equals(cmd)) {
			telaCadastro();
			telaLogin.setVisible(false);
			janela.setContentPane(telaCadastro);
			telaCadastro.setVisible(true);
			janela.invalidate();
			janela.revalidate();
			janela.repaint();
		}
		
		if ("Sair".equals(cmd)){
			telaLogin();
			telaEscolha.setVisible(false);
			janela.setContentPane(telaLogin);
			telaLogin.setVisible(true);
			janela.invalidate();
			janela.revalidate();
			janela.repaint();
		} else if ("Transferencia".equals(cmd)) {
			telaTransferencia();
			telaEscolha.setVisible(false);
			janela.setContentPane(telaTransferencia);
			telaTransferencia.setVisible(true);
		}
	}
}
