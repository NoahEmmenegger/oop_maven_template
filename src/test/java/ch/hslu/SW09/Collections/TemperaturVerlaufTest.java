package ch.hslu.SW09.Collections;

import ch.hslu.SW09.FinalAndStatic.Temperatur;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TemperaturVerlaufTest {
    @Test
    public void testAdd() {
        TemperaturVerlauf temperaturVerlauf = new TemperaturVerlauf();
        temperaturVerlauf.add(new Temperatur(20));
        assertEquals(1, temperaturVerlauf.size());
    }

    @Test
    public void testClear() {
        TemperaturVerlauf temperaturVerlauf = new TemperaturVerlauf();
        temperaturVerlauf.add(new Temperatur(20));
        temperaturVerlauf.clear();
        assertEquals(0, temperaturVerlauf.size());
    }

    @Test
    public void testGetCount() {
        TemperaturVerlauf temperaturVerlauf = new TemperaturVerlauf();
        temperaturVerlauf.add(new Temperatur(20));
        temperaturVerlauf.add(new Temperatur(30));
        assertEquals(2, temperaturVerlauf.getCount());
    }

}