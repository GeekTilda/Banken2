import java.util.ArrayList;

public class Konto {
    double saldo;
    double transaktion = 0;
    //Kund kund = new Kund(); //Skapar en ny instans av objektet kund. Detta för att kunna använda det i addKund()

    public Konto() {}

    public void addKund(Kund kund) { //För att lägga till en kund till ett konto
        kund.addKonto(this); //Skickar vårt konto till kund klassen som skickar in det i metoden "addKonto"
    }

    public void addSaldo(double transaktion, Kund kund) { //Ändrar saldot efter senaste transaktionen.
        //this.transaktion = 0; //Nollställer transaktionen
        saldo = saldo + transaktion; //Ändrar saldot efter transaktionen
        this.transaktion = transaktion; //Sätter transaktionen som den vi precis fick in
        kund.transaktionskonto.addTransaktion(this.transaktion); //Skickar transaktionen till transaktionskontot och lägger till det i listan av transaktioner
    }

    public double getSaldo() {
        return saldo;
    }
}

