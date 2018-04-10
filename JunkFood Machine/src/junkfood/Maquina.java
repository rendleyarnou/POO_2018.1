package junkfood;

import java.util.ArrayList;
import java.util.List;

public class Maquina {

	public List<Espiral> espirais;
	public float saldoCliente;
	public float lucro;

	public Maquina(int qtdEspirais) {
		this.saldoCliente = 0.0f;
		this.lucro = 0.0f;
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
			return false;
		}
	}

	public boolean alterarEspiral(int indice, String nome, int qtd, float preco) {
		if (indice < espirais.size()) {
			this.espirais.get(indice).setNome(nome);
			this.espirais.get(indice).setPreco(preco);
			this.espirais.get(indice).setQtd(qtd);
			return true;
		}
		return false;
	}
	
	public boolean resetar(int indice) {
		if(this.espirais.get(indice) != null) {
			this.espirais.get(indice).setNome(" - ");
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
		String saida = "";
		for (int i = 0; i < this.espirais.size(); i++) {
			saida += i + " " + this.espirais.get(i) + " Saldo: " + this.saldoCliente + "\n";
		}
		return saida;
	}
}
