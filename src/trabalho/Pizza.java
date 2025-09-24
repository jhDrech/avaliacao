package trabalho;

import java.util.ArrayList;
public class Pizza {
    private String nome;
    private float preco;
    private ArrayList<Ingrediente> ingredientes;
    
    public Pizza(String nome, float preco) {
        this.nome = nome;
        this. preco = preco;
    }

    public void adicionarIngredientes(Ingrediente ingrediente){
        this.ingredientes.add(ingrediente);
    }

    public void mostrarIngredientes(ArrayList ingredientes){
        for (Ingrediente ingrediente : this.ingredientes) {
            System.out.printf("%s, \n", ingrediente.getNome());
        }
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
    public void setPreco(int preco) {
        this.preco = preco;
    }
    public ArrayList<Ingrediente> getIngredientes() {
        return ingredientes;
    }
    public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }
}
