package zus.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import zus.model.utility.JDBCUtils;
import zus.view.LogView;
import zus.view.NebeskiObjektiView;

public class LogInController implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent actionEvent) {

        if (JDBCUtils.prijava() == true) {
            LogView.getInstance().close();
            NebeskiObjektiView.getInstance().show();
        } else {
            System.out.println("Korisnik ne postoji");
        }
    }
}
