package trabalho;

import java.util.List;
public class Pedido {
    private Mesa mesa;
    private float percentualGarcom;
    private float total;
    private List<Pizza> pedidoPizza;
    private List<Bebida> pedidoBebida;

    public Pedido() {
    }
    
    public Mesa getMesa() {
        return mesa;
    }
    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }
    public float getPercentualGarcom() {
        return percentualGarcom;
    }
    public void setPercentualGarcom(float percentualGarcom) {
        this.percentualGarcom = percentualGarcom;
    }
    public float getTotal() {
        return total;
    }
    public void setTotal(float total) {
        this.total = total;
    }
    public List<Pizza> getPedidoPizza() {
        return pedidoPizza;
    }
    public void setPedidoPizza(List<Pizza> pedidoPizza) {
        this.pedidoPizza = pedidoPizza;
    }
    public List<Bebida> getPedidoBebida() {
        return pedidoBebida;
    }
    public void setPedidoBebida(List<Bebida> pedidoBebida) {
        this.pedidoBebida = pedidoBebida;
    }
}
