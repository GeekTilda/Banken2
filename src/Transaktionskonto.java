import java.util.ArrayList;

public class Transaktionskonto extends Konto { //LÄNKA SAMMAN TRANSAKTIONSKONTO OCH VANLIGT KONTO???
    double senasteTransaktion;
    ArrayList<String> transaktioner = new ArrayList<String>(); //Lista av transaktioner

    public Transaktionskonto() {}

    /*
    public Transaktionskonto(Kund kund) {
        this.kund = kund;
    }
     */

    public void writeTransaktion() {
        for (String s : transaktioner) {
            System.out.println(transaktioner);

        }
    }

    public void addTransaktion(double kontoTransaktion) { //Lägger till den senaste transaktionen i vår lista av transaktioner.
        //transaktion = this.senasteTransaktion; //Gör senasteTransaktion till den transaktionen vi precis gjorde
        transaktioner.add(String.valueOf(kontoTransaktion)); //Lägger till den transaktionen vi precis skrev in i listan av transaktioner
    }
}
