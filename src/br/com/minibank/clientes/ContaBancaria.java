package br.com.minibank.clientes;

public class ContaBancaria extends Cliente {

    private static int contadorContas = 1000;
    private final int numeroConta;
    private final int numeroAgencia = 123;
    private double saldo;

    public ContaBancaria(String nome, String cpf, String email, String telefone, double saldoInicial) {
        super(nome, cpf, email, telefone);
        this.saldo = saldoInicial;
        this.numeroConta = contadorContas++;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public int getNumeroAgencia() {
        return numeroAgencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$" + valor + " realizado com sucesso!");
            System.out.println("Saldo atual: R$" + saldo);
        } else {
            System.out.println("Valor inválido para depósito.");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso!");
            System.out.println("Saldo atual: R$" + saldo);
        } else {
            System.out.println("Saldo insuficiente ou valor inválido.");
        }
    }

    public void transferir(ContaBancaria destino, double valor) {
        if (valor > 0 && valor <= saldo) {
            this.saldo -= valor;
            destino.saldo += valor;
            System.out.println("Transferência de R$" + valor + " realizada com sucesso para a conta " + destino.numeroConta);
            System.out.println("Saldo atual da conta " + this.getNumeroConta() + ": R$" + this.saldo);
        } else {
            System.out.println("Saldo insuficiente ou valor inválido para transferência.");
        }
    }

    public void consultarConta() {
        System.out.println("---- Dados do Titular ----");
        System.out.println("Titular: " + getNome());
        System.out.println("CPF: " + getCpf());
        System.out.println("E-mail: " + getEmail());
        System.out.println("Telefone: " + getTelefone());
        System.out.println("---- Dados da Conta ----");
        System.out.println("Número da Conta: " + numeroConta);
        System.out.println("Número da Agência: " + numeroAgencia);
        System.out.println("Saldo: R$" + saldo);
    }
}