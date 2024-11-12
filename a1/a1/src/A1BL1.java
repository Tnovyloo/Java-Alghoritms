import java.util.ArrayList;
import java.util.Random;

public class A1BL1 {
    static int[] idx = {0, 1, 2, 3, 4, 5};
    static int[] v =   {6, 2, 3, 2, 3, 1};
    static int[] w =   {6, 4, 5, 7, 10, 2};
    
    public static void main(String[] args) {
        
        Random random = new Random();
        int iterations = 1000;
        int[] randomBackPack = new int[idx.length];

        for (int i = 0; i < randomBackPack.length; i++) {
            randomBackPack[i] = random.nextInt(idx.length);
        }

        for (int b : randomBackPack) {
            System.out.print(b + ", ");
        }
        System.out.print("\n");

        int maxWeight = 10;
        int maxValue = 0;
        ArrayList<Integer> bestCombination = new ArrayList<>();
        
        for (int i = 0; i < iterations; i++) {
            // Sprawdz czy dany plecak jest lepszy od ostatniego jesli jego laczna waga jest mniejsza niz 10
            int tempWeight = 0;
            int tempValue = 0;

            ArrayList<Integer> itemsInBackpack = new ArrayList<>();
            for (int j = 0; j < randomBackPack.length; j++) {
                if (!(itemsInBackpack.contains(randomBackPack[j]))) {
                    tempWeight += v[randomBackPack[j]];
                    tempValue += w[randomBackPack[j]];
                    itemsInBackpack.add(randomBackPack[j]);
                }
            }

            if (tempWeight <= 10 && tempValue > maxValue) {
                maxValue = tempValue;
                bestCombination = itemsInBackpack;
            } else {
                randomBackPack[random.nextInt(idx.length)] = random.nextInt(idx.length);
                System.out.print("Kolejna proba z:" );
                for (Integer integer : randomBackPack) {
                    System.out.print(" " + integer);
                }
                System.out.println("");
            }
        }

        System.out.println(bestCombination + " " + maxWeight + " " + maxValue);
    }
}
