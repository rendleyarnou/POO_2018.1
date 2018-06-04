package clinica_veterinaria;

import java.util.Scanner;

/*
 
nwcli rendin Rendley Arnou Xavier
nwcli seninha David Sena de Oliveira
nwcli zezin Jose Philomeno Barros
lacli
addani rendin bilubilu gato
addani rendin auau cachorro
addani seninha miau gatoesq
addaeni zezin galo dinoçauru
lscli rendin
lscli senhina
lscli zezin
laani
addser banho 50
addser tosa 40
addser tintura 33
addser make 19
laser
nwven rendin bilubilu 1
nwven seninha miau 4
nwven zezin galo 3
laven
saldo

 */

public class Main_06_clinica_veterinaria {

	public static void main(String[] args) {
		ServicoClinica sc = new ServicoClinica();

		Scanner input = new Scanner(System.in);
		int sair = 0;

		while (sair != 1) {
			System.out.print(">>");
			String linha = input.nextLine();
			String comando[] = linha.split(" ");
			String opcao = comando[0];

			try {
				switch (opcao) {
				case "nwcli":
					
					String texto = "";
					for (int i = 2; i < comando.length; i++)
						texto += comando[i] + " ";					
					sc.addCli(comando[1], texto);
					System.out.println("Done! cliente " + comando[2] + " adicionado.");
					break;
				case "lacli":
					System.out.println(sc.getAllrCli());
					break;
				case "addani":
					sc.addAni(comando[1], comando[2], comando[3]);
					System.out.println("Done! " + comando[2] + " adicionado à " + comando[1] + ".");
					break;
				case "lscli":
					System.out.println(sc.getrCli(comando[1]).getAnimais());
					break;
				case "laani":
					System.out.println(sc.getrAllAni());
					break;
				case "addser":
					sc.addSer(comando[1], Float.parseFloat(comando[2]));
					System.out.println("Done! serviço " + comando[1] + " adicionado.");
					break;
				case "laser":
					System.out.println(sc.getrAllSer());
					break;
				case "nwven":
					sc.Vender(comando[1], comando[2], Integer.parseInt(comando[3]));
					System.out.println("Done! ");
					break;
				case "laven":
					System.out.println(sc.getAllrVen());
					break;
				case "saldo":
					System.out.println("Saldo: R$:" + sc.getSaldoDeVendas());
					break;
				case "help":
					System.out.println("# nwcli _idCli _nome_completo");
					System.out.println("# lacli");
					System.out.println("# addani _idCli _nome_animal _especie");
					System.out.println("# lscli _idCli");
					System.out.println("# laani");
					System.out.println("# addser _nome_servico _preco");
					System.out.println("# laser");
					System.out.println("# nwven _idCli _nome_animal _idSer");
					System.out.println("# laven");
					System.out.println("# saldo");
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
