import java.util.ArrayList;

public class Transaktionskonto extends Konto { //LÄNKA SAMMAN TRANSAKTIONSKONTO OCH VANLIGT KONTO???
    double senasteTransaktion;
    ArrayList<String> transaktioner = new ArrayList<String>(); //Lista av transaktioner

    public Transaktionskonto() {}

    public Transaktionskonto(Kund kund) {
        this.kund = kund;
    }

    public void addTransaktion() { //Lägger till den senaste transaktionen i vår lista av transaktioner.
        transaktion = this.senasteTransaktion; //Gör senasteTransaktion till den transaktionen vi precis gjorde
        transaktioner.add(String.valueOf(transaktion));
    }
}
