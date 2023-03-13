import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;
import java.util.Scanner;

public class DBSql {

    private Connection connection;
    private Statement stmt;

    DBSql() {
        connection = null;
        stmt = null;
        try {
            String url = "jdbc:sqlite:C://Users/wzs84/IdeaProjects/TrackAndTraceSystem/TrackAndTraceDB.db";
            connection = DriverManager.getConnection(url);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void indsaetModtager(Modtager m) {
        try {
            String sql = "INSERT INTO Modtager (fNavn,eNavn,adresse,postNr,telefonNr,eMail) VALUES('"
                    + String.valueOf(m.getfNavn()) + "','" + m.geteNavn() + "','";
            sql = sql + m.getAdresse() + "','" + m.getPostNr() + "','" + m.getTelefonNr() + "','" + m.geteMail() + "')";

            Statement stmt = connection.createStatement();
            stmt.execute(sql);

            System.out.println("Connection to SQLite has been established. \n");
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void opretPakke(Pakke p) {
        try {
            String sql = "INSERT INTO Pakke (lokation, modtager, transportType, afsender) VALUES('"
                    + p.getLokation() + "'," + p.getModtager() + ",'" + p.getTransportType() + "','" + p.getAfsender() + "')";

            Statement stmt = connection.createStatement();
            stmt.execute(sql);

            System.out.println("Connection to SQLite has been established.");
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ArrayList<Modtager> hentAlleModtagere() {
        try {
            String sql = "SELECT * FROM Modtager ";
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            ResultSet rs = stmt.getResultSet();
            ArrayList<Modtager> modtagerListe = new ArrayList<>();
            while (rs.next()) {
                {
                    Modtager m = new Modtager(
                            rs.getInt("kundeNr"),
                            rs.getString("fNavn"),
                            rs.getString("eNavn"),
                            rs.getString("adresse"),
                            rs.getString("postNr"),
                            rs.getString("telefonNr"),
                            rs.getString("eMail"));
                    modtagerListe.add(m);
                }
            }
            return modtagerListe;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Pakke> hentAllePakker() {
        try {
            String sql = "SELECT * FROM Pakke ";
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            ResultSet rs = stmt.getResultSet();
            ArrayList<Pakke> pakkeListe = new ArrayList<>();
            while (rs.next()) {
                {
                    Pakke p = new Pakke(
                            rs.getInt("pakkeNr"),
                            rs.getString("lokation"),
                            rs.getString("transportType"),
                            rs.getInt("modtager"),
                            rs.getString("afsender"));
                    pakkeListe.add(p);
                }
            }
            return pakkeListe;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String sogLokation(int pakkeNr) {
        String pakke = "";
        try {
            String sql = "SELECT lokation FROM Pakke WHERE pakkeNr = '" + pakkeNr + "'";
            Statement stmt = connection.createStatement();
            stmt.execute(sql);

            ResultSet rs = stmt.getResultSet();

            if (rs.next()) {
                pakke = rs.getString("lokation");
            }

            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return pakke;
    }

    public String opdaterLokation(int pakkeNr, String nyLokation) {
        String pakke = "";
        try {
            String sql = "UPDATE Pakke SET lokation = '" + nyLokation + "'" + "WHERE pakkeNr = '" + pakkeNr + "'" ;
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            
            sql = "SELECT lokation FROM Pakke WHERE pakkeNr = '" + pakkeNr + "'";
            stmt.execute(sql);

            ResultSet rs = stmt.getResultSet();

            if (rs.next()) {
                pakke = rs.getString("lokation");
            }

            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return pakke;
    }
}