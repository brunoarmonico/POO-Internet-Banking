package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.NumberFormatter;

import controller.ControleIB;
import controller.lstExtrato;
import model.Conta;

public class TelaPrincipal implements ActionListener {
	private static TelaPrincipal tela = new TelaPrincipal();
	private static JFrame janela;
	private JPanel telaLogin;
	private JPanel telaCadastro;
	private JPanel telaEscolha;
	private JPanel telaTransferencia;
	private JPanel telaPagamento;
	private JPanel telaRecarga;
	private JPanel telaExtrato;
	private ControleIB controle = new ControleIB();
	private lstExtrato listaExtrato = new lstExtrato();
	private JTextField login;
	private JPasswordField senha;
	Conta conta = new Conta();

	public static void main(String[] args) {
		janela = new JFrame("Banco do HUE");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		telaEscolha = new JPanel(new BorderLayout());

		int btnX = 130;
		int btnY = 40;

		JLabel titulo = new JLabel("Bem vindo ao banco HUE");
		titulo.setFont(new Font("Segoe UI", Font.BOLD, 28));
		JPanel painelTitulo = new JPanel();
		painelTitulo.add(titulo);

		Font fonteTexto = new Font("Segoe UI", Font.PLAIN, 12);

		JPanel painelGeral = new JPanel(new GridLayout(1, 4));

		JPanel painelTransferencia = new JPanel(new GridLayout(9, 1));
		JButton btnTranferencia = new JButton("Transferencia");
		btnTranferencia.setPreferredSize(new Dimension(btnX, btnY));
		btnTranferencia.setFont(fonteTexto);
		JPanel botao1 = new JPanel();
		botao1.add(btnTranferencia);
		JLabel lbTransferencia = new JLabel();
		lbTransferencia.setText("<html><center>Transferencia DOC ou TED entre contas HUE ou outros bancos</html>");
		lbTransferencia.setFont(fonteTexto);
		painelTransferencia.add(new JPanel());
		painelTransferencia.add(new JPanel());
		painelTransferencia.add(new JPanel());
		painelTransferencia.add(botao1);
		painelTransferencia.add(lbTransferencia);

		JPanel painelExtrato = new JPanel(new GridLayout(9, 1));
		JButton btnExtrato = new JButton("Extrato");
		btnExtrato.setPreferredSize(new Dimension(btnX, btnY));
		btnExtrato.setFont(fonteTexto);
		JPanel botao2 = new JPanel();
		botao2.add(btnExtrato);
		JLabel lbExtrato = new JLabel();
		lbExtrato.setText("<html><center>Extrato de suas movimentações da conta</html>");
		lbExtrato.setFont(fonteTexto);
		painelExtrato.add(new JPanel());
		painelExtrato.add(new JPanel());
		painelExtrato.add(new JPanel());
		painelExtrato.add(botao2);
		painelExtrato.add(lbExtrato);

		JPanel painelPagamento = new JPanel(new GridLayout(9, 1));
		JButton btnPagamento = new JButton("Pagamento");
		btnPagamento.setPreferredSize(new Dimension(btnX, btnY));
		btnPagamento.setFont(fonteTexto);
		JPanel botao3 = new JPanel();
		botao3.add(btnPagamento);
		JLabel lbPagamento = new JLabel();
		lbPagamento.setText("<html><center>Pagamentos por codigo de barra</html>");
		lbPagamento.setFont(fonteTexto);
		painelPagamento.add(new JPanel());
		painelPagamento.add(new JPanel());
		painelPagamento.add(new JPanel());
		painelPagamento.add(botao3);
		painelPagamento.add(lbPagamento);

		JPanel painelRecarga = new JPanel(new GridLayout(9, 1));
		JButton btnRecarga = new JButton("Recarga");
		btnRecarga.setPreferredSize(new Dimension(btnX, btnY));
		btnRecarga.setFont(fonteTexto);
		JPanel botao4 = new JPanel();
		botao4.add(btnRecarga);
		JLabel lbRecarga = new JLabel();
		lbRecarga.setText("<html><center>Recarga pré pago</html>");
		lbRecarga.setFont(fonteTexto);
		painelRecarga.add(new JPanel());
		painelRecarga.add(new JPanel());
		painelRecarga.add(new JPanel());
		painelRecarga.add(botao4);
		painelRecarga.add(lbRecarga);

		btnTranferencia.addActionListener(this);
		btnPagamento.addActionListener(this);
		btnRecarga.addActionListener(this);
		btnExtrato.addActionListener(this);

		painelGeral.add(painelTransferencia);
		painelGeral.add(painelExtrato);
		painelGeral.add(painelPagamento);
		painelGeral.add(painelRecarga);

		telaEscolha.add(painelSuperior(), BorderLayout.NORTH);
		telaEscolha.add(painelGeral, BorderLayout.CENTER);
	}

