import java.util.ArrayList;

public class Modtager {

    //variabler til modtager
    private int kundeNr;
    private String fNavn;
    private String eNavn;
    private String adresse;
    private String postNr;
    private String telefonNr;
    private String eMail;

    Modtager(){

    }

    public Modtager(String fNavn, String eNavn, String adresse, String postNr, String telefonNr, String eMail){
        this.fNavn = fNavn;
        this.eNavn = eNavn;
        this.adresse = adresse;
        this.postNr = postNr;
        this.telefonNr = telefonNr;
        this.eMail = eMail;
    }

    public Modtager(int kundeNr, String fNavn, String eNavn, String adresse, String postNr, String telefonNr, String eMail){
        this.kundeNr = kundeNr;
        this.fNavn = fNavn;
        this.eNavn = eNavn;
        this.adresse = adresse;
        this.postNr = postNr;
        this.telefonNr = telefonNr;
        this.eMail = eMail;
    }

    //Getter and Setter
    public String getfNavn() {
        return fNavn;
    }
    public void setfNavn(String fNavn) {
        this.fNavn = fNavn;
    }

    public String geteNavn() {
        return eNavn;
    }
    public void seteNavn(String eNavn) {
        this.eNavn = eNavn;
    }

    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPostNr() {
        return postNr;
    }
    public void setPostNr(String postNr) {
        this.postNr = postNr;
    }

    public String getTelefonNr() {
        return telefonNr;
    }
    public void setTelefonNr(String telefonNr) {
        this.telefonNr = telefonNr;
    }

    public String geteMail() {
        return eMail;
    }
    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public int getKundeNr() {
        return kundeNr;
    }
    public void setKundeNr(int kundeNr) {
        this.kundeNr = kundeNr;
    }

    //Override - to string
    @Override
    public String toString() {
        return "Modtager{" +
                ", kundeNr='" + kundeNr + '\'' +
                ", fNavn='" + fNavn + '\'' +
                ", eNavn='" + eNavn + '\'' +
                ", adresse='" + adresse + '\'' +
                ", postNr=" + postNr +
                ", telefonNr=" + telefonNr +
                ", eMail='" + eMail + '\'' +
                '}';
    }
}