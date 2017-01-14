package ch9;

public class Devil extends Thread {
    Devil() {
        setDaemon(true);
        start();
    }

    @Override
    public void run() {

    }
}
