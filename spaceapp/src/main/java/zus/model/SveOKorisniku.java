package zus.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class SveOKorisniku {

    private int idKorisnik;
    private String ime;
    private String prezime;
    private int godine;
    private String putovanjaKorisnikaOD;
    private String putovanjaKorisnikaDo;
    private LocalTime vreme;
    private String posedKorisnika;
    private LocalDate datum1;
    private int idKarte;
    private int idPut;
    private int idPosed;
    private int idObjs;
    private String od;
    private String doo;

    public SveOKorisniku(int idKorisnik, String ime, String prezime, int godine, int idKarte, int idPut, int idPosed, int idObjs) {
        this.idKorisnik = idKorisnik;
        this.ime = ime;
        this.prezime = prezime;
        this.godine = godine;
        this.idKarte = idKarte;
        this.idPut = idPut;
        this.idPosed = idPosed;
        this.idObjs = idObjs;
    }

    public SveOKorisniku(int idKorisnik, String ime, String prezime, int godine, String putovanjaKorisnikaOD, String putovanjaKorisnikaDo, LocalTime vreme, LocalDate datum1, String posedKorisnika) {
        this.idKorisnik = idKorisnik;
        this.ime = ime;
        this.prezime = prezime;
        this.godine = godine;
        this.putovanjaKorisnikaOD = putovanjaKorisnikaOD;
        this.putovanjaKorisnikaDo = putovanjaKorisnikaDo;
        this.vreme = vreme;
        this.datum1 = datum1;
        this.posedKorisnika = posedKorisnika;
    }

    public SveOKorisniku(int idKorisnik, String ime, String prezime, int godine, String putovanjaKorisnikaOD, String putovanjaKorisnikaDo, LocalTime vreme, LocalDate datum1) {
        this.idKorisnik = idKorisnik;
        this.ime = ime;
        this.prezime = prezime;
        this.godine = godine;
        this.putovanjaKorisnikaOD = putovanjaKorisnikaOD;
        this.putovanjaKorisnikaDo = putovanjaKorisnikaDo;
        this.vreme = vreme;
        this.datum1 = datum1;
    }

    public SveOKorisniku(int idKorisnik, String ime, String prezime, int godine, String posedKorisnika) {
        this.idKorisnik = idKorisnik;
        this.ime = ime;
        this.prezime = prezime;
        this.godine = godine;
        this.posedKorisnika = posedKorisnika;
    }
}
