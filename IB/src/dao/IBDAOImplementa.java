package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Conta;
import model.Extrato;
import model.Transferencia;

public class IBDAOImplementa implements IBDAO {

	//verificar dados de login
	@Override
	public boolean consultaLogin(Conta conta) {
		Connection conexao = DBUtil.getInstance().getConnection();
		String sql = "SELECT CONVERT(VARCHAR, CPF) AS CPF FROM LOGIN " + "WHERE LOGIN = '" + conta.getLogin()
				+ "' AND SENHA = '" + conta.getSenha() + "'";
		try {
			PreparedStatement dados = conexao.prepareStatement(sql);

			ResultSet resultado = dados.executeQuery();
			String recebido = null;
			while (resultado.next()) {
				recebido = resultado.getString("CPF");
			}
			if (recebido != null) {
				conta.setCpf(recebido);
				recebeDados(conta);
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}
	
	//adicionar cliente no banco de dados	
	@Override
	public void primeiroAcesso(Conta conta) {
		Connection conexao = DBUtil.getInstance().getConnection();
		String acc = "INSERT INTO CLIENTE( CPF, NOME, AGENCIA, CONTA, SALDO) VALUES" + "(?, ?, ?, ?, ?)";
		try {
			PreparedStatement dados = conexao.prepareStatement(acc);
			dados.setString(1, conta.getCpf());
			dados.setString(2, conta.getNome());
			dados.setString(3, conta.getAgencia());
			dados.setString(4, conta.getConta());
			dados.setFloat(5, conta.getSaldo());
			dados.executeUpdate();
		} catch (SQLException e) {
			if (e.toString().contains("Violation of PRIMARY KEY")) {
				JOptionPane.showMessageDialog(null, "CPF JA CADASTRADO");
				return;
			}
			else {
				e.printStackTrace();
			}
			return;
		}

		String lgn = "INSERT INTO LOGIN( LOGIN, SENHA, CPF) VALUES" + "(?, ?, ?)";
		try {
			PreparedStatement dados = conexao.prepareStatement(lgn);
			dados.setString(1, conta.getLogin());
			dados.setString(2, conta.getSenha());
			dados.setString(3, conta.getCpf());
			dados.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}
		JOptionPane.showMessageDialog(null, "USUARIO CADASTRADO!");
	}

	//adicionar transferencia no extrato
	@Override
	public void transferencia(Conta conta, Transferencia destino, String ocorrencia, String identificacao) {
		Connection conexao = DBUtil.getInstance().getConnection();

		String tra = "INSERT INTO EXTRATO(DATAOCORRENCIA, OCORRENCIA, DESCRICAO, VALOR, AGENCIA, CONTA, CPF) VALUES"
				+ "(GETDATE(), ?, ?, ?, ?, ?, ?)";
		// ADICIONA NO EXTRATO DO USUARIO
		try {
			PreparedStatement dados = conexao.prepareStatement(tra);
			dados.setString(1, "Recebido: " + ocorrencia);
			dados.setString(2, identificacao);
			dados.setFloat(3, destino.getValor());
			dados.setString(4, destino.getAgencia());
			dados.setString(5, destino.getConta());
			dados.setString(6, destino.getCpf());
			dados.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}

		// ADICIONA NO EXTRATO DO BENEFICIARIO
		try {
			PreparedStatement dados = conexao.prepareStatement(tra);
			dados.setString(1, "Enviado: " + ocorrencia);
			dados.setString(2, identificacao);
			dados.setFloat(3, destino.getValor());
			dados.setString(4, conta.getAgencia());
			dados.setString(5, conta.getConta());
			dados.setString(6, conta.getCpf());
			dados.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}

		// ATUALIZA O SALDO DO USUARIO
		String upd1 = "UPDATE CLIENTE " + "SET SALDO = " + conta.getSaldo() + "" + "WHERE CPF = '" + conta.getCpf()
				+ "' AND AGENCIA = '" + conta.getAgencia() + "' AND CONTA = '" + conta.getConta() + "'";
		try {
			PreparedStatement dados = conexao.prepareStatement(upd1);
			dados.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// ATUALIZA O SALDO DO BENEFICIARIO
		String upd2 = "UPDATE CLIENTE " + "SET SALDO = SALDO + " + destino.getValor() + "" + "WHERE CPF = '"
				+ destino.getCpf() + "' AND AGENCIA = '" + destino.getAgencia() + "' AND CONTA = '" + destino.getConta()
				+ "'";
		try {
			PreparedStatement dados = conexao.prepareStatement(upd2);
			dados.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		JOptionPane.showMessageDialog(null, "TRANSFERENCIA CONCLUIDA COM SUCESSO!");
	}

	//realizar pagamento
	@Override
	public void pagamento(Float valor, Conta conta, String identificacao) {
		Connection conexao = DBUtil.getInstance().getConnection();
		String pag = "UPDATE CLIENTE "
		+ "SET SALDO = "+ conta.getSaldo()
		+ " WHERE CPF = '" + conta.getCpf() +"'";
		try {
			PreparedStatement dados = conexao.prepareStatement(pag);
			dados.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String ext = "INSERT INTO EXTRATO (DATAOCORRENCIA, OCORRENCIA, DESCRICAO, VALOR, AGENCIA, CONTA, CPF) VALUES "
				+ "(GETDATE(), 'PAGAMENTO POR CODIGO DE BARRAS', ?, ?, ?, ?, ?)";
		try {
			PreparedStatement dados = conexao.prepareStatement(ext);
			dados.setString(1, identificacao);
			dados.setFloat(2, valor);
			dados.setString(3, conta.getAgencia());
			dados.setString(4, conta.getConta());
			dados.setString(5, conta.getCpf());
			dados.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//recebe dados do cliente por cpf
	@Override
	public void recebeDados(Conta conta) {
		Connection conexao = DBUtil.getInstance().getConnection();
		String sql = "SELECT * FROM CLIENTE " + "WHERE CPF = '" + conta.getCpf() + "'";
		try {
			PreparedStatement dados = conexao.prepareStatement(sql);
			ResultSet resultado = dados.executeQuery();
			while (resultado.next()) {
				conta.setNome(resultado.getString("nome"));
				conta.setCpf(resultado.getString("cpf"));
				conta.setSaldo(resultado.getFloat("saldo"));
				conta.setAgencia(resultado.getString("agencia"));
				conta.setConta(resultado.getString("conta"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//recebe extrato do cliente
	@Override
	public List<Extrato> extrato(Conta conta) {
		Connection conexao = DBUtil.getInstance().getConnection();
		String ext = "SELECT * FROM EXTRATO " + "WHERE CPF = '" + conta.getCpf() + "'";

		List<Extrato> temp = new ArrayList<Extrato>();

		try {
			PreparedStatement dados = conexao.prepareStatement(ext);
			ResultSet resultado = dados.executeQuery();

			while (resultado.next()) {
				Extrato extrato = new Extrato();
				extrato.setData(resultado.getString("DATAOCORRENCIA"));
				extrato.setOcorrencia(resultado.getString("OCORRENCIA"));
				extrato.setDescricao(resultado.getString("DESCRICAO"));
				extrato.setValor(resultado.getFloat("VALOR"));
				extrato.setAgencia(resultado.getString("AGENCIA"));
				extrato.setConta(resultado.getString("CONTA"));
				extrato.setCpf(resultado.getString("CPF"));
				temp.add(extrato);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return temp;
	}
	
	//busca nome do clente
	@Override
	public String buscaUsuario (Transferencia destino) {
		System.out.println(destino.getConta() + " - " + destino.getAgencia() + " - " +  destino.getCpf());
		Connection conexao = DBUtil.getInstance().getConnection();
		String ext = "SELECT NOME FROM CLIENTE "
			+ "WHERE CONTA  = '" + destino.getConta() + "' AND AGENCIA  = '" + destino.getAgencia() + "' AND CPF = '"+ destino.getCpf() +"'";
		try {
			PreparedStatement dados = conexao.prepareStatement(ext);
			ResultSet resultado = dados.executeQuery();
			String nome = null;
			while (resultado.next()) {
				nome = resultado.getString("nome");
			}
			return nome;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//realiza recarga e atualiza saldo
	@Override
	public void recarga(Conta conta, String ocorrencia, Float valor) {
		Connection conexao = DBUtil.getInstance().getConnection();
		String pag = "UPDATE CLIENTE "
		+ "SET SALDO = "+ conta.getSaldo()
		+ " WHERE CPF = '" + conta.getCpf() +"'";
		try {
			PreparedStatement dados = conexao.prepareStatement(pag);
			dados.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String ext = "INSERT INTO EXTRATO (DATAOCORRENCIA, OCORRENCIA, DESCRICAO, VALOR, AGENCIA, CONTA, CPF) VALUES "
				+ "(GETDATE(), ?, NULL, ?, ?, ?, ?)";
		try {
			PreparedStatement dados = conexao.prepareStatement(ext);
			dados.setString(1, ocorrencia);
			dados.setFloat(2, valor);
			dados.setString(3, conta.getAgencia());
			dados.setString(4, conta.getConta());
			dados.setString(5, conta.getCpf());
			dados.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
