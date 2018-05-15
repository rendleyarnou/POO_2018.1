package agiota_gente_fina;

public class Cliente {
	public String clienteID;
	private String nome;
	public boolean vivo = true;
	private float saldo;

	public Cliente(String clienteID, String nome) {
		this.clienteID = clienteID;
		this.nome = nome;
		this.saldo = 0;
	}

	public String getClienteID() {
		return clienteID;
	}

	public String getNome() {
		return this.nome;
	}

	public boolean isVivo() {
		return vivo;
	}

	public float getSaldo() {
		return this.saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}

	public String toString() {
		return " [" + clienteID + " " + this.getSaldo() + "]";
	}
}
