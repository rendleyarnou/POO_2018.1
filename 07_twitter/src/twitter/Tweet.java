package twitter;

public class Tweet {

	public int idTweet = 0;
	public String username;
	public String tweet;
	public Repositorio<String> curtidores;
	
	public Tweet(int idTweet, String username, String tweet) {
		this.idTweet = idTweet;
		this.username = username;
		this.tweet = tweet;
	}
	
	public void darLike(String username) {
		if(username == null) {
			throw new RuntimeException("Fail: username nulo");
		}
		curtidores.add(username);
	}
	
	public String getTweet() {
		return tweet;
	}
	
	public int getIdTweet() {
		return idTweet;
	}

	public String toString() {
		return "" +this.idTweet + " " + this.username + ": " + this.tweet + "{" +
				curtidores.getAll() + "}";
	}
}
