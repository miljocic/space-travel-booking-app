package zus.view;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;
import zus.controller.ExitController;
import zus.controller.KupiController;
import zus.model.Karta;
import zus.model.base.Server;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class KartaView extends Stage {

    private static KartaView instance = null;

    public static KartaView getInstance() {
        if (instance == null) {
            instance = new KartaView();
        }
        return instance;
    }

    private KartaView() {
        init();
    }

    private TableView<Karta> tvKarta = new TableView<>();
    private Button btnKupi = new Button("Kupi");
    private Button btnExit = new Button("Exit");


    public void init() {
        setTitle("Kupi kartu");

        tvKarta.setItems(FXCollections.observableArrayList(Server.SERVER.getKarte()));

        TableColumn<Karta, Integer> tcId = new TableColumn<>("Id karte");
        TableColumn<Karta, String> tcOd = new TableColumn<>("Od");
        TableColumn<Karta, String> tcDo = new TableColumn<>("Do");
        TableColumn<Karta, LocalTime> tcVreme = new TableColumn<>("Vreme");
        TableColumn<Karta, LocalDate> tcDatum = new TableColumn<>("Datum");
        TableColumn<Karta, Integer> tcCena = new TableColumn<>("Cena");

        tcId.setCellValueFactory(new PropertyValueFactory<>("idKarte"));
        tcOd.setCellValueFactory(new PropertyValueFactory<>("OdS"));
        tcDo.setCellValueFactory(new PropertyValueFactory<>("DoS"));
        tcVreme.setCellValueFactory(new PropertyValueFactory<>("vr"));
        tcDatum.setCellValueFactory(new PropertyValueFactory<>("datum"));
        tcCena.setCellValueFactory(new PropertyValueFactory<>("cena"));

        tvKarta.getColumns().add(tcId);
        tvKarta.getColumns().add(tcOd);
        tvKarta.getColumns().add(tcDo);
        tvKarta.getColumns().add(tcVreme);
        tvKarta.getColumns().add(tcDatum);
        tvKarta.getColumns().add(tcCena);

        btnExit.setOnAction(new ExitController());
        btnKupi.setOnAction(new KupiController());

        HBox hBox1 = new HBox(btnKupi, btnExit);
        hBox1.setSpacing(10);
        hBox1.setAlignment(Pos.CENTER);

        VBox root = new VBox(tvKarta, hBox1);
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(40));

        Scene scene = new Scene(root, 600, 600);
        super.setScene(scene);
    }
}
