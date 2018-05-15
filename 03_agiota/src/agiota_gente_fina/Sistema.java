package agiota_gente_fina;

import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private float saldoSis;
	private List<Cliente> clientes;
	private int idTrans = 0;
	private ArrayList<Transacao> extrato;

	public Sistema(float saldo) {
		this.saldoSis = saldo;
		this.clientes = new ArrayList<Cliente>();
		this.extrato = new ArrayList<Transacao>();
	}

	public float getSaldoSis() {
		return this.saldoSis;
	}

	public int getIdTrans() {
		return idTrans;
	}

	public Cliente getCli(String nome) {
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getClienteID().equals(nome)) {
				return clientes.get(i);
			}
		}
		throw new RuntimeException("Fail: Cliente não existe!");
	}

	public String latran() {
		String saida = "";
		for (Transacao ext : extrato) {
			saida += ext.toString();
		}
		return saida;
	}

	public String lacli() {
		String saida = "";
		for (int i = 0; i < clientes.size(); i++) {
			saida += clientes.get(i).getNome() + " " + clientes.get(i).getSaldo() + "\n";
		}
		return saida;
	}

	public boolean addCli(String cliId, String nome) {
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getClienteID().equals(cliId)) {
				throw new RuntimeException("Fail: " + cliId + " já existe!");
			}
		}
		clientes.add(new Cliente(cliId, nome));
		return true;
	}

	public boolean killCli(String nome) {
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getClienteID().equals(nome)) {
				clientes.remove(i);
				return true;
			}
		}
		throw new RuntimeException("Fail: " + nome + " não encontrado!");
	}

	public boolean emprestar(String cliId, float valor) {
		if (valor < 0) {
			throw new RuntimeException("Fail: Valor menor que 0!");
		}
		if (valor > this.saldoSis) {
			throw new RuntimeException("Fail: Valor acima do permitido!");
		}
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getClienteID().equals(cliId)) {
				extrato.add(new Transacao(this.idTrans, cliId, -valor));
				clientes.get(i).setSaldo(clientes.get(i).getSaldo() + (-valor));
				;
				this.saldoSis -= valor;
				this.idTrans++;
				return true;
			}
		}
		throw new RuntimeException("Fail: Cliente não encontrado!");
	}

	public boolean receber(String cliId, float valor) {
		if (valor < 0) {
			throw new RuntimeException("Fail: Valor menor que 0!");
		}
		if (valor > this.saldoSis) {
			throw new RuntimeException("Fail: valor maior que divida!");
		}
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getClienteID().equals(cliId)) {
				extrato.add(new Transacao(this.idTrans, cliId, valor));
				clientes.get(i).setSaldo(clientes.get(i).getSaldo() + valor);
				this.saldoSis += valor;
				this.idTrans++;
				return true;
			}
		}
		throw new RuntimeException("Fail: Cliente não encontrado!");
	}

	public String toString() {
		String saida = "";

		for (Cliente cliente : clientes) {
			saida += cliente.toString() + "\n";
		}
		return saida;
	}
}
