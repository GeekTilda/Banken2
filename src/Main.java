import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Bank bank = new Bank(); //Gör vår bank
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in); //Skapar en ny skanner
        while (true) { //Håller programmet vid liv
            meny();
        }
    }
    public static void meny() {
        System.out.println("~~~ Meny ~~~");
        System.out.println("1. Ny kund");
        System.out.println("2. Ñytt konto"); //VILKEN KONTOTYP????
        System.out.println("3. Ändra saldo"); //ETC
        System.out.println("4. Exit");
        System.out.print("SKRIV: ");
        int i = 0;

        Scanner sc = new Scanner(System.in); //Skapar en ny skanner
        try { //Try-catch metod som kollar om det man skriver in är ett heltal.
            i = sc.nextInt();
        } catch (Exception e) { //Om det inte är ett heltal skrivs följande text ut och användaren får testa igen.
            System.out.println("Skriv in ett heltal (1, 2, 3 eller 4)!");
        }

        switch (i) {
            case 1:
                nyKund();
                break;
            case 2:
                nyttKonto();
                break;
            case 3:
                //saldo
                break;
            case 4:
                System.exit(5); //Stänger av
        }
    }
    public static void nyKund() {
        Scanner sc = new Scanner(System.in); //Skapar en ny skanner
        System.out.println();
        System.out.println("Vad heter du?");
        String name = sc.nextLine(); //Sätter namnet till det man skrev
        System.out.println("Vad är ditt personnummer? ");
        String personnummer = sc.nextLine(); //Sätter personnummret till det man skrev
        double kontonummer = (int) (Math.random()*1000); //Får ett random kontonummer som först är en double men som bli konverterad till int
        System.out.println("Ditt konto nummer är " + kontonummer);
        Kund kund = new Kund(name,personnummer,kontonummer); //Gör en ny instans av objektet kund.
        Transaktionskonto transaktionskonto = new Transaktionskonto(kund); //Skapar ett nytt transaktionskonto
    }
    public static void nyttKonto() {
        Scanner sc = new Scanner(System.in); //Skapar en ny skanner
        System.out.println("Vilket slags konto vill du ha? ");
        System.out.println("1. Vanligt konto");
        System.out.println("2. Sparkonto");
        int i = 0;

        try { //Try-catch metod som kollar om det man skriver in är ett heltal.
            i = sc.nextInt();
        } catch (Exception e) { //Om det inte är ett heltal skrivs följande text ut och användaren får testa igen.
            System.out.println("Skriv in ett heltal (1 eller 2)!");
        }

        switch (i) {
            case 1:
                System.out.println("Vad är ditt namn? ");
                String namn = sc.nextLine();
                for (Kund k : bank.kunder) { //For loop som går igenom listan av kunder i banken
                    if (k.namn == namn) { //Om namnet för kunden matchar namnet man skrev in
                        Konto konto = new Konto(k); //Skapar ett nytt konto
                        break;
                    }
                }
                System.out.println("Det finns ingen med det namnet i vår databas! ");
                break;
            case 2:

                break;
        }
    }
}
