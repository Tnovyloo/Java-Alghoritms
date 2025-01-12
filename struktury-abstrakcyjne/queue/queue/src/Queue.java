import java.util.ArrayList;

public class Queue {
    ArrayList<Person> arr = new ArrayList<Person>();
    
    public void put(Person p) {
        arr.add(p);
    }

    public void pop() {
        // arr.removeFirst();
        ArrayList<Person> newArray = new ArrayList<>();

        for (int i = 1; i < arr.size(); i++) {
            newArray.add(arr.get(i));
        }

        arr = newArray;
    }

    public static void main(String[] args) {
        Person p1 = new Person("null", 0);
        Person p2 = new Person("herllo", 4);
        Person p3 = new Person("siemanko", 8);

        Queue queue = new Queue();
        queue.put(p1);
        queue.put(p2);
        queue.put(p3);

        System.out.println(queue.arr);

        queue.pop();

        System.out.println(queue.arr);
    }
}
