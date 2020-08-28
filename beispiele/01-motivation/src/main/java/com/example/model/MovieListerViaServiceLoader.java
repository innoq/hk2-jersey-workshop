package com.example.model;

import java.util.Iterator;
import java.util.ServiceLoader;

public class MovieListerViaServiceLoader extends MovieLister {
    public MovieListerViaServiceLoader() {
        super(newMovieFinder());
    }

    private static MovieFinder newMovieFinder() {
        final ServiceLoader<MovieFinder> sl = ServiceLoader.load(MovieFinder.class);
        final Iterator<MovieFinder> it = sl.iterator();
        if (!it.hasNext()) {
            throw new IllegalStateException("kein MovieFinder");
        }
        return it.next();
    }
}
