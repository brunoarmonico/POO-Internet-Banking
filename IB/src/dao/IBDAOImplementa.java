package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.Conta;

public class IBDAOImplementa implements IBDAO {

	@Override
	public boolean consultaLogin(Conta conta) {	
		Connection conexao = DBUtil.getInstance().getConnection();
		String sql = "SELECT CONVERT(VARCHAR, CPF) AS CPF FROM LOGIN "
				+"WHERE LOGIN = '"+ conta.getLogin() +"' AND SENHA = '"+ conta.getSenha() +"'";
		try {
			PreparedStatement dados = conexao.prepareStatement(sql);
		

			ResultSet resultado = dados.executeQuery();
			String x = null;
			while (resultado.next()) {
			x = resultado.getString("CPF");
			}
			if (x != null) {
				conta.setCpf(x);
				recebeDados(conta);
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public void primeiroAcesso(Conta conta) {
		// TODO Auto-generated method stub
		Connection conexao = DBUtil.getInstance().getConnection();
		String acc = "INSERT INTO CLIENTE( CPF, NOME, AGENCIA, CONTA, SALDO) VALUES"
				+"(?, ?, ?, ?, ?)";
		try {
			PreparedStatement dados = conexao.prepareStatement(acc);
			dados.setString(1, conta.getCpf());
			dados.setString(2, conta.getNome());
			dados.setString(3, conta.getAgencia());
			dados.setString(4, conta.getConta());
			dados.setFloat(5, conta.getSaldo());
			dados.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		
		String lgn = "INSERT INTO LOGIN( LOGIN, SENHA, CPF) VALUES"
				+"(?, ?, ?)";
		try {
			PreparedStatement dados = conexao.prepareStatement(lgn);
			dados.setString(1, conta.getLogin());
			dados.setString(2, conta.getSenha());
			dados.setString(3, conta.getCpf());
			dados.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		JOptionPane.showMessageDialog(null, "USUARIO CADASTRADO!");
	}

	@Override
	public void transferencia() {
		// TODO Auto-generated method stub
		Connection conexao = DBUtil.getInstance().getConnection();
	}

	@Override
	public void pagamento() {
		// TODO Auto-generated method stub
		Connection conexao = DBUtil.getInstance().getConnection();
	}

	@Override
	public void recebeDados(Conta conta) {
		// TODO Auto-generated method stub
		Connection conexao = DBUtil.getInstance().getConnection();
		String sql = "SELECT * FROM CLIENTE "
				+"WHERE CPF = '"+ conta.getCpf() +"'";

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
