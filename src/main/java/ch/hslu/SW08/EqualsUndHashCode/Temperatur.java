package ch.hslu.SW08.EqualsUndHashCode;

import java.util.Objects;

public final class Temperatur {
    private float earthTempCelsius;

    /**
     * Konstruktor für Objekte der Klasse Temperatur
     */
    public Temperatur() {
        this.earthTempCelsius = 20;
    }

    /**
     * Overload Konstruktor für Objekte der Klasse Temperatur
     */
    public Temperatur(float initEarthTempCelsius) {
        this.earthTempCelsius = initEarthTempCelsius;
    }

    public static void main(String[] args) {
        ChemicalElement ce = new ChemicalElement("Stickstoff", 39, 19, 3, false);
        Temperatur t = new Temperatur(20);
        System.out.println(t.getEarthTempCelsius());
        System.out.println(t.getEarthTempKelvin());
        System.out.println(t.getEarthTempFahreinheit());
        t.increaseTemp(10);
        System.out.println(t.getEarthTempCelsius());
        System.out.println(t.getAggregatszustand(ce));
    }

    public float getEarthTempCelsius() {
        return this.earthTempCelsius;
    }

    public void setEarthTempCelsius(float newTemp) {
        this.earthTempCelsius = newTemp;
    }

    public float getEarthTempKelvin() {
        return this.earthTempCelsius + 273.15f;
    }

    public float getEarthTempFahreinheit() {
        return this.earthTempCelsius * 1.8f + 32f;
    }

    public void increaseTemp(float add) {
        this.earthTempCelsius += add;
    }

    public void decreaseTemp(float sub) {
        this.earthTempCelsius -= sub;
    }

    public AggregatszustandEnum getAggregatszustand(ChemicalElement chemicalElement) {
        return chemicalElement.getAggregatszustand(this.earthTempCelsius);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        return (o instanceof Temperatur that)
                && Float.compare(getEarthTempCelsius(), that.getEarthTempCelsius()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEarthTempCelsius());
    }
}
