package junkFood_machine;

import java.util.Scanner;
/*
	COMANDOS PARA INICIAR O CONTATO
	
iniciar 5 3
show
set 0 Tody 3 1.2
set 1 Bis 2 3.99
set 2 M&M 2 5.9
set 3 Kit 1 0.99
set 4 Dan 2 9.99
show
dinheiro 100
saldo
show
comprar 1
comprar 2
saldo
show
troco
limpar 1
limpar 2
limpar 3
limpar 4
show
set 4 Dan 5 9.99

*/

public class Main_02_junkFood {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		Maquina maquina = null;
		int sair = 1;

		while (sair != 0) {
			System.out.print(">>");
			String linha = ler.nextLine();
			String comando[] = linha.split(" ");
			String opcao = comando[0];

			switch (opcao) {
			case "iniciar":
				maquina = new Maquina(Integer.parseInt(comando[1]), Integer.parseInt(comando[2]));
				System.out.println("Done! iniciado uma maquina com " + comando[1] + " espirais!");
				break;
			case "saldo":
				System.out.println("Saldo R$: " + maquina.saldoCliente);
				break;
			case "show":
				System.out.println(maquina.toString());
				break;
			case "dinheiro":
				maquina.inserirDinheiro(Float.parseFloat(comando[1]));
				System.out.println("Done! " + comando[1] + " inserido!");
				break;
			case "set":
				if (maquina.alterarEspiral(Integer.parseInt(comando[1]), comando[2], Integer.parseInt(comando[3]),
						Float.parseFloat(comando[4]))) {
					System.out.println("Done! espiral " + comando[1] + " modificada!");
				}
				break;
			case "comprar":
				if (maquina.vender(Integer.parseInt(comando[1]))) {
					System.out.println("Done! produto do indice " + comando[1] + " comprado!");
				}
				break;
			case "limpar":
				if (maquina.resetar(Integer.parseInt(comando[1]))) {
					System.out.println("Done! indice " + comando[1] + " limpo!");
				}
				break;

			case "troco":
				System.out.println("Você recebeu: " + maquina.saldoCliente);
				break;
			case "help":
				System.out.println("# iniciar _espirais");
				System.out.println("# saldo");
				System.out.println("# show");
				System.out.println("# dinheiro _valor");
				System.out.println("# set _ind _nome _qtd _valor");
				System.out.println("# comprar _ind");
				System.out.println("# limpar _ind");
				break;
			case "sair":
				sair = 0;
				break;
			default:
				System.out.println("Comando não encontrado!");
				break;
			}
		}
	}
}
