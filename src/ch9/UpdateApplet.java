package ch9;
//shift+option держа курсор на строке двигать стрелками строку вверх/вниз
public class UpdateApplet extends java.applet.Applet implements Runnable {
    Thread thread;
    boolean running;
    int updateInterval = 1000;

    public void run() {
        while (running) {
            repaint();
        }

        try {
            thread.sleep(this.updateInterval);
        } catch (InterruptedException e) {
            System.out.println("Interrupted...");
            return;
        }
    }

    public void start() {
//        synchronized (myObject) {
//            При достижение этого места блокируется myObject дли эксклюзивного выполнения стр 388
//        }

        System.out.println("Start");

        if (!running) {
            running = true;
            thread = new Thread(this);
            thread.start();
        }
    }

    public void stop() {
        System.out.print("Stop");
        thread.interrupt();
        running = false;
    }

    /** Экивалетны следующие два метода*/
//    synchronized void myMethod() {
//
//    }
//
//    void myMethod() {
//        synchronized (this) {
//
//        }
//    }
}
