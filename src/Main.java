import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in); //Skapar en ny skanner
        while (true) {
            meny();
        }
    }
    public static void meny() {
        System.out.println("~~~ Meny ~~~");
        System.out.println("1. Ny kund");
        System.out.println("2. Ñytt konto"); //VILKEN KONTOTYP????
        System.out.println("3. "); //ETC
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
                //nyKund();
                break;
            case 2:
                //nyttKonto();
                break;
            case 3:
                //ETC
                break;
        }
    }
}