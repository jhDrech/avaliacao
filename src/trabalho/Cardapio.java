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

    public void adicionarBebida(Bebida bebida){
        this.cardapioBebidas.add(bebida);
    }

    public void mostrarCardapio(){
        while (true) {
            int i = 1; 
            System.out.println("\n--- PIZZAS ---");
            for (Pizza pizza : cardapioPizzas) {
                System.out.printf("%d. %s: R$ %2.2f\n", i, pizza.getNome(), pizza.getPreco());
                i++;
            }
            i = 1;
            System.out.println("\n--- BEBIDAS ---");
            for (Bebida bebida : cardapioBebidas) {
                System.out.printf("%d. %s: R$ %2.2f\n", i, bebida.getNome(), bebida.getPreco());
                i++;
            }
            System.out.println("-------------------");
            System.out.println("insira 0 para voltar!");
                int acao = sc.nextInt();
                if (acao == 0) {
                    break;
                }else{
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
