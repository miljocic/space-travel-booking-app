package zus.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import zus.model.Karta;
import zus.model.base.Server;
import zus.model.utility.JDBCUtils;
import zus.view.KartaView;
import zus.view.NebeskiObjektiView;

import java.util.List;

public class KartaController implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent actionEvent) {
        KartaView kartaView = KartaView.getInstance();
        kartaView.getTvKarta().getItems().clear();
        kartaView.getTvKarta().getItems().addAll(JDBCUtils.izaberiPlanetuZaPut());
        NebeskiObjektiView.getInstance().close();
        KartaView.getInstance().show();
    }
}
