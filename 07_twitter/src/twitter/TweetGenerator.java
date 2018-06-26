package twitter;

public class TweetGenerator {
	
	public int idTweet = 0;
	
	public void addTweet(String username, Tweet tweet) {
		if(username == null) {
			throw new RuntimeException("Fail: nome de usuario nulo.");
		}
		if(tweet == null) {
			throw new RuntimeException("Fail: tweet nulo.");
		}
		for(Usuario user : Controller.cUsers.getAll()) {
			if(user.getUsername().equals(username)) {
				Controller.cUsers.get(user.getUsername()).tweetar(tweet);
			}
		}
	}

}
