package br.com.minibank.visual;
import br.com.minibank.clientes.ContaBancaria;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContaBancaria contaBancaria = new ContaBancaria( );

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
                    contaBancaria.setNome(scanner.nextLine());
                    System.out.print("Qual seu CPF? ");
                    contaBancaria.setCpf(scanner.nextLine());
                    System.out.print("Qual seu melhor e-mail? ");
                    contaBancaria.setEmail(scanner.nextLine());
                    System.out.print("Qual seu telefone? ");
                    contaBancaria.setTelefone(scanner.nextLine());
                    System.out.print("Qual será o saldo inicial? R$ ");
                    contaBancaria.setSaldo(scanner.nextDouble());
                    contaBancaria.adicionarConta(
                        contaBancaria.getNome(),
                        contaBancaria.getCpf(),
                        contaBancaria.getEmail(),
                        contaBancaria.getTelefone(),
                        contaBancaria.getSaldo()
                    );
                    break;

                case 2:
                    System.out.print("Informe o número da conta a ser excluída: ");
                    String contaExcluir = scanner.nextLine();
                    ContaBancaria contaEx = contaBancaria.buscarConta(contaExcluir);
                    if (contaEx == null) {
                        System.out.println("Conta não encontrada.");
                    } else {
                    contaBancaria.removerConta(contaExcluir);}
                    break;

                case 3:
                    System.out.print("Informe o número da conta para depósito: ");
                    String contaDeposito = scanner.nextLine();
                    ContaBancaria contaDep = contaBancaria.buscarConta(contaDeposito);
                    if (contaDep != null) {
                        System.out.print("Valor do depósito: R$ ");
                        double valorDep = scanner.nextDouble();
                        contaDep.depositar(valorDep);
                    } else {
                        System.out.println("Conta não encontrada. Tente novamente.");
                    }
                    break;

                case 4:
                    System.out.print("Informe o número da conta para saque: ");
                    String contaSaque = scanner.nextLine();
                    ContaBancaria contaSac = contaBancaria.buscarConta(contaSaque);
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
                    ContaBancaria contaOri = contaBancaria.buscarConta(contaOrigem);

                    if (contaOri != null) {
                        System.out.print("Informe o número da conta de destino: ");
                        String contaDestino = scanner.nextLine();

                        if (contaOrigem.equals(contaDestino)) {
                            System.out.println("Erro: A conta de origem e a conta de destino não podem ser a mesma.");
                            break;
                        }

                        ContaBancaria contaDest = contaBancaria.buscarConta(contaDestino);
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
                    ContaBancaria contaDad = contaBancaria.buscarConta(contaDados);
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
