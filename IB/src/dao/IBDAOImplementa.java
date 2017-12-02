package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Conta;

public class IBDAOImplementa implements IBDAO{

	@Override
	public boolean consultaLogin(Conta conta) {
		Connection conexao = DBUtil.getInstance().getConnection();
		String sql = "";
		try {
			PreparedStatement dados = conexao.prepareStatement(sql);
			dados.setString(1, conta.getLogin());
			//IMPLEMENTAR A TRANSFERENCIA DE SENHA CORRETAMENTE
			dados.setString(2, conta.getSenha());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

			recebeDados(conta);
			return true;

		
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
		String sql = "";

			try {
				PreparedStatement dados = conexao.prepareStatement(sql);
				ResultSet resultado = dados.executeQuery();
				
				while (resultado.next()) {
				conta.setNome(resultado.getString("nome"));
				conta.setCpf(resultado.getString("cpf"));
				conta.setSaldo(resultado.getFloat("saldo"));
				conta.setAgencia(resultado.getInt("agencia"));
				conta.setConta(resultado.getString("conta"));
				
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}


}
