package agencia_bancaria;

public class Operacao {
	private String descricao;
	private float valor;
	private float saldoParcial;

	// CONSTRUTOR
	public Operacao(String descricao, float valor, float saldoParcial) {
		this.descricao = descricao;
		this.valor = valor;
		this.saldoParcial = saldoParcial;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String toString() {
		return "desc: " + this.descricao + ", value: " + this.valor + ", saldo: " + this.saldoParcial;
	}
}
