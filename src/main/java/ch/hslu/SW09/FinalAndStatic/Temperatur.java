package ch.hslu.SW09.FinalAndStatic;

import java.util.Objects;

public final class Temperatur implements Comparable<Temperatur> {
    public static final float KELVIN_OFFSET = 273.15f;
    private float kelvin;

    /**
     * Konstruktor für Objekte der Klasse Temperatur
     */
    public Temperatur() {
        this.kelvin = 20;
    }

    /**
     * Overload Konstruktor für Objekte der Klasse Temperatur
     *
     * @param kelvin temperature in Kelvin
     */
    public Temperatur(float kelvin) {
        this.kelvin = kelvin;
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
    public void setKelvin(final float kelvin) {
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
    public void setCelsius(final float celsius) {
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
