package zus.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;
import zus.controller.RegistracijaController;

@Getter
@Setter
public class SignView extends Stage {

    private static SignView instance = null;

    public static SignView getInstance() {
        if (instance == null) {
            instance = new SignView();
        }
        return instance;
    }

    private SignView() {
        init();
    }

    private Button btnRegistracija = new Button("Registruj se");
    private Label lblIme = new Label("Ime");
    private TextField tfIme = new TextField();
    private Label lblPrezime = new Label("Prezime");
    private TextField tfPrezime = new TextField();
    private Label lblGodine = new Label("Godine");
    private TextField tfGodine = new TextField();
    private Label lblKorisnickoIme = new Label("Korisnicko ime");
    private TextField tfKorisnickoIme = new TextField();
    private Label lblLozinka = new Label("Lozinka");
    private TextField tfLozinka = new TextField();
    private Label lblPlaneta = new Label("Planeta");
    private TextField tfPlaneta = new TextField();


    public void init() {
        setTitle("Registracija");
        btnRegistracija.setOnAction(new RegistracijaController(tfIme, tfPrezime, tfGodine, tfKorisnickoIme, tfLozinka));


        VBox root = new VBox(lblIme, tfIme, lblPrezime, tfPrezime, lblGodine, tfGodine, lblKorisnickoIme, tfKorisnickoIme, lblLozinka, tfLozinka, btnRegistracija);
        root.setSpacing(15);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(70));

        Scene scene = new Scene(root, 450, 450);
        super.setScene(scene);
    }


}
