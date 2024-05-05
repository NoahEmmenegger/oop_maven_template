package ch.hslu.SW11.Auto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.PropertyChangeEvent;

public class Car implements Switchable {
    private static final Logger LOG = LoggerFactory.getLogger(Car.class);
    private final Motor motor;
    private final Licht licht;
    private boolean switchedOn;

    public Car() {
        this.motor = new Motor();
        this.motor.addPropertyChangeListener(this::handleMotorEvent);
        this.licht = new Licht();
        this.switchedOn = false;
    }

    private void handleMotorEvent(PropertyChangeEvent e) {
        LOG.info("Event von Motor" + ": " + e.getOldValue() + " -> " + e.getNewValue());
        System.out.println("Event von Motor" + ": " + e.getOldValue() + " -> " + e.getNewValue());
    }

    public void switchOn() {
        motor.switchOn();
        licht.switchOn();
        switchedOn = true;
    }

    public void switchOff() {
        motor.switchOff();
        licht.switchOff();
        switchedOn = false;
    }

    public boolean isSwitchedOn() {
        return switchedOn;
    }

    public boolean isSwitchedOff() {
        return !switchedOn;
    }
}
