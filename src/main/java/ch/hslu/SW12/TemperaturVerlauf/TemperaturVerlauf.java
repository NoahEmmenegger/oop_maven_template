package ch.hslu.SW12.TemperaturVerlauf;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Temperaturverlauf
 */
public final class TemperaturVerlauf extends ArrayList<Temperatur> {
    private final List<PropertyChangeListener> changeListeners = new ArrayList<>();

    public static void main(String[] args) {
        TemperaturVerlauf temperaturVerlauf = new TemperaturVerlauf();
        temperaturVerlauf.addPropertyChangeListener(temperaturVerlauf::handleNewInfoEvent);
        Scanner scanner = new Scanner(System.in);
        String input = "";
        do {
            System.out.println("Bitte Temperatur eingeben (oder 'exit' zum Beenden): ");
            input = scanner.next();
            try {
                float value = Float.valueOf(input);
                System.out.println(value);

                temperaturVerlauf.add(Temperatur.createFromKelvin(value));
            } catch (NumberFormatException e) {
                System.out.println("Ungültige Eingabe. Bitte Temperatur eingeben (oder 'exit' zum Beenden): ");
                continue;
            }
        } while (!"exit".equals(input));

        System.out.println(temperaturVerlauf);
    }

    /**
     * Handle new info event.
     *
     * @param e The property change event.
     */
    private void handleNewInfoEvent(PropertyChangeEvent e) {
        System.out.println("New Max: " + e.getNewValue());
        if (e.getPropertyName() == "max") {
            System.out.println("Max changed");
        }

        if (e.getPropertyName() == "min") {
            System.out.println("Min changed");
        }
    }

    @Override
    public boolean add(Temperatur temperatur) {
        boolean result = super.add(temperatur);
        if (this.getMax() == temperatur) {
            PropertyChangeEvent event = new PropertyChangeEvent(this, "max", this.getMax(), temperatur);
            firePropertyChangeEvent(event);

        }
        if (this.getMin() == temperatur) {
            PropertyChangeEvent event = new PropertyChangeEvent(this, "min", this.getMin(), temperatur);
            firePropertyChangeEvent(event);

        }
        return result;
    }

    @Override
    public String toString() {
        return "TemperaturVerlauf{" +
                "count=" + this.getCount() +
                ", min=" + this.getMin() +
                ", max=" + this.getMax() +
                ", average=" + this.getAverage() +
                "}";
    }

    /**
     * Get the size of the TemperaturVerlauf.
     *
     * @return The size of the TemperaturVerlauf.
     */
    public int getCount() {
        return this.size();
    }

    /**
     * Get the Max Temperature
     *
     * @return The max temperature
     */
    public Temperatur getMax() {
        if (this.isEmpty()) {
            return null;
        }
        Temperatur max = this.get(0);
        for (Temperatur temperatur : this) {
            if (temperatur.getKelvin() > max.getKelvin()) {
                max = temperatur;
            }
        }
        return max;
    }

    /**
     * Get the Min Temperature
     *
     * @return The min temperature
     */
    public Temperatur getMin() {
        if (this.isEmpty()) {
            return null;
        }
        Temperatur min = this.get(0);
        for (Temperatur temperatur : this) {
            if (temperatur.getKelvin() < min.getKelvin()) {
                min = temperatur;
            }
        }
        return min;
    }

    public float getAverage() {
        if (this.isEmpty()) {
            return 0;
        }
        float sum = 0;
        for (Temperatur temperatur : this) {
            sum += temperatur.getKelvin();
        }
        return sum / this.size();
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
