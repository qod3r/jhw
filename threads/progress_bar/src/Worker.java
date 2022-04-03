import javafx.application.Platform;
import javafx.scene.control.ProgressBar;

class Worker implements Runnable {

    private ProgressBar bar;
    private boolean shutdown = false;
    private boolean running = false;
    private volatile boolean suspended = false;

    public Worker(ProgressBar bar) {
        this.bar = bar;
    }

    public void setShutdown(boolean a) {
        shutdown = a;
    }

    public boolean getShutdown() {
        return shutdown;
    }

    public boolean isRunning() {
        return running;
    }

    public void sus() {
        suspended = !suspended;
    }

    public void run() {
        running = true;
        for (int i = 1; i <= 1000; i++) {
            if (shutdown) {
                System.out.println("worker stopped, current i: " + i);
                shutdown = false;
                suspended = false;
                Platform.runLater(() -> bar.setProgress(0));
                break;
            }
            try {
                Thread.sleep(20);

                synchronized (this) {
                    while(suspended) {
                        System.out.println("worker waiting, suspended: " + suspended);
                        wait();
                    }
                }
                final double progress = (double) i/1000;
                System.out.println(i + "\t Thread " + Thread.currentThread().getId());
                Platform.runLater(() -> bar.setProgress(progress));
            } catch (InterruptedException e) {
                System.out.println("thread interrupted");
                break;
            }
        }
        running = false;
    }
}