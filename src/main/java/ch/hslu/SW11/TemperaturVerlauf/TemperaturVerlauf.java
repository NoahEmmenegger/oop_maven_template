package ch.hslu.SW11.TemperaturVerlauf;

import java.util.ArrayList;
import java.util.Scanner;

public final class TemperaturVerlauf extends ArrayList<Temperatur> {

    public static void main(String[] args) {
        TemperaturVerlauf temperaturVerlauf = new TemperaturVerlauf();
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
}
