package zus.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NebeskiObjekat {

    private int idNebeskiObjekat;
    private String naziv;
    private String tip;
    private int udaljenostOdZvezde;
    private int minTemp;
    private int maxTemp;
    private int kiseonik;
    private int drugiGas;
    private int visina;
    private int brzinaObrtaja;
    private int manjeOd20Ljudi;

    public NebeskiObjekat(int idNebeskiObjekat, String naziv, String tip, int udaljenostOdZvezde, int minTemp, int maxTemp, int kiseonik, int drugiGas, int visina, int brzinaObrtaja) {
        this.idNebeskiObjekat = idNebeskiObjekat;
        this.naziv = naziv;
        this.tip = tip;
        this.udaljenostOdZvezde = udaljenostOdZvezde;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.kiseonik = kiseonik;
        this.drugiGas = drugiGas;
        this.visina = visina;
        this.brzinaObrtaja = brzinaObrtaja;
    }
}
