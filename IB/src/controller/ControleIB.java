package controller;

import dao.IBDAOImplementa;
import model.Conta;
import model.Extrato;
import model.Transferencia;

public class ControleIB {
	private static IBDAOImplementa bd = new IBDAOImplementa();
	private static Conta conta = new Conta();

	public void criarConta(Conta conta) {
		bd.primeiroAcesso(conta);
		return;
	}
	
	public boolean gerenciaSaldo(Float valor) {
		return conta.modificaSaldo(valor);
	}
	
	public boolean acessoConta(Conta dados) {
		return bd.consultaLogin(dados);
	}
	
	public void transferirValor(Conta conta, Transferencia destino, String ocorrencia, String identificacao) {
		bd.transferencia(conta, destino, ocorrencia, identificacao);
	}
	
	public void pagarConta(Float valor, Conta conta, String identificacao) {
		bd.pagamento(valor, conta, identificacao);
	}
	
	public String verificaConta (Transferencia destino) {
		return bd.buscaUsuario(destino);
	}
}