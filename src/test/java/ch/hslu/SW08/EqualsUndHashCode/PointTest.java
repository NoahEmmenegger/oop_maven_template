package ch.hslu.SW08.EqualsUndHashCode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PointTest {

    @Test
    void testEquals() {
        Point point = new Point(1, 2);
        Point point2 = new Point(1, 2);
        assertEquals(point, point2);
    }

    @Test
    void testHashCode() {
        Point point = new Point(1, 2);
        Point point2 = new Point(1, 2);
        assertEquals(point.hashCode(), point2.hashCode());
    }
}