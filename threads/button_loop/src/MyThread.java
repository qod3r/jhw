public class MyThread extends Thread {
    public void run() {
        int i = 0;
        while (true) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(++i);
        }
    }
}
