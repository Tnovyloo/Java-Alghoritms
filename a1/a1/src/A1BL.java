import java.util.ArrayList;
import java.util.Random;

public class A1BL {
    static int[] idx = {0, 1, 2, 3, 4, 5};
    static int[] v = {6, 2, 3, 2, 3, 1};
    static int[] w = {6, 4, 5, 7, 10, 2};
    public static void main(String[] args) {
        int iterations = 100000;

        Random random = new Random();
        
        // Musimy stworzyc najpierw jakas losowa kombinacje
        boolean[] currentItems = new boolean[idx.length];
        for (int j = 0; j < currentItems.length; j++) {
            currentItems[j] = random.nextBoolean();
        }

        for (boolean b : currentItems) {
            System.out.print(b + ", ");
        }

        // Policz wartosc poczatkowego rozwiazania
        int bestValue = 0;
        int weight = 0;
        for (int i = 0; i < currentItems.length; i++) {
            if (currentItems[i]) {
                bestValue += w[i];
                weight += v[i];
            }
        }

        System.out.println(bestValue + " " + weight);

        for (int i = 0; i < iterations; i++) {
            boolean[] newItems = currentItems.clone();
            int randomIndex = random.nextInt(idx.length);
            newItems[randomIndex] = !newItems[randomIndex];

            int newValue = 0;
            int newWeight = 0;

            for (int j = 0; j < newItems.length; j++) {
                if (newItems[j]) {
                    newValue += w[j];
                    newWeight += v[j];
                }
            }
            
            if (newValue > bestValue && newWeight <= 10) {
                bestValue = newValue;
                weight = newWeight;
            }
        }

        System.out.println("Best value: " + bestValue + " weight: " + weight);
        
    }
}
