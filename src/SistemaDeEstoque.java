import java.util.ArrayList;
import java.util.List;

public class SistemaDeEstoque {
    private List<Produto> produtos;

    public SistemaDeEstoque() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void removerProduto(int id, int quantidade) throws EstoqueInsuficienteException {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                produto.removerQuantidade(quantidade);
                return;
            }
        }
        System.out.println("Produto não encontrado.");
    }

    public void exibirEstoque() {
        System.out.println("Estoque atual:");
        for (Produto produto : produtos) {
            System.out.println("ID: " + produto.getId() + ", Nome: " + produto.getNome() + ", Quantidade: " + produto.getQuantidade());
        }
    }
}
