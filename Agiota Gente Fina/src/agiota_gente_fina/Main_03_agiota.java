package agiota_gente_fina;

import java.util.Scanner;

public class Main_03_agiota {

	public static void main(String[] args) {

		Sistema system = null;

		Scanner input = new Scanner(System.in);
		int sair = 0;

		while (sair != 1) {

			System.out.println(">>");

			String linha = input.nextLine();
			String comando[] = linha.split(" ");
			String opcao = comando[0];

			switch (opcao) {
			case "init":

				system = new Sistema(Float.parseFloat(comando[1]));
				System.out.println("Done!");

				break;

			case "saldo":

				System.out.println("Saldo: R$ " + system.getSaldoSis());

				break;

			case "newcli":

				if (system.addCli(comando[1], comando[2])) {
					System.out.println("Done!");
				}

				break;

			case "kill":

				if (system.killCli(comando[1])) {
					System.out.println("Done!");
				}
				

				break;

			case "ls":

				//TA FUNFANDO
				System.out.println("Id:" + system.getIdTrans() + system.getCli(comando[1]));

				break;

			case "emprestar":

				if(system.emprestar(comando[1], Float.parseFloat(comando[2]))){
				System.out.println("Done!");
				System.out.println("Id:" + system.getIdTrans() + system.getCli(comando[1]).toString());
				}
				

				break;

			case "receber":

				if(system.receber(comando[1], Float.parseFloat(comando[2]))){
					System.out.println("Done!");
					System.out.println("Id:" + system.getIdTrans() + system.getCli(comando[1]).toString());
				}

				break;
			
			case "help":


				System.out.println("init _valor");
				System.out.println("saldo ");
				System.out.println("newcli _apelido _nome");
				System.out.println("kill _apelido");
				System.out.println("ls _nomeDoCliente");
				System.out.println("emprestar");
				System.out.println("receber");

				break;

			default:

				System.out.println("Comando não encotrado!");

				break;
			}
		}

	}

}