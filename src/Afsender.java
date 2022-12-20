public class Afsender {

    private int firmaNr;
    private String firmaNavn;
    private String adresse;
    private String postNr;
    private String telefonNr;
    private String eMail;

    Afsender(){

    }

    public Afsender(String firmaNavn, String adresse, String postNr, String telefonNr, String eMail){
        this.firmaNavn = firmaNavn;
        this.adresse = adresse;
        this.postNr = postNr;
        this.telefonNr = telefonNr;
        this.eMail = eMail;
    }

    public Afsender(int firmaNr, String firmaNavn, String adresse, String postNr, String telefonNr, String eMail){
        this.firmaNr = firmaNr;
        this.firmaNavn = firmaNavn;
        this.adresse = adresse;
        this.postNr = postNr;
        this.telefonNr = telefonNr;
        this.eMail = eMail;
    }

    public String getFirmaNavn() {
        return firmaNavn;
    }

    public void setFirmaNavn(String firmaNavn) {
        this.firmaNavn = firmaNavn;
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

    @Override
    public String toString() {
        return "Afsender{" +
                "firmaNavn='" + firmaNavn + '\'' +
                ", adresse='" + adresse + '\'' +
                ", postNr=" + postNr +
                ", telefonNr=" + telefonNr +
                ", eMail='" + eMail + '\'' +
                '}';
    }
}