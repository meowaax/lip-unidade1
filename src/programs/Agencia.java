package programs;

import java.util.ArrayList;

import java.util.Scanner;
public class Agencia {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias = new ArrayList<Conta>();

    public static void operacoes() {

        System.out.println("------------------------------------------------------");
        System.out.println("-------------Bem vindos a nossa Agência---------------");
        System.out.println("------------------------------------------------------");
        System.out.println("** Selecione uma operação que deseja realizar **");
        System.out.println("------------------------------------------------------");
        System.out.println("|   Opção 1 - Criar conta   |");
        System.out.println("|   Opção 2 - Depositar     |");
        System.out.println("|   Opção 3 - Sacar         |");
        System.out.println("|   Opção 4 - Transferir    |");
        System.out.println("|   Opção 5 - Listar        |");
        System.out.println("|   Opção 6 - Emprestimo    |");
        System.out.println("|   Opção 7 - Ivestimento   |");
        System.out.println("|   Opção 8 - Sair          |");
        int operacao = input.nextInt();


        switch (operacao) {
            case 1:
                criarConta();
                break;

            case 2:
                depositar();
                break;

            case 3:
                sacar();
                break;

            case 4:
                transferir();
                break;

            case 5:
                listarContas();
                break;

            case 6:
                emprestimo();
                break;

            case 7:
                investimo();
                break;

            case 8:
                System.out.println("Obrigado por usar nosso sistema! Até mais :)");
                System.exit(0); // para o sistema

            default:
                System.out.println("Opção inválida!");
                operacoes();
                break;
        }
    }

    public static void criarConta() {


        System.out.println("\nNome: ");
        String nome = input.next();

        System.out.println("\nCPF: ");
        String cpf = input.next();

        System.out.println("Email: ");
        String email = input.next();

        Pessoa cliente = new Pessoa(nome, cpf, email);

        Conta conta = new Conta(cliente);

        contasBancarias.add(conta);
        System.out.println("--- Sua conta foi criada com sucesso! ---");

        operacoes();

    }

    private static Conta encontrarConta(int numeroConta) {
        Conta conta = null;
        if (contasBancarias.size() > 0) {
            for (Conta contaa : contasBancarias) {
                if (contaa.getNumeroConta() == numeroConta) {
                    conta = contaa;
                }
            }
        }
        return conta;
    }

    public static void depositar() {
        System.out.println("Número da conta: ");
        int numeroConta = input.nextInt();
        Conta conta = encontrarConta(numeroConta);

        if (conta != null) {
            System.out.println("Qual valor deseja depositar? ");
            Double valorDeposito = input.nextDouble();

            conta.depositar(valorDeposito);
        } else {
            System.out.println("--- Conta não encontrada ---");
        }

        operacoes();

    }

    public static void sacar() {
        System.out.println("Número da conta: ");
        int numeroConta = input.nextInt();

        Conta conta = encontrarConta(numeroConta);

        if (conta != null) {
            System.out.println("Qual valor deseja sacar? ");
            Double valorSaque = input.nextDouble();

            conta.sacar(valorSaque);
            System.out.println("--- Saque realizado com sucesso! ---");
        } else {
            System.out.println("--- Conta não encontrada ---");
        }

        operacoes();

    }

    public static void transferir() {
        System.out.println("Número da conta que vai enviar a transferência: ");
        int numeroContaRemetente = input.nextInt();

        Conta contaRemetente = encontrarConta(numeroContaRemetente);

        if (contaRemetente != null) {
            System.out.println("Número da conta do destinatário: ");
            int numeroContaDestinatario = input.nextInt();

            Conta contaDestinatario = encontrarConta(numeroContaDestinatario);

            if (contaDestinatario != null) {
                System.out.println("Valor da transferência: ");
                Double valor = input.nextDouble();

                contaRemetente.transferencia(contaDestinatario, valor);

            } else {
                System.out.println("--- A conta para depósito não foi encontrada ---");
            }

        } else {
            System.out.println("--- Conta para transferência não encontrada ---");
        }
        operacoes();
    }

    public static void listarContas() {
        if (contasBancarias.size() > 0) {
            for (Conta conta : contasBancarias) {
                System.out.println(conta);
            }
        } else {
            System.out.println("--- Não há contas cadastradas ---");
        }

        operacoes();
    }

    public static void emprestimo(){
        System.out.print("Digite o valor do empréstimo: ");
        double valor = input.nextDouble();
        System.out.print("Digite o juros ao mês (%): ");
        double juros = input.nextDouble();
        System.out.print("Digite o número de meses: ");
        int meses = input.nextInt();

        Emprestimo emprestimo = new Emprestimo(valor, juros, meses);
        System.out.printf("Valor do empréstimo: %.2f", emprestimo.getValor());
        System.out.println("");
        System.out.printf("Juros totais: %.2f", emprestimo.calcularJuros());
        System.out.println("");
        System.out.printf("Valor total a pagar: %.2f", emprestimo.calcularValorTotal());
        System.out.println("");
        operacoes();

    }

    public static void investimo(){
        System.out.print("Digite o valor do investimento: ");
        double valorInvest = input.nextDouble();
        System.out.print("Digite o lucro ao ano (%): ");
        double jurosInvest = input.nextDouble();
        System.out.print("Digite o número de anos: ");
        int anosInvest = input.nextInt();

        Investimento investimento = new Investimento(valorInvest, jurosInvest, anosInvest);
        System.out.printf("Valor do investimento: %.2f", investimento.getValor());
        System.out.println("");
        System.out.printf("Lucro total: %.2f", investimento.calcularJuros());
        System.out.println("");
        System.out.printf("Valor total: %.2f", investimento.calcularValorTotal());
        System.out.println("");
        operacoes();
    }

}