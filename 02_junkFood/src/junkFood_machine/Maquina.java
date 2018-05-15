package junkFood_machine;

import java.util.ArrayList;
import java.util.List;

public class Maquina {

	public List<Espiral> espirais;
	public float saldoCliente;
	public float lucro;
	public int max_prod = 0;

	public Maquina(int qtdEspirais, int max_prod) {
		this.saldoCliente = 0.0f;
		this.lucro = 0.0f;
		this.max_prod = max_prod;
		this.espirais = new ArrayList<Espiral>();
		for (int i = 0; i < qtdEspirais; i++) {
			this.espirais.add(new Espiral("-", 0, 0));
		}
	}

	public boolean vender(int indice) {
		if (indice < espirais.size() && this.saldoCliente > espirais.get(indice).getPreco()) {
			this.saldoCliente -= espirais.get(indice).getPreco();
			this.lucro += espirais.get(indice).getPreco();
			this.espirais.get(indice).setQtd(this.espirais.get(indice).getQtd() - 1);
			System.out.println("Item " + espirais.get(indice).getNome() + " comprado com sucesso");
			return true;
		} else {
			throw new RuntimeException("Fail: Produto não existe!");

		}
	}

	public boolean alterarEspiral(int indice, String nome, int qtd, float preco) {
		if (indice < espirais.size()) {
			if (qtd <= max_prod) {
				this.espirais.get(indice).setNome(nome);
				this.espirais.get(indice).setPreco(preco);
				this.espirais.get(indice).setQtd(qtd);
				return true;
			}
			throw new RuntimeException(" Fail: limite de produtos eh " + max_prod + " por espiral!");
		}
		throw new RuntimeException("Fail: espiral " + indice + " não existe!");
	}

	public boolean resetar(int indice) {
		if (this.espirais.get(indice) != null) {
			this.espirais.get(indice).setNome("-");
			this.espirais.get(indice).setPreco(0);
			this.espirais.get(indice).setQtd(0);
			return true;
		}
		return false;
	}

	public boolean inserirDinheiro(float valor) {
		if (valor > 0) {
			saldoCliente += valor;
			return true;
		} else {
			return false;
		}
	}

	public float getSaldo() {
		return this.getSaldo();
	}

	public String toString() {
		String saida = "Saldo: " + this.saldoCliente + "\n";
		for (int i = 0; i < this.espirais.size(); i++) {
			saida += i + " " + this.espirais.get(i) + "\n";
		}
		return saida;
	}
}
