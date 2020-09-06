package com.innoq.model;

import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public abstract class AbstractMovieListerTest {

    protected abstract MovieLister lister();

    @Test
    public void copolaDirectedTheGodfather() {
        final List<Movie> directedByCopola = lister().findByDirector("Francis Ford Coppola");
        // so schreibt man solche Tests natürlich nicht
        Assert.assertEquals("The Godfather", directedByCopola.get(0).getTitle());
    }

}
