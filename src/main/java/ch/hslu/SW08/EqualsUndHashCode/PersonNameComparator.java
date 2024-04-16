package ch.hslu.SW08.EqualsUndHashCode;

import java.util.Comparator;

public class PersonNameComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        int lastNameComparison = p1.getLastname().compareTo(p2.getLastname());
        if (lastNameComparison != 0) {
            return lastNameComparison;
        } else {
            return p1.getPreName().compareTo(p2.getPreName());
        }
    }
}
