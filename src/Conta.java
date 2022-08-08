

public abstract class Conta implements iConta {

    private static final int AGENCIA_PADRAO = 1;
    protected int agencia;
    protected int numero;
    protected double saldo = 0;
    protected int diaVencimentoFatura;
    protected double valorFatura;
    private Cliente cliente;
    private static int SEQUENCIAL = 1;

    public double getValorFatura() {
        return valorFatura;
    }

    public void setValorFatura(double valorFatura) {
        this.valorFatura = valorFatura;
    }

    public int getDiaVencimentoFatura() {
        return diaVencimentoFatura;
    }

    public void setDiaVencimentoFatura(int diaVencimentoFatura) {
        this.diaVencimentoFatura = diaVencimentoFatura;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        this.saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    protected void impressaoInfosComuns() {
        System.out.println("Cliente: " + this.cliente.getNome());
        System.out.println(String.format("Agência: %d", this.agencia));
        System.out.println(String.format("Número: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
        System.out.println(String.format("Data Fatura: " + this.diaVencimentoFatura));
    }
}
