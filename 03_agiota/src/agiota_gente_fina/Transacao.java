package agiota_gente_fina;

public class Transacao {
	private int idTrans;
	private String nomeCli;
	private float valor;

	public Transacao(int idTrans, String nomeCli, float valor) {
		this.idTrans = idTrans;
		this.nomeCli = nomeCli;
		this.valor = valor;
	}

	public int getIdTrans() {
		return idTrans;
	}

	public String getNomeCli() {
		return nomeCli;
	}

	public float getValor() {
		return valor;
	}

	public String toString() {
		return "id:" + this.idTrans + " [" + this.nomeCli + " " + this.valor + "]" + "\n";
	}
}
