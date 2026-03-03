package zus.model.base;


import zus.model.*;
import zus.model.utility.JDBCUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Server {

    public static final Server SERVER = new Server();

    private final List<NebeskiObjekat> nebeskiObjekat = new ArrayList<>();
    private List<StambeniObjekat> stambeniObjekti = new ArrayList<>();
    private List<Karta> karte = new ArrayList<>();
    private List<Korisnik> korisnici = new ArrayList<>();
    private List<SveOKorisniku> sviPodaciKorisnika = new ArrayList<>();
    private List<Misija> sveMisije = new ArrayList<>();


    private Server() {
        this.setNebeskiObjekat(JDBCUtils.selectAllFromNebeskiObjekat());
        this.setStambeniObjekti(JDBCUtils.sellectAllFromStambeniObjekat());
        this.setKarte(JDBCUtils.sellectAllFromKarta());
        this.setKorisnici(JDBCUtils.sellectAllFromKorisnik());
        this.setSviPodaciKorisnika(JDBCUtils.sellectAllFromKorisnikPosedPutovanje());
        this.setSveMisije(JDBCUtils.sellectAllMisije());
    }

    public List<Karta> getKarte() {
        return karte;
    }

    public void setKarte(List<Karta> karte) {
        this.karte.clear();
        this.karte.addAll(karte);
    }

    public List<StambeniObjekat> getStambeniObjekti() {
        return stambeniObjekti;
    }

    public void setStambeniObjekti(List<StambeniObjekat> stambObj) {
        this.stambeniObjekti.clear();
        this.stambeniObjekti.addAll(stambObj);
    }

    public List<NebeskiObjekat> getNebeskiObjekat() {
        return nebeskiObjekat;
    }

    public void setNebeskiObjekat(Collection<NebeskiObjekat> nebeskiObjekat) {
        this.nebeskiObjekat.clear();
        this.nebeskiObjekat.addAll(nebeskiObjekat);
    }

    public List<Korisnik> getKorisnici() {
        return korisnici;
    }

    public void setKorisnici(List<Korisnik> korisnici) {
        this.korisnici.clear();
        this.korisnici.addAll(korisnici);
    }

    public List<SveOKorisniku> getSviPodaciKorisnika() {
        return sviPodaciKorisnika;
    }

    public void setSviPodaciKorisnika(List<SveOKorisniku> sviPodaciKorisnika) {
        this.sviPodaciKorisnika.clear();
        this.sviPodaciKorisnika.addAll(sviPodaciKorisnika);
    }

    public List<Misija> getSveMisije() {
        return sveMisije;
    }

    public void setSveMisije(List<Misija> sveMisije) {
        this.sveMisije.clear();
        this.sveMisije.addAll(sveMisije);
    }
}
