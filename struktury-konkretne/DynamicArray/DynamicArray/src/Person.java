public class Person {
    int age;
    String name;

    public Person() {
        this.age = 0;
        this.name = "";
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return this.age + " " + this.name;
    }
}
