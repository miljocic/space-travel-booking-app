package zus.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import zus.model.utility.JDBCUtils;
import zus.view.NebeskiObjektiView;

public class NastanjiveController implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent actionEvent) {
        NebeskiObjektiView nebeskiObjektiView = NebeskiObjektiView.getInstance();
        nebeskiObjektiView.getTvNebObj().getItems().clear();
        nebeskiObjektiView.getTvNebObj().getItems().addAll(JDBCUtils.selectAllNastanjive());
        nebeskiObjektiView.show();
    }
}
