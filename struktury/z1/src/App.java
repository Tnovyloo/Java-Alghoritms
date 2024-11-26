public class App {
    public static void main(String[] args) throws Exception {
        OrdDynArrayGeneric<Person> personArray = new OrdDynArrayGeneric<>();

        personArray.add(new Person("Jacek", "Damian"));
        personArray.add(new Person("Tomislaw", "Apolonius curuś bahled faryl"));
        personArray.add(new Person("Bogusław", "Łęcina"));
        personArray.add(new Person("Sangti", "Magistri"));

        System.out.println(personArray);

        int index = personArray.indexOf(new Person("Bogusław", "Łęcina"));
        System.out.println("Index łęciny: " + index);

        personArray.remove(index);
        System.out.println("Po usunięciu łeciny " + personArray);
    }
}
