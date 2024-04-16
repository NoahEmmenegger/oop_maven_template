package ch.hslu.SW09.FinalAndStatic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TemperaturTest {

    @Test
    void convertToCelsius() {
        float kelvin = 293.15f;
        float celsius = Temperatur.convertToCelsius(kelvin);
        assert (celsius == 20);
    }

    @Test
    void convertToKelvin() {
        float celsius = 20;
        float kelvin = Temperatur.convertToKelvin(celsius);
        assert (kelvin == 293.15f);
    }

    @Test
    void getKelvin() {
        Temperatur temperatur = new Temperatur(20);
        assert (temperatur.getKelvin() == 20);
    }

    @Test
    void setKelvin() {
        Temperatur temperatur = new Temperatur(20);
        temperatur.setKelvin(30);
        assert (temperatur.getKelvin() == 30);
    }

    @Test
    void getCelsius() {
        Temperatur temperatur = new Temperatur(20);
        assert (temperatur.getCelsius() == 20 - 273.15f);
    }

    @Test
    void setCelsius() {
        Temperatur temperatur = new Temperatur(20);
        temperatur.setCelsius(30);
        assert (temperatur.getCelsius() == 30);
    }

    @Test
    void testEquals() {
        Temperatur temperatur = new Temperatur(20);
        Temperatur temperatur2 = new Temperatur(20);
        assertEquals(temperatur, temperatur2);
    }

    @Test
    void testHashCode() {
        Temperatur temperatur = new Temperatur(20);
        Temperatur temperatur2 = new Temperatur(20);
        assertEquals(temperatur.hashCode(), temperatur2.hashCode());
    }

    @Test
    void testToString() {
        Temperatur temperatur = new Temperatur(20);
        assert (temperatur.toString().equals("Temperatur{kelvin=20.0}"));
    }

    @Test
    void compareTo() {
        Temperatur temperatur = new Temperatur(20);
        Temperatur temperatur2 = new Temperatur(30);
        assert (temperatur.compareTo(temperatur2) < 0);
    }
}