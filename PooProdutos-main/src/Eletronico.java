public class Eletronico extends Produto {
    private String marca;

    public Eletronico(String nome, double preco, int quantidade, String marca) {
        super(nome, preco, quantidade);
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    @Override
    // Sobrescrevendo o método mostrarDetalhes() para exibir detalhes específicos de produtos eletrônicos
    public void mostrarDetalhes() {
        System.out.println("Eletrônico: " + getNome() + ", Preço: " + getPreco() + ", Quantidade: " + getQuantidade() + ", Marca: " + marca);
    }
}
