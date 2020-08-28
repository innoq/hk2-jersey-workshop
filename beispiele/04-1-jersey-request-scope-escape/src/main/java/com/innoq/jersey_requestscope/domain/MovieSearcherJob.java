package com.innoq.jersey_requestscope.domain;

import javax.inject.Inject;

public class MovieSearcherJob implements Runnable {
    @Inject
    private MovieSearcher searcher;

    @Override
    public void run() {
        try {
            System.out.println(searcher.findByDirector("Stanley Kubrick"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
