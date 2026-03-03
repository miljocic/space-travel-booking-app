package zus.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import zus.model.utility.JDBCUtils;
import zus.view.NebeskiObjektiView;
import zus.view.StambeniObjekatView;

public class StambeniObjekatController implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent actionEvent) {
        StambeniObjekatView stambeniObjekatView = StambeniObjekatView.getInstance();
        stambeniObjekatView.getTvStambeniObj().getItems().clear();
        stambeniObjekatView.getTvStambeniObj().getItems().addAll(JDBCUtils.izaberiPlanetuZaNaseljenje());

        NebeskiObjektiView.getInstance().close();
        StambeniObjekatView.getInstance().show();

    }
}
