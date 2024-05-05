package ch.hslu.SW11.Auto;

import org.junit.jupiter.api.Test;

import java.beans.PropertyChangeEvent;

class CarTest {

    @Test
    void testListener() {
        PropertyChangeEvent event = new PropertyChangeEvent(this, "test", 1, 2);

    }

}