import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class A4PD {

    public static void main(String[] args) {
        int[][] skills = {
            {1, 0, 0, 0, 1, 0}, // k1
            {0, 1, 0, 1, 0, 1}, // k2  
            {1, 1, 0, 0, 1, 0}, // k3
            {0, 1, 0, 0, 1, 1}, // k4
            {0, 0, 1, 1, 0, 0}  // k5
        };

        int numSkills = skills[0].length;
        int numCosmonauts = skills.length;
        int[] targetSkills = {1, 1, 1, 1, 1, 1}; // Docelowe umiejętności

        // Tablica do przechowywania minimalnej liczby kosmonautów dla każdego zestawu umiejętności
        List<int[]> dpSkills = new ArrayList<>();
        List<Set<Integer>> dpCosmonauts = new ArrayList<>();

        // Inicjalizacja: brak umiejętności na początku
        dpSkills.add(new int[numSkills]);
        dpCosmonauts.add(new HashSet<>());

        // Iteracja po każdym kosmonaucie
        for (int i = 0; i < numCosmonauts; i++) {
            int[] currentSkills = skills[i];
            List<int[]> newDpSkills = new ArrayList<>(dpSkills);
            List<Set<Integer>> newDpCosmonauts = new ArrayList<>(dpCosmonauts);

            // Iteracja po istniejących zestawach umiejętności
            for (int j = 0; j < dpSkills.size(); j++) {
                int[] combinedSkills = combineSkills(dpSkills.get(j), currentSkills);
                Set<Integer> combinedCosmonauts = new HashSet<>(dpCosmonauts.get(j));
                combinedCosmonauts.add(i + 1); // Dodanie kosmonauty

                // Sprawdzenie, czy nowy zestaw umiejętności jest lepszy
                if (!containsSkills(newDpSkills, combinedSkills) || 
                    (containsSkills(newDpSkills, combinedSkills) && 
                     newDpCosmonauts.get(j).size() > combinedCosmonauts.size())) {
                    newDpSkills.add(combinedSkills);
                    newDpCosmonauts.add(combinedCosmonauts);
                }
            }

            dpSkills = newDpSkills;
            dpCosmonauts = newDpCosmonauts;
        }

        // Szukanie rozwiązania
        for (int i = 0; i < dpSkills.size(); i++) {
            if (Arrays.equals(dpSkills.get(i), targetSkills)) {
                System.out.println("Minimalna liczba kosmonautów: " + dpCosmonauts.get(i).size());
                System.out.println("Wybrani kosmonauci: " + dpCosmonauts.get(i));
                return;
            }
        }

        System.out.println("Nie znaleziono rozwiązania.");
    }

    // Funkcja łączy dwa zestawy umiejętności
    public static int[] combineSkills(int[] skills1, int[] skills2) {
        int[] combined = new int[skills1.length];
        for (int i = 0; i < skills1.length; i++) {
            combined[i] = Math.max(skills1[i], skills2[i]);
        }
        return combined;
    }

    // Sprawdza, czy lista `dpSkills` zawiera określony zestaw umiejętności
    public static boolean containsSkills(List<int[]> dpSkills, int[] skills) {
        for (int[] skillSet : dpSkills) {
            if (Arrays.equals(skillSet, skills)) {
                return true;
            }
        }
        return false;
    }
}
