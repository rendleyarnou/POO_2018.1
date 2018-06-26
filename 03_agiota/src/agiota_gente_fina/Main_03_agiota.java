package agiota_gente_fina;

import java.util.Scanner;
/*

ERRO NÃO CORRIGIDO
apagar as transações do batman



COMANDOS PARA INICIAR O CONTATO

init 10000
newcli Batman Bat
newcli Thanos thatha
newcli Sena seninha
emprestar Batman 100
emprestar Thanos 150
emprestar Sena 200
latran
lscli Batman
lscli Thanos
lscli Sena
lacli
receber Batman 50
receber Thanos 75
receber Sena 100
lscli Batman
lscli Thanos
lscli Sena


*/
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
				System.out.println("Done! sistema iniciado com " + comando[1] + " Reais");
				break;
			case "saldo":
				System.out.println("Saldo: R$" + system.getSaldoSis());
				break;
			case "newcli":
				if (system.addCli(comando[1], comando[2])) {
					System.out.println("Done! cliente " + comando[1] + " adicionado!");
				}
				break;
			case "kill":
				if (system.killCli(comando[1])) {
					System.out.println("Done! cliente " + comando[1] + " morto!");
				}
				break;
			case "lscli":
				System.out.println("Id: " + system.getIdTrans() + "[" + system.getCli(comando[1]).getClienteID() +
									" " + system.getCli(comando[1]).getSaldo() + "]");
				break;
			case "latran":
				System.out.println("lacli\n" + system.latran());
				break;
			case "lacli":
				System.out.println("lacli\n" + system.lacli());
				break;
			case "emprestar":
				if(system.emprestar(comando[1], Float.parseFloat(comando[2]))){
				System.out.println("Id:" + system.getIdTrans() + system.getCli(comando[1]));
				}
				break;
			case "receber":
				if(system.receber(comando[1], Float.parseFloat(comando[2]))){
					System.out.println("Done!");
					System.out.println("Id: " + system.getIdTrans() + system.getCli(comando[1]).toString());
				}
				break;
			case "help":
				System.out.println("# init _valor");
				System.out.println("# saldo ");
				System.out.println("# newcli _apelido _nome");
				System.out.println("# kill _apelido");
				System.out.println("# lscli _nomeDoCliente");
				System.out.println("# latran mostra todas as trnasacoes");
				System.out.println("# lacli _mostra todos os clientes");
				System.out.println("# emprestar _nome _valor");
				System.out.println("# receber _nome _valor");
				break;
			default:
				System.out.println("Comando não encotrado!");
				break;
			}
		}
	}
}