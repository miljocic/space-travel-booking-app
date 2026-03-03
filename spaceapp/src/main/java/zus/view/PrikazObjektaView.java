package zus.view;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lombok.Getter;
import zus.controller.FIltrirajPrikazController;
import zus.controller.SveKarteController;
import zus.controller.SviPosediController;
import zus.controller.SviPosediObjektiController;
import zus.model.SveOKorisniku;
import zus.model.base.Server;

@Getter
public class PrikazObjektaView extends Stage {

    private static PrikazObjektaView instance = null;

    public static PrikazObjektaView getInstance() {
        if (instance == null) {
            instance = new PrikazObjektaView();
        }
        return instance;
    }

    private TableView<SveOKorisniku> tvPrikaz = new TableView<>();

    private Button btnExit = new Button("Exit");
    private Button btnLogin = new Button("Log in again");
    private Button btnFiltrirajP = new Button("Filter");
    private TextField tfFIlterP = new TextField();
    private Button btnKarta = new Button("Sva putovanja");
    private Button btnPosed = new Button("Svi stambeni objekti");
    private Button btnSve = new Button("Svi stambeni objekti i putovanja");

    private PrikazObjektaView() {
        init();
    }

    public void init() {
        setTitle("Prikaz podataka");

        tvPrikaz.setItems(FXCollections.observableArrayList(Server.SERVER.getSviPodaciKorisnika()));

        TableColumn<SveOKorisniku, Integer> tcImeKorisnika = new TableColumn<>("Id");
        TableColumn<SveOKorisniku, String> tcIme = new TableColumn<>("Ime");
        TableColumn<SveOKorisniku, String> tcPrezime = new TableColumn<>("Prezime");
        TableColumn<SveOKorisniku, Integer> tcGodien = new TableColumn<>("Godine");
        TableColumn<SveOKorisniku, String> tcObj = new TableColumn<>("Objekat");


        tcImeKorisnika.setCellValueFactory(new PropertyValueFactory<>("idKorisnik"));
        tcIme.setCellValueFactory(new PropertyValueFactory<>("ime"));
        tcPrezime.setCellValueFactory(new PropertyValueFactory<>("prezime"));
        tcGodien.setCellValueFactory(new PropertyValueFactory<>("godine"));
        tcObj.setCellValueFactory(new PropertyValueFactory<>("posedKorisnika"));

        tvPrikaz.getColumns().addAll(tcImeKorisnika, tcIme, tcPrezime, tcGodien, tcObj);

        btnKarta.setOnAction(new SveKarteController());
        btnPosed.setOnAction(new SviPosediController());
        btnSve.setOnAction(new SviPosediObjektiController());

        btnExit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                close();
            }
        });
        btnLogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                PrikazView.getInstance().close();
                LogView.getInstance().getTfIme().clear();
                LogView.getInstance().getTfLozinka().clear();
                SignView.getInstance().getTfIme().clear();
                SignView.getInstance().getTfLozinka().clear();
                SignView.getInstance().getTfGodine().clear();
                SignView.getInstance().getTfPrezime().clear();
                SignView.getInstance().getTfKorisnickoIme().clear();
                LogView.getInstance().show();
            }
        });
        btnFiltrirajP.setOnAction(new FIltrirajPrikazController());

        HBox hBox1 = new HBox(btnKarta, btnPosed, btnSve);
        hBox1.setSpacing(10);
        hBox1.setAlignment(Pos.CENTER);

        HBox hBox2 = new HBox(btnLogin, btnExit);
        hBox2.setSpacing(10);
        hBox2.setAlignment(Pos.CENTER);

        VBox root = new VBox(hBox1, tvPrikaz, hBox2);
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(40));

        Scene scene = new Scene(root, 500, 600);
        super.setScene(scene);
    }
}