package com.innoq.uebung2;

import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;
import java.util.Random;
import java.util.concurrent.*;

@Service
public class Entenhausen {
    private RandomNameBean nameBean;

    @Inject
    public Entenhausen(RandomNameBean nameBean) {
        this.nameBean = nameBean;
    }

    public void werWohntWo() throws InterruptedException {
        final ExecutorService exex = new ScheduledThreadPoolExecutor(3);
        for (int i = 0; i < 100; i++) {
            exex.submit(this::run);
        }
        Thread.sleep(40 * 1000);
        exex.shutdown();
    }

    private void run() {
        try {
            System.err.println("In Thread: " + Thread.currentThread().getName() + " wohnt " + nameBean.getName());
            Thread.sleep(new Random().nextInt(1000));
            System.err.println("In Thread: " + Thread.currentThread().getName() + " wohnt jetzt " + nameBean.getName());
        } catch (InterruptedException ex) {
            System.err.println("Beendet");
        }
    }
}
