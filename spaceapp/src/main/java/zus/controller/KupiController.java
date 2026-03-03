package zus.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import zus.model.utility.JDBCUtils;
import zus.view.KartaView;
import zus.view.NebeskiObjektiView;

public class KupiController implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent actionEvent) {

        int idKorisnika = JDBCUtils.getKorisnik1().getIdKorisnik();
        int idKarte = KartaView.getInstance().getTvKarta().getSelectionModel().getSelectedItem().getOd();
        JDBCUtils.insertIntoPutovanje(idKorisnika, idKarte);
        KartaView.getInstance().close();


        NebeskiObjektiView.getInstance().show();
    }
}
