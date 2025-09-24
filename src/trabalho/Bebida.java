package trabalho;

public class Bebida {
    private String nome;
    private float preco;
    private String descricao;
   
    public Bebida(String nome, float preco) {
        this.nome = nome;
        this.preco = preco;
        
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public float getPreco() {
        return preco;
    }
    public void setPreco(float preco) {
        this.preco = preco;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }    
}
