package servico_de_anotacoes;

public class Sistema {

	private Repositorio<Usuario> usuarios;
	private Usuario user = null;

	public Sistema(Repositorio<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public boolean addUser(String username, String password) {
		if(username == null) {
			throw new RuntimeException("Fail: username nulo.");
		}
		if(password == null) {
			throw new RuntimeException("Fail: password nulo.");
		}
		usuarios.add(new Usuario(username, password));
		return true;
	}
	
	public String getAllUsers() {
		String saida = "";
		for (Usuario user : usuarios.getAll()) {
			saida += user.getUsername() + "\n";
		}
		return saida;
	}
	
	public Usuario getUser(String nome) {
		for (Usuario user : usuarios.getAll()) {
			if(user.getUsername().equals(nome)) {
				return user;
			}
		}
		throw new RuntimeException("Fail: usuario não existe.");
	}

	public void login(String username, String password) {
		if (this.user != null) {
			throw new RuntimeException("Fail: Já existe alguem logado!");
		}
		for (Usuario usuario : usuarios.getAll()) {
			if(!usuario.getUsername().equals(username)) {
				throw new RuntimeException("Fail: usuario não existe.");
			}
			else if(!usuario.matchPassword(password)) {
				throw new RuntimeException("Fail: senha não coincide.");
			}
			if (usuario.getUsername().equals(username) && usuario.matchPassword(password)) {
				this.user = usuario;
			}
		}
	}

	public void logout() {
		if (user == null)
			throw new RuntimeException("Fail: ninguém logado.");
		user = null;
	}

	public Usuario getUser() {
		if (user == null)
			throw new RuntimeException("fail: Ninguém logado!");
		return user;
	}
}
