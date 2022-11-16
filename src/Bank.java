import java.util.ArrayList;

public class Bank {
    ArrayList<Kund> kunder = new ArrayList<Kund>(); //Skapar lista av kunder
    ArrayList<Konto> konton = new ArrayList<Konto>(); //Skapar lista av konton

    public Bank () {} //Skapar en instans av Banken

    public void addKund(Kund kund) { //Lägger till en kund till "kunder" listan.

        kunder.add(kund);
    }

    public  void addKonto(Konto konto) { //Lägger till ett konto i "konto" listan.

        konton.add(konto);
    }

    public double omsättning() { //Räknar ihop alla kontons värde FIXA FIXA FIXA
        for (Konto k : konton) //For-loop som går igenom hela listan konton
        {
            System.out.println(konton);
            //konton.get(saldo);
        }

        double omsättning = 0;
        return omsättning;
    }
}
