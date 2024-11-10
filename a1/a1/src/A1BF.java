import java.util.ArrayList;

public class A1BF {
    static int[] i = {0, 1, 2, 3, 4, 5};
    static int[] v = {6, 2, 3, 2, 3, 1};
    static int[] w = {6, 4, 5, 7, 10, 2};

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        // Generujemy wszystkie kombinacje zbioru 'i'

        int totalCombinations = 2 << i.length;

        System.out.println(totalCombinations);  

        ArrayList<ArrayList<Integer>> allCombinations = new ArrayList<>();
        for (int j = 0; j < totalCombinations; j++) {
            ArrayList<Integer> currentCombination = new ArrayList();
            for (int k = 0; k < i.length; k++) {
                if ((j & (1 << k)) != 0) {
                    currentCombination.add(i[k]);
                }
            }
            allCombinations.add(currentCombination);
        }

        int backpackWeight = 10;
        int maxValue = 0;
        // int bestCombinationIndex = 0;
        ArrayList<Integer> bestCombination = new ArrayList<>();
        for (ArrayList<Integer> arrayList : allCombinations) {
            System.out.println(arrayList);
            int tempValue = 0;
            int tempWeight = 0;
            for (int j = 0; j < arrayList.size(); j++) {
                tempValue += w[arrayList.get(j)];
                tempWeight += v[arrayList.get(j)];
            }

            if (tempWeight <= backpackWeight) {
                if (tempValue >= maxValue) {                    
                    maxValue = tempValue;
                    bestCombination = arrayList;
                }
            }
        }

        System.out.println(bestCombination);


    }
}
