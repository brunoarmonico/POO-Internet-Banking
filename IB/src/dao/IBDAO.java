package dao;

import model.Conta;

public interface IBDAO {
	boolean consultaLogin(Conta conta);
	
	void primeiroAcesso();
	
	void transferencia();
	
	void pagamento();
	
	void recebeDados(Conta conta);
}
