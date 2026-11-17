import java.util.Scanner;

public class Biblioteca {

    public static void exibirMenu() {
        System.out.println("\n--- MENU ---");
        System.out.println("1. Verificar empréstimo");
        System.out.println("2. Calcular devolução e multa");
        System.out.println("3. Sair");
    }

    public static int lerInteiroValidado(Scanner scanner, String prompt, String erro) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                int valor = scanner.nextInt();
                scanner.nextLine();
                return valor;
            } else {
                System.out.println(erro);
                scanner.nextLine();
            }
        }
    }

    public static void processarOpcao(int opcao, Scanner scanner, int limiteMaximo, int prazoDias, double multaDiaria, int opcaoSair) {
        switch (opcao) {
            case 1:
                verificarElegibilidadeEmprestimo(scanner, limiteMaximo, prazoDias);
                break;
            case 2:
                calcularDevolucaoMulta(scanner, prazoDias, multaDiaria);
                break;
            case 3:
                System.out.println("\nSaindo do sistema....");
                break;
            default:
                System.out.println("\n[Aviso] Opção inválida. Escolha entre 1 e 3.");
        }
    }

    private static void verificarElegibilidadeEmprestimo(Scanner scanner, int limiteMaximo, int prazoDias) {
        System.out.println("\n--- VERIFICAR EMPRÉSTIMO ---");
        
        int livrosAtuais = lerInteiroValidado(
            scanner, 
            "Quantos livros a pessoa já pegou emprestado? ", 
            "[Erro] Digite um número válido."
        );

        if (livrosAtuais < 0) {
            System.out.println("[Erro] O número não pode ser negativo.");
            return;
        }

        if (livrosAtuais >= limiteMaximo) {
            System.out.println("[Bloqueado] Limite atingido! A pessoa já está com " + limiteMaximo + " livros.");
        } else {
            int vagas = limiteMaximo - livrosAtuais;
            System.out.println("[Liberado] Tudo ok! Ainda pode pegar até " + vagas + " livro(s).");
            System.out.println("Prazo de devolução: " + prazoDias + " dias.");
        }
    }

    private static void calcularDevolucaoMulta(Scanner scanner, int prazoDias, double multaDiaria) {
        System.out.println("\n--- CALCULAR MULTA ---");
        
        int diasComLivro = lerInteiroValidado(
            scanner, 
            "Quantos dias o livro ficou com a pessoa? ", 
            "[Erro] Digite um número válido."
        );

        if (diasComLivro < 0) {
            System.out.println("[Erro] Os dias não podem ser negativos.");
            return;
        }

        if (diasComLivro <= prazoDias) {
            System.out.println("[Ok] Devolvido no prazo! Sem multa.");
        } else {
            int atraso = diasComLivro - prazoDias;
            double multaTotal = atraso * multaDiaria;

            System.out.println("[Atraso] O livro está com " + atraso + " dia(s) de atraso.");
            System.out.printf("Multa total a pagar: R$ %.2f%n", multaTotal);
        }
    }
}