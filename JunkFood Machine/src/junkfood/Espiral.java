package junkfood;

public class Espiral {

	public String nome;
	public int qtd;
	public float preco;

	public Espiral(String nome, int qtd, float preco) {
		this.nome = nome;
		this.qtd = qtd;
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public String toString() {
		return " " + this.nome + " : " + this.qtd + " U" + " : " + this.preco + " R$ ";
	}

}
