package zus.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import zus.view.KartaView;
import zus.view.NebeskiObjektiView;
import zus.view.StambeniObjekatView;

public class ExitController implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent actionEvent) {
        KartaView.getInstance().close();
        StambeniObjekatView.getInstance().close();
        NebeskiObjektiView.getInstance().show();
    }
}
