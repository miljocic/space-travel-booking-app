package zus.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import zus.model.utility.JDBCUtils;
import zus.view.PrikazView;

public class FIltrirajPrikazController implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent) {

        PrikazView prikazView = PrikazView.getInstance();
        prikazView.getTvPrikaz().getItems().clear();
        prikazView.getTvPrikaz().getItems().addAll(JDBCUtils.filtrirajPrikaz());
        prikazView.show();

    }
}