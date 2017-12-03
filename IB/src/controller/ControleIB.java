package controller;

import dao.IBDAOImplementa;
import model.Conta;

public class ControleIB {
	private static IBDAOImplementa bd = new IBDAOImplementa();
	private static Conta conta = new Conta();

	public void criarConta() {
		
	}
	
	public boolean gerenciaSaldo(Float valor) {
		return conta.modificaSaldo(valor);
	}
	
	public boolean acessoConta(Conta dados) {
		return true;
//		return bd.consultaLogin(dados);
	}
	
	public void verExtrato() {
		
	}
	
	public void transferirValor() {
		
	}
	
	public void pagarConta() {
		
	}
}
