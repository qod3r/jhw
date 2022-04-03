package calculator.viewmodel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Main.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.show();
    }
}
