package net.voovo.thread.executor;

import lombok.SneakyThrows;

public class PrinterRunnable implements Runnable{

    int printerId;

    public PrinterRunnable(int printerId) {
        this.printerId = printerId;
    }

    @SneakyThrows
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" printer"+printerId+" "+System.currentTimeMillis());
        Thread.sleep(2);//耗时操作
    }
}
