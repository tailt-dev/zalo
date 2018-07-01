package com.tailt.web.app;

import com.tailt.web.servlet.WebHub;
import org.eclipse.jetty.server.Server;
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;

public class Start {
    public static void main(String[] args) {
        final String port = "6197";
        URI uri = URI.create("http://localhost:"+port+"/");
        System.out.println(uri.getHost());

        ResourceConfig resourceConfig = new ResourceConfig(
                WebHub.class
        );
        resourceConfig.register(MultiPartFeature.class);

        Server server = JettyHttpContainerFactory.createServer(uri, resourceConfig, true);
        System.out.println(server.getURI());

    }
}
