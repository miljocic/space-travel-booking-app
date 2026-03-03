package zus.view;

import javafx.collections.FXCollections;
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
import lombok.Setter;
import zus.controller.*;
import zus.model.NebeskiObjekat;
import zus.model.base.Server;

@Getter
@Setter
public class NebeskiObjektiView extends Stage {

    private static NebeskiObjektiView instance = null;

    public static NebeskiObjektiView getInstance() {
        if (instance == null) {
            instance = new NebeskiObjektiView();
        }
        return instance;
    }

    private NebeskiObjektiView() {
        init();
    }

    private Button btnFiltriraj = new Button("Filter");
    private Button btnObjekat = new Button("Stambeni objekat");
    private Button btnKarta = new Button("Karta");
    private Button btnPrikaz = new Button("Prikaz");
    private Button btnNastanjive = new Button("Nastanjive planete");
    private Button btnSve = new Button("Sve planete");
    private Button btnMisije = new Button("Misije");


    private TableView<NebeskiObjekat> tvNebObj = new TableView<>();
    private TextField tfFIlter = new TextField();


    public void init() {
        tvNebObj.setItems(FXCollections.observableArrayList(Server.SERVER.getNebeskiObjekat()));

        TableColumn<NebeskiObjekat, Integer> tcNbObjID = new TableColumn<>("idObj");
        TableColumn<NebeskiObjekat, String> tcNaziv = new TableColumn<>("naziv");
        TableColumn<NebeskiObjekat, String> tcTip = new TableColumn<>("tip");
        TableColumn<NebeskiObjekat, Integer> tcUdaljenost = new TableColumn<>("udaljen");
        TableColumn<NebeskiObjekat, Integer> tcMinTemp = new TableColumn<>("minimalan");
        TableColumn<NebeskiObjekat, Integer> tcMaxTemp = new TableColumn<>("maximalan");
        TableColumn<NebeskiObjekat, Integer> tcKiseonik = new TableColumn<>("kiseonik");
        TableColumn<NebeskiObjekat, Integer> tcDrugiGas = new TableColumn<>("drugiGas");
        TableColumn<NebeskiObjekat, Integer> tcVisina = new TableColumn<>("visina");
        TableColumn<NebeskiObjekat, Integer> tcBrzina = new TableColumn<>("brzinaObrtaja");

        tcNbObjID.setCellValueFactory(new PropertyValueFactory<>("idNebeskiObjekat"));
        tcNaziv.setCellValueFactory(new PropertyValueFactory<>("naziv"));
        tcTip.setCellValueFactory(new PropertyValueFactory<>("tip"));
        tcUdaljenost.setCellValueFactory(new PropertyValueFactory<>("udaljenostOdZvezde"));
        tcMinTemp.setCellValueFactory(new PropertyValueFactory<>("minTemp"));
        tcMaxTemp.setCellValueFactory(new PropertyValueFactory<>("maxTemp"));
        tcKiseonik.setCellValueFactory(new PropertyValueFactory<>("kiseonik"));
        tcDrugiGas.setCellValueFactory(new PropertyValueFactory<>("drugiGas"));
        tcVisina.setCellValueFactory(new PropertyValueFactory<>("visina"));
        tcBrzina.setCellValueFactory(new PropertyValueFactory<>("brzinaObrtaja"));


        tvNebObj.getColumns().addAll(tcNbObjID, tcNaziv, tcTip, tcUdaljenost, tcMinTemp, tcMaxTemp, tcKiseonik, tcDrugiGas, tcVisina, tcBrzina);


        btnFiltriraj.setOnAction(new FilterController());
        btnObjekat.setOnAction(new StambeniObjekatController());
        btnKarta.setOnAction(new KartaController());
        btnPrikaz.setOnAction(new PrikazController());
        btnNastanjive.setOnAction(new NastanjiveController());
        btnSve.setOnAction(new SvePlaneteController());
        btnMisije.setOnAction(new MisijaController());


        setTitle("Nastanjivi nebeski objekti");
        HBox hBox1 = new HBox(tfFIlter, btnFiltriraj, btnNastanjive, btnSve, btnMisije);
        hBox1.setSpacing(10);
        hBox1.setAlignment(Pos.CENTER);

        HBox hBox2 = new HBox(btnObjekat, btnKarta, btnPrikaz);
        hBox2.setSpacing(10);
        hBox2.setAlignment(Pos.CENTER);


        VBox root = new VBox(hBox1, tvNebObj, hBox2);
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(40));


        Scene scene = new Scene(root, 1000, 600);
        super.setScene(scene);
    }

}
