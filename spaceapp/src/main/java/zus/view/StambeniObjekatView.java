package zus.view;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lombok.Getter;
import zus.controller.ExitController;
import zus.controller.KupiPosedController;
import zus.model.StambeniObjekat;
import zus.model.base.Server;

@Getter
public class StambeniObjekatView extends Stage {

    private static StambeniObjekatView instance = null;

    public static StambeniObjekatView getInstance() {
        if (instance == null) {
            instance = new StambeniObjekatView();
        }
        return instance;
    }

    private StambeniObjekatView() {
        init();
    }

    private TableView<StambeniObjekat> tvStambeniObj = new TableView<>();
    private Button btnKupi = new Button("Kupi");
    private Button btnExit = new Button("Exit");
    private TextField tfIme1 = new TextField();
    private TextField tfIme2 = new TextField();
    private Label tfCimer1 = new Label("Cimer1");
    private Label tfCimer2 = new Label("Cimer2");

    public void init() {
        setTitle("Stambeni objekat");

        tvStambeniObj.setItems(FXCollections.observableArrayList(Server.SERVER.getStambeniObjekti()));

        TableColumn<StambeniObjekat, Integer> tcIdObj = new TableColumn<>("Id objekta");
        TableColumn<StambeniObjekat, String> tcIdPlanete = new TableColumn<>("Planeta");
        TableColumn<StambeniObjekat, Integer> tcCena = new TableColumn<>("Cena");
        TableColumn<StambeniObjekat, Integer> tcPovrsina = new TableColumn<>("Broj mogicih stanovnika");

        tcIdObj.setCellValueFactory(new PropertyValueFactory<>("idObjekta"));
        tcIdPlanete.setCellValueFactory(new PropertyValueFactory<>("planeta"));
        tcCena.setCellValueFactory(new PropertyValueFactory<>("cena"));
        tcPovrsina.setCellValueFactory(new PropertyValueFactory<>("povrsina"));

        tvStambeniObj.getColumns().add(tcIdObj);
        tvStambeniObj.getColumns().add(tcIdPlanete);
        tvStambeniObj.getColumns().add(tcCena);
        tvStambeniObj.getColumns().add(tcPovrsina);

        btnExit.setOnAction(new ExitController());
        btnKupi.setOnAction(new KupiPosedController());

        HBox hBox2 = new HBox(tfCimer1, tfIme1, tfCimer2, tfIme2);
        hBox2.setSpacing(10);
        hBox2.setAlignment(Pos.CENTER);

        HBox hBox1 = new HBox(btnKupi, btnExit);
        hBox1.setSpacing(10);
        hBox1.setAlignment(Pos.CENTER);

        VBox root = new VBox(tvStambeniObj, hBox2, hBox1);
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(40));

        Scene scene = new Scene(root, 600, 600);
        super.setScene(scene);
    }
}
