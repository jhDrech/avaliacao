package trabalho;

public class Garcom extends Funcionario{
    private float percentualGarcom;

    public Garcom() {
    }

    public Garcom(float percentualGarcom) {
        this.percentualGarcom = percentualGarcom;
    }

    public float getPercentualGarcom() {
        return percentualGarcom;
    }

    public void setPercentualGarcom(float percentualGarcom) {
        this.percentualGarcom = percentualGarcom;
    }
}
