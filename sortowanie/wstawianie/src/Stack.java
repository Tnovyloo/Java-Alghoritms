import java.util.ArrayList;

public class Stack {
    ArrayList<Person> persons = new ArrayList<>();

    public void put(Person p) {
        persons.add(p);
    }

    public void delete() {
        int size = persons.size();
        persons.remove(size - 1);
    }
    
    public static void main(String[] args) {
        Stack stack = new Stack();
        
        stack.put(new Person("Smieszko", 20));
        stack.put(new Person());
        stack.put(new Person("Jupik", 43));

        System.out.println(stack.persons);

        stack.delete();

        System.out.println(stack.persons);
    }
}
