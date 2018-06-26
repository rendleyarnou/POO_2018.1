package twitter;

import java.util.Scanner;

/*

nwuser goku
nwuser sara
nwuser tina
lauser
seguir goku sara
seguir goku tina
seguir sara tina
lauser
twittar sara hoje estou triste
twittar tina ganhei chocolate
twittar sara partiu ru
twittar tina chocolate ruim
twittar goku internet maldita
timeline goku
myTweets goku
timeline tina
myTweets sara
unread sara
unread sara
twittar tina eu
twittar tina amo
twittar tina chocolate
unread sara
unread sara
like sara 6
like goku 6
like sara 4
timeline sara
timeline bruno
seguir goku kuririm

 
 */

public class Main_07_twitter {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Controller con = new Controller();
		TweetGenerator tg = new TweetGenerator();
		int sair = 0;

		while (sair != 1) {

			System.out.print(">>");
			String linha = input.nextLine();
			String comando[] = linha.split(" ");
			String opcao = comando[0];

			try {
				switch (opcao) {
				case "nwuser":
					Controller.cUsers.add(comando[1],new Usuario(comando[1]));
					System.out.println("Done.");
					break;
				case "lauser":
					System.out.println(Controller.cUsers.toString());
					break;
				case "seguir":
					con.getUser(comando[1]).seguir(con.getUser(comando[2]));
					System.out.println("Done.");
					break;
				case "twittar":
					String texto = "";
					for (int i = 2; i < comando.length; i++)
						texto += comando[i] + " ";
					tg.addTweet(comando[1], new Tweet(tg.idTweet+=1, comando[1], texto));
					System.out.println("Done.");
					break;
				case "timeline":
					System.out.println(con.getUser(comando[1]).getTimeLine());
					break;
				case "myTweets":
					System.out.println(con.getUser(comando[1]).getmeusTweets());
					break;
				case "unread":
					System.out.println(con.getUser(comando[1]).getUnread());
					break;
				case "like":
					Controller.cUsers.get(comando[1]).darLike(Integer.parseInt(comando[2]));
					//con.getUser(comando[1]).darLike(Integer.parseInt(comando[2]));
					break;
				case "help":
					System.out.println("# nwuser _username");
					System.out.println("# lauser");
					System.out.println("# seguir _seguidor _seguido");
					System.out.println("# twittar _username _tweet");
					System.out.println("# timeline _username");
					System.out.println("# myTweets _username");
					System.out.println("# unread _username");
					System.out.println("# like _username _idTw");
					break;
				default:
					System.out.println("Comando não encotrado!");
					break;
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
