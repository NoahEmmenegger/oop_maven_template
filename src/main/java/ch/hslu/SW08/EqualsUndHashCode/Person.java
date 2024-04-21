package ch.hslu.SW08.EqualsUndHashCode;

/**
 * Represents a Person with a lastname and a preName.
 */
public final class Person implements Comparable<Person> {
    /**
     * The ID of the Person.
     */
    private final long id;

    /**
     * The Lastname of the Person.
     */
    private String lastname;

    /**
     * The PreName of the Person.
     */
    private String preName;

    /**
     * Create a new Person with a lastname and a prename.
     *
     * @param id       The ID of the Person.
     * @param lastname The Lastname of the Person.
     * @param preName  The PreName of the Person.
     */
    public Person(long id, String lastname, String preName) {
        this.id = id;
        this.lastname = lastname;
        this.preName = preName;
    }

    /**
     * Get the ID of the Person.
     *
     * @return The ID of the Person.
     */
    public long getId() {
        return id;
    }

    /**
     * Get the Lastname of the Person.
     *
     * @return The Lastname of the Person.
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Set the Lastname of the Person.
     *
     * @param lastname The Lastname of the Person.
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Get the Prename of the Person.
     *
     * @return The Prename of the Person.
     */
    public String getPreName() {
        return preName;
    }

    /**
     * Set the Prename of the Person.
     *
     * @param preName The Prename of the Person.
     */
    public void setPreName(String preName) {
        this.preName = preName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", lastname='" + lastname + '\'' +
                ", preName='" + preName + '\'' +
                '}';
    }

    // Person kann Namen ändern, ist aber immer noch die gleiche Person
    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        return (o instanceof Person person)
                && getId() == person.getId();
    }

    @Override
    public int hashCode() {
        return Long.hashCode(getId());
        //return Objects.hash(getId());
    }

    /**
     * Compare two Persons by their ID.
     *
     * @param other The other Person to compare to.
     * @return 0 if the Persons are equal, -1 if this Person is smaller than the other Person, 1 if this Person is bigger than the other Person.
     */
    public int compareTo(Person other) {
        return Long.compare(this.id, other.id);
    }
}
