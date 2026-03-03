package zus.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import zus.model.utility.JDBCUtils;
import zus.view.PrikazObjektaView;
import zus.view.PrikazPutovanjaView;
import zus.view.PrikazView;

public class SveKarteController implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent actionEvent) {
        PrikazView.getInstance().close();
        PrikazObjektaView.getInstance().close();
        PrikazPutovanjaView prikazView = PrikazPutovanjaView.getInstance();
        prikazView.getTvPrikaz().getItems().clear();
        prikazView.getTvPrikaz().getItems().addAll(JDBCUtils.sellectAllFromKorisnikKarta());
        prikazView.show();
    }
}
