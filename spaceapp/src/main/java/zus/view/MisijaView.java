package zus.view;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lombok.Getter;
import zus.model.Misija;
import zus.model.base.Server;

@Getter
public class MisijaView extends Stage {

    private static MisijaView instance = null;

    public static MisijaView getInstance() {
        if (instance == null) {
            instance = new MisijaView();
        }
        return instance;
    }

    private MisijaView() {
        init();
    }

    private Button btnExit = new Button("Exit");
    private Label lblIDK = new Label("Misija je uspesna ukoliko je ocena njene misije veca od 3");

    private TableView<Misija> tvMisija = new TableView<>();
    private TextField tfFIlter = new TextField();


    public void init() {

        setTitle("Misije");
        tvMisija.setItems(FXCollections.observableArrayList(Server.SERVER.getSveMisije()));

        TableColumn<Misija, Integer> tcIDmisije = new TableColumn<>("ID");
        TableColumn<Misija, String> tcNazivNebObj = new TableColumn<>("Nebeski objekat");
        TableColumn<Misija, String> tcime = new TableColumn<>("Ime");
        TableColumn<Misija, String> tcusp = new TableColumn<>("Uspena misija");

        tcIDmisije.setCellValueFactory(new PropertyValueFactory<>("idMisije"));
        tcNazivNebObj.setCellValueFactory(new PropertyValueFactory<>("idPlanete"));
        tcime.setCellValueFactory(new PropertyValueFactory<>("nazivPl"));
        tcusp.setCellValueFactory(new PropertyValueFactory<>("uspesna"));


        tvMisija.getColumns().addAll(tcIDmisije, tcNazivNebObj, tcime, tcusp);

        btnExit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                NebeskiObjektiView.getInstance().show();
                close();
            }
        });

        VBox root = new VBox(lblIDK, tvMisija, btnExit);
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(40));


        Scene scene = new Scene(root, 500, 400);
        super.setScene(scene);
    }

}
