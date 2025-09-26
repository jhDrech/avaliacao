package trabalho;

import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    final static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        //INGREDIENTES
        Ingrediente linguicaCalabresa = new Ingrediente("Calabresa");   
        Ingrediente queijoMussarela = new Ingrediente("Mussarela");
        Ingrediente frango = new Ingrediente("Frango desfiado");
        Ingrediente catupiry = new Ingrediente("Catupiry");
        Ingrediente molhoDeTomate = new Ingrediente("Molho de tomate");
        Ingrediente oregano = new Ingrediente("Orégano");
        Ingrediente cebola = new Ingrediente("Cebola");
        
        //PIZZAS
        Pizza calabresa = new Pizza("Calabresa", 50);
        calabresa.adicionarIngredientes(linguicaCalabresa, molhoDeTomate, oregano, cebola);
        Pizza mussarela = new Pizza("Mussarela", 45);
        mussarela.adicionarIngredientes(queijoMussarela, molhoDeTomate, oregano);
        Pizza frangoComcatupiry = new Pizza("Frango com catupiry", 50);
        frangoComcatupiry.adicionarIngredientes(frango, catupiry, molhoDeTomate, oregano);

        //BEBIDAS
        Bebida refrigerante = new Bebida("Refrigerante", 8);
        Bebida suco = new Bebida("Suco de Laranja", 12);
        Bebida suco2 = new Bebida("Suco de Abacaxi", 15);
        Bebida agua = new Bebida("Agua com gas", 6);
        Bebida agua2 = new Bebida("Agua sem gas", 6);

        //CARDAPIO 
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
        System.out.printf(" _____     _____    ______     ______      ____    _______\n");
        System.out.printf("(  __ \\   (_   _)  (____  )   (____  )    (    )   \\     / \n");
        System.out.printf(" ) )_) )    | |        / /        / /     / /\\ \\    \\   / \n");
        System.out.printf("(  ___/     | |    ___/ /_    ___/ /_    ( (__) )    ) (  \n");
        System.out.printf(" ) )        | |   /__  ___)  /__  ___)    )    (     \\_/  \n");
        System.out.printf("( (        _| |__   / /____    / /____   /  /\\  \\     _   \n");
        System.out.printf("/__\\      /_____(  (_______)  (_______) /__(  )__\\   (_)  \n");
        System.out.println();
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
        int qtdPizzas = 0;
        int qtdBebidas = 0;
        float conta = 0;
        float percentualGarcom = 0;
        ArrayList<Pizza> pedidosDePizzas = new ArrayList<Pizza>();
        ArrayList<Bebida> pedidosDeBebidas = new ArrayList<Bebida>();
        while(true){
            sc.nextLine();
            System.out.println("Quantas pizzas deseja pedir?");
            while(true){
                qtdPizzas = sc.nextInt();
                if(qtdPizzas > cardapio.getCardapioPizzas().size()){
                    System.out.println("Quantidade inválida, temos apenas " + cardapio.getCardapioPizzas().size() + " pizzas no cardápio");
                    System.out.println("insira novamente:");
            }else{
                break;
            }
        }
            sc.nextLine();
            for (int i = 0; i < qtdPizzas; i++) {
                System.out.println("insira o nome da pizza:");
                String pedido = sc.nextLine();
                Pizza pizzaFeita  = cardapio.obterPizzaPorNome(pedido); 
                pedidosDePizzas.add(pizzaFeita);
                conta += pizzaFeita.getPreco();
            }

            System.out.println("Quantas bebidas deseja pedir?");
            while(true){
                qtdBebidas = sc.nextInt();
                if(qtdBebidas > cardapio.getCardapioPizzas().size()){
                    System.out.println("Quantidade inválida, temos apenas " + cardapio.getCardapioPizzas().size() + " bebidas no cardápio");
                    System.out.println("insira novamente:");
                    qtdBebidas = sc.nextInt();
            }else{
                break;
            }
        }
            sc.nextLine();
            for (int i = 0; i < qtdBebidas; i++) {
                System.out.println("insira o nome da bebida");
                String pedido = sc.nextLine();
                Bebida bebidaRecebida  = cardapio.obterBebidaPorNome(pedido); 
                pedidosDeBebidas.add(bebidaRecebida);
                conta += bebidaRecebida.getPreco();           
            }
            garcom.setPercentualGarcom(conta * 10/100);
            conta += garcom.getPercentualGarcom();

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
            System.out.printf("PERCENTUAL DO GARÇOM (10%%): %2.2fR$\n", garcom.getPercentualGarcom());
            System.out.printf("TOTAL: %2.2fR$\n", conta);
            System.out.println("-------------------");

            System.out.println();
            System.out.println("0. encerrar");
            System.out.println("1. fazer novo pedido");
            int acao = sc.nextInt();
            switch (acao) {
                case 0:
                System.out.println();
                System.out.printf("                  .;      .                      \n");
                System.out.printf(".;.       .-.    .;'  ...;...                    \n");
                System.out.printf(" `;     .'.-.   .;     .'.-.                     \n");
                System.out.printf("  ;;  .' ;   ;'::    .;.;.-'                     \n");
                System.out.printf(" ;;  ;   `;;'_;;_.-.;   `:::'                    \n");
                System.out.printf(" `;.'      .-.                                .;.\n");
                System.out.printf("   .;;;.`-'                                  ;;;'\n");
                System.out.printf("  ;;     .-.  . ,';.,';. `..:.   .;.::..-.  .;'  \n");
                System.out.printf("  `;;;..;.-'  ;;  ;;  ;;  ;;  :  .;  .;.-' .-.   \n");
                System.out.printf("  _   `:`:::'';  ;;  ';   ;;_.`.;'    `:::'`-'   \n");
                System.out.printf(" (_.;;;'    _;        `-'.;'                     \n");
                System.out.println();
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
