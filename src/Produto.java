public class Produto {
    private int id;
    private String nome;
    private int quantidade;

    public Produto(int id, String nome, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void adicionarQuantidade(int quantidade) {
        this.quantidade += quantidade;
    }

    public void removerQuantidade(int quantidade) throws EstoqueInsuficienteException {
        if (this.quantidade < quantidade) {
            throw new EstoqueInsuficienteException("Quantidade solicitada excede a quantidade em estoque!");
        }
        this.quantidade -= quantidade;
    }
}

