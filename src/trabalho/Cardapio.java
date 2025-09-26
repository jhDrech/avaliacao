package trabalho;

import java.util.ArrayList;
import java.util.Scanner;
public class Cardapio {
    final static Scanner sc = new Scanner(System.in);

    private ArrayList<Pizza> cardapioPizzas;
    private ArrayList<Bebida> cardapioBebidas;

    public Cardapio() {
        this.cardapioBebidas = new ArrayList<>();
        this.cardapioPizzas = new ArrayList<>();
    }

    public void adicionarPizza(Pizza pizza){
        this.cardapioPizzas.add(pizza);
    }

    public void removerPizza(Pizza pizza){
        this.cardapioPizzas.remove(pizza);
    }

    public void adicionarBebida(Bebida bebida){
        this.cardapioBebidas.add(bebida);
    }

    public void removerBebida(Bebida bebida){
        this.cardapioBebidas.remove(bebida);
    }

    public void mostrarCardapio(){
        while (true) {
            int i = 1; 
            System.out.printf("   __\n");
            System.out.printf("  /  )           /             \n");
            System.out.printf(" /   __.  __  __/ __.  _   o __\n");
            System.out.printf("(__/(_/|_/ (_(_/_(_/|_/_)_<_(_)\n");
            System.out.printf("                     /\n");
            System.out.printf("                    '\n");
            System.out.println("\n----- PIZZAS ------");
            for (Pizza pizza : cardapioPizzas) {
                System.out.printf("%d. %s: R$ %2.2f\n", i, pizza.getNome(), pizza.getPreco());
                i++;
            }
            i = 1;
            System.out.println("\n----- BEBIDAS -----");
            for (Bebida bebida : cardapioBebidas) {
                System.out.printf("%d. %s: R$ %2.2f\n", i, bebida.getNome(), bebida.getPreco());
                i++;
            }
            System.out.println("-------------------");
            System.out.println("insira 0 para voltar!");
            System.out.println("insira 1 para obter os ingredientes de uma pizza!");
                int acao = sc.nextInt();
                if (acao == 0) {
                    break;
                }else if(acao == 1){
                    sc.nextLine();
                    System.out.println("Qual pizza você gostaria de ver os ingredientes?");
                    String nomePizza = sc.nextLine();
                    Pizza pizzaEscolhida = obterPizzaPorNome(nomePizza);
                    if(pizzaEscolhida != null){
                        System.out.printf("Ingredientes da pizza %s:\n", pizzaEscolhida.getNome());
                        pizzaEscolhida.mostrarIngredientes();
                    }else{
                        System.out.println("Pizza não encontrada no cardápio!");
                    }
                }else{
                    System.out.println("Ação inválida! Tente novamente");
                    acao = sc.nextInt();
                }
        }
    }

    public Pizza obterPizzaPorNome(String nome){
        for (Pizza pedido : cardapioPizzas) {
            if (pedido.getNome().equalsIgnoreCase(nome)) return pedido;
        }
        return null;
    }
    public Bebida obterBebidaPorNome(String nome){
        for (Bebida pedido : cardapioBebidas) {
            if (pedido.getNome().equalsIgnoreCase(nome)) return pedido;
        }
        return null;
    }
    public ArrayList<Pizza> getCardapioPizzas() {
        return cardapioPizzas;
    }
    public void setCardapioPizzas(ArrayList<Pizza> cardapioPizzas) {
        this.cardapioPizzas = cardapioPizzas;
    }
    public ArrayList<Bebida> getCardapioBebidas() {
        return cardapioBebidas;
    }
    public void setCardapioBebidas(ArrayList<Bebida> cardapioBebidas) {
        this.cardapioBebidas = cardapioBebidas;
    }
}
