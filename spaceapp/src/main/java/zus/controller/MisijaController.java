package zus.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import zus.model.utility.JDBCUtils;
import zus.view.MisijaView;
import zus.view.NebeskiObjektiView;

public class MisijaController implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent actionEvent) {
        MisijaView misijaView = MisijaView.getInstance();
        misijaView.getTvMisija().getItems().clear();
        misijaView.getTvMisija().getItems().addAll(JDBCUtils.sellectAllMisije());
        misijaView.show();
        NebeskiObjektiView.getInstance().close();
    }
}
