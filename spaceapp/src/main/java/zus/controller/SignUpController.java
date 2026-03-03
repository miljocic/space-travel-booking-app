package zus.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import zus.view.LogView;
import zus.view.SignView;

public class SignUpController implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent actionEvent) {
        LogView.getInstance().close();
        LogView.getInstance().getTfLozinka().clear();
        LogView.getInstance().getTfIme().clear();
        SignView.getInstance().show();
    }
}
