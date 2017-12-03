package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Conta;

public class IBDAOImplementa implements IBDAO {

	@Override
	public boolean consultaLogin(Conta conta) {	
		Connection conexao = DBUtil.getInstance().getConnection();
		
		String sql = "SELECT CASE" 
		+ "WHEN LOGIN = '?' AND SENHA = '?'"
				+ "THEN 1" 
				+ "ELSE 0" 
		+ "END AS RESULTADO"
				+ "FROM LOGIN"
		+ "WHERE LOGIN = '?' AND SENHA = '?'";
		try {
			PreparedStatement dados = conexao.prepareStatement(sql);
			dados.setString(1, conta.getLogin());
			dados.setString(2, conta.getSenha());
			dados.setString(3, conta.getLogin());
			dados.setString(4, conta.getSenha());

			ResultSet resultado = dados.executeQuery();
			int x = resultado.getInt("RESULTADO");
			if (x == 1) {
//				recebeDados(conta);
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
	public void primeiroAcesso() {
		// TODO Auto-generated method stub

	}

	@Override
	public void transferencia() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pagamento() {
		// TODO Auto-generated method stub

	}

	@Override
	public void recebeDados(Conta conta) {
		// TODO Auto-generated method stub
		Connection conexao = DBUtil.getInstance().getConnection();
		String sql = "SELECT * FROM CLIENTE";

		try {
			PreparedStatement dados = conexao.prepareStatement(sql);
			ResultSet resultado = dados.executeQuery();

//			while (resultado.next()) {
//				conta.setNome(resultado.getString("nome"));
//				conta.setCpf(resultado.getString("cpf"));
//				conta.setSaldo(resultado.getFloat("saldo"));
//				conta.setAgencia(resultado.getInt("agencia"));
//				conta.setConta(resultado.getString("conta"));
//
//			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
