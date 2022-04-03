public class MyThread extends Thread {

    static int instanceCounter = 1;
    public int ID;

    final Printer p;

    public MyThread(Printer p) {
        this.p = p;
        ID = instanceCounter;
        instanceCounter++;
    }

    public void run() {
        while (true) {
            synchronized (p) {
                try {
                    p.print(this.ID + "");
                    p.notify();
                    p.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
