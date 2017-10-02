package no.ntnu.monitoring;

import org.glassfish.jersey.netty.httpserver.NettyHttpContainerProvider;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;
import java.util.logging.Logger;

public class App {
    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        final int portNumber = 8081;
        final URI BASE_URI = URI.create("http://localhost:" + portNumber + "/");

        final ResourceConfig resourceConfig = new ResourceConfig()
                .packages(App.class.getPackage().getName());

        LOGGER.info("Starting server at " + BASE_URI);
        NettyHttpContainerProvider.createServer(BASE_URI, resourceConfig, true);
    }
}
