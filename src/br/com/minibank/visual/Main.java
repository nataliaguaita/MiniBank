import br.com.minibanck.dados.clientes.Cliente;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cliente cliente = new Cliente();

        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Cadastrar conta bancária");
            System.out.println("2 - Excluir conta bancária");
            System.out.println("3 - Depósito");
            System.out.println("4 - Saque");
            System.out.println("5 - Transferência");
            System.out.println("6 - Consultar Saldo");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Número da conta: ");
                    String numeroConta = scanner.nextLine();
                    System.out.print("Número da agência: ");
                    String numeroAgencia = scanner.nextLine();
                    System.out.print("Saldo inicial: R$ ");
                    double saldoInicial = scanner.nextDouble();
                    cliente.adicionarConta(numeroConta, numeroAgencia, saldoInicial);
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
                        ContaBancaria contaDest = cliente.buscarConta(contaDestino);
                        if (contaDest != null) {
                            System.out.print("Valor da transferência: R$ ");
                            double valorTransf = scanner.nextDouble();
                            contaOri.transferir(contaDest, valorTransf);
                        } else {
                            System.out.println("Conta de destino não encontrada.");
                        }
                    } else {
                        System.out.println("Conta de origem não encontrada.");
                    }
                    break;

                case 6:
                    System.out.print("Informe o número da conta para consultar saldo: ");
                    String contaSaldo = scanner.nextLine();
                    ContaBancaria contaSal = cliente.buscarConta(contaSaldo);
                    if (contaSal != null) {
                        contaSal.consultarSaldo();
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
