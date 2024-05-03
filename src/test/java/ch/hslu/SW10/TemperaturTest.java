package ch.hslu.SW10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TemperaturTest {

    @Test
    void createFromCelsius() {
        Temperatur temperatur = Temperatur.createFromCelsius(20);
        assertEquals(20, temperatur.getCelsius());
    }

    @Test
    void createFromKelvin() {
        Temperatur temperatur = Temperatur.createFromKelvin(293.15f);
        assertEquals(293.15f, temperatur.getKelvin());
    }
}