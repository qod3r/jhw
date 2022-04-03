import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    public void start(Stage stage) {
        Button b1 = new Button();
        b1.setText("Thread");

        Button b2 = new Button();
        b2.setText("Runnable");

        Scene scene = new Scene(new StackPane(new HBox(b1, b2)), 200, 50);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();

        b1.setOnAction(actionEvent -> {
            MyThread t = new MyThread();
            t.start();
        });

        b2.setOnAction(actionEvent -> {
            Thread thread = new Thread(() -> {
                int i = 0;
                while (true) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(++i);
                }
            });
            thread.start();
        });
    }

    public static void main(String[] args) {
        launch();
    }
}
