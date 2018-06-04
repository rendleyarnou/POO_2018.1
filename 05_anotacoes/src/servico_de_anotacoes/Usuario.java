package servico_de_anotacoes;

public class Usuario {

	private String username;
	private String password;
	private Repositorio<Nota> notas;

	public Usuario(String username, String password) {
		this.username = username;
		this.password = password;
		this.notas = new Repositorio<Nota>("Notas");
	}

	public boolean addNota(Nota note) {
		if(note == null) {
			throw new RuntimeException("Fail: note nulo.");
		}
		notas.add(note);
		return true;
	}
	
	public boolean rmNota(String titulo) {
		if(titulo == null) {
			throw new RuntimeException("Fail: titulo nulo.");
		}
		for (Nota note : notas.getAll()) {
			if(note.titulo.equals(titulo)) {
				notas.remove(note);
				return true;
			}
		}
		throw new RuntimeException("Fail: nota não existe.");
	}
	
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
	public String getNotas() {
		String saida = "";
		for (Nota nota : notas.getAll()) {
			saida += " Título: " + nota.titulo + "\n" + nota.texto + "\n";
		}
		return saida;
	}
	
	public void setPassword(String oldpass, String newpass) {
		if(this.password == newpass) {
			throw new RuntimeException("Fail: password inválido.");
		}
		if(oldpass == null) {
			throw new RuntimeException("Fail: password nulo.");
		}
		this.password = newpass;
	}

	public boolean matchPassword(String password) {
		return this.password.equals(password);
	}
}
