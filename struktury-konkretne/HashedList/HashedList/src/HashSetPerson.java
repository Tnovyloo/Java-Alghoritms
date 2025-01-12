import java.util.LinkedList;

public class HashSetPerson {
    private LinkedList<Person>[] buckets;
    private int size = 0;
    private int nBuckets;

    public HashSetPerson(int nBuckets) {
        this.buckets = new LinkedList[nBuckets];    // Nie podajemy typu generycznego
        this.nBuckets = nBuckets;

        for (int i = 0; i < nBuckets; i++) {
            this.buckets[i] = new LinkedList<>();
        }
    }

    private int indexFromHash(Person value) {
        return Math.abs(value.hashCode() % this.nBuckets); // Tutaj użyjemy HashCode z klasy Person
    }

    private void increaseBucketsIfNeeded() {
        if (this.size > this.nBuckets * 0.7) {
            int newNBuckets = this.nBuckets * 2;
            HashSetPerson newSet = new HashSetPerson(newNBuckets);

            for (LinkedList<Person> bucket : this.buckets)
                for (Person elem : bucket)
                    newSet.add(elem);

            this.size = newSet.size;
            this.buckets = newSet.buckets;
            this.nBuckets = newSet.nBuckets;
        }
    }

    public void add(Person value) {
        increaseBucketsIfNeeded();

        int index = indexFromHash(value);
        LinkedList<Person> bucket = buckets[index];
        if (!bucket.contains(value)) {  // Wykorzystuje metodę equals z klasy, na której działamy
            bucket.add(value);
            this.size++;
        }
    }

    public boolean contains(Person value) {
        int index = indexFromHash(value);
        LinkedList<Person> bucket = buckets[index];
        return bucket.contains(value);
    }

    /**
     * Tworzy nowy zbiór, który jest sumą elementów tego zbioru oraz drugiego zbioru.
     *
     * @param other drugi zbiór, którego elementy mają być dodane do wyniku
     * @return nowy zbiór zawierający wszystkie unikalne elementy z obu zbiorów
     */
    public HashSetPerson union(HashSetPerson other) {
        return null;
    }

    /**
     * Tworzy nowy zbiór, który zawiera elementy obecne w tym zbiorze, ale nieobecne w drugim zbiorze.
     *
     * @param other drugi zbiór, którego elementy mają zostać wykluczone
     * @return nowy zbiór zawierający różnicę między tym zbiorem a drugim
     */
    public HashSetPerson difference(HashSetPerson other) {
        return null;
    }

    /**
     * Tworzy nowy zbiór, który zawiera elementy wspólne tego zbioru oraz drugiego zbioru.
     *
     * @param other drugi zbiór do porównania
     * @return nowy zbiór zawierający elementy wspólne obu zbiorów
     */
    public HashSetPerson intersection(HashSetPerson other) {
        return null;
    }

    public void remove(Person value) {
        int index = indexFromHash(value);
        LinkedList<Person> bucket = buckets[index];
        if (bucket.remove((Person) value)) this.size--;
    }

    public void clear() {
        for (LinkedList<Person> bucket : buckets) {
            bucket.clear();
        }
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        String text = "{\n";

        for (int i = 0; i < this.buckets.length; i++) {
            text += "\t" + i + ": " + this.buckets[i].toString() + "\n";
        }

        return text + "}\n";
    }

    public static void main(String[] args) {
        HashSetPerson set1 = new HashSetPerson(4);
        for (Person elem : new Person[]{
                new Person(34, "Adam"),
                new Person(12, "Marian"),
                new Person(53, "Paweł"),
                new Person(54, "Stefan"),
        }) {
            set1.add(elem);
        }

        HashSetPerson set2 = new HashSetPerson(4);
        for (Person elem : new Person[]{
                new Person(53, "Paweł"),
                new Person(54, "Bogdan"),
                new Person(26, "Anna"),
                new Person(52, "Maria"),
        }) {
            set2.add(elem);
        }

        System.out.println(set1);
        System.out.println(set2);

        HashSetPerson unionSet = set1.union(set2);
        HashSetPerson differenceSet = set1.difference(set2);
        HashSetPerson intersectionSet = set1.intersection(set2);

        System.out.println(unionSet);
    }
}
