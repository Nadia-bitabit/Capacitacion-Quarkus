package org.acme;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class TemperaturaService implements ITemperaturaService {

    private List<Temperatura> valores = new ArrayList<>();

    @Override
    public void addTemperatura(Temperatura temperatura){
        valores.add(temperatura);
    }
    @Override
    public List<Temperatura> obtenerTemperaturas() {
        return Collections.unmodifiableList(valores);
    }

    @Override
    public Optional<Temperatura> buscarTemperaturaXCiudad(String ciudad) {
        return valores.stream()
                .filter(t -> t.getCiudad().equals(ciudad))
                .findFirst();
    }

    @Override
    public int maxima(){
        return valores.stream().mapToInt(Temperatura::getTemperaturaMaxima).max().orElse(0);
    }

    @Override
    public boolean isEmpty() {
        return valores.isEmpty();
    }


}
