package junkfood;

import java.util.Scanner;

public class Controller {

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

				int qtdEspirais = Integer.parseInt(comando[1]);

				maquina = new Maquina(qtdEspirais);
				System.out.println("Done!");

				break;
			
			case "saldo":

				System.out.println("R$: " + maquina.saldoCliente);

				break;
				
			case "show":

				System.out.println(maquina.toString());

				break;
				
			case "dinheiro":

				float dinheiro = Float.parseFloat(comando[1]);
				
				maquina.inserirDinheiro(dinheiro);
				System.out.println("Done!");

				break;
				
			case "set":

				int indice = Integer.parseInt(comando[1]);
				String nome = comando[2];
				int qtd = Integer.parseInt(comando[3]);
				float preco = Float.parseFloat(comando[4]);
				
				if(maquina.alterarEspiral(indice, nome, qtd, preco)) {
					System.out.println("Done!");
				}

				break;
				
			case "comprar":
				
				int prod = Integer.parseInt(comando[1]);

				if(maquina.vender(prod)) {
					System.out.println("Done!");
				}else {
					System.out.println("Produto não existe!");
				}

				break;
			
			case "limpar":

				int produto = Integer.parseInt(comando[1]);

				if(maquina.resetar(produto)) {
					System.out.println("Done!");
				}
				
				break;
								
			case "help":

				System.out.println("iniciar _espirais");
				System.out.println("saldo");
				System.out.println("show");
				System.out.println("dinheiro _valor");
				System.out.println("set _ind _nome _qtd _valor");
				System.out.println("comprar _ind");
				System.out.println("limpar _ind");

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
