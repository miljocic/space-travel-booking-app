package zus.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import zus.view.NebeskiObjektiView;
import zus.view.PrikazView;

public class PrikazController implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent actionEvent) {
        NebeskiObjektiView.getInstance().close();
        PrikazView.getInstance().show();
    }
}
