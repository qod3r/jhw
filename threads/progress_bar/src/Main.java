import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.ProgressBar;

public class Main extends Application {
    public static void main(String[] args) {
        launch();
    }

    Thread thread;
    private boolean suspended = false;


    public void start(Stage stage) {
        ProgressBar bar = new ProgressBar(0);
        Worker worker = new Worker(bar);
        thread = new Thread(worker);

        Button start = new Button();
        start.setText("Старт");
        start.setOnAction(actionEvent -> {
            if (suspended) {
                suspended = false;
                worker.sus();
            }
            if (worker.isRunning()) {
                worker.setShutdown(true);
            }
            try {
                Thread.sleep(20);
                worker.setShutdown(false);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            thread = new Thread(worker);
            thread.start();
        });

        Button stop = new Button();
        stop.setText("Стоп");
        stop.setOnAction(actionEvent -> worker.setShutdown(true));

        Button pause = new Button();
        pause.setText("Пауза");
        pause.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                suspended = !suspended;
                worker.sus();
                if (!suspended)
                    synchronized (worker) {
                        worker.notify();
                    }
                System.out.println("sus: " + suspended);
            }
        });

        Scene scene = new Scene(new HBox(bar, start, pause, stop));
        stage.setScene(scene);
        stage.show();
    }
}
