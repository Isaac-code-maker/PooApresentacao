public class Alimento extends Produto {
    private String validade;

    public Alimento(String nome, double preco, int quantidade, String validade) {
        super(nome, preco, quantidade);
        this.validade = validade;
    }

    public String getValidade() {
        return validade;
    }

    @Override
     // Sobrescrevendo o método mostrarDetalhes() para exibir detalhes específicos de produtos alimentícios
    public void mostrarDetalhes() {
        System.out.println("Alimento: " + getNome() + ", Preço: " + getPreco() + ", Quantidade: " + getQuantidade() + ", Validade: " + validade);
    }
}
