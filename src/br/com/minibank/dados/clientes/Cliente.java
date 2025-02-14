package br.com.minibanck.dados.clientes;

import java.util.ArrayList;
import java.util.Iterator;

public class Cliente {
    private String nome;
      private String cpf;
      private String email;
      private String telefone;
      private List<ContaBancaria> contas = new ArrayList<>();

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

    public void adicionarConta(String numeroConta, String numeroAgencia, double saldoInicial) {
      contas.add(new ContaBancaria(numeroConta, numeroAgencia, saldoInicial));
      System.out.println("Conta bancária criada com sucesso!");
    }

    public void removerConta(String numeroConta) {
        Iterator<ContaBancaria> iterator = contas.iterator();
        while (iterator.hasNext()) {
            ContaBancaria conta = iterator.next();
            if (conta.getNumeroConta().equals(numeroConta)) {
                iterator.remove();
                System.out.println("Conta bancária removida com sucesso!");
                return;
            }
        }
        System.out.println("Conta não encontrada.");
    }

    public ContaBancaria buscarConta(String numeroConta) {
        for (ContaBancaria conta : contas) {
         if (conta.getNumeroConta().equals(numeroConta)) {
                return conta;
            }
        }
        return null;
    }

    public void exibirTodasAsContas() {
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta cadastrada.");
        } else {
            for (ContaBancaria conta : contas) {
                conta.exibirDadosConta();
                System.out.println("------------------------");
            }
        }
    }

    public void exibirDadosCliente() {
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("E-mail: " + email);
        System.out.println("Telefone: " + telefone);
    }
}