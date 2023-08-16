package Conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import Conta.controller.ContaController;
import Conta.model.Conta;
import Conta.model.ContaCorrente;
import Conta.model.ContaPoupanca;
import Conta.ultil.Cores;

public class Menu {

	public static void main(String[] args) {
		
		ContaController contas = new ContaController();
				
		Scanner leia = new Scanner (System.in);
		
		int opcao, numero, agencia, tipo, aniversario, numeroDestino;
		String titular;
		float saldo, limite, valor;
		
		System.out.println("\nCriar Contas\n");
		
		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "Claudylene Santista", 1000f, 100.0f);
		contas.cadastrar(cc1);
		
		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 124, 1, "Maryclayde Fernandes", 2000f, 100.0f);
		contas.cadastrar(cc2);
		
		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Fagundes Araujo", 4000f, 12);
		contas.cadastrar(cp1);
		
		ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Shakely Benedito", 8000f, 15);
		contas.cadastrar(cp2);
		
		contas.listatTodas();
		
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
					
			try {
				   opcao = leia.nextInt();
				   
			}catch(InputMismatchException e) {
				System.out.println("\nDigite valores inteiros");
				leia.nextLine();
				opcao = 0;
				
			}
			
			if ( opcao == 9) {
				System.out.println(Cores.TEXT_GREEN_BOLD+ "\nBanco Pe De Galinha - O Seu FUTURO Começa Aqui!");
				leia.close();
				System.exit(0);
			}
			 switch (opcao) {
			 
			 case 1:
				 System.out.println(Cores.TEXT_GREEN_BOLD + "Criar Conta \n\n");
				 
				 System.out.println("Digite o Numero da Agencia: ");
				 agencia = leia.nextInt();
				 
				 System.out.println("Digite o Numero do Titular: ");
				 leia.skip("\\R?");
				 titular = leia.nextLine();
				 
				 do {
					 System.out.println("Digite o Tipo da Conta (1-CC ou 2-CP): ");
					 tipo = leia.nextInt();
					 }while(tipo < 1 && tipo > 2);
				 
				 System.out.println("Digite o Saldo da Conta (R$): ");
				 saldo = leia.nextFloat();
				 
				 switch(tipo) {
				 case 1 -> {
					 System.out.println("Digite o Limite de Credito (R$): ");
					 limite = leia.nextFloat();
					     contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));				 
				 }
				 case 2 ->{
					System.out.println("Digte o dia do Aniversario da Conta: ");
					aniversario = leia.nextInt();
					contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));	
				          }
				 }				 
				 keyPress();
				 break;
				 
			 case 2:
				 System.out.println(Cores.TEXT_GREEN_BOLD + "Listar todas as Contas\n\n");
				 contas.listatTodas();
				 keyPress();
				 break;
				 
			 case 3:
				 System.out.println(Cores.TEXT_GREEN_BOLD + "Consultar dados da Conta - por números\n\n");
				 
				 System.out.println("Digite o numero da conta: ");
				 numero = leia.nextInt();
				 
				 contas.procurarPorNumero(numero);
				 
				 keyPress();
				 break;
				 
			 case 4:
				 System.out.println(Cores.TEXT_GREEN_BOLD + "Atualizar dados da Conta\n\n");
				 
				 System.out.println("Digite o numero da conta: ");
				 numero = leia.nextInt();
				 
				 if (contas.buscarNaCollection(numero) != null) {
					 
					 System.out.println("Digite o Numero da Agencia: ");
					 agencia = leia.nextInt();
					 
					 System.out.println("Digite o Nome do Titular: ");
					 leia.skip("\\R?");
					 titular = leia.nextLine();			
					 
					 System.out.println("Digite o Saldo da Conta (R$): ");
					 saldo = leia.nextFloat();
					 
					 tipo = contas.retornaTipo(numero);
					 
					 switch(tipo) {
					 case 1 -> {
						 System.out.println("Digite o Limite de Credito (R$): ");
						 limite = leia.nextFloat();
						 contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));						 
				     }
					 case 2  ->{
						 System.out.println("Digite o dia do Aniversario da Conta: ");
						 aniversario = leia.nextInt();
						 contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));					 					 
					 }
					 default -> {
						 System.out.println("Tipo de conta invalido! ");	 
					 }			 
					 }
					 
			      }else
			    	  System.out.println("\nConta nao encontrada!");
				 	 
				 keyPress();
				 break;
				 
			 case 5:
				 System.out.println(Cores.TEXT_GREEN_BOLD + "Apagar a Conta\n\n");
				 
				 System.out.println("Digite o numero da conta: ");
				 numero = leia.nextInt();
				 
				 contas.deletar(numero);
				 
				 
				 keyPress();
				 break;
				 
			 case 6:
				 System.out.println(Cores.TEXT_GREEN_BOLD + "Saque\n\n");
				 
				 System.out.println("Digite o Numero da Conta: ");
				 numero = leia.nextInt();
				 
				 do {
					 System.out.println("Digite o Valor do Saque (R$): ");
					 valor = leia.nextFloat();					 
				 }while(valor <= 0);
				 
				 contas.sacar(numero, valor);
				 
				 keyPress();
				 break;
				 
			 case 7:
				 System.out.println(Cores.TEXT_GREEN_BOLD + "Déposito\n\n");
				 
				 System.out.println("Digite o Numero da Conta: ");
				 numero = leia.nextInt();
				 
				do {
					System.out.println("Digite o valor do Deposito (R$): ");
					valor = leia.nextFloat();
				}while(valor <= 0);
				
				contas.depositar(numero, valor);
				
				 
				 keyPress();
				 break;
				 
			 case 8:
				 System.out.println(Cores.TEXT_GREEN_BOLD + "Transferência entre Contas\n\n");
				 
				 System.out.println("Digite o Numero da Conta Origem: ");
				 numero = leia.nextInt();
				 System.out.println("Digite o Numero da Conta de Destino: ");
				 numeroDestino = leia.nextInt();
				 
				 do {
					 System.out.println("Digite o Valor da Transferencia (R$): ");
					 valor = leia.nextFloat();
				 }while(valor <= 0);
				 
				 contas.transferir(numero, numeroDestino, valor);
				 
				 keyPress();
				 break;
				 
			 default:
				 System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Invalida!\n");
				 
				 keyPress();
				 break;
			 
			 }
		}	
	}
	             public static void keyPress() {
	            	
	            	 try {
	            		 
	            		System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para continuar...");
	            		System.in.read();	                 		 		 
	            		 
	            	 } catch(IOException e) {
	            	 
	            	    System.out.println("Voce pressionou uma tecla diferente de enter!");  
	            	    
	          } 
	            	 
	      }
	             
      }
















