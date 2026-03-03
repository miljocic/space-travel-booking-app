package zus.controller;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import zus.model.Korisnik;
import zus.model.base.Server;
import zus.model.utility.JDBCUtils;
import zus.view.LogView;
import zus.view.SignView;

import java.time.LocalDate;
import java.util.List;

public class RegistracijaController implements EventHandler<ActionEvent> {

    private TextField tfIme;
    private TextField tfPrezime;
    private TextField tfGodine;
    private TextField tfKorisnickoIme;
    private TextField tfLozinka;
    private TextField tfPlaneta;
    private TextField tfDatumDoseljenja;


    public RegistracijaController(TextField tfIme, TextField tfPrezime, TextField tfGodine, TextField tfKorisnickoIme, TextField tfLozinka, TextField tfPlaneta, TextField tfDatumDoseljenja) {
        this.tfIme = tfIme;
        this.tfPrezime = tfPrezime;
        this.tfGodine = tfGodine;
        this.tfKorisnickoIme = tfKorisnickoIme;
        this.tfLozinka = tfLozinka;
        this.tfPlaneta = tfPlaneta;
        this.tfDatumDoseljenja = tfDatumDoseljenja;
    }

    public RegistracijaController(TextField tfIme, TextField tfPrezime, TextField tfGodine, TextField tfKorisnickoIme, TextField tfLozinka) {
        this.tfIme = tfIme;
        this.tfPrezime = tfPrezime;
        this.tfGodine = tfGodine;
        this.tfKorisnickoIme = tfKorisnickoIme;
        this.tfLozinka = tfLozinka;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        String ime = SignView.getInstance().getTfIme().getText().trim();
        String prezime = SignView.getInstance().getTfPrezime().getText().trim();
        Integer godine = Integer.valueOf(SignView.getInstance().getTfGodine().getText());
        String korisnickoIme = SignView.getInstance().getTfKorisnickoIme().getText().trim();
        String lozinka = SignView.getInstance().getTfLozinka().getText().trim();
        int planeta = 1;
        LocalDate datumdoseljenja = LocalDate.now();

        JDBCUtils.insertIntoKorisnik(ime, prezime, korisnickoIme, godine, lozinka, planeta, datumdoseljenja);
        List<Korisnik> korisnici = JDBCUtils.sellectAllFromKorisnik();
        Server.SERVER.setKorisnici(korisnici);
        SignView.getInstance().close();
        LogView.getInstance().show();
    }

}
