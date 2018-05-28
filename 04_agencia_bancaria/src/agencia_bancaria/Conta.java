package agencia_bancaria;

public class Conta {
	public static int ultIdConta = 0;

	private float saldo;
	private int numero;
	private Repositorio<Operacao> extrato;
	private boolean ativa;

	// CONSTRUTOR
	public Conta(int numero) {
		this.numero = numero;
		this.saldo = 0;
		this.extrato = new Repositorio<Operacao>("Extrato");
		this.ativa = true;
	}

	// DEPOSITAR
	public boolean depositar(float valor) {
		if (valor <= 0) {
			throw new RuntimeException("Fail: valor negativo ou igual a zero.");
		}
		if(!ativa) {
			throw new RuntimeException("Fail: conta destivada.");
		}
		this.saldo += valor;
		this.extrato.add(new Operacao("Deposito", valor, this.saldo));
		return true;
	}

	// SACAR
	public boolean sacar(float valor) {
		if (valor <= 0) {
			throw new RuntimeException("Fail: valor negativo ou igual a zero.");
		}
		if (valor > saldo) {
			throw new RuntimeException("Fail: valor maior que o saldo.");
		}
		this.saldo -= valor;
		this.extrato.add(new Operacao("Saque", valor, this.saldo));
		return true;
	}

	// TRANSFERIR
	public boolean transferir(Conta other, float valor) {
		if (!other.isAtiva()) {
			throw new RuntimeException("Fail: a conta destino está inativa.");
		}
		if (this.sacar(valor)) {
			other.depositar(valor);
			this.extrato.add(new Operacao("Transferência", valor, this.saldo));
			return true;
		}
		return false;
	}

	// ENCERRAR
	public void encerrar() {
		this.ativa = false;
	}

	public float getSaldo() {
		return saldo;
	}

	public int getNumero() {
		return numero;
	}

	public String getExtrato() {
		String saida = " ";
		for (Operacao oper : extrato.getAll()) {
			saida += oper.toString() + "\n";			
		}
		return saida;
	}

	public boolean isAtiva() {
		return ativa;
	}

	public String toString() {		
		return "Conta: " + numero + "|Saldo: " + saldo + "|Status: " + ativa;
	}
}
