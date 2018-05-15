package contato_telefonico;

import java.util.Scanner;

/*
 		COMANDOS PARA INICIAR O CONTATO
 		
init Batman
show
addfone Oi 88
addfone Vivo 85
addfone Tim 98
addfone Claro 94
show
rmfone Vivo
rmfone Oi
show
rmfone Oi
	
 */

public class Main_01_contato {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		Contato contato = null;

		int sair = 1;

		while (sair != 0) {
			System.out.print(">>");
			String linha = ler.nextLine();
			String comando[] = linha.split(" ");
			String opcao = comando[0];

			switch (opcao) {
			case "sair":
				sair = 0;
				break;
			case "init":
				contato = new Contato(comando[1]);
				System.out.println("Done! " + comando[1] + " iniciado!");
				break;
			case "addfone":
				if (contato.addFone(new Telefone(comando[1], Integer.parseInt(comando[2])))) {
					System.out.println("Done! " + comando[1] + " " + comando[2] + " adicionado!");
				}
				break;
			case "rmfone":
				if (contato.rmFone(comando[1])) {
					System.out.println("Done! " + comando[1] + " removido!");
				} else {
					System.out.println(comando[1] + " não existe!!!");
				}
				break;
			case "update":
				if (contato.update(comando[1], Integer.parseInt(comando[2]), comando[3],
						Integer.parseInt(comando[4]))) {
					System.out.println("Done! " + comando[1] + " " + comando[2] + " alterado" + 
						" para " + comando[3] + " " + comando[4]);
				}
				break;
			case "show":
				System.out.println(contato.toString());
				break;
			case "help":
				System.out.println("# init _nome");
				System.out.println("# addfone _idTel _numero");
				System.out.println("# rmfone _idTele");
				System.out.println("# update _oldfoneid _oldnumber _newfoneid _newnumber");
				System.out.println("# show");
				break;
			default:
				System.out.println("Comando não encontrado!");
				break;
			}
		}
	}
}
