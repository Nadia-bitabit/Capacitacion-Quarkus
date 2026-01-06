package org.acme;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.Optional;

@Path("/saludar")
public class GreetingResource {

    //Creacion de endpoint
    //@GET
    //public String hello() {
    //    return "Hello from Quarkus REST";
    //}

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

    //PathParam y QueryParam
    @GET
    @Path("/mensajevacio")
    public String saludarVacio(@QueryParam("mensaje") String mensaje) {
        /*if(mensaje == null) {
            return "Mensaje Vacio";
        }else {
            return ">" + mensaje;
        }*/
        return Optional.ofNullable(mensaje).orElse("Mensaje vacio").toUpperCase();
    }

    @GET
    @Path("/{nombre}")
    public String saludarPath(@PathParam("nombre") String nombre) {
        return Optional.ofNullable(nombre).map(n -> n.toUpperCase()).orElse("Nombre Vacio");
    }

    @GET
    @Path("/{nombre}/mayuscula")
    public String saludo(@PathParam("nombre") String nombre) {
        return "Hola, " + nombre.toUpperCase();
    }


}
