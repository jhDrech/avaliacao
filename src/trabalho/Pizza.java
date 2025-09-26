package trabalho;

import java.util.ArrayList;
public class Pizza {
    private String nome;
    private float preco;
    private ArrayList<Ingrediente> ingredientes;
    
    public Pizza(String nome, float preco) {
        this.nome = nome;
        this. preco = preco;
        this.ingredientes = new ArrayList<>();
    }

    public void adicionarIngredientes(Ingrediente... ingredientes){
        for (Ingrediente ingrediente : ingredientes) {
            this.ingredientes.add(ingrediente);
        } 
    }

    public void mostrarIngredientes(){
        for (Ingrediente ingrediente : this.ingredientes) {
            System.out.printf("- %s ", ingrediente.getNome());
        }
        System.out.println();
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
