import java.io.PipedReader;

public class Pakke {

    private int pakkeNr;
    private String lokation;
    private int modtager;
    private String transportType;
    private String afsender;

    Pakke(){

    }

    public Pakke(int pakkeNr, String lokation,String transportType, int modtager, String afsender){
        this.pakkeNr = pakkeNr;
        this.lokation = lokation;
        this.transportType = transportType;
        this.modtager = modtager;
        this.afsender = afsender;
    }

    public Pakke(String lokation,String transportType, int modtager, String afsender){
        this.lokation = lokation;
        this.transportType = transportType;
        this.modtager = modtager;
        this.afsender = afsender;
    }

    public Pakke(String lokation){
        this.lokation = lokation;
    }


    public int getPakkeNr() {
        return pakkeNr;
    }
    public void setPakkeNr(int pakkeNr) {
        this.pakkeNr = pakkeNr;
    }

    public String getLokation() {
        return lokation;
    }
    public void setLokation(String lokation) {
        this.lokation = lokation;
    }

    public int getModtager() {
        return modtager;
    }
    public void setModtager(int modtager) {
        this.modtager = modtager;
    }

    public String getTransportType() {
        return transportType;
    }
    public void setTransportType(String transportType) {
        this.transportType = transportType;
    }

    public String getAfsender() {
        return afsender;
    }
    public void setAfsender(String afsender) {
        this.afsender = afsender;
    }


    public String toString() {
        return "Pakke{" +
                "pakkeNr=" + pakkeNr +
                ", lokation='" + lokation + '\'' +
                ", modtager=" + modtager +
                ", transportType='" + transportType + '\'' +
                ", afsender='" + afsender + '\'' +
                '}';
    }
}