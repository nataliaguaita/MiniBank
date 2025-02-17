package br.com.minibank.clientes;

import java.util.ArrayList;
import java.util.Iterator;

public class Cliente {
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private final ArrayList<ContaBancaria> contas = new ArrayList<>();

    public Cliente(String nome, String cpf, String email, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
    }

    public Cliente() {}

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void adicionarConta(String nome, String cpf, String email, String telefone, double saldoInicial) {
        ContaBancaria novaConta = new ContaBancaria(nome, cpf, email, telefone, saldoInicial);
        contas.add(novaConta);
        System.out.println("---- Conta bancária criada com sucesso! ----");
        System.out.println("Número da sua conta: " + novaConta.getNumeroConta());
        System.out.println("Número da sua agência: " + novaConta.getNumeroAgencia());
        System.out.println("Saldo inicial da conta: R$" + saldoInicial);
    }

    public void removerConta(String numeroConta) {
        try {
            int numeroContaInt = Integer.parseInt(numeroConta);
            Iterator<ContaBancaria> iterator = contas.iterator();
            while (iterator.hasNext()) {
                ContaBancaria conta = iterator.next();
                if (conta.getNumeroConta() == numeroContaInt) {
                    iterator.remove();
                    System.out.println("Conta bancária removida com sucesso!");
                    return;
                }
            }
            System.out.println("Conta não encontrada.");
        } catch (NumberFormatException e) {
            System.out.println("Número de conta inválido.");
        }
    }

    public ContaBancaria buscarConta(String numeroConta) {
        try {
            int numeroContaInt = Integer.parseInt(numeroConta);
            for (ContaBancaria conta : contas) {
                if (conta.getNumeroConta() == numeroContaInt) {
                    return conta;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Número de conta inválido.");
        }
        return null;
    }
}