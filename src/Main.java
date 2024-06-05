import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        SistemaDeEstoque sistema = new SistemaDeEstoque();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Adicionar produto");
            System.out.println("2. Remover produto");
            System.out.println("3. Exibir estoque");
            System.out.println("4. Sair");

            int opcao = 0;
            while (true) {
                try {
                    opcao = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Por favor, insira um número válido.");
                    scanner.next(); // Limpa a entrada inválida
                }
            }

            switch (opcao) {

                case 1:
                    // Adicionar produto
                    int id = 0;
                    while (true) {
                        try {
                            System.out.print("ID do produto: ");
                            id = scanner.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Por favor, insira um número válido.");
                            scanner.next(); // Limpa a entrada inválida
                        }
                    }
                    scanner.nextLine();  // Consumir nova linha
                    System.out.print("Nome do produto: ");
                    String nome = scanner.nextLine();
                    int quantidade = 0;
                    while (true) {
                        try {
                            System.out.print("Quantidade do produto: ");
                            quantidade = scanner.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Por favor, insira um número válido.");
                            scanner.next(); // Limpa a entrada inválida
                        }
                    }
                    sistema.adicionarProduto(new Produto(id, nome, quantidade));
                    break;
                case 2:
                    // Remover produto
                    id = 0;
                    while (true) {
                        try {
                            System.out.print("ID do produto para remoção: ");
                            id = scanner.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Por favor, insira um número válido.");
                            scanner.next(); // Limpa a entrada inválida
                        }
                    }
                    quantidade = 0;
                    while (true) {
                        try {
                            System.out.print("Quantidade a remover: ");
                            quantidade = scanner.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Por favor, insira um número válido.");
                            scanner.next(); // Limpa a entrada inválida
                        }
                    }
                    try {
                        sistema.removerProduto(id, quantidade);
                    } catch (EstoqueInsuficienteException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    // Exibir estoque
                    sistema.exibirEstoque();
                    break;
                case 4:
                    // Sair
                    running = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        scanner.close();
    }
}
