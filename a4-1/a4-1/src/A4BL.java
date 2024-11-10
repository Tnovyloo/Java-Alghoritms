import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class A4BL {
    static int[][] skills = {
        //   A  B  C  D  E  F
            {1, 0, 0, 0, 1, 0}, // k1
            {0, 1, 0, 1, 0, 1}, // k2  
            {1, 1, 0, 0, 1, 0}, // k3
            {0, 1, 0, 0, 1, 1}, // k4
            {0, 0, 1, 1, 0, 0} // k5
        };
    public static int[] cosmonauts = {0, 1, 2, 3, 4};        
    public static int[] targetSkills = {1, 1, 1, 1, 1, 1};
        
    public static void main(String[] args) {
        Random random = new Random();

        boolean[] cosmonautsList = new boolean[5];
        for (int i = 0; i < cosmonautsList.length; i++) {
            cosmonautsList[i] = random.nextBoolean();
        }

        for (boolean b : cosmonautsList) {
            System.out.print(b + ", ");
        }
        System.out.println("");

        // cosmonautsList[0] = false;
        // cosmonautsList[1] = false;
        // cosmonautsList[2] = false;
        // cosmonautsList[3] = false;
        // cosmonautsList[4] = false;
        
        // for (boolean b : cosmonautsList) {
        //     System.out.print(b + ", ");
        // }
        // System.out.println("");


        for (int i = 0; i < 10; i++) {
            int[] iterateCosmonautsSkills = {0, 0, 0, 0, 0, 0};
            for (int j = 0; j < cosmonautsList.length; j++) {

                // Dodaj wszystkich kosmonautow do listy aby sprawdzic czy ich umiejetnosci sa w target skillsach
                ArrayList<Integer> indexesOfCosmonauts = new ArrayList<>();
                for (int k = 0; k < cosmonautsList.length; k++) {
                    if (cosmonautsList[k]) {
                        indexesOfCosmonauts.add(k);
                    }    
                }
                

                int[] currentSkills = {0, 0, 0, 0, 0, 0};
                // System.out.println(indexesOfCosmonauts);
                for (int cosmonaut : indexesOfCosmonauts) {
                    int[] cosmonautSkills = skills[cosmonaut];
                    for (int k = 0; k < cosmonautSkills.length; k++) {
                        if (cosmonautSkills[k] == 1) {
                            currentSkills[k] = 1;
                        }
                    }
                }

                if (Arrays.equals(targetSkills, currentSkills)) {
                    for (int k : currentSkills) {
                        System.out.print(k + ", ");
                    }
                    System.out.println(indexesOfCosmonauts);
                    iterateCosmonautsSkills = currentSkills;
                    break;
                } else {
                    for (int k : currentSkills) {
                        System.out.print(k + ", ");
                    }
                    System.out.println(indexesOfCosmonauts);
                    int randomIndex = random.nextInt(cosmonautsList.length);
                    cosmonautsList[randomIndex] = !cosmonautsList[randomIndex];
                }

            }

            if (Arrays.equals(iterateCosmonautsSkills, targetSkills)) {
                break;
            } else {
                continue;
            }

        }
    }

}
