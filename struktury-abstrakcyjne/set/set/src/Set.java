import java.util.ArrayList;

public class Set {
    ArrayList<Person> set = new ArrayList<>();

    public boolean insert(Person p) {
        for (Person person : set) {
            if (person.equals(p)) {
                return false;
            }
        }

        set.add(p);
        return true;
    } 

    public boolean remove(Person p) {
        for (int i = 0; i < set.size(); i++) {
            if (p.equals(set.get(i))) {
                set.remove(i);
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Set zbr = new Set();
        zbr.insert(new Person("Tomisław", 19));
        zbr.insert(new Person("Nowak", 20));
        zbr.insert(new Person("Rychu", 21));
        System.out.println(zbr.set);
        zbr.insert(new Person("Tomisław", 19));
        zbr.insert(new Person("Rychu", 21));
        System.out.println(zbr.set);
        zbr.remove(new Person("Tomasz", 19));
        System.out.println(zbr.set);
    }
}
