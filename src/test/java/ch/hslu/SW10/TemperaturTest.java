package ch.hslu.SW10;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    void createInvalidTempUnit() {
        final Exception e = assertThrows(IllegalArgumentException.class, () -> Temperatur.createFromKelvin(-1));
        assertEquals("Temperatur darf nicht kleiner als 0 sein.", e.getMessage());

        assertThatThrownBy(() -> Temperatur.createFromCelsius(-300))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Temperatur darf nicht kleiner als -273.15 sein.");
    }

}