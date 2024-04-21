package ch.hslu.SW09.Collections;

import ch.hslu.SW09.FinalAndStatic.Temperatur;

import java.util.ArrayList;

public final class TemperaturVerlauf extends ArrayList<Temperatur> {

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
}
