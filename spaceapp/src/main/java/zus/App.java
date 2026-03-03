package zus;

import javafx.application.Application;
import javafx.stage.Stage;
import zus.model.utility.JDBCUtils;
import zus.view.LogView;


public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
      JDBCUtils.connect();
        LogView logView = LogView.getInstance();
        logView.show();

    }
}
