package ch.hslu.SW12.TemperaturVerlauf;

import ch.hslu.SW10.TempUnitEnum;

import java.util.Objects;
import java.util.Scanner;

public final class Temperatur implements Comparable<Temperatur> {
    public static final float KELVIN_OFFSET = 273.15f;
    private float kelvin;


    /**
     * Konstruktor für Objekte der Klasse Temperatur
     */
    private Temperatur() {
        this.kelvin = 20;
    }

    /**
     * Overload Konstruktor für Objekte der Klasse Temperatur
     *
     * @param temp Temperatur
     * @param unit Temperatur Einheit
     */
    private Temperatur(float temp, TempUnitEnum unit) {
        if (unit == TempUnitEnum.KELVIN) {
            this.setKelvin(temp);
        } else if (unit == TempUnitEnum.CELSIUS) {
            this.setCelsius(temp);
        } else {
            throw new IllegalArgumentException("Ungültige Temperatur Einheit");
        }
    }

    /**
     * Create a new temperature object from Kelvin
     *
     * @param celsius temperature in Kelvin
     * @return temperature object
     */
    public static Temperatur createFromCelsius(final float celsius) {
        return new Temperatur(celsius, TempUnitEnum.CELSIUS);
    }

    /**
     * Create a new temperature object from Celsius
     *
     * @param kelvin temperature in Celsius
     * @return temperature object
     */
    public static Temperatur createFromKelvin(final float kelvin) {
        return new Temperatur(kelvin, TempUnitEnum.KELVIN);
    }

    /**
     * Convert temperature from Kelvin to Celsius
     *
     * @param kelvin temperature in Kelvin
     * @return temperature in Celsius
     */
    public static float convertToCelsius(float kelvin) {
        return kelvin - KELVIN_OFFSET;
    }

    /**
     * Convert temperature from Celsius to Kelvin
     *
     * @param celsius temperature in Celsius
     * @return temperature in Kelvin
     */
    public static float convertToKelvin(float celsius) {
        return celsius + KELVIN_OFFSET;
    }

    public static void main(String[] args) {
        String input = "";
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Bitte Temperatur eingeben (oder 'exit' zum Beenden): ");
            input = scanner.next();
            try {
                float value = Float.valueOf(input);
                System.out.println(value);
            } catch (NumberFormatException e) {
                System.out.println("Ungültige Eingabe. Bitte Temperatur eingeben (oder 'exit' zum Beenden): ");
                continue;
            }
        } while (!"exit".equals(input));
        System.out.println("Programm beendet.");
    }

    /**
     * Get temperature in Kelvin
     *
     * @return temperature in Kelvin
     */
    public float getKelvin() {
        return kelvin;
    }

    /**
     * Set temperature in Kelvin
     *
     * @param kelvin temperature in Kelvin
     */
    private void setKelvin(final float kelvin) {
        if (kelvin < 0) throw new IllegalArgumentException("Temperatur darf nicht kleiner als 0 sein.");
        this.kelvin = kelvin;
    }

    /**
     * Get temperature in Celsius
     *
     * @return temperature in Celsius
     */
    public float getCelsius() {
        return this.kelvin - KELVIN_OFFSET;
    }

    /**
     * Set temperature in Celsius
     *
     * @param celsius temperature in Celsius
     */
    private void setCelsius(final float celsius) {
        if (celsius < -KELVIN_OFFSET)
            throw new IllegalArgumentException("Temperatur darf nicht kleiner als -273.15 sein.");
        this.kelvin = celsius + KELVIN_OFFSET;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        return (o instanceof Temperatur that)
                && Float.compare(getKelvin(), that.getKelvin()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getKelvin());
    }

    @Override
    public String toString() {
        return "Temperatur{" +
                "kelvin=" + kelvin +
                '}';
    }

    @Override
    public int compareTo(Temperatur o) {
        return Float.compare(this.kelvin, o.kelvin);
    }
}
