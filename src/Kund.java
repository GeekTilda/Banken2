import java.util.ArrayList;

public class Kund {
    String namn; //Namnet på kunden
    String personnummer; //Personnummer på kunden
    double kontonummer; //Kontonummret
    Transaktionskonto transaktionskonto = new Transaktionskonto();

    ArrayList<Konto> konton = new ArrayList<Konto>(); //Lista av konton som kunden har
    public Kund () {}

    public void kontolista() { //Skriver ut alla konton i listan "konton"
        int b = 0;
        for (Konto k : konton) {
            b++;
            System.out.println(b + ". " + k + ". Saldo: " + k.saldo); //Skriver ut alla konton och dess saldo
        }
    }

    public void addKonto(Konto konto){ //Lägger till kontot som skickas med i listan av konton som kunden har
        konton.add(konto);
    }

    public Kund (String namn, String personnummer,double kontonummer) { // -||-
        this.namn = namn;
        this.personnummer = personnummer;
        this.kontonummer = kontonummer;
    }
    public void amountPengar() { //En metod som skriver ut hur mycket pengar man har
        double pengar = 0;
        for (Konto k : konton) { //En for-loop som går igenom hela listan av konton.
            pengar =+ k.getSaldo();
        }
        System.out.println("Pengar på alla konton: " + pengar); //Skriver ut pengarna
    }
}
