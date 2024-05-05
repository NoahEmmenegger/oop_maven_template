package ch.hslu.SW11.Auto;

/**
 * Interface for switchable devices.
 */
public interface CountingSwitchable extends Switchable {
    /**
     * Returns the number of times the device has been switched on.
     *
     * @return the number of times the device has been switched on
     */
    long getSwitchCount();
}
