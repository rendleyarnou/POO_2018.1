package contato_telefonico;

public class Telefone {
	public String foneId;
	public int numero;
	//CONSTRUTOR
	public Telefone(String foneId, int numero) {
		this.foneId = foneId;
		this.numero = numero;
	}
	public String getFoneId() {
		return foneId;
	}
	public void setFoneId(String foneId) {
		this.foneId = foneId;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public String toString() {
		return "[" + this.foneId + ":" + this.numero + "]";
	}
}
