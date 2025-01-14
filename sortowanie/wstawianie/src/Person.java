import java.util.Objects;

public class Person {
    int age;
    String name;

    public Person() {
        this.age = 0;
        this.name = "none";
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != getClass() || obj == null) {
            return false;
        }
        Person person = (Person) obj;
        return person.age == this.age && Objects.equals(this.name, person.name);
    }

    @Override
    public String toString() {
        return this.name + " " + this.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
