package clinica_veterinaria;

public class Cliente {
	
	private String idCli;
	private String nome;
	private Repository<Animal> animais;
	
	public Cliente(String nome, String idCli) {
		this.nome = nome;
		this.idCli = idCli;
		this.animais = new Repository<Animal>("Animais");
	}
	
	public void addAni(Animal ani) {
		if(ani == null) {
			throw new RuntimeException("Fail: animal nulo.");
		}
		animais.add(ani);
	}

	public String getIdCli() {
		return idCli;
	}

	public String getNome() {
		return nome;
	}

	public String getAnimais() {
		String saida = "";
		for (Animal ani : animais.getAll()) {
			saida += ani.toString() + " | ";
		}
		return saida;
	}

	public String toString() {
		return "Cli " + this.idCli + ": " + this.nome;
	}
}
