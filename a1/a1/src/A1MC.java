import java.util.ArrayList;
import java.util.Random;

public class A1MC {
    static int[] idx = {0, 1, 2, 3, 4, 5};
    static int[] v = {6, 2, 3, 2, 3, 1};
    static int[] w = {6, 4, 5, 7, 10, 2};
    public static void main(String[] args) {
        // Algorytm monte carlo nie porusza sie po przestrzeni rozwiazan. Proby sa niezalezne, w kazdej iteracji generowana jest calkowicie nowa losowa konfiguracja woboru przedmiotow
        int iterations = 1000;

        Random random = new Random();

        int bestValue = 0;
        int maxWeight = 10;
        boolean[] bestItems = new boolean[idx.length];
        for (int i = 0; i < iterations; i++) {
            // Losowanie
            boolean[] currentItems = new boolean[idx.length];
            for (int j = 0; j < currentItems.length; j++) {
                currentItems[j] = random.nextBoolean();
            }

            int tempValue = 0;
            int tempWeight = 0;
            for (int j = 0; j < currentItems.length; j++) {
                if (currentItems[j] == true) {
                    tempValue += w[j];
                    tempWeight += v[j];
                }
            }

            if (tempWeight <= maxWeight && tempValue > bestValue) {
                bestValue = tempValue;

                for (boolean b : currentItems) {
                    System.out.print(b + ", ");
                }
                System.out.println(bestValue + " " + tempWeight);
            }

        }

        
    }
}
