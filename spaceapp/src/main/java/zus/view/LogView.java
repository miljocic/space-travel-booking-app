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
import zus.controller.LogInController;
import zus.controller.SignUpController;

@Getter
public class LogView extends Stage {

    private static LogView instance = null;

    public static LogView getInstance() {
        if (instance == null) {
            instance = new LogView();
        }
        return instance;
    }

    private LogView() {
        init();
    }

    private Button logBtn = new Button("Log in");
    private Button signBtn = new Button("Sign up");
    private Label lblIme = new Label("Korisnicko ime:");
    private TextField tfIme = new TextField();
    private Label lblLozinka = new Label("Lozinka:");
    private TextField tfLozinka = new TextField();

    private void init() {

        setTitle("Prijava");
        logBtn.setOnAction(new LogInController());
        signBtn.setOnAction(new SignUpController());

        VBox root = new VBox(lblIme, tfIme, lblLozinka, tfLozinka, logBtn, signBtn);
        root.setSpacing(15);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10));

        Scene scene = new Scene(root, 400, 300);
        super.setScene(scene);

    }

}
