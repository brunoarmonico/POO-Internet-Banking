package dao;

import java.util.List;

import model.Conta;
import model.Extrato;
import model.Transferencia;

public interface IBDAO {
	boolean consultaLogin(Conta conta);
	
	void primeiroAcesso(Conta conta);
	
	void transferencia(Conta conta, Transferencia destino, String ocorrencia, String identificacao);
	
	void pagamento(Float valor, Conta conta, String identificacao);
	
	void recebeDados(Conta conta);
	
	List <Extrato> extrato (Conta conta);
	
	String buscaUsuario (Transferencia destino);
}
