import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Kalder funktionen menu
        menu();
    }

    public static Modtager opretModtager (){
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

        Modtager m = new Modtager (modtagerfNavn, modtagereNavn, modtagerAdresse, modtagerPostnr, modtagerTelefonnr, modtagerEmail);

        return m;
    }

    public static void menu() {

        int valg;
        //skaber kontakt til DBsql klassen ved at lave et objekt
        DBSql db = new DBSql();
        //opretter en scanner
        Scanner input = new Scanner(System.in);
        //fortæller brugeren deres valgmuligheder
        System.out.println(
                        "1. Opret bruger \n" +
                        "2. Opret pakke \n" +
                        "3. Spor din pakke \n" +
                        "4. Opdater pakke \n" +
                        "5. hent alle pakker \n" +
                        "6. Vis alle brugere \n" +
                        "7. Afslut \n" +
                        "Indtast dit valg");
        valg = input.nextInt();
        //Et switch statement, hvor at brugeren kan vælge imellem de forskellige cases og hver case gør noget forskelligt
        switch (valg) {
            case 1:
                //afsenderen opretter en pakke som foregår i funktionen opretpakke
                //kalder en funktion over i dbsql klassen
                Modtager m = opretModtager();
                db.indsaetModtager(m);

                break;

            case 2:
                //modtageren kan sporer sin pakke ved brug af et pakkenr som foregår i funktionen sporpakke
                //kalder en funktion over i DBsql klassen
                System.out.println("Indtast modtagerNr");
                int mNr = input.nextInt();
                //Modtager mt = new Modtager();
                System.out.println("Indtast transporttype");
                String transportType = input.next();
                Pakke p = new Pakke("afsender", transportType, mNr,"fanatic");
                db.opretPakke(p);
                break;

            case 3:
                //Modtageren kan sporer en pakke
                //refere til pakke nummer, få lokation
                System.out.println("Indtast pakkenr");
                int pNr = input.nextInt();

                String minPakke = db.sogLokation(pNr);
                System.out.println("Nuværende lokation: " + minPakke);
                break;

            case 4:
                //afsenderen eller leverandøren kan opdatere hvor langt pakken er
                System.out.println("Indtast pakkenr");
                pNr = input.nextInt();
                System.out.println("Indtast ny lokation");
                String nyLokation = input.next();
                nyLokation = db.opdaterLokation (pNr, nyLokation);
                System.out.println("Pakkens lokation er nu:  " + nyLokation);
                break;

            case 5:
                //printer alle pakker
                System.out.println("Hent alle pakker");
                ArrayList<Pakke> pakkeListe;
                pakkeListe = db.hentAllePakker();
                for (int i = 0; i < pakkeListe.size(); i++) {
                    System.out.println(pakkeListe.get(i));
                }
                break;

            case 6:
                //printer alle modtagere
                System.out.println("Hent alle Modtagere");
                ArrayList<Modtager> modtagerListe;
                modtagerListe = db.hentAlleModtagere();
                for (int i = 0; i < modtagerListe.size(); i++) {
                    System.out.println(modtagerListe.get(i));
                }
                break;

            case 7:
                //Brugeren eller afsenderens vælger af afslutte og programmet lukker
                System.out.println("Afslut");
                //quit
                break;
        }
    }
}