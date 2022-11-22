import java.util.ArrayList;

public class Konto {
    Kund owner;
    double saldo;
    double transaktion;

    Kund kund = new Kund(); //Skapar en ny instans av objektet kund. Detta för att kunna använda det i addKund()

    public void addKund() { //För att lägga till en kund till ett konto
        kund.addKonto(this); //Skickar vårt konto till kund klassen som skickar in det i metoden "addKonto"
    }

    public void addSaldo(double transaktion) { //Ändrar saldot efter senaste transaktionen.
        this.transaktion = 0; //Nollställer transaktionen
        saldo = saldo + transaktion; //Ändrar saldot efter transaktionen
        this.transaktion = transaktion; //Sätter transaktionen som den vi precis fick in
    }

    public double getSaldo() {
        return saldo;
    }
}

