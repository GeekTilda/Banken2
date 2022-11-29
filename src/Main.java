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
    public static void meny() { //Metod som visar menyn.
        System.out.println("~~~ Meny ~~~");
        System.out.println("1. Ny kund");
        System.out.println("2. Ñytt konto");
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

        switch (i) { //Olika scenarion (se menyn)
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
        bank.addKund(kund); //Lägger till kunden i bankens lista av kunder
        Transaktionskonto transaktionskonto = new Transaktionskonto(kund); //Skapar ett nytt transaktionskonto
        kund.addKonto(transaktionskonto); //Lägger till transaktionskontot hos kundens lista av konton
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

        System.out.print("Vad är ditt namn? ");
        System.out.println();
        String namn = sc.nextLine();

        switch (i) {
            case 1:
                for (Kund k : bank.kunder) { //For loop som går igenom listan av kunder i banken
                    if (k.namn == namn) { //Om namnet för kunden matchar namnet man skrev in
                        System.out.println("Namn: " + k.namn + ". Personnummer: " + k.personnummer + ". Kontonummer: " + k.kontonummer);
                        Konto konto = new Konto(k); //Skapar ett nytt konto
                        konto.addKund(); //Lägger till kunden som kontoansvarig
                        k.addKonto(konto); //Lägger till kontot hos kunden.
                        System.out.println("Nytt konto tillagt! ");
                        break;
                    }
                    else {
                        System.out.println("Det finns ingen med det namnet i vår databas! ");
                        break;
                    }
                }

            case 2:
                for (Kund k : bank.kunder) { //For loop som går igenom listan av kunder i banken
                    if (k.namn == namn) { //Om namnet för kunden matchar namnet man skrev in
                        Sparkonto sparkonto = new Sparkonto(); //Skapar ett nytt Sparkonto
                        sparkonto.addKund(); //Lägger till kunden som kontoansvarig
                        k.addKonto(sparkonto); //Lägger till sparkontot hos kunden.
                        break;
                    }
                    else {
                        System.out.println("Det finns ingen med det namnet i vår databas! ");
                        break;
                    }
                }
        }
    }
}
