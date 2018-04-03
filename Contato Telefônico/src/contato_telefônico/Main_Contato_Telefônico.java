package contato_telefônico;

import java.util.Scanner;

public class Main_Contato_Telefônico {

	public void help() {
	}

	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);
		Contato contato = null;

		int sair = 1;

		while (sair != 0) {

			System.out.print("help para ver os comandos >>");

			String linha = ler.nextLine();
			String comando[] = linha.split(" ");
			String opcao = comando[0];

			switch (opcao) {
			case "sair":

				sair = 0;

				break;

			case "init":

				String varNome = comando[1];

				contato = new Contato(varNome);
				System.out.println("Done!");

				break;

			case "addFone":

				String idTelefone = comando[1];
				int varNumero = Integer.parseInt(comando[2]);

				if (contato.addFone(new Telefone(idTelefone, varNumero))) {
					System.out.println("Done!");
				} else {
					System.out.println("Error!!!");
				}

				break;

			case "rmFone":

				String idTele = comando[1];

				if (contato.rmFone(idTele)) {
					System.out.println("Done!");
				} else {
					System.out.println("id não existe!!!");
				}

				break;

			case "show":

				System.out.println(contato.toString());

				break;

			case "help":

				System.out.println("init _nome");
				System.out.println("addFone _idTel _numero");
				System.out.println("rmFone _idTele");
				System.out.println("show");

				break;

			default:

				System.out.println("Comando não encontrado!");

				break;
			}
		}

	}

}
