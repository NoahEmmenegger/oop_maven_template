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
}
