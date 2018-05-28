package agencia_bancaria;

import java.util.Scanner;

public class Main_04_agencia_bancaria {
	public static void main(String[] args) {
		Agencia agencia = new Agencia();

		Scanner input = new Scanner(System.in);
		int sair = 0;

		while (sair != 1) {
			System.out.print(">>");
			String linha = input.nextLine();
			String comando[] = linha.split(" ");
			String opcao = comando[0];

			try {
				switch (opcao) {
				case "addcli":
					agencia.addCliente(comando[1]);
					System.out.println("Done! " + comando[1] + " adicionado com sucesso.");
					break;
				case "abrirco":
					agencia.abrirNovaConta(comando[1]);
					System.out.println("Done! Conta " + comando[1] + " adicionada ao cliente.");
					break;
				case "encerrarco":
					agencia.encer(comando[1], Integer.parseInt(comando[2]));
					System.out.println("Done!");
					break;
				case "sholl":
					System.out.print(agencia.toString());
					break;
				case "login":
					agencia.login(comando[1]);
					System.out.println("Done! " + comando[1] + " logado.");
					break;
				case "logout":
					agencia.logout();
					System.out.println("Done!");
					break;
				case "show":
					System.out.println(agencia.getUser().getIdCliente());
					System.out.println(agencia.getUser().getContas().toString());
					break;
				case "saldo":
					System.out.println("Saldo: R$:" + agencia.getConta(Integer.parseInt(comando[1])).getSaldo());
					break;
				case "saque":
					agencia.getConta(Integer.parseInt(comando[1])).sacar(Float.parseFloat(comando[2]));
					System.out.println("Done! saque de R$:" + comando[2] + " na conta " + comando[1] + " efetuado com sucesso.");
					break;
				case "deposito":
					agencia.getConta(Integer.parseInt(comando[1])).depositar(Float.parseFloat(comando[2]));
					System.out.println("Done! deposito de R$:" + comando[2] + " na conta " + comando[1] + " efetuado com sucesso.");
					break;
				case "extrato":
					System.out.println(agencia.getConta(Integer.parseInt(comando[1])).getExtrato());
					System.out.println("Done!");
					break;
				case "transf":
					agencia.getConta(Integer.parseInt(comando[1])).transferir(agencia.getContaCli(Integer.parseInt(comando[2])), Float.parseFloat(comando[3]));
					System.out.println("Done! transferencia de R$:" + comando[3] + " da conta " + comando[1] + " para conta " + comando[2]);
					break;
				case "help":
					System.out.println("# addcli _idCliente");
					System.out.println("# abrirco _idCliente");
					System.out.println("# encerrarco _idCliente _idConta");
					System.out.println("# sholl");
					System.out.println("# login _idCliente");
					System.out.println("# logout");
					System.out.println("# show");
					System.out.println("# saldo _idConta");
					System.out.println("# saque _idConta _valor");
					System.out.println("# deposito _idConta _valor");
					System.out.println("# extrato _idConta");
					System.out.println("# transf _idConta _idContaDestino _valor");
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
