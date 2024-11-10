import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class A4MC {
    
    public static void main(String[] args) {
        int[][] skills = {
            //   A  B  C  D  E  F
                {1, 0, 0, 0, 1, 0}, // k1
                {0, 1, 0, 1, 0, 1}, // k2  
                {1, 1, 0, 0, 1, 0}, // k3
                {0, 1, 0, 0, 1, 1}, // k4
                {0, 0, 1, 1, 0, 0} // k5
            };
        int[] cosmonauts = {0, 1, 2, 3, 4};        
        int[] targetSkills = {1, 1, 1, 1, 1, 1};
        int iterations = 1000;


        for (int i = 0; i < iterations; i++) {
            
            Random random = new Random();

            ArrayList<Integer> cosmonautsSquad = new ArrayList<>();
            for (int j = 0; j < cosmonauts.length; j++) {
                cosmonautsSquad.add(random.nextInt(cosmonauts.length));
            }

            int[] squadSkills = {0, 0, 0, 0, 0, 0};

            for (int j : cosmonautsSquad) {
                for (int k = 0; k < skills[j].length; k++) {
                    if (skills[j][k] == 1) {
                        squadSkills[k] = 1;
                    }
                }
            }

            if (Arrays.equals(squadSkills, targetSkills)) {
                // System.out.println(cosmonautsSquad);
                Set<Integer> setOfCosmonautsSquad = new HashSet<>();
                for (Integer integer : cosmonautsSquad) {
                    setOfCosmonautsSquad.add(integer + 1); // Dodaje + 1 dla latwiejszego porownania kosmonauty
                }
                
                if (setOfCosmonautsSquad.size() <= 3) {
                    for (int j : squadSkills) {
                        System.out.print(j + " ");
                    }
    
                    // System.out.println(cosmonautsSquad);
    
                    System.out.println(setOfCosmonautsSquad);
                }

                
                    
            }

        }

    }
}
