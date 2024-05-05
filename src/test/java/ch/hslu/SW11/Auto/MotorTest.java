package ch.hslu.SW11.Auto;

import org.junit.jupiter.api.Test;

class MotorTest {
    @Test
    void testSwitchOn() {
        Motor motor = new Motor();
        motor.addPropertyChangeListener(e -> {
            System.out.println("Event von Motor" + ": " + e.getOldValue() + " -> " + e.getNewValue());
        });
        motor.switchOn();
        motor.switchOff();
    }

}