package zus.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Korisnik {

    private int idKorisnik;
    private String ime;
    private String prezime;
    private int godine;
    private String korisnickoIme;
    private String lozinka;
    private int planeta;
    private LocalDate datum;


    public Korisnik(int idKorisnik, String ime, String prezime, int godine, String korisnickoIme, String lozinka, int planeta, LocalDate datum) {
        this.idKorisnik = idKorisnik;
        this.ime = ime;
        this.prezime = prezime;
        this.godine = godine;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.planeta = planeta;
        this.datum = datum;
    }
}
