import java.util.ArrayList;
import java.util.Arrays;

public class A4AZ1 {
    public static int[][] cosmonauts = {
        //       A  B  C  D  E  F
                {1, 0, 0, 0, 1, 0}, // k1
                {0, 1, 0, 1, 0, 1}, // k2  
                {1, 1, 0, 0, 1, 0}, // k3
                {0, 1, 0, 0, 1, 1}, // k4
                {0, 0, 1, 1, 0, 0} // k5
    };
    
    public static void main(String[] args) {

        // boolean[] cosmonautsSkills = new boolean[cosmonauts[0].length];
        // for (boolean b : cosmonautsSkills) {
        //     System.out.print(b + ", ");
        // }

        int[] cosmonautsSkills = new int[cosmonauts[0].length];
        int[] targetSkills = {1, 1, 1, 1, 1, 1};

        // Ustaw na poczatku najlepszego
        int bestFirstCosmonautIndex = 0;
        int bestFirstCounter = 0;
        for (int i = 0; i < cosmonauts.length; i++) {
            int tempFirstCounter = 0;
            for (int j = 0; j < cosmonauts[i].length; j++) {
                if (cosmonauts[i][j] == 1) {
                    tempFirstCounter++;
                }
            }

            if (tempFirstCounter > bestFirstCounter) {
                bestFirstCounter = tempFirstCounter;
                bestFirstCosmonautIndex = i;
            }
        }

        for (int i = 0; i < cosmonauts[bestFirstCosmonautIndex].length; i++) {
            if (cosmonauts[bestFirstCosmonautIndex][i] == 1) {
                cosmonautsSkills[i] = 1;
            }
        }

        ArrayList<Integer> squadArrayList = new ArrayList<>();
        squadArrayList.add(bestFirstCosmonautIndex);
        
        while (true) {
            // Znajdz kosmonaute z najwieksza iloscia skilli 
            int bestCounter = 0;
            int bestCosmonaut = 0; // Index chwilowo najlepszego kosmonauty
            // wchodzimy w for loop dla kazdego kosmonauty
            for (int i = 0; i < cosmonauts.length; i++) {
                // Wchodzimy w umiejetnosci kosmonauty[i]
                int tempCounter = 0;
                for (int j = 0; j < cosmonauts[i].length; j++) { 
                    if (cosmonauts[i][j] == 1) {
                        if (cosmonautsSkills[j] < cosmonauts[i][j]) {
                            tempCounter++;
                        }
                    }
                }

                if (tempCounter > bestCounter) {
                    bestCounter = tempCounter;
                    bestCosmonaut = i;

                    for (int j = 0; j < cosmonauts[i].length; j++) {
                        if (cosmonauts[i][j] == 1) {
                            cosmonautsSkills[j] = 1;
                        }
                        // cosmonautsSkills[j] = cosmonauts[i][j];
                    }

                    squadArrayList.add(i);
                }

                System.out.println("Zestaw umiejetnosci: ");
                for (int j : cosmonautsSkills) {
                    System.out.print(j + ", ");
                }
                System.out.println("Dla kosmonauty " + i + " ilosc kwalifikacji przydatnych: " + tempCounter);
            }

            if (Arrays.equals(cosmonautsSkills, targetSkills)) {
                break;
            }
        }

        System.out.println(squadArrayList);
    }
}
