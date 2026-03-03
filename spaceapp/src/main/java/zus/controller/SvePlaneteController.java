package zus.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import zus.model.NebeskiObjekat;
import zus.model.base.Server;
import zus.model.utility.JDBCUtils;
import zus.view.NebeskiObjektiView;

import java.util.List;

public class SvePlaneteController implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent actionEvent) {
        NebeskiObjektiView nebeskiObjektiView = NebeskiObjektiView.getInstance();
        nebeskiObjektiView.getTvNebObj().getItems().clear();
        nebeskiObjektiView.getTvNebObj().getItems().addAll(JDBCUtils.selectAllFromNebeskiObjekat());
        nebeskiObjektiView.show();
    }
}