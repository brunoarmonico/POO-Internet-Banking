package controller;

import dao.IBDAOImplementa;
import model.Conta;
import model.Extrato;
import model.Transferencia;

public class ControleIB {
	private static IBDAOImplementa dao = new IBDAOImplementa();
	private static Conta conta = new Conta();

	public void criarConta(Conta conta) {
		dao.primeiroAcesso(conta);
		return;
	}
	
	public boolean gerenciaSaldo(Float valor) {
		return conta.modificaSaldo(valor);
	}
	
	public boolean acessoConta(Conta dados) {
		return dao.consultaLogin(dados);
	}
	
	public void transferirValor(Conta conta, Transferencia destino, String ocorrencia, String identificacao) {
		dao.transferencia(conta, destino, ocorrencia, identificacao);
	}
	
	public void pagarConta(Float valor, Conta conta, String identificacao) {
		dao.pagamento(valor, conta, identificacao);
	}
	
	public String verificaConta (Transferencia destino) {
		return dao.buscaUsuario(destino);
	}
	
	public void realizarRecarga(Conta conta, String ocorrencia, Float valor) {
		dao.recarga(conta, ocorrencia, valor);
	}
}