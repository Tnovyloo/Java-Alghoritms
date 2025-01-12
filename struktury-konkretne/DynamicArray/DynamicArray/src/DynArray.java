class DynArray {

    Person[] persons;
    int size;

    public DynArray() {
        persons = new Person[2];
        size = 0;
    }

    public void add(Person p) {
        if (size == persons.length) {
            resizeArray();
        }

        persons[size] = p;
        size++;
    }

    public void resizeArray() {
        int newSize = persons.length * 2;
        Person[] newPersons = new Person[newSize];

        for (int i = 0; i < persons.length; i++) {
            newPersons[i] = persons[i];
        }

        persons = newPersons;
    }

    public void remove(int index) {
        // Person[] newPersons = new Person[size];

        DynArray newDynArray = new DynArray();

        for (int i = 0; i < persons.length; i++) {
            if (i != index) {
                newDynArray.add(persons[i]);
            }
        }

        persons = newDynArray.persons;
    }

    public void newRemove(int index) {
        Person[] newPersons = new Person[size];

        int counter = 0;
        for (int i = 0; i < newPersons.length; i++) {
            if (i != index) {
                newPersons[counter] = persons[i];
                counter++;
            }
        }

        persons = newPersons;
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.println(persons[i]);
        }

        System.out.println();
    }

    public static void main(String[] args) {
        DynArray da = new DynArray();

        Person p1 = new Person();
        Person p2 = new Person(50, "Janusz");
        Person p3 = new Person(30, "Alicja");

        da.add(p1);
        da.add(p2);
        da.add(p3);
        da.add(new Person(40, "Asia"));
        da.display();
        da.newRemove(0);
        da.display();
    }

}