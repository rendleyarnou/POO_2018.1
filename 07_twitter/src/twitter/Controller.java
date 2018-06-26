package twitter;

public class Controller {
	
	static Repositorio<Tweet> cTweets;
	static Repositorio<Usuario> cUsers;
	
	public Controller() {
		Controller.cTweets = new Repositorio<Tweet>("Tweets");
		Controller.cUsers = new Repositorio<Usuario>("Usuários");
	}
	
	public Usuario getUser(String nome) {
		if(nome == null) {
			throw new RuntimeException("Fail: username inválido.");
		}
		for(Usuario user : cUsers.getAll()) {
			if(user.getUsername().equals(nome)) {
				return user;
			}
		}
		throw new RuntimeException("Fail: usuário não existe.");
	}
}
