import java.util.ArrayList;

public class A1BF1 {

    static int[] idx = {0, 1, 2, 3, 4, 5};
    static int[] v =   {6, 2, 3, 2, 3, 1};
    static int[] w =   {6, 4, 5, 7, 10, 2};

    public static void main(String[] args) {
        
        int totalCombinations = 2 << idx.length;

        System.out.println(totalCombinations);

        ArrayList<ArrayList<Integer>> allCombinations = new ArrayList<>();

        for (int i = 0; i < totalCombinations; i++) {
            ArrayList<Integer> currentCombination = new ArrayList<>();
            for (int j = 0; j < idx.length; j++) {
                if ((i & (1 << j)) != 0) {
                    currentCombination.add(j);
                }
            }
            allCombinations.add(currentCombination);
        }

        System.out.println(allCombinations);

        int maxWeight = 10;
        int bestValue = 0;
        ArrayList<Integer> bestCombination = new ArrayList<>();
        for (ArrayList<Integer> currentCombination : allCombinations) {
            int tempWeight = 0;
            int tempValue = 0;
            for (int i = 0; i < currentCombination.size(); i++) {
                int cosmonautIndex = currentCombination.get(i);
                tempWeight += v[cosmonautIndex];
                tempValue += w[cosmonautIndex];
            }

            if (tempValue > bestValue && tempWeight <= 10) {
                bestValue = tempValue;
                bestCombination = currentCombination;
            }
        }

        System.out.println(bestValue + " " + bestCombination);
    }
}
