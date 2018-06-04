package clinica_veterinaria;

public class Servico {

	public int idSer = 0;
	public String nome;
	public float valor;

	public Servico(int idSer, String nome, float valor) {
		this.idSer = idSer;
		this.nome = nome;
		this.valor = valor;
	}

	public int getIdSer() {
		return idSer;
	}

	public String getNome() {
		return nome;
	}

	public float getValor() {
		return valor;
	}

	public String toString() {
		return "" + this.idSer + this.nome + " R$:" + this.valor;
	}
}
