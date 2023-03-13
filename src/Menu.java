import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    static UIController UIcontroller = new UIController();
    public static void mainMenu() {

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
                        "5. Vis alle pakker \n" +
                        "6. Vis alle brugere \n" +
                        "7. Afslut \n" +
                        "Indtast dit valg");
        valg = input.nextInt();
        //Et switch statement, hvor at brugeren kan vælge imellem de forskellige cases og hver case gør noget forskelligt
        switch (valg) {
            case 1:
                //afsenderen opretter en modtager som foregår i funktionen opretmodtager
                Modtager m = UIcontroller.opretModtager();
                //kalder en funktion over i dbsql klassen
                db.indsaetModtager(m);

                System.out.println("");
                mainMenu();
                break;

            case 2:
                //afsenderen opretter en pakke
                System.out.println("Indtast modtagerNr");
                int mNr = input.nextInt();

                System.out.println("Indtast transporttype");
                String transportType = input.next();

                Pakke p = new Pakke("afsender", transportType, mNr,"fanatic");
                //kalder en funktion over i DBsql klassen
                db.opretPakke(p);

                System.out.println("");
                mainMenu();
                break;

            case 3:
                //modtageren kan sporer sin pakke ved brug af et pakkenr og derefter vil lokationen blive vist
                //refere til pakke nummer, få lokation
                System.out.println("Indtast pakkenr");
                int pNr = input.nextInt();

                String minPakke = db.sogLokation(pNr);
                System.out.println("Nuværende lokation: " + minPakke);

                System.out.println("");
                mainMenu();
                break;

            case 4:
                //afsenderen eller leverandøren kan opdatere hvor langt pakken er
                System.out.println("Indtast pakkenr");
                pNr = input.nextInt();

                System.out.println("Indtast ny lokation");
                String nyLokation = input.next();

                nyLokation = db.opdaterLokation (pNr, nyLokation);
                System.out.println("Pakkens lokation er nu:  " + nyLokation);

                System.out.println("");
                mainMenu();
                break;

            case 5:
                //printer alle pakker
                System.out.println("Vis alle pakker");
                ArrayList<Pakke> pakkeListe;
                pakkeListe = db.hentAllePakker();
                for (int i = 0; i < pakkeListe.size(); i++) {
                    System.out.println(pakkeListe.get(i));
                }

                System.out.println("");
                mainMenu();
                break;

            case 6:
                //printer alle modtagere
                System.out.println("Vis alle Modtagere");
                ArrayList<Modtager> modtagerListe;
                modtagerListe = db.hentAlleModtagere();
                for (int i = 0; i < modtagerListe.size(); i++) {
                    System.out.println(modtagerListe.get(i));
                }
                System.out.println("");
                mainMenu();
                break;

            case 7:
                //Brugeren eller afsenderens vælger af afslutte og programmet lukker
                System.out.println("Afslut");
                //quit
                break;
        }
    }
}


