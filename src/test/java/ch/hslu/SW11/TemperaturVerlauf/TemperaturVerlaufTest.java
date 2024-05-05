package ch.hslu.SW11.TemperaturVerlauf;

import ch.hslu.SW09.Collections.TemperaturVerlauf;
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

}