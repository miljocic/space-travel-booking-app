package zus.model.utility;

import zus.model.*;
import zus.view.LogView;
import zus.view.NebeskiObjektiView;
import zus.view.PrikazView;
import zus.view.StambeniObjekatView;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class JDBCUtils {
    public static Connection connection = null;

    private static Korisnik korisnik1;


    public static void connect() {
        Properties properties = new Properties();
        properties.put("user", "root");
        properties.put("password", "");
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/zus", properties);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<NebeskiObjekat> selectAllFromNebeskiObjekat() {
        List<NebeskiObjekat> nebeskiObjekti = new ArrayList<>();
        String query = "select * from nebeski_objekat";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int nebObjId = resultSet.getInt(1);
                String naziv = resultSet.getString(2);
                String tip = resultSet.getString(3);
                int udaljenost = resultSet.getInt(4);
                int minTemp = resultSet.getInt(5);
                int maxTemp = resultSet.getInt(6);
                int kiseonik = resultSet.getInt(7);
                int drugiGas = resultSet.getInt(8);
                int visina = resultSet.getInt(9);
                int brzinaObrtaja = resultSet.getInt(10);


                NebeskiObjekat nebeskiObjekat = new NebeskiObjekat(nebObjId, naziv, tip, udaljenost, minTemp, maxTemp, kiseonik, drugiGas, visina, brzinaObrtaja);
                nebeskiObjekti.add(nebeskiObjekat);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return nebeskiObjekti;
    }


    public static List<NebeskiObjekat> selectAllNastanjive() {
        List<NebeskiObjekat> nebeskiObjekti = new ArrayList<>();
        String query = "select * from nebeski_objekat n  where n.udaljen between 100 and 200 and n.minimlan between 150 and 250 and n.maximalan between 250 and 350 " +
                "and n.kiseonik between 15 and 25 and n.drugi_gas between 90 and 99 and n.visina > 1000 and n.brzina_obrtaja between 25 and 35 and ((n.maximalan - n.minimlan) < 120)"
                + " and (select count(datum_smrti) from korisnik where godine < 40 and TIMEDIFF(datum_smrti, datum_doseljenja) < 1) < 20";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int nebObjId = resultSet.getInt(1);
                String naziv = resultSet.getString(2);
                String tip = resultSet.getString(3);
                int udaljenost = resultSet.getInt(4);
                int minTemp = resultSet.getInt(5);
                int maxTemp = resultSet.getInt(6);
                int kiseonik = resultSet.getInt(7);
                int drugiGas = resultSet.getInt(8);
                int visina = resultSet.getInt(9);
                int brzinaObrtaja = resultSet.getInt(10);


                NebeskiObjekat nebeskiObjekat = new NebeskiObjekat(nebObjId, naziv, tip, udaljenost, minTemp, maxTemp, kiseonik, drugiGas, visina, brzinaObrtaja);
                nebeskiObjekti.add(nebeskiObjekat);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return nebeskiObjekti;
    }

    public static List<StambeniObjekat> sellectAllFromStambeniObjekat() {
        List<StambeniObjekat> stambeniObjekats = new ArrayList<>();
        String query = "select * from stambeni_objekat join nebeski_objekat using(id_obj)";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int idStObj = resultSet.getInt(2);
                int idPlanete = resultSet.getInt(1);
                int cena = resultSet.getInt(3);
                int povrsina = resultSet.getInt(4);
                String planeta = resultSet.getString(6);

                StambeniObjekat stambeniObjekat = new StambeniObjekat(idStObj, idPlanete, cena, povrsina, planeta);
                stambeniObjekats.add(stambeniObjekat);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return stambeniObjekats;
    }


    public static List<Karta> sellectAllFromKarta() {
        List<Karta> karte = new ArrayList<>();
        String query = "select id_karte, id_obj, do, datum, vreme, naziv, cena from karta join nebeski_objekat using(id_obj)";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int idKarta = resultSet.getInt(1);
                int od = resultSet.getInt(2);
                int doo = resultSet.getInt(3);
                String ods = "Zemlja";
                String doos = resultSet.getString(6);
                LocalDate datum = resultSet.getDate(4).toLocalDate();
                Time timeee = resultSet.getTime(5);
                LocalTime vr = timeee.toLocalTime();
                int cena = resultSet.getInt(7);

                Karta karta = new Karta(idKarta, od, doo, vr, datum, cena, ods, doos);
                karte.add(karta);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return karte;
    }

    public static List<NebeskiObjekat> filtrirajNebeskiObjekat() {
        List<NebeskiObjekat> nebeskiObjekti = new ArrayList<>();
        String ime = NebeskiObjektiView.getInstance().getTfFIlter().getText();
        String query = "select * from nebeski_objekat where naziv like '%" + ime + "%'";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int nebObjId = resultSet.getInt(1);
                String naziv = resultSet.getString(2);
                String tip = resultSet.getString(3);
                int udaljenost = resultSet.getInt(4);
                int minTemp = resultSet.getInt(5);
                int maxTemp = resultSet.getInt(6);
                int kiseonik = resultSet.getInt(7);
                int drugiGas = resultSet.getInt(8);
                int visina = resultSet.getInt(9);
                int brzinaObrtaja = resultSet.getInt(10);

                NebeskiObjekat nebeskiObjekat = new NebeskiObjekat(nebObjId, naziv, tip, udaljenost, minTemp, maxTemp, kiseonik, drugiGas, visina, brzinaObrtaja);
                nebeskiObjekti.add(nebeskiObjekat);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return nebeskiObjekti;
    }

    public static List<Korisnik> sellectAllFromKorisnik() {
        List<Korisnik> korisnici = new ArrayList<>();
        String query = "select * from korisnik";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int idKorisnika = resultSet.getInt(1);
                String ime = resultSet.getString(2);
                String prezime = resultSet.getString(3);
                int godine = resultSet.getInt(4);
                String korisnickoIme = resultSet.getString(5);
                String lozinka = resultSet.getString(6);
                int planetaId = resultSet.getInt(7);
                Date datumSmrti = resultSet.getDate(8);
                LocalDate vremeLokalno = null;
                if (datumSmrti != null) {
                    vremeLokalno = datumSmrti.toLocalDate();

                }

                Korisnik korisnik = new Korisnik(idKorisnika, ime, prezime, godine, korisnickoIme, lozinka, planetaId, vremeLokalno);
                korisnici.add(korisnik);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return korisnici;
    }


    public static boolean prijava() {
        String ime = LogView.getInstance().getTfIme().getText();
        String lozinka = LogView.getInstance().getTfLozinka().getText();
        String query = "select * from korisnik where korisnicko_ime = '" + ime + "' and lozinka ='" + lozinka + "'";
        boolean flag = false;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                if (resultSet != null) {
                    flag = true;
                    int idKorisnika = resultSet.getInt(1);
                    String imecore = resultSet.getString(2);
                    String prezime = resultSet.getString(3);
                    int godine = resultSet.getInt(4);
                    String korisnickoIme = resultSet.getString(5);
                    String lozinkac = resultSet.getString(6);
                    int planetaId = resultSet.getInt(7);
                    Date datumSmrti = resultSet.getDate(8);

                    LocalDate vremeLokalno = null;
                    if (datumSmrti != null) {
                        vremeLokalno = datumSmrti.toLocalDate();

                    }
                    korisnik1 = new Korisnik(idKorisnika, ime, prezime, godine, korisnickoIme, lozinkac, planetaId, vremeLokalno);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return flag;
    }


    public static void insertIntoKorisnik(String ime, String prezime, String korisnickoIme, int godine, String lozinka, int br, LocalDate datum) {
        String query = "insert into korisnik(ime, prezime, godine, korisnicko_ime, lozinka, id_obj, datum_doseljenja)" + "values(?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            br = 1;
            datum = LocalDate.now();
            statement.setString(1, ime);
            statement.setString(2, prezime);
            statement.setInt(3, godine);
            statement.setString(4, korisnickoIme);
            statement.setString(5, lozinka);
            statement.setInt(6, br);
            statement.setString(7,
                    datum.getYear() + "-" +
                            datum.getMonthValue() + "-" + datum.getDayOfMonth());

            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Karta> izaberiPlanetuZaPut() {
        List<Karta> karte = new ArrayList<>();
        String ime = String.valueOf(NebeskiObjektiView.getInstance().getTvNebObj().getSelectionModel().getSelectedItem().getIdNebeskiObjekat());
        String query = "select * from karta  join nebeski_objekat  using (id_obj) where id_obj = '" + ime + "' or do = '" + ime + "'";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int idKarta = resultSet.getInt(1);
                int od = resultSet.getInt(2);
                int doo = resultSet.getInt(3);
                String odS = "Zemlja";
                String dooS = resultSet.getString(7);
                LocalDate datum = resultSet.getDate(5).toLocalDate();
                LocalTime vr = resultSet.getTime(4).toLocalTime();
                System.out.println(vr);

                int cena = resultSet.getInt(6);

                Karta karta = new Karta(idKarta, od, doo, vr, datum, cena, odS, dooS);
                karte.add(karta);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return karte;
    }


    public static void insertIntoPutovanje(int idKorisnika, int idKarte) {
        String query = "insert into putovanje(id_korisnika, id_karte)" + "values(?, ?)";
        ;

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            statement.setInt(1, idKorisnika);
            statement.setInt(2, idKarte);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<StambeniObjekat> izaberiPlanetuZaNaseljenje() {
        List<StambeniObjekat> objekti = new ArrayList<>();
        String ime = String.valueOf(NebeskiObjektiView.getInstance().getTvNebObj().getSelectionModel().getSelectedItem().getIdNebeskiObjekat());
        String query = "select * from stambeni_objekat join nebeski_objekat using(id_obj) where id_obj = '" + ime + "'";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int idObjekta = resultSet.getInt(1);
                int idPlanete = resultSet.getInt(2);
                int cena = resultSet.getInt(3);
                int povrsina = resultSet.getInt(4);
                String planeta = resultSet.getString(5);


                StambeniObjekat objekat = new StambeniObjekat(idObjekta, idPlanete, cena, povrsina, planeta);
                objekti.add(objekat);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return objekti;
    }

    public static Korisnik nadjiKorisnikaPoKorisnickomImenu(String ime) {
        Korisnik korisnik = null;
        String query = "select * from korisnik where korisnicko_ime = '" + ime + "'";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int idKorisnika = resultSet.getInt(1);
                String imee = resultSet.getString(2);
                String prezime = resultSet.getString(3);
                int godine = resultSet.getInt(4);
                String korisnickoIme = resultSet.getString(5);
                String lozinka = resultSet.getString(6);
                int planetaId = resultSet.getInt(7);
                Date datumSmrti = resultSet.getDate(8);
                LocalDate vremeLokalno = null;
                if (datumSmrti != null) {
                    vremeLokalno = datumSmrti.toLocalDate();

                }
                korisnik = new Korisnik(idKorisnika, imee, prezime, godine, korisnickoIme, lozinka, planetaId, vremeLokalno);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return korisnik;
    }


    public static void insertIntoPosed(int idKorisnika, int idStambenogObj) {
        boolean cimer1 = false;
        boolean cimer2 = false;
        if (!(StambeniObjekatView.getInstance().getTfIme1().getText().isEmpty()))
            cimer1 = true;
        if (!(StambeniObjekatView.getInstance().getTfIme2().getText().isEmpty()))
            cimer2 = true;


        String query = "insert into posed(id_korisnika, id_stambenog_objekta)" + "values(?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            connection.setAutoCommit(false);

            if (cimer1 == true) {
                Korisnik korisnik = nadjiKorisnikaPoKorisnickomImenu(StambeniObjekatView.getInstance().getTfIme1().getText());
                statement.setInt(1, korisnik.getIdKorisnik());
                statement.setInt(2, idStambenogObj);
                statement.executeUpdate();
            }
            if (cimer2 == true) {
                Korisnik korisnik = nadjiKorisnikaPoKorisnickomImenu(StambeniObjekatView.getInstance().getTfIme2().getText());
                statement.setInt(1, korisnik.getIdKorisnik());
                statement.setInt(2, idStambenogObj);
                statement.executeUpdate();

            } else {
                statement.setInt(1, idKorisnika);
                statement.setInt(2, idStambenogObj);
                System.out.println(idKorisnika + " " + idStambenogObj);
                statement.executeUpdate();
            }


            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<SveOKorisniku> filtrirajPrikaz() {
        List<SveOKorisniku> sveOKorisnikus = new ArrayList<>();
        String ime = PrikazView.getInstance().getTfFIlterP().getText();
        String query = "select * from korisnik join putovanje using(id_korisnika) join posed using(id_korisnika) where ime like '%" + ime + "%'";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int idKorisnika = resultSet.getInt(1);
                String namae = resultSet.getString(2);
                String prezime = resultSet.getString(3);
                int godine = resultSet.getInt(4);
                int idKartr = resultSet.getInt(8);
                int idPutovanja = resultSet.getInt(7);
                int idposed = resultSet.getInt(9);
                int idobj = resultSet.getInt(10);

                SveOKorisniku korisnik = new SveOKorisniku(idKorisnika, namae, prezime, godine, idKartr, idPutovanja, idposed, idobj);
                sveOKorisnikus.add(korisnik);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return sveOKorisnikus;
    }

    public static List<SveOKorisniku> sellectAllFromKorisnikPosedPutovanje() {
        List<SveOKorisniku> sviPodaciOKorisniku = new ArrayList<>();
        String query = "select * from korisnik join putovanje using(id_korisnika) join karta using(id_karte) join posed using(id_korisnika) join stambeni_objekat using(id_stambenog_objekta)";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int idKorisnika = resultSet.getInt(2);
                String ime = resultSet.getString(4);
                String prezime = resultSet.getString(5);
                int godine = resultSet.getInt(6);

                String Od = resultSet.getString(14);
                String Do = resultSet.getString(13);
                LocalTime vreme = resultSet.getTime(15).toLocalTime();
                LocalDate datum = resultSet.getDate(16).toLocalDate();
                String posed = resultSet.getString(19);

                SveOKorisniku korisik = new SveOKorisniku(idKorisnika, ime, prezime, godine, Do, Od, vreme, datum, posed);
                sviPodaciOKorisniku.add(korisik);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return sviPodaciOKorisniku;
    }

    public static List<SveOKorisniku> sellectAllFromKorisnikKarta() {
        List<SveOKorisniku> sviPodaciOKorisniku = new ArrayList<>();
        String query = "select  id_karte, id_korisnika, do, vreme, datum, ime, prezime, naziv, godine, naziv godine from nebeski_objekat n join karta k on(n.id_obj = k.id_obj)  join putovanje using(id_karte) join korisnik using(id_korisnika)";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int idKorisnika = resultSet.getInt(2);
                String ime = resultSet.getString(6);
                String prezime = resultSet.getString(7);
                int godine = resultSet.getInt(9);

                String Od = "Zemlja";
                String Do = resultSet.getString(8);
                LocalTime vreme = resultSet.getTime(4).toLocalTime();
                LocalDate datum = resultSet.getDate(5).toLocalDate();

                SveOKorisniku korisik = new SveOKorisniku(idKorisnika, ime, prezime, godine, Od, Do, vreme, datum);
                sviPodaciOKorisniku.add(korisik);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return sviPodaciOKorisniku;
    }


    public static List<SveOKorisniku> sellectAllFromKorisnikObjekat() {
        List<SveOKorisniku> sviPodaciOKorisniku = new ArrayList<>();
        String query = "select * from stambeni_objekat join nebeski_objekat using(id_obj) join posed using(id_stambenog_objekta) join korisnik using(id_korisnika)";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int idKorisnika = resultSet.getInt(1);
                String ime = resultSet.getString(16);
                String prezime = resultSet.getString(17);
                int godine = resultSet.getInt(18);
                String posed = resultSet.getString(6);

                SveOKorisniku korisik = new SveOKorisniku(idKorisnika, ime, prezime, godine, posed);
                sviPodaciOKorisniku.add(korisik);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return sviPodaciOKorisniku;
    }


    public static List<Misija> sellectAllMisije() {
        List<Misija> sveMisije = new ArrayList<>();
        String query = "select id_misije, tip, naziv,  if(ocena < 3, 'ne', 'da') from misije join nebeski_objekat using(id_obj)";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int idMisije = resultSet.getInt(1);
                String naziv = resultSet.getString(2);
                String nazivPl = resultSet.getString(3);
                String uspesna = resultSet.getString(4);

                Misija misja = new Misija(idMisije, naziv, nazivPl, uspesna);
                sveMisije.add(misja);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return sveMisije;
    }


    public static Korisnik getKorisnik1() {
        return korisnik1;
    }


    private JDBCUtils() {
    }


    //
}
