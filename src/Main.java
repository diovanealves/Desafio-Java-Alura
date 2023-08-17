import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String nome = "Diovane Alves";
        String tipoConta = "Corrente";
        double saldoAtual = 2000.00;
        boolean sairAplicacao = false;

        String dadosCliente = """
                **************************
                Dados iniciais do cliente:
                Nome do cliente: %s
                Tipo da Conta: %s
                Saldo Atual: R$ %.2f
                **************************
                """ .formatted(nome, tipoConta, saldoAtual);
        System.out.println(dadosCliente);

        String operacoes = """
                Operações \n
                
                1- Consultar valores
                2- Receber valor
                3- Transferir valor
                4- Sair
                """;

        Scanner scanner = new Scanner(System.in);

        while (!sairAplicacao) {
            System.out.println(operacoes);
            int operacao = scanner.nextInt();

            switch (operacao) {
                case 1 -> System.out.println("Saldo atualizado: R$ " + saldoAtual);
                case 2 -> {
                    System.out.println("Informe o valor a receber");
                    double saldoDepositar = scanner.nextDouble();
                    saldoAtual += saldoDepositar;
                    System.out.println("Saldo atualizado: R$ " + saldoAtual);
                }
                case 3 -> {
                    System.out.println("Informe o valor a transferir");
                    double saldoTransferir = scanner.nextDouble();
                    if (saldoTransferir > saldoAtual) {
                        System.out.println("Não há saldo suficiente para fazer essa transferência.");
                    }
                    saldoAtual -= saldoTransferir;
                    System.out.println("Saldo atualizado: R$ " + saldoAtual);
                }
                case 4 -> {
                    System.out.println("Saindo....");
                    sairAplicacao = true;
                }
                default -> System.out.println("Opção inválida");
            }
        }
    }
}