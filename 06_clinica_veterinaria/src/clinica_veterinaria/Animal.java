package clinica_veterinaria;

public class Animal {

	public int idAni = 0;
	public String nome;
	public String especie;
	public Cliente dono;

	public Animal(int idAni, String nome, String especie) {
		this.idAni = idAni;
		this.nome = nome;
		this.especie = especie;
	}
	
	public Cliente getDono() {
		return dono;
	}

	public void setDono(Cliente dono) {
		this.dono = dono;
	}

	public String toString() {
		return "[" + this.idAni + " : " + this.nome + " : " + this.especie + "]";
	}
}
