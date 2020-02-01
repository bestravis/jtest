package net.voovo.thread.executor;

public class PrinterRunnable implements Runnable{

    int printerId;

    public PrinterRunnable(int printerId) {
        this.printerId = printerId;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" printer"+printerId+" "+System.currentTimeMillis());
    }
}
