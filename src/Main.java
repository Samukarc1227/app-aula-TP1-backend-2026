import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        final int LIMITE_EMPRESTIMOS = 10;
        final int PRAZO_DIAS = 14;
        final double VALOR_MULTA_POR_DIA = 2.50;
        final int OPCAO_SAIR = 3;

        System.out.println("=== SISTEMA DE GERENCIAMENTO DE BIBLIOTECA ===");

        do {
            Biblioteca.exibirMenu();
            
            opcao = Biblioteca.lerInteiroValidado(
                scanner, 
                "Escolha uma opção: ", 
                "[ERRO] Entrada inválida! Por favor, digite um número inteiro correspondente à opção."
            );

            Biblioteca.processarOpcao(opcao, scanner, LIMITE_EMPRESTIMOS, PRAZO_DIAS, VALOR_MULTA_POR_DIA, OPCAO_SAIR);

            System.out.println();
        } while (opcao != OPCAO_SAIR);

        scanner.close();
    }
}