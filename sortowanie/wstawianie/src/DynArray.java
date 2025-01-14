// Source code is decompiled from a .class file using FernFlower decompiler.
class DynArray {
    Person[] persons = new Person[2];
    int size = 0;
 
    public DynArray() {
    }
 
    public void add(Person p) {
       if (this.size == this.persons.length) {
          this.resizeArray();
       }
 
       this.persons[this.size] = p;
       ++this.size;
    }
 
    public void resizeArray() {
       int newSize = this.persons.length * 2;
       Person[] newPersons = new Person[newSize];
 
       for(int i = 0; i < this.persons.length; ++i) {
          newPersons[i] = this.persons[i];
       }
 
       this.persons = newPersons;
    }
 
    public void remove(int index) {
       DynArray newDynArray = new DynArray();
 
       for(int i = 0; i < this.persons.length; ++i) {
          if (i != index) {
             newDynArray.add(this.persons[i]);
          }
       }
 
       this.persons = newDynArray.persons;
    }
 
    public void newRemove(int index) {
       Person[] newPersons = new Person[this.size];
       int counter = 0;
 
       for(int i = 0; i < newPersons.length; ++i) {
          if (i != index) {
             newPersons[counter] = this.persons[i];
             ++counter;
          }
       }
 
       this.persons = newPersons;
    }
 
    public void display() {
       for(int i = 0; i < this.size; ++i) {
          System.out.println(this.persons[i]);
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
 