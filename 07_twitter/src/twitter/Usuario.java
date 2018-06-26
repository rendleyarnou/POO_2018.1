package twitter;

public class Usuario {

	public String username;
	public Repositorio<Usuario> seguidores;
	public Repositorio<Usuario> seguidos;
	public Repositorio<Tweet> timeLine;
	public Repositorio<Tweet> meusTweets;
	public int naoLidos;

	public Usuario(String username) {
		this.username = username;
		this.seguidores = new Repositorio<Usuario>("Seguidores");
		this.seguidos = new Repositorio<Usuario>("Seguidos");
		this.timeLine = new Repositorio<Tweet>("TimeLine");
		this.meusTweets = new Repositorio<Tweet>("Minhas Mensagens");
		this.naoLidos = 0;
	}

	public void seguir(Usuario usuario) {
		if (usuario == null) {
			throw new RuntimeException("Fail: usuario nulo.");
		}
		this.seguidos.add(usuario);
		usuario.seguidores.add(this);
	}

	public void tweetar(Tweet tweet) {
		this.meusTweets.add(tweet);
		for (Usuario user : seguidores.getAll()) {
			this.naoLidos += 1;
			user.timeLine.add(tweet);
		}
	}

	public String darLike(int idTweet) {
		for (Tweet tweet : Controller.cTweets.getAll()) {
				tweet.darLike(this.username);
				return "Done";
		}
		return "Fail.";
	}

	public String getUnread() {
		String saida = "";
		if (naoLidos == 0) {
			throw new RuntimeException("Fail: todas os tweets foram lidas.");
		}
		for (Tweet tweet : this.meusTweets.getAll()) {
			saida += tweet.toString() + "\n";
			this.naoLidos = 0;
			this.meusTweets = new Repositorio<Tweet>("MeusTweets");
		}
		return saida;
	}

	public String getUsername() {
		return this.username;
	}

	public String getAllSeguidores() {
		String saida = "[";
		for (Usuario seguidor : this.seguidores.getAll()) {
			saida += seguidor.username + " ";
		}
		return saida + "]";
	}

	public String getAllSeguidos() {
		String saida = "[";
		for (Usuario seguido : this.seguidos.getAll()) {
			saida += seguido.username + " ";
		}
		return saida + "]";
	}

	public String getTimeLine() {
		String saida = "";
		for (Tweet tweet : timeLine.getAll()) {
			saida += tweet.toString() + "\n";
			naoLidos = 0;
		}
		return saida;
	}

	public String getmeusTweets() {
		String saida = "";
		for (Tweet tweet : meusTweets.getAll()) {
			saida += tweet.toString() + "\n";
		}
		return saida;
	}

	public String toString() {
		return "" + "\n  Seguidos " + this.getAllSeguidos() + "\n  Seguidores " + this.getAllSeguidores();
	}
}
