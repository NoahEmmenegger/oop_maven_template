package ch.hslu.SW11.Auto;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class Motor implements Switchable {
    private final List<PropertyChangeListener> changeListeners = new ArrayList<>();
    /**
     * Umdrehungen pro Minute.
     */
    private int rpm;
    private MotorState state = MotorState.OFF;

    /**
     * Konstruktor.
     */
    public Motor() {
        this.rpm = 0;
    }

    public static void main(String[] args) {
        Motor motor = new Motor();
        motor.printStatus();
        motor.switchOn();
        motor.printStatus();
        motor.switchOff();
        motor.printStatus();
    }

    public void switchOn() {
        if (isSwitchedOff()) {
            this.state = MotorState.ON;
            final PropertyChangeEvent pcEvent = new PropertyChangeEvent(
                    this, "state", MotorState.OFF, MotorState.ON);
            this.firePropertyChangeEvent(pcEvent);
            System.out.println("Motor switched on.");
        }
    }

    public void switchOff() {
        if (isSwitchedOn()) {
            this.state = MotorState.OFF;
            final PropertyChangeEvent pcEvent = new PropertyChangeEvent(
                    this, "state", MotorState.ON, MotorState.OFF);
            this.firePropertyChangeEvent(pcEvent);
            System.out.println("Motor switched off.");
        }
    }

    public boolean isSwitchedOn() {
        return this.state == MotorState.ON;
    }

    public boolean isSwitchedOff() {
        return this.state == MotorState.OFF;
    }

    public int getRpm() {
        return rpm;
    }

    public void setRpm(int rpm) {
        this.rpm = rpm;
    }

    public void printStatus() {
        System.out.println("Motor rpm: " + rpm);
    }

    /**
     * Registriert einen PropertyChangeListener.
     *
     * @param listener PropertyChangeListener.
     */
    public void addPropertyChangeListener(
            final PropertyChangeListener listener) {
        this.changeListeners.add(listener);
    }

    /**
     * Deregistriert einen PropertyChangeListener.
     *
     * @param listener PropertyChangeListener.
     */
    public void removePropertyChangeListener(
            final PropertyChangeListener listener) {
        this.changeListeners.remove(listener);
    }

    /**
     * Informiert alle PropertyChangeListeners über PropertyChangeEvent.
     *
     * @param pcEvent PropertyChangeEvent.
     */
    private void firePropertyChangeEvent(
            final PropertyChangeEvent pcEvent) {
        for (final PropertyChangeListener listener : this.changeListeners) {
            listener.propertyChange(pcEvent);
        }
    }
}
