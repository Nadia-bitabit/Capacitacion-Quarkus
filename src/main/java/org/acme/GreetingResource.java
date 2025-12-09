package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/saludar")
public class GreetingResource {

    @GET
    public String hello() {
        return "Hello from Quarkus REST";
    }

    @GET
    @Path("/dia")
    public String saludaDias() {
        return "Buenos dias";
    }

    @GET
    @Path("/tarde")
    public String saludaTarde() {
        return "Buenos Tarde";
    }

    @GET
    @Path("/noche")
    public String saludaNoche() {
        return "Buenos Noche";
    }



}
