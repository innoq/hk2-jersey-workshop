package com.innoq.uebung2;

import java.util.Random;

// Klasse als Singleton Service anbieten
public class Entenhausen {
    private RandomNameBean nameBean;

    // TODO nameBean erhalten
    public Entenhausen(RandomNameBean nameBean) {
        this.nameBean = nameBean;
    }

    public void werWohntWo() throws InterruptedException {
        // TODO ein paar Threads erzeugen und in denen ein paar Mal run ausführen
        // beispielsweise 100 Ausführungen auf 3 Threads verteilt
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
