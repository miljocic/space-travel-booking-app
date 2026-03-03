package zus.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class Karta {

    private int idKarte;
    private int Od;
    private int Do;
    private LocalTime vr;
    private LocalDate datum;
    private int cena;
    private String OdS;
    private String DoS;


    public Karta(int idKarte, int od, int aDo, LocalTime vr, LocalDate datum, int cena, String odS, String doS) {
        this.idKarte = idKarte;
        Od = od;
        Do = aDo;
        this.vr = vr;
        this.datum = datum;
        this.cena = cena;
        OdS = odS;
        DoS = doS;
    }
}
