package Conta;

import java.util.Scanner;

import Conta.model.Conta;
import Conta.model.ContaCorrente;
import Conta.model.ContaPoupanca;
import Conta.ultil.Cores;

public class Menu {

	public static void main(String[] args) {
		
		
		Conta c1 = new Conta(1, 347, 1, "Maricleide", 10000.0f);
		c1.visualizar();
		c1.sacar(12000.0f);
		c1.visualizar();
		c1.depositar(5000.0f);
		c1.visualizar();
		
		ContaCorrente cc1 = new ContaCorrente(2, 458, 1, "Shakelle", 15000.0f, 1000.0f);
		cc1.visualizar();
		cc1.sacar(12000.0f);
		cc1.visualizar();
		cc1.depositar(5000.0f);
		cc1.visualizar();
		
		ContaPoupanca cp1 = new ContaPoupanca(3, 547, 2, "Hirineu", 100000.0f, 15);
		cp1.visualizar();
		cp1.sacar(1000.0f);
		cp1.visualizar();
		cp1.depositar(5000.0f);
		cp1.visualizar();
		
		
		Scanner leia = new Scanner (System.in);
		
		int opcao;
		
		while (true) {
			
			System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND
					         + "************************************************************");
			System.out.println("                                                            ");
			System.out.println("                BANCO PE DE GALINHA                         ");
			System.out.println("                                                            ");
			System.out.println("************************************************************");
			System.out.println("                                                            ");
			System.out.println("                1 - Criar Conta                             ");
			System.out.println("                2 - Listar todas as Contas                  ");
			System.out.println("                3 - Buscar Conta por Numero                 ");
			System.out.println("                4 - Atualizar Dados da Conta                ");
			System.out.println("                5 - Apagar a Conta                          ");
			System.out.println("                6 - Sacar                                   ");
			System.out.println("                7 - Depositar                               ");
			System.out.println("                8 - Transferir Valores entre Contas         ");
			System.out.println("                9 - Sair                                    ");
			System.out.println("                                                            ");
			System.out.println("************************************************************");
			System.out.println(" Entre com a opção desejada:                                ");
			System.out.println("                                                            "+ Cores.TEXT_RESET);
					
			opcao = leia.nextInt();
			
			if ( opcao == 9) {
				System.out.println(Cores.TEXT_GREEN_BOLD+ "\nBanco Pe De Galinha - O Seu FUTURO Começa Aqui!");
				leia.close();
				System.exit(0);
			}
			 switch (opcao) {
			 
			 case 1:
				 System.out.println(Cores.TEXT_GREEN_BOLD + "Criar Conta \n\n");
				 
				 break;
			 case 2:
				 System.out.println(Cores.TEXT_GREEN_BOLD + "Listar todas as Contas\n\n");
				 
				 break;
			 case 3:
				 System.out.println(Cores.TEXT_GREEN_BOLD + "Consultar dados da Conta - por números\n\n");
				 
				 break;
			 case 4:
				 System.out.println(Cores.TEXT_GREEN_BOLD + "Atualizar dados da Conta\n\n");
				 
				 break;
			 case 5:
				 System.out.println(Cores.TEXT_GREEN_BOLD + "Apagar a Conta\n\n");
				 
				 break;
			 case 6:
				 System.out.println(Cores.TEXT_GREEN_BOLD + "Saque\n\n");
				 
				 break;
			 case 7:
				 System.out.println(Cores.TEXT_GREEN_BOLD + "Déposito\n\n");
				 
				 break;
			 case 8:
				 System.out.println(Cores.TEXT_GREEN_BOLD + "Transferência entre Contas\n\n");
				 
				 break;
			 default:
				 System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Invalida!\n");
				 
				 break;
			 
			 }
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
		
		
	}

}
