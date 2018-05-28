package agencia_bancaria;

import javax.management.RuntimeErrorException;

public class Cliente {
	private String idCliente;
	private Repositorio<Conta> contas;
	int qtd = 0;

	//CONSTRUTOR
	public Cliente(String idCliente) {
		this.idCliente = idCliente;
		this.contas = new Repositorio<Conta>("Contas");
		this.contas.add(new Conta(Conta.ultIdConta+=1));
	}

	//ADICIONAR CONTA
	public boolean addConta(Conta conta) {
		if (conta == null) {
			throw new RuntimeException("Fail: " + conta +" nula!");
		}
		for (Conta c : contas.getAll()) {
			if (c.isAtiva()) {
				qtd+=1;
			}
		}
		if (qtd >= 2) {
			throw new RuntimeException("Fail: limite de contas atingido!");
		}
		this.contas.add(conta);
		return true;
	}

	//ENCERRAR CONTA
	public boolean encerrarConta(int numero) {
		for (Conta c : contas.getAll()) {
			if (c.getNumero() == numero) {
				if (c.getSaldo() == 0) {
					c.encerrar();
					return true;
				}
			}
		}
		throw new RuntimeException("Fail: conta com saldo não nulo!");
	}

	public String getIdCliente() {
		return idCliente;
	}

	public Repositorio<Conta> getContas() {
		return contas;
	}
	
	//MÉTODO EQUALS
	public boolean equals(Cliente cli) {
		return cli.getIdCliente().equals(this.getIdCliente());
	}
}
