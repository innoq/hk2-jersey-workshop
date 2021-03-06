package com.innoq;

import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import org.glassfish.grizzly.http.server.HttpServer;

/**
 * Main class.
 *
 */
public class Main {
    // Base URI the Grizzly HTTP server will listen on
    public static final URI BASE_URI = URI.create("http://localhost:8080/myapp/");
    public static final String ROOT_HELLO_PATH = "myresource";

    public static HttpServer startServer() throws IOException {
        ResourceConfig resourceConfig = new ResourceConfig(MyResource.class);
        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(BASE_URI, resourceConfig, false);
        server.start();
        return server;
    }

    /**
     * Main method.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        try {
            System.out.println("\"Hello World\" Jersey Example App");

            HttpServer server = startServer();
            Runtime.getRuntime().addShutdownHook(new Thread(server::shutdownNow));


            System.out.println("Application started.\nTry out");
            System.out.println(String.format("%s%s", BASE_URI, ROOT_HELLO_PATH));
            System.out.println("Stop the application using CTRL+C");

            Thread.currentThread().join();
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

