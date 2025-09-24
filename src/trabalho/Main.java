package trabalho;

import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    final static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Pizza calabresa = new Pizza("Calabresa", 50);
        Pizza mussarela = new Pizza("Mussarela", 45);
        Pizza frangoComcatupiry = new Pizza("Frango com catupiry", 50);
        Bebida refrigerante = new Bebida("Refrigerante", 8);
        Bebida suco = new Bebida("Suco de Laranja", 12);
        Bebida suco2 = new Bebida("Suco de Abacaxi", 15);
        Bebida agua = new Bebida("Agua com gas", 6);
        Bebida agua2 = new Bebida("Agua da torneira", 0);

        Cardapio cardapio = new Cardapio();
        cardapio.adicionarBebida(suco);
        cardapio.adicionarBebida(refrigerante);
        cardapio.adicionarPizza(mussarela);
        cardapio.adicionarPizza(calabresa);
        cardapio.adicionarPizza(frangoComcatupiry);
        cardapio.adicionarBebida(suco2);
        cardapio.adicionarBebida(agua);
        cardapio.adicionarBebida(agua2);
        Garcom garcom = new Garcom();
        
        while(true){
            telaInicial(cardapio, garcom); 
        }
    }

    public static void telaInicial(Cardapio cardapio, Garcom garcom){
        limparTela();
        System.out.println("1. fazer pedido");
        System.out.println("2. mostrar cardápio");
        int entrada = sc.nextInt();    
        switch(entrada){
                case 1:
                fazerPedido(cardapio, garcom);
                case 2:
                limparTela();
                cardapio.mostrarCardapio();
                telaInicial(cardapio, garcom);
        }
    }

    public static void fazerPedido(Cardapio cardapio, Garcom garcom){
        limparTela();
        float conta = 0;
        float percentualGarcom = 0;
        ArrayList<Pizza> pedidosDePizzas = new ArrayList<Pizza>();
        ArrayList<Bebida> pedidosDeBebidas = new ArrayList<Bebida>();
        while(true){
            sc.nextLine();
            System.out.println("insira o nome da pizza");
            String pedido = sc.nextLine();
            Pizza pizzaFeita  = cardapio.obterPizzaPorNome(pedido); 
            pedidosDePizzas.add(pizzaFeita);
            conta += pizzaFeita.getPreco();

            System.out.println("insira o nome da bebida");
            pedido = sc.nextLine();
            Bebida bebidaRecebida  = cardapio.obterBebidaPorNome(pedido); 
            pedidosDeBebidas.add(bebidaRecebida);
            conta += bebidaRecebida.getPreco();           
            garcom.setPercentualGarcom(conta * (10/100));;

            limparTela();
            System.out.println("-------CONTA-------");
            System.out.println("PIZZAS:");
            for (Pizza pizzaPedida : pedidosDePizzas) {
                System.out.printf("%s - %2.2fR$\n", pizzaPedida.getNome(), pizzaPedida.getPreco());
            }
            System.out.println("BEBIDAS:");
            for (Bebida bebidaPedida : pedidosDeBebidas) {
                System.out.printf("%s - %2.2fR$\n", bebidaPedida.getNome(), bebidaPedida.getPreco());
            } 
            System.out.printf("TOTAL: %2.2fR$\n", conta);
            System.out.println("-------------------");

            System.out.println();
            System.out.println("0. encerrar");
            System.out.println("1. fazer novo pedido");
            int acao = sc.nextInt();
            switch (acao) {
                case 0:
                    System.exit(0);
                case 1:
                    telaInicial(cardapio, garcom);
                    break;
            }
        }
    }

    public static void limparTela() {
        for (int i = 0; i < 40; ++i) {
            System.out.println();
        }
        System.out.print("\033\143");

    }
}
