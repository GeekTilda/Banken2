import java.util.ArrayList;

public class Kund {
    String namn; //Namnet på kunden
    String personnummer; //Personnumer på kunden
    int Kontonummer; //Kontonummret

    ArrayList<Konto> konton = new ArrayList<Konto>(); //Lista av konton som kunden har
    public Kund () {}

    public void addKonto(Konto konto){ //Lägger till kontot som skickas med i listan av konton som kunden har
        konton.add(konto);
    }

    public Kund (String namn) { //Skickar med namn för att kunna göra en kund med ett namn (användes mest bara för att kolla om saker fungerade)
        this.namn = namn;
    }

    public Kund (String namn, String personnummer) { // -||-
        this.namn = namn;
        this.personnummer = personnummer;
    }


}
