package dao;

import java.sql.Connection;

public class IBDAOImplementa implements IBDAO{

	@Override
	public boolean consultaLogin() {
		Connection conexao = DBUtil.getInstance().getConnection();
		return false;
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

}
