import java.util.Scanner;

public class CadastroProduto {
    public static void main(String[] args) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== Menu de Cadastro de Produtos ===");
            System.out.println("1. Cadastrar Produto");
            System.out.println("2. Deletar Produto");
            System.out.println("3. Listar Produtos");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    cadastrarProduto(produtoDAO, scanner);
                    break;
                case 2:
                    deletarProduto(produtoDAO, scanner);
                    break;
                case 3:
                    produtoDAO.listarProdutos();
                    break;
                case 4:
                    running = false;
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }

    private static void cadastrarProduto(ProdutoDAO produtoDAO, Scanner scanner) {
        System.out.println("\n--- Cadastrar Produto ---");
        System.out.print("Tipo de Produto (Eletronico/Alimento): ");
        String tipo = scanner.nextLine();

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Preço: ");
        double preco = scanner.nextDouble();

        System.out.print("Quantidade: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();  // Limpar o buffer do scanner

        Produto produto = null;

        if (tipo.equalsIgnoreCase("Eletronico")) {
            System.out.print("Marca: ");
            String marca = scanner.nextLine();

            produto = new Eletronico(nome, preco, quantidade, marca);
        } else if (tipo.equalsIgnoreCase("Alimento")) {
            System.out.print("Validade: ");
            String validade = scanner.nextLine();

            produto = new Alimento(nome, preco, quantidade, validade);
        } else {
            System.out.println("Tipo de produto inválido.");
            return;
        }

        produtoDAO.adicionarProduto(produto);
    }

    private static void deletarProduto(ProdutoDAO produtoDAO, Scanner scanner) {
        System.out.println("\n--- Deletar Produto ---");
        System.out.print("Nome do Produto: ");
        String nome = scanner.nextLine();

        produtoDAO.removerProduto(nome);
    }

    private static void listarProdutos(ProdutoDAO produtoDAO) { // Listando todos os produtos, demonstrando o polimorfismo
        System.out.println("\n--- Listar Produtos ---");
        produtoDAO.listarProdutos();
    }
}
