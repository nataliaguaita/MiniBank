package br.com.minibank.visual;

import br.com.minibank.clientes.Cliente;
import br.com.minibank.clientes.ContaBancaria;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cliente cliente = new Cliente();

        while (true) {
            System.out.println("\n---- MENU ----");
            System.out.println("1 - Cadastrar conta bancária");
            System.out.println("2 - Excluir conta bancária");
            System.out.println("3 - Depósito");
            System.out.println("4 - Saque");
            System.out.println("5 - Transferência");
            System.out.println("6 - Consultar dados da conta");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Qual o nome completo do titular? ");
                    String nome = scanner.nextLine();
                    System.out.print("Qual seu CPF? ");
                    String cpf = scanner.nextLine();
                    System.out.print("Qual seu melhor e-mail? ");
                    String email = scanner.nextLine();
                    System.out.print("Qual seu telefone? ");
                    String telefone = scanner.nextLine();
                    System.out.print("Qual será o saldo inicial? R$ ");
                    double saldoInicial = scanner.nextDouble();
                    cliente.adicionarConta(nome, cpf, email, telefone, saldoInicial);
                    break;

                case 2:
                    System.out.print("Informe o número da conta a ser excluída: ");
                    String contaExcluir = scanner.nextLine();
                    cliente.removerConta(contaExcluir);
                    break;

                case 3:
                    System.out.print("Informe o número da conta para depósito: ");
                    String contaDeposito = scanner.nextLine();
                    ContaBancaria contaDep = cliente.buscarConta(contaDeposito);
                    if (contaDep != null) {
                        System.out.print("Valor do depósito: R$ ");
                        double valorDep = scanner.nextDouble();
                        contaDep.depositar(valorDep);
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 4:
                    System.out.print("Informe o número da conta para saque: ");
                    String contaSaque = scanner.nextLine();
                    ContaBancaria contaSac = cliente.buscarConta(contaSaque);
                    if (contaSac != null) {
                        System.out.print("Valor do saque: R$ ");
                        double valorSaq = scanner.nextDouble();
                        contaSac.sacar(valorSaq);
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 5:
                    System.out.print("Informe o número da conta de origem: ");
                    String contaOrigem = scanner.nextLine();
                    ContaBancaria contaOri = cliente.buscarConta(contaOrigem);

                    if (contaOri != null) {
                        System.out.print("Informe o número da conta de destino: ");
                        String contaDestino = scanner.nextLine();

                        if (contaOrigem.equals(contaDestino)) {
                            System.out.println("Erro: A conta de origem e a conta de destino não podem ser a mesma.");
                            break;
                        }

                        ContaBancaria contaDest = cliente.buscarConta(contaDestino);
                        if (contaDest != null) {
                            System.out.print("Valor da transferência: R$ ");
                            double valorTransf = scanner.nextDouble();
                            scanner.nextLine();
                            contaOri.transferir(contaDest, valorTransf);
                        } else {
                            System.out.println("Conta de destino não encontrada.");
                        }
                    } else {
                        System.out.println("Conta de origem não encontrada.");
                    }
                    break;

                case 6:
                    System.out.print("Informe o número da conta para consultar os dados: ");
                    String contaDados = scanner.nextLine();
                    ContaBancaria contaDad = cliente.buscarConta(contaDados);
                    if (contaDad != null) {
                        contaDad.consultarConta();
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 0:
                    System.out.println("Saindo do sistema...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}
