public class Main {
    public static void main(String[] args) {
        Cliente maria = new Cliente();
        maria.setNome("Maria");

        Conta cc = new ContaCorrente(maria);
        Conta cp = new ContaPoupanca(maria);

        cc.depositar(50);
        cc.transferir(10, cp);

        cc.setDiaVencimentoFatura(5);
        cp.setDiaVencimentoFatura(5);

        cc.imprimirExtrato();
        cp.imprimirExtrato();
    }
}
