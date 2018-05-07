package agiota_gente_fina;

import java.util.ArrayList;
import java.util.List;

public class Sistema {

	private float saldoSis;
	private List<Cliente> clientes;
	private int idTrans;

	public Sistema(float saldo) {
		this.saldoSis = saldo;
		this.clientes = new ArrayList<Cliente>();
		this.idTrans = 0;
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

	// ADICIONAR CLIENTE
	public boolean addCli(String cliId, String nome) {
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getClienteID().equals(cliId)) {
				throw new RuntimeException("Fail: " + cliId + " já existe!");
			}

			/*
			 * else if(clientes.get(i).getNome().equals(nome)) { throw new
			 * RuntimeException("Fail: " + nome + " já existe!"); }
			 */

		}
		clientes.add(new Cliente(cliId, nome));
		return true;
	}

	// MATAR CLIENTE
	public boolean killCli(String nome) {
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getClienteID().equals(nome)) {
				clientes.remove(i);
				return true;
			}
		}
		throw new RuntimeException("Fail: " + nome + " Não encontrado!");
	}

	// EMPRESTAR DINHEIRO
	public boolean emprestar(String cliId, float valor) {

		if (valor < 0) {
			throw new RuntimeException("Fail: Valor menor que 0!");
		}
		if(valor > this.saldoSis) {
			throw new RuntimeException("Fail: Valor acima do permitido!");
		}
		
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getClienteID().equals(cliId)) {
					this.saldoSis -= valor;
					clientes.get(i).setSaldo((clientes.get(i).getSaldo() + valor) * (-1));
					this.idTrans++;
					return true;
			}
		}
		throw new RuntimeException("Fail: Cliente não encontrado!");
	}

	// RECEBER DINHEIRO
	public boolean receber(String cliId, float valor) {
		if (valor < 0) {
			throw new RuntimeException("Fail: Valor menor que 0!");
		}
		
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getClienteID().equals(cliId)) {
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
			saida += cliente.toString();
		}
		return saida;
	}

}
