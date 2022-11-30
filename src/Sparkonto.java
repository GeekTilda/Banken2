public class Sparkonto extends Konto{
    double renta = 0.04; //Räntan på sparkontot

    public Sparkonto() {}

    public void addRenta() { //Lägger till räntan på saldo
        saldo = saldo*renta;

    }
}
