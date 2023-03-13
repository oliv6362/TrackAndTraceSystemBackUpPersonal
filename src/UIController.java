import java.util.Scanner;

public class UIController {


    //Denne funktion bruges når en bruger operetter en modtager i databasen ved brug af consollen.
    public static Modtager opretModtager() {
        Scanner input = new Scanner(System.in);

        System.out.println("Indtast modtager:");

        System.out.println("fornavn");
        String modtagerfNavn = input.next();

        System.out.println("efternavn");
        String modtagereNavn = input.next();

        System.out.println("adresse");
        String modtagerAdresse = input.next();

        System.out.println("postnummer");
        String modtagerPostnr = input.next();

        System.out.println("telefonnummer");
        String modtagerTelefonnr = input.next();

        System.out.println("email");
        String modtagerEmail = input.next();

        Modtager m = new Modtager(modtagerfNavn, modtagereNavn, modtagerAdresse, modtagerPostnr, modtagerTelefonnr, modtagerEmail);

        return m;
    }
}
