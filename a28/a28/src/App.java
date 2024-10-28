import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class App {
    static final int[] NOMINALS = {500, 200, 100, 50, 20, 10, 5, 2, 1};
    static final int[] LIMITS = {1, 2, 0, 7, 2, 2, 5, 2, 10};

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        int[] reserve = LIMITS;
        ArrayList<Integer> usedNominalsList = new ArrayList<>();

        System.out.print("Podaj liczbę w groszach: ");
        int input = scanner.nextInt();
        scanner.close();

        // Dopóki suma jest mniejsza od input
        while (sum < input) {
            int bestNominal = -1;
            int bestCover = 0;

            // Przechodzimy po kolei po każdym nominale i patrzymy czy jest mniejszy lub rowny od (wartosci poczatkowej - aktualna suma)
            for (int i = 0; i < NOMINALS.length; i++){
                int tempCover = 0;

                // Jeśli podana moneta jest dalej w rezerwie oraz nie spowoduje przepełnienia sumy to ustawiamy wartość tempCover na jej nominał
                if (reserve[i] > 0 && NOMINALS[i] <= input - sum) {
                    tempCover = NOMINALS[i];
                }

                // Ustawiamy najwiekszy chwilowy nominał
                if (tempCover > bestCover) {
                    bestCover = tempCover;
                    // Zapamietujemy indeks najlepszego nominału
                    bestNominal = i;
                }
            }
            
            // Jeśli nominał jest rózny od -1 to dodajemy go do listy użytych monet.
            // Następnie dodajemy do sumy nominał który użyliśmy
            // Oraz z naszej rezerwy usuwamy banknot który nam został.
            if (bestNominal != -1) {
                usedNominalsList.add(NOMINALS[bestNominal]);
                sum += NOMINALS[bestNominal];
                reserve[bestNominal]--;
            } else {
                break;
            }
        }
        
        System.out.println("Wynik to: " + sum + " gr.");
        if (sum < input) {
            System.out.println("Brakło: " + (input - sum) + " gr." );
        }
        
        System.out.println("\nUżyte nominały:");
        HashMap<Integer, Integer> nominalsHashMap = new HashMap<>();
        // Dla lepszego wyswietlania używam HashMapy, (Mógłbym użyc również String buildera)
        for (int integer : usedNominalsList) {
            if (nominalsHashMap.containsKey(integer)) {
                nominalsHashMap.put(integer, nominalsHashMap.get(integer) + 1);
            } else {
                nominalsHashMap.put(integer, 1);
            }
        }

        System.out.println(nominalsHashMap);
    }
}
