package ch.hslu.SW08.EqualsUndHashCode;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for the Person class.
 */
final class PersonTest {
    @Test
    public void testEquals() {
        Person person = new Person(1, "Hans", "Muster");
        assertTrue(person.getId() == 1 && person.getLastname().equals("Hans") && person.getPreName().equals("Muster"));
    }

    @Test
    public void testEqualsContract() {
        EqualsVerifier.forClass(Person.class).withIgnoredFields("lastname", "preName").verify();
    }

    @Test
    public void testEqualPerson() {
        Person person1 = new Person(1, "Hans", "Muster");
        Person person2 = new Person(1, "Hans", "Muster");
        assertEquals(person1, person2);
    }

    @Test
    public void testNotEqualPerson() {
        Person person1 = new Person(1, "Hans", "Muster");
        Person person2 = new Person(2, "Hans", "Muster");
        assertNotEquals(person1, person2);
    }

    @Test
    public void testSameId() {
        Person person1 = new Person(1, "Noah", "Emmenegger");
        Person person2 = new Person(1, "Hans", "Muster");
        assertEquals(person1, person2);
    }

    @Test
    public void testHashCode() {
        Person person1 = new Person(1, "Hans", "Muster");
        Person person2 = new Person(1, "Hans", "Muster");
        assertEquals(person1.hashCode(), person2.hashCode());
    }

    @Test
    public void testHashCodeNotEqual() {
        Person person1 = new Person(1, "Hans", "Muster");
        Person person2 = new Person(2, "Hans", "Muster");
        assertNotEquals(person1.hashCode(), person2.hashCode());
    }

    @Test
    public void comparePerson() {
        Person person1 = new Person(1, "Hans", "Muster");
        Person person2 = new Person(1, "Hans", "Muster");
        assertEquals(person1, person2);
    }


    @Test
    public void testCompareToLessThan() {
        Person person1 = new Person(1, "Hans", "Muster");
        Person person2 = new Person(2, "Hans", "Muster");
        assertTrue(person1.compareTo(person2) < 0);
    }

    @Test
    public void testCompareToGreaterThan() {
        Person person1 = new Person(2, "Hans", "Muster");
        Person person2 = new Person(1, "Hans", "Muster");
        assertTrue(person1.compareTo(person2) > 0);
    }

    @Test
    public void testCompareToEquals() {
        Person person1 = new Person(1, "Hans", "Muster");
        Person person2 = new Person(1, "Hans", "Muster");
        assertEquals(0, person1.compareTo(person2));
    }
}