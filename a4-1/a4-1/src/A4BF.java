import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class A4BF {
    
    public static void main(String[] args) throws Exception {
        // Metoda Brute Force dla Kosmitow
        int[][] skills = {
        //   A  B  C  D  E  F
            {1, 0, 0, 0, 1, 0}, // k1
            {0, 1, 0, 1, 0, 1}, // k2  
            {1, 1, 0, 0, 1, 0}, // k3
            {0, 1, 0, 0, 1, 1}, // k4
            {0, 0, 1, 1, 0, 0} // k5
        };
        int[] cosmonauts = {0, 1, 2, 3, 4};


        ArrayList<ArrayList<Integer>> cosmonautsCombinationsArrayList = new ArrayList<>();

        int totalCombinations = 1 << cosmonauts.length; // 2^n

        for (int i = 0; i < totalCombinations; i++) {
            ArrayList<Integer> currentArrayList = new ArrayList<>();
            for (int j = 0; j < cosmonauts.length; j++) {
                if ((i & (1 << j)) != 0) {
                    currentArrayList.add(cosmonauts[j]);
                }
            }

            cosmonautsCombinationsArrayList.add(currentArrayList);
        }

        int combinations = 0;
        for (ArrayList<Integer> arrayList : cosmonautsCombinationsArrayList) {
            System.out.println(arrayList);
            combinations++;
        }
        System.out.println("Ilosc kombinacji: " + combinations);

        // Sprawdzamy teraz dla kazdej kombinacji czy spelnia warunek.
        ArrayList<ArrayList<Integer>> finalCosmonautsArrayList = new ArrayList<>();
        int[] targetSkills = {1, 1, 1, 1, 1, 1};
        for (ArrayList<Integer> combination : cosmonautsCombinationsArrayList) {
            int[] tempSkillSet = {0, 0, 0, 0, 0, 0};

            // System.out.println(combination);


            for (int i = 0; i < combination.size(); i++) {
                int currentCosmonaut = combination.get(i);
                int[] currentCosmounatSkills = skills[currentCosmonaut];

                // System.out.println(currentCosmounatSkills);
                for (int k = 0; k < currentCosmounatSkills.length; k++) {
                    if (currentCosmounatSkills[k] == 1) {
                        tempSkillSet[k] = 1;
                    }
                }
            }

            // for (int i = 0; i < tempSkillSet.length; i++) {
            //     System.out.print(tempSkillSet[i] + " ");
            // }
            // System.out.println("");
            
            if (Arrays.equals(targetSkills, tempSkillSet)) {
                System.out.println(combination);
            }
        }
    }
}
