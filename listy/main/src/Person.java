public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Person other) {
        // Porównanie po wieku
        if (this.age != other.age) {
            return Integer.compare(this.age, other.age);
        }
        // Porównanie po nazwisku leksykograficznie
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}
