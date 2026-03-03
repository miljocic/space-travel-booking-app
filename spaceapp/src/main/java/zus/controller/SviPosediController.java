package zus.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import zus.model.SveOKorisniku;
import zus.model.base.Server;
import zus.model.utility.JDBCUtils;
import zus.view.PrikazObjektaView;
import zus.view.PrikazPutovanjaView;
import zus.view.PrikazView;

import java.util.List;

public class SviPosediController implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent actionEvent) {
        PrikazPutovanjaView.getInstance().close();
        PrikazView.getInstance().close();
        PrikazObjektaView prikazView = PrikazObjektaView.getInstance();
        prikazView.getTvPrikaz().getItems().clear();
        prikazView.getTvPrikaz().getItems().addAll(JDBCUtils.sellectAllFromKorisnikObjekat());
        prikazView.show();
    }
}