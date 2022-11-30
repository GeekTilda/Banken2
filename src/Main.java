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
        System.out.println("3. Ändra saldo");
        System.out.println("4. Kolla transaktioner");
        System.out.println("5. Exit");
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
                saldo();
                break;
            case 4:
                transaktioner();
                break;
            case 5:
                System.exit(5); //Stänger av
        }
    }

    public static void nyKund() {
        Scanner sc = new Scanner(System.in); //Skapar en ny skanner
        System.out.println();
        System.out.println("Vad heter du?");
        String name = sc.nextLine().toLowerCase(); //Sätter namnet till det man skrev (toLowerCase fixar så att namnet blir helt lowercase)
        System.out.println("Vad är ditt personnummer? ");
        String personnummer = sc.nextLine(); //Sätter personnummret till det man skrev
        double kontonummer = (Math.random()*1000); //Får ett random kontonummer som först är en double men som bli konverterad till int
        System.out.println("Ditt konto nummer är " + kontonummer);
        Kund kund = new Kund(name,personnummer,kontonummer); //Gör en ny instans av objektet kund.
        bank.addKund(kund); //Lägger till kunden i bankens lista av kunder
        //kund.transaktionskonto.addTransaktion(15);
        kund.kontolista();
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

        System.out.println("Vad är ditt namn? ");
        String namn = sc.next().toLowerCase(); //toLowerCase fixar så att namnet blir helt lowercase

        switch (i) {
            case 1:
                int a = 0;
                for (Kund k : bank.kunder) { //For loop som går igenom listan av kunder i banken
                    System.out.println(k.namn); //Skriver ut namn
                    if (k.namn.equals(namn)) { //Om namnet för kunden matchar namnet man skrev in
                        System.out.println("Namn: " + k.namn + ". Personnummer: " + k.personnummer + ". Kontonummer: " + k.kontonummer);
                        Konto konto = new Konto(); //Skapar ett nytt konto
                        konto.addKund(k); //Lägger till kunden som kontoansvarig
                        k.addKonto(konto); //Lägger till kontot hos kunden.
                        System.out.println("Nytt konto tillagt! ");
                        a = 1;
                        k.kontolista(); //Skriver ut listan av konton
                        break;
                    }
                }
                if (a == 0) {
                System.out.println("Det finns ingen med det namnet i vår databas! ");
                }
                break;
            case 2:
                int b = 0;
                for (Kund k : bank.kunder) { //For loop som går igenom listan av kunder i banken
                    if (k.namn.equals(namn)) { //Om namnet för kunden matchar namnet man skrev in
                        Sparkonto sparkonto = new Sparkonto(); //Skapar ett nytt Sparkonto
                        sparkonto.addKund(k); //Lägger till kunden som kontoansvarig
                        k.addKonto(sparkonto); //Lägger till sparkontot hos kunden.
                        System.out.println("Nytt konto tillagt! ");
                        k.kontolista(); //Skriver ut listan av konton
                        b = 1;
                        break;
                    }
                }
                if (b == 0) {
                    System.out.println("Det finns ingen med det namnet i vår databas! ");
                    break;
                }
        }
    }
    public static void saldo() { //Saldo metod som ändrar saldot.
        System.out.println("Vill du ta ut eller lägga in pengar? ");
        System.out.println("1. Ta ut");
        System.out.println("2. Lägga in");
        int i = 0;
        Scanner sc = new Scanner(System.in); //Skapar en ny skanner

        try { //Try-catch metod som kollar om det man skriver in är ett heltal.
            i = sc.nextInt();
        } catch (Exception e) { //Om det inte är ett heltal skrivs följande text ut.
            System.out.println("Skriv in ett heltal (1 eller 2)!");
        }

        if (i == 1 || i == 2) { //Kollar så att man skrev 1 eller 2
            System.out.println("Vad är ditt namn? ");
            String namn = sc.next().toLowerCase(); //toLowerCase fixar så att namnet blir helt lowercase
            switch (i) {
                case 1:
                    int a = 0;
                    int b = 0;
                    double c = 0;
                    double d = 0;
                    for (Kund k : bank.kunder) { //For loop som går igenom listan av kunder i banken
                        System.out.println(k.namn);
                        if (k.namn.equals(namn)) { //Om namnet för kunden matchar namnet man skrev in
                            System.out.println("Namn: " + k.namn + ". Personnummer: " + k.personnummer);
                            k.kontolista();
                            System.out.println("Vilket konto? (Skriv heltal)");
                            try { //Try-catch metod som kollar om det man skriver in är ett heltal.
                                c = sc.nextDouble();
                            } catch (Exception e) { //Om det inte är ett heltal skrivs följande text ut.
                                System.out.println("Skriv in ett heltal som matchar kontot!");
                            }
                            for (Konto t : k.konton) {
                                b++;
                            }
                            if (c > b || c < 0) { //Kollar om det man skrev in var ett riktigt konto eller bara ett random nummer
                                System.out.println("Inte riktigt konto!");
                                break;
                            }
                            int f = 0;
                            int g = 0;
                            for (Konto kon : k.konton) { //Går igenom alla konton i kundens lista av konton
                                f++;
                                if (f == b) { //Hittar samma konto
                                    System.out.println("Hur mycket vill du ta ut?");
                                    try { //Try-catch metod som kollar om det man skriver in är ett heltal.
                                        d = sc.nextDouble();
                                    } catch (Exception e) { //Om det inte är ett heltal skrivs följande text ut.
                                        System.out.println("Skriv in ett heltal som matchar kontot!");
                                    }
                                    if (d > kon.saldo) { //Kollar om man försöker ta ut mer än vad man har
                                        System.out.println("Går inte att ta ut mer än vad du har!");
                                        break;
                                    }
                                    kon.addSaldo(d * -1, k); //Ändrar saldot
                                    k.transaktionskonto.addTransaktion(d * -1); //Lägger till transaktionen
                                    g = 1;
                                    break;
                                }
                            }
                            if (g == 0) { //Om det inte hittade något konto/om något gick fel
                                break;
                            }
                            a = 1;
                            break;
                        }
                    }
                    if (a == 0) {
                        System.out.println("Det finns ingen med det namnet i vår databas! ");
                        break;
                    }
                    break;
                case 2:
                    a = 0;
                    b = 0;
                    c = 0;
                    d = 0;
                    for (Kund k : bank.kunder) { //For loop som går igenom listan av kunder i banken
                        System.out.println(k.namn);
                        if (k.namn.equals(namn)) { //Om namnet för kunden matchar namnet man skrev in
                            System.out.println("Namn: " + k.namn + ". Personnummer: " + k.personnummer);
                            k.kontolista();
                            for (Konto t : k.konton) {
                                b++;
                            }
                            System.out.println("Vilket konto? (Skriv heltal)");
                            try { //Try-catch metod som kollar om det man skriver in är ett heltal.
                                c = sc.nextDouble();
                            } catch (Exception e) { //Om det inte är ett heltal skrivs följande text ut.
                                System.out.println("Skriv in ett heltal som matchar kontot!");
                            }
                            if (c > b || c < 0) { //Kollar om det man skrev in var ett riktigt konto eller bara ett random nummer
                                System.out.println("Inte riktigt konto!");
                                break;
                            }
                            int f = 0;
                            int g = 0;
                            for (Konto kon : k.konton) { //Går igenom alla konton i kundens lista av konton
                                f++;
                                if (f == b) { //Hittar samma konto
                                    System.out.println("Hur mycket vill du lägga in?");
                                    try { //Try-catch metod som kollar om det man skriver in är ett heltal.
                                        d = sc.nextDouble();
                                    } catch (Exception e) { //Om det inte är ett heltal skrivs följande text ut.
                                        System.out.println("Skriv in ett heltal som matchar kontot!");
                                    }
                                    kon.addSaldo(d, k); //Ändrar saldot
                                    k.transaktionskonto.addTransaktion(d); //Lägger till transaktionen
                                    g = 1;
                                    break;
                                }
                            }
                            if (g == 0) { //Om det inte hittade något konto/om något gick fel
                                break;
                            }
                            a = 1;
                            break;
                        }
                    }
                    if (a == 0) {
                        System.out.println("Det finns ingen med det namnet i vår databas! ");
                        break;
                    }
                    break;
            }
        }
    }
    public static void transaktioner() {
        Scanner sc = new Scanner(System.in); //Skapar en ny skanner
        System.out.println("Vad är ditt namn? ");
        String namn = sc.next().toLowerCase(); //toLowerCase fixar så att namnet blir helt lowercase

        for (Kund k : bank.kunder) { //For loop som går igenom listan av kunder i banken
            if (k.namn.equals(namn)) { //Om namnet för kunden matchar namnet man skrev in
                k.transaktionskonto.writeTransaktion(); //Skriver ut alla transaktioner
                break;
            }
        }

    }
}
