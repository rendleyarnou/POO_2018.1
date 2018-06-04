package servico_de_anotacoes;

public class Nota {

	public String titulo;
	public String texto;
	
	public Nota(String titulo, String texto) {
		this.titulo = titulo;
		this.texto = texto;
	}
	
	public String toString() {
		return "" + this.titulo + "\n" + this.texto;
	}
}
