package servico_de_anotacoes;

import java.util.Scanner;

public class Main_05_anotacoes {
	public static void main(String[] args) {
		Sistema sis = new Sistema(new Repositorio<Usuario>("Usuarios"));

		Scanner input = new Scanner(System.in);
		int sair = 0;

		while (sair != 1) {
			System.out.print(">>");
			String linha = input.nextLine();
			String comando[] = linha.split(" ");
			String opcao = comando[0];

			try {
				switch (opcao) {
				case "addUser":
					sis.addUser(comando[1], comando[2]);
					System.out.println("Done.");
					break;
				case "showUsers":
					System.out.println(sis.getAllUsers());
					break;
				case "login":
					sis.login(comando[1], comando[2]);
					System.out.println("Done.");
					break;
				case "logout":
					sis.logout();
					break;
				case "changePass":
					sis.getUser().setPassword(comando[1], comando[2]);
					System.out.println("Done.");
					break;
				case "addNote":
					String texto = "";
					for (int i = 2; i < comando.length; i++)
						texto += comando[i] + " ";
					if(texto != null) {
						sis.getUser().addNota(new Nota(comando[1], texto));
						System.out.println("Done.");
					}
					throw new RuntimeException("Fail: nota não pode ser criada, texto vazio.");
				case "rmNote":
					sis.getUser().rmNota(comando[1]);
					break;
				case "showNotes":
					System.out.println(sis.getUser().getNotas());
					break;
				case "help":
					System.out.println("# addUser _username _password");
					System.out.println("# showUsers");
					System.out.println("# login _username _senha");
					System.out.println("# logout");
					System.out.println("# changePass _oldpass _newpass");
					System.out.println("# addNote _titulo _texto");
					System.out.println("# rmNote _titulo");
					System.out.println("# showNotes");
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
