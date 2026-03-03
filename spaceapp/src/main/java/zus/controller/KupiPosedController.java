package zus.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import zus.model.utility.JDBCUtils;
import zus.view.NebeskiObjektiView;
import zus.view.StambeniObjekatView;

public class KupiPosedController implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent actionEvent) {
        int idKorisnika = JDBCUtils.getKorisnik1().getIdKorisnik();

        int idStambenogObj = StambeniObjekatView.getInstance().getTvStambeniObj().getSelectionModel().getSelectedItem().getIdPlanete();
        JDBCUtils.insertIntoPosed(idKorisnika, idStambenogObj);
        StambeniObjekatView.getInstance().getTfIme2().clear();
        StambeniObjekatView.getInstance().getTfIme1().clear();
        StambeniObjekatView.getInstance().close();

        NebeskiObjektiView.getInstance().show();
    }
}
