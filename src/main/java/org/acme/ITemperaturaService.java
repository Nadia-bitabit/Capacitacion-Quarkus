package org.acme;

import java.util.List;
import java.util.Optional;

public interface ITemperaturaService {
    void addTemperatura(Temperatura temperatura);
    List<Temperatura> obtenerTemperaturas();
    Optional<Temperatura> buscarTemperaturaXCiudad(String ciudad);
    boolean isEmpty();
    int maxima();


}
