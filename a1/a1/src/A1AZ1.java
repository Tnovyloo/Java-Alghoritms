import java.util.ArrayList;

public class A1AZ1 {

    static int[] idx = {0, 1, 2, 3, 4, 5};
    static int[] v =   {6, 2, 3, 2, 3, 1};
    static int[] w =   {6, 4, 5, 7, 10, 2};

    public static void main(String[] args) {
        // Musimy wziac tego z najlepszym waga/
        double[] valueRatio = new double[idx.length];

        for (int i = 0; i < valueRatio.length; i++) {
            valueRatio[i] = (double) w[i] / v[i];
        }

        for (double d : valueRatio) {
            System.out.print(d + ", ");
        }

        ArrayList<Integer> backPackArrayList = new ArrayList<>();
        int currentWeight = 0;
        int maxWeight = 10;
        int bestValue = 0;

        boolean[] packed = new boolean[idx.length];

        for (int i = 0; i < valueRatio.length; i++) {
            double bestRatio = 0;
            int bestRatioIndex = 0;
            for (int j = 0; j < valueRatio.length; j++) {
                if (bestRatio < valueRatio[j] && !packed[j]) {
                    bestRatio = valueRatio[j];
                    bestRatioIndex = j;
                }
            }
            System.out.println(bestRatio + " " + bestRatioIndex);
            
            if (currentWeight + v[bestRatioIndex] < maxWeight && !packed[bestRatioIndex]) {
                backPackArrayList.add(bestRatioIndex);
                bestValue += w[bestRatioIndex];
                packed[bestRatioIndex] = true;
                currentWeight += v[bestRatioIndex];
            }
        }

        System.out.println(bestValue + " " + backPackArrayList);
        

    }
}