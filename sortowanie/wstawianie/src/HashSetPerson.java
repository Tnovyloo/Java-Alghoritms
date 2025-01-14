import java.util.*;

public class HashSetPerson {
    private LinkedList<Person>[] buckets;
    private int size = 0;
    private int nBuckets;

    public HashSetPerson(int nBuckets) {
        this.buckets = new LinkedList[nBuckets];
        this.nBuckets = nBuckets;

        for (int i = 0; i < nBuckets; i++) {
            this.buckets[i] = new LinkedList<>();
        }
    }

    private int indexFromHash(Person value) {
        return Math.abs(value.hashCode() % this.nBuckets);
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
        if (!bucket.contains(value)) {
            bucket.add(value);
            this.size++;
        }
    }

    public boolean contains(Person value) {
        int index = indexFromHash(value);
        LinkedList<Person> bucket = buckets[index];
        return bucket.contains(value);
    }

    public HashSetPerson union(HashSetPerson other) {
        HashSetPerson unionSet = new HashSetPerson(Math.max(this.nBuckets, other.nBuckets));

        for (LinkedList<Person> bucket : this.buckets) {
            for (Person person : bucket) {
                unionSet.add(person);
            }
        }

        for (LinkedList<Person> bucket : other.buckets) {
            for (Person person : bucket) {
                unionSet.add(person);
            }
        }

        return unionSet;
    }

    public HashSetPerson difference(HashSetPerson other) {
        HashSetPerson differenceSet = new HashSetPerson(this.nBuckets);

        for (LinkedList<Person> bucket : this.buckets) {
            for (Person person : bucket) {
                if (!other.contains(person)) {
                    differenceSet.add(person);
                }
            }
        }

        return differenceSet;
    }

    public HashSetPerson intersection(HashSetPerson other) {
        HashSetPerson intersectionSet = new HashSetPerson(this.nBuckets);

        for (LinkedList<Person> bucket : this.buckets) {
            for (Person person : bucket) {
                if (other.contains(person)) {
                    intersectionSet.add(person);
                }
            }
        }

        return intersectionSet;
    }

    public void remove(Person value) {
        int index = indexFromHash(value);
        LinkedList<Person> bucket = buckets[index];
        if (bucket.remove(value)) this.size--;
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

        HashSetPerson unionSet = set1.union(set2);
        HashSetPerson differenceSet = set1.difference(set2);
        HashSetPerson intersectionSet = set1.intersection(set2);

        System.out.println("Union:");
        System.out.println(unionSet);

        System.out.println("Difference:");
        System.out.println(differenceSet);

        System.out.println("Intersection:");
        System.out.println(intersectionSet);
    }
}
