public class Main {
    public static void main(String[] args) {
        Printer p = new Printer();
        MyThread t1 = new MyThread(p);
        MyThread t2 = new MyThread(p);

        t1.start();
        t2.start();
    }
}
