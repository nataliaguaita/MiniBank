public ContaBancaria(String numeroConta, String numeroAgencia, double saldoInicial) {
    this.numeroConta = numeroConta;
    this.numeroAgencia = numeroAgencia;
    this.saldo = saldoInicial;
}

public String getNumeroConta() {
    return numeroConta;
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
        System.out.println("Saldo atual da conta " + this.numeroConta + ": R$" + this.saldo);
    } else {
        System.out.println("Saldo insuficiente ou valor inválido para transferência.");
    }
}

public void consultarSaldo() {
    System.out.println("Saldo atual da conta " + numeroConta + ": R$" + saldo);
}

public void exibirDadosConta() {
    System.out.println("Número da Conta: " + numeroConta);
    System.out.println("Número da Agência: " + numeroAgencia);
    System.out.println("Saldo: R$" + saldo);
}