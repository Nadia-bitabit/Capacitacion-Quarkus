package org.acme;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.*;

@Path("/temperaturas")
public class TemperaturasResource {

    private TemperaturaService temperaturas;
    @Inject
    public TemperaturasResource( TemperaturaService temperaturas ) {
        this.temperaturas = temperaturas;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)//MediaType.APPLICATION_JSON -> De forma explicita
    @Path("/unaTemperaturas")
    public Temperatura medicion() {
        return new Temperatura("Malaga", 18,    28);
    }

    //Devuelve una lista de Temperaturas en formato de Array de objetos
    @GET
    @Produces(MediaType.APPLICATION_JSON)//MediaType.APPLICATION_JSON -> De forma explicita
    public List<Temperatura> listTemperaturas() {
        return Arrays.asList(
                new Temperatura("Malaga", 18,    28),
                new Temperatura("Bogota", 18,    28),
                new Temperatura("La plata", 18,    28),
                new Temperatura("Santiago de Chile", 18,    28),
                new Temperatura("Madrid", 18,    28)
        );
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)//MediaType.APPLICATION_JSON -> De forma explicita
    @Path("/temperaturas2")
    public List<Temperatura> listTemperaturas2() {
        return temperaturas.obtenerTemperaturas();
    }


    @POST
    public Temperatura nuevaTemperatura(Temperatura temp) {
        temperaturas.addTemperatura(temp);
        return temp;
    }


    @GET
    @Path("/maxima2")
    @Produces(MediaType.TEXT_PLAIN)
    public String maxima() {
        return Integer.toString(temperaturas.maxima());
    }

    //Response
    @GET
    @Path("/maximaTemperatura")
    @Produces(MediaType.TEXT_PLAIN)
    public Response maxima2() {
        if (!temperaturas.isEmpty()) {
            int temperaturaMaxima = temperaturas.maxima();
            return Response.ok(Integer.toString(temperaturaMaxima))
                    .header("X-Hola", "Buenos dias")
                    .build();
        } else {
            return  Response.status(404)
                    .entity("No temperaturas encontradas")
                    .build();
        }
    }

    @GET
    @Path("/{ciudad}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response temperaturaporciudad(@PathParam("ciudad")  String ciudad) {

        if (!temperaturas.isEmpty()) {
            Optional<Temperatura> temperaturaMaxima = temperaturas.buscarTemperaturaXCiudad(ciudad);
            return Response.ok( temperaturaMaxima.get())
                    .header("X-Hola", "Buenos dias")
                    .build();
        } else {
            return  Response.status(404)
                    .entity("Ciudad no encontrada")
                    .build();
        }
    }

    //ExceptionMapper y tratamiento de errores
    @GET
    @Path("/txc/{ciudad}")
    @Produces(MediaType.APPLICATION_JSON)
    public Temperatura tempxciudad2(@PathParam("ciudad")  String ciudad) {

        return temperaturas.buscarTemperaturaXCiudad(ciudad)
                .orElseThrow(() ->
                        new NoSuchElementException("No hay registro en ciudad: " + ciudad));
    }
}