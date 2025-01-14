import java.util.ArrayList;

public class Set {
    private ArrayList<Person> persons = new ArrayList<>();

    public Set() {

    }

    public boolean add(Person p) {
        if (persons.contains(p)) {
            return false;
        }
        persons.add(p);
        return true;
    }

    public static void main(String[] args) {
        Set set = new Set();

        Person p1 = new Person("siemanko", 15);
        set.add(new Person("Hello", 20));
        set.add(new Person("Naaa", 40));
        set.add(p1);
        set.add(p1);
        set.add(new Person("siii", 40));

        System.out.println(set.persons);
    }
}
