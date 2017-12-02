package dao;

public interface IBDAO {
	boolean consultaLogin();
	
	void primeiroAcesso();
	
	void transferencia();
	
	void pagamento();
}
