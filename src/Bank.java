import java.util.ArrayList;

public class Bank {
    ArrayList<Kund> kunder = new ArrayList<Kund>(); //Skapar lista av kunder
    ArrayList<Konto> konton = new ArrayList<Konto>(); //Skapar lista av konton

    public Bank () {} //Skapar en instans av Banken

    public void addKund(Kund kund) { //Lägger till en kund till "kunder" listan.

        kunder.add(kund);
    }

    public void addKonto(Konto konto) { //Lägger till ett konto i "konto" listan.

        konton.add(konto);
    }

    public void antalKunder() { //En metod som skriver ut antal kunder som banken har
        int i = 0;
        for (Kund k : kunder) { //En for-loop som går igenom hela listan av kunder.
            i++;
        }
        System.out.println("Antal kunder: " + i); //Skriver ut antal kunder
    }

    public double omsattning() { //Räknar ihop alla kontons saldo
        double omsattning = 0;
        for (Konto k : konton) //For-loop som går igenom hela listan konton
        {
            omsattning = omsattning + k.getSaldo(); //Tar kontot k i listan konton och använder metoden getSaldo för att få dess saldo.
        }
        return omsattning;
    }
    //FIXA SÅ ATT FLERA KONTON MED SAMMA NAMN INTE FÅR EXISTERA???
}
