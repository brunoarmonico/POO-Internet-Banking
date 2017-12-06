package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import dao.IBDAOImplementa;
import model.Conta;
import model.Extrato;

public class lstExtrato implements TableModel {
	private List<Extrato> lista = new ArrayList<Extrato>();
	private IBDAOImplementa bd = new IBDAOImplementa();

	public List<Extrato> verExtrato(Conta conta) {
		List<Extrato> tabela = bd.extrato(conta);
		this.lista = tabela;
		return tabela;
	}

	@Override
	public void addTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public Class<?> getColumnClass(int coluna) {
		// TODO Auto-generated method stub
		switch (coluna) {
		case 0:
			return String.class;
		case 1:
			return String.class;
		case 2:
			return String.class;
		case 3:
			return String.class;
		case 4:
			return String.class;
		case 5:
			return String.class;
		case 6:
			return String.class;
		}
		return String.class;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 7;
	}

	@Override
	public String getColumnName(int coluna) {
		// TODO Auto-generated method stub
		switch (coluna) {
		case 0:
			return "Data da Ocorrencia";
		case 1:
			return "Ocorrencia";
		case 2:
			return "Descrição";
		case 3:
			return "Valor";
		case 4:
			return "Agencia";
		case 5:
			return "Conta";
		case 6:
			return "CPF";
		}
		return "";
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return lista.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		Extrato ext = lista.get(linha);
		// TODO Auto-generated method stub
		switch (coluna) {
		case 0:
			return ext.getData();
		case 1:
			return ext.getOcorrencia();
		case 2:
			return ext.getDescricao();
		case 3:
			return ext.getValor();
		case 4:
			return ext.getAgencia();
		case 5:
			return ext.getConta();
		case 6:
			return ext.getCpf();
		}
		return "";
	}

	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setValueAt(Object arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

}
