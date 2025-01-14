import java.util.ArrayList;

public class Queue {
    ArrayList<Person> array = new ArrayList<>();

    public void add(Person p) {
        array.add(p);
    }

    public void delete() {
        array.remove(0);
    }
    
    public static void main(String[] args) {
        Queue queue = new Queue();

        queue.add(new Person("siemaneczko", 20));
        queue.add(new Person("hello", 41));
        queue.add(new Person("hhh", 23));

        System.out.println(queue);

        queue.delete();

        System.out.println(queue.array);
    }
}
