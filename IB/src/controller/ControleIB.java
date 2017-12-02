package controller;

import dao.IBDAOImplementa;
import model.Conta;

public class ControleIB {
	private IBDAOImplementa bd = new IBDAOImplementa();

	public void criarConta() {
		
	}
	
	public boolean acessoConta(Conta dados) {
		bd.consultaLogin(dados);
		return false;
	}
	
	public void verExtrato() {
		
	}
	
	public void transferirValor() {
		
	}
	
	public void pagarConta() {
		
	}
}