	public void telaTransferencia() {
		telaTransferencia = new JPanel(new BorderLayout());

		JPanel dadosTransferencia = new JPanel(new GridLayout(8, 1));

		JLabel lbBanco = new JLabel("Banco: ");
		JTextField banco = new JTextField(10);
		JPanel painelBanco = new JPanel();
		painelBanco.add(lbBanco);
		painelBanco.add(banco);

		JLabel lbAgencia = new JLabel("Agencia e Conta: ");
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
		JComboBox cbxFinalidade = new JComboBox<String>();
		cbxFinalidade.addItem("01 - Credito em conta corrente");
		cbxFinalidade.addItem("07 - Pagamentos em geral");
		cbxFinalidade.addItem("12 - Transferencia Internacional");
		cbxFinalidade.addItem("22 - DOC para Poupança");
		cbxFinalidade.addItem("50 - Outros");
		JPanel painelFinalidade = new JPanel();
		painelFinalidade.add(lbFinalidade);
		painelFinalidade.add(cbxFinalidade);

		JLabel lbIdenfificacao = new JLabel("Idenficação: ");
		JTextArea idenficacao = new JTextArea(4, 20);
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
		JButton btnCancelar = new JButton("Cancelar e Voltar ao Menu");
		JPanel painelBotao = new JPanel();
		painelBotao.add(btnTransferir);
		painelBotao.add(btnCancelar);
		btnCancelar.addActionListener(this);

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
		telaPagamento = new JPanel(new BorderLayout());

		JPanel paineis = new JPanel(new GridLayout(4, 1));
		JLabel lbCodigo = new JLabel("Codigo de barras: ");
		JTextField codigoBarras = new JTextField(30);
		JPanel painelCodigo = new JPanel();
		painelCodigo.add(lbCodigo);
		painelCodigo.add(codigoBarras);

		JLabel lbPagamento = new JLabel("Valor do Pagamento: ");
		JTextField valorPagamento = new JTextField(10);
		JPanel painelPagamento = new JPanel();
		painelPagamento.add(lbPagamento);
		painelPagamento.add(valorPagamento);

		JLabel lbIdent = new JLabel("Identificação: ");
		JTextArea identificacao = new JTextArea(4, 20);
		JPanel painelIden = new JPanel();
		painelIden.add(lbIdent);
		painelIden.add(identificacao);

		JButton btnPagar = new JButton("Pagar");
		JButton btnCancelar = new JButton("Cancelar e Voltar ao Menu");
		JPanel painelBotao = new JPanel();
		painelBotao.add(btnPagar);
		painelBotao.add(btnCancelar);

		paineis.add(painelCodigo);
		paineis.add(painelPagamento);
		paineis.add(painelIden);
		paineis.add(painelBotao);

		btnCancelar.addActionListener(this);

		telaPagamento.add(painelSuperior(), BorderLayout.NORTH);
		telaPagamento.add(paineis, BorderLayout.CENTER);
	}

	public void telaRecarga() {
		telaRecarga = new JPanel(new BorderLayout());

		JPanel paineis = new JPanel(new GridLayout(4, 1));

		JPanel painelTel = new JPanel();
		JLabel lbTelefone = new JLabel("DDD e Telefone: ");
		JTextField ddd = new JTextField(2);
		JTextField telefone = new JTextField(8);
		painelTel.add(lbTelefone);
		painelTel.add(ddd);
		painelTel.add(telefone);

		JLabel lbOperadora = new JLabel("Operadora: ");
		JComboBox valorOperadora = new JComboBox<String>();
		valorOperadora.addItem("TIM");
		valorOperadora.addItem("Vivo");
		valorOperadora.addItem("Claro");
		JPanel painelOperadora = new JPanel();
		painelOperadora.add(lbOperadora);
		painelOperadora.add(valorOperadora);

		JLabel lbPagamento = new JLabel("Valor do Pagamento: ");
		JComboBox valorPagamento = new JComboBox<String>();

		// CORRIGIR COMBOBOX
		valorPagamento.addItem(recargaValor((String) valorOperadora.getSelectedItem()));
		valorPagamento.addActionListener(this);
		JPanel painelPagamento = new JPanel();
		painelPagamento.add(lbPagamento);
		painelPagamento.add(valorPagamento);

		JButton btnRecaregar = new JButton("Realizar Recarga");
		JButton btnCancelar = new JButton("Cancelar e Voltar ao Menu");
		JPanel painelBotao = new JPanel();
		painelBotao.add(btnRecaregar);
		painelBotao.add(btnCancelar);

		paineis.add(painelTel);
		paineis.add(painelOperadora);
		paineis.add(painelPagamento);
		paineis.add(painelBotao);
		
		btnCancelar.addActionListener(this);

		telaRecarga.add(painelSuperior(), BorderLayout.NORTH);
		telaRecarga.add(paineis, BorderLayout.CENTER);
	}

	public JComboBox<String> recargaValor(String op) {
		System.out.println(op);
		JComboBox valores = new JComboBox<String>();
		if ("TIM".equals(op)) {
			valores.addItem("R$ 15");
			valores.addItem("R$ 18");
			valores.addItem("R$ 20");
			valores.addItem("R$ 30");
			valores.addItem("R$ 50");
		} else if ("Vivo".equals(op)) {
			valores.addItem("R$ 15");
			valores.addItem("R$ 20");
			valores.addItem("R$ 30");
			valores.addItem("R$ 50");
			valores.addItem("R$ 100");
		} else if ("Claro".equals(op)) {
			valores.addItem("R$ 12");
			valores.addItem("R$ 20");
			valores.addItem("R$ 25");
			valores.addItem("R$ 40");
			valores.addItem("R$ 50");
			valores.addItem("R$ 100");
		}
		return valores;
	}

	public void telaExtrato() {
		telaExtrato = new JPanel(new BorderLayout());
		
		JLabel lbExtrato = new JLabel("<html><center>Extrato atual</html>");
		lbExtrato.setFont(new Font("Segoe UI", Font.BOLD, 20));
		
		JTable extrato = new JTable(listaExtrato);
		
		JButton btnVoltar = new JButton("Voltar ao Menu");
		btnVoltar.setPreferredSize(new Dimension(150, 40));
		JPanel painelBtn = new JPanel();
		painelBtn.add(btnVoltar);
		
		JPanel painelExtrato = new JPanel(new BorderLayout());

		painelExtrato.add(lbExtrato, BorderLayout.NORTH);
		painelExtrato.add(extrato, BorderLayout.CENTER);
		painelExtrato.add(painelBtn, BorderLayout.SOUTH);

		btnVoltar.addActionListener(this);

		telaExtrato.add(painelSuperior(), BorderLayout.NORTH);
		telaExtrato.add(painelExtrato, BorderLayout.CENTER);

	}

	public JPanel painelSuperior() {
		
		JLabel imagem = new JLabel (new ImageIcon(adjustaImagem()));
		
		JPanel superior = new JPanel(new BorderLayout());

		JPanel conteudo = new JPanel(new GridLayout(3, 1));
		JLabel user = new JLabel("Ola, " + conta.getNome());
		JLabel saldo = new JLabel("Saldo: " + String.valueOf(conta.getSaldo()));
		JLabel acc = new JLabel("Agencia: " + conta.getAgencia() + " Conta: " + conta.getConta());
		conteudo.add(user);
		conteudo.add(acc);
		conteudo.add(saldo);

		JPanel painelSair = new JPanel();
		JButton btnSair = new JButton("Sair");
		btnSair.setPreferredSize(new Dimension(150,40));
		painelSair.add(btnSair);
		btnSair.addActionListener(this);

		superior.add(imagem, BorderLayout.WEST);
		superior.add(conteudo, BorderLayout.CENTER);
		superior.add(painelSair, BorderLayout.EAST);
		superior.add(new JSeparator(), BorderLayout.SOUTH);

		return superior;
	}

	public boolean fazerLogin() {

		// System.out.println("TESTE LOGIN " +login.getText());
		conta.setLogin(login.getText());
		// System.out.println("TESTE senha " +senha.getPassword());
		conta.setSenha(senha.toString());
		return controle.acessoConta(conta);
	}
	
	public BufferedImage adjustaImagem() {
		BufferedImage bufImagem = null;
		try {
			bufImagem = ImageIO.read(getClass().getResource("./coin.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BufferedImage imgSize = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2 = imgSize.createGraphics();

	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(bufImagem, 0, 0, 100, 100, null);
	    g2.dispose();
		return imgSize;
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

		if ("Sair".equals(cmd)) {
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
		} else if ("Pagamento".equals(cmd)) {
			telaPagamento();
			telaEscolha.setVisible(false);
			janela.setContentPane(telaPagamento);
			telaPagamento.setVisible(true);

		} else if ("Recarga".equals(cmd)) {
			telaRecarga();
			telaEscolha.setVisible(false);
			janela.setContentPane(telaRecarga);
			telaRecarga.setVisible(true);
		} else if ("Extrato".equals(cmd)) {
			telaExtrato();
			telaEscolha.setVisible(false);
			janela.setContentPane(telaExtrato);
			telaExtrato.setVisible(true);
		} else if ("Cancelar e Voltar ao Menu".equals(cmd) || "Voltar ao Menu".equals(cmd)) {
			telaEscolha();
			janela.setContentPane(telaEscolha);
			telaEscolha.setVisible(true);
			janela.invalidate();
			janela.revalidate();
			janela.repaint();
		}
	}
}
