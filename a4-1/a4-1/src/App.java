import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static int[][] cosmonauts = {
        //       A  B  C  D  E  F
                {1, 0, 0, 0, 1, 0}, // k1
                {0, 1, 0, 1, 0, 1}, // k2  
                {1, 1, 0, 0, 1, 0}, // k3
                {0, 1, 0, 0, 1, 1}, // k4
                {0, 0, 1, 1, 0, 0} // k5
    };

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        int[] skills = {0, 0, 0, 0, 0, 0};
        int[] targetSkills = {1, 1, 1, 1, 1, 1};

        // Najpierw znajdziemy tego kosmonaute (indeks na ktorym jest w cosmonauts) ktory ma najwiecej umiejetnosci.
        int theBestFirstCosmonautSkillCount = 0;
        int[] firstBestCosmonaut = {};
        int firstBestCosmonautIndex = 0;
        ArrayList<Integer> cosmonautsSquadArrayList = new ArrayList<>();

        int index = 0;
        for (int[] i : cosmonauts) {
            int sumOfSkills = 0;

            for (int j : i) {
                sumOfSkills += j;
            }
            
            // W tym przypadku (>=) wybierzemy ostatniego najlepszego kosmonaute.
            if (sumOfSkills >= theBestFirstCosmonautSkillCount) {
                theBestFirstCosmonautSkillCount = sumOfSkills;    
                firstBestCosmonautIndex = index;
                firstBestCosmonaut = i;
                // Usuwamy wczesniejsych, poniewaz bez tego dodalibysmy wszystkie przypdaki 'najlepszych' a nam chodzi poki co o wziecie tylko pierwszego
                cosmonautsSquadArrayList.clear();
                cosmonautsSquadArrayList.add(index);
            }

            index++;
        }

        System.out.println("Zaczne od kosmonauty: k" + (firstBestCosmonautIndex + 1) + " "  + firstBestCosmonaut + " " + theBestFirstCosmonautSkillCount + " " );

        // Aktualizujemy liste umiejetnosci naszych kosmonautow (po tym jak wybralismy najlepszego z nich)
        skills = firstBestCosmonaut;

        // Sprawdzamy kazdego kosmite z ktorym bedzie najmniej zer!!!
        // Analogia tej petli jest taka:
        boolean continueWhile = true;
        while (continueWhile) {
            // HashMapa {'kosmonauta': 'ilość zapełnionych zer dla danej załogi'}
            HashMap<Integer, Integer> aggregatedCosmonauts = new HashMap<>();

            // Zapisuje sobie indeksy gdzie są zera w aktualnej tablicy Skillów
            ArrayList<Integer> whereIsZeros = new ArrayList<>();
                
            for (int k = 0; k < skills.length; k++) {
                if (skills[k] == 0) {
                    whereIsZeros.add(k);
                }
            }

            // Teraz sprawdzam każdego kosmonaute z którym będzie najmniej 0, Właściwie to agreguję wszystkich kosmonautów,
            // sprawdzam ile zapełnią zer w 'skills', 
            // po wykonanej pętli wybiorę najlepszych i dodam ich umiejetnosci do 'skills' oraz dodam ich do arrayListCosmonautsSquad
            for (int i = 0; i < cosmonauts.length; i++) {
                
                // Gdy aktualny kosmonauta bedzie rowny z tym ktory jest juz w zalodze, wtedy go nie bierzemy pod uwage.
                for (Integer indexInteger : cosmonautsSquadArrayList) {
                    if (i == indexInteger) {
                        break;
                    }
                }
                
                // Ten kawałek kodu sprawdza nam ILE cosmonauta[i] zapelnia potrzebnych umiejetnosci swoimi umiejetnosciami
                int tempCounter = 0;
                // Wchodzimy w petle sprawdzajaca kazdy pojedynczy skill cosmonauty[i]
                for (int j = 0; j < cosmonauts[i].length; j++) {
                    // Sprawdz czy pojedynczy skill jest jedynką
                    if (cosmonauts[i][j] == 1) {
                        // Sprawdz czy ten skill jest na liscie whereIsZero
                        for (Integer zeroSkillIndexInteger : whereIsZeros) {
                            // Jesli skill cosmonauty[i] jest na zerSkillIndexInteger zwiekszam tempCounter
                            if (zeroSkillIndexInteger == j) {
                                tempCounter += 1;
                            }
                        }
                    }
                }
                
                // Dodaje kosmonaute do zaagregowanej listy, w ktorej mamy wszystkich kosmonautow i ich ilosc zapelnien 0 w biezacym skillsecie.
                aggregatedCosmonauts.put(i, tempCounter);
                
            }

            // Przed zaczeciem nowej iteracji (ktora wykona sie z petli while) z nowymi zapelnienionymi skillami, sprawdz ich zaagregowanych i wybierz najlepszego i zaaktualizuj skillsy
            System.out.println(aggregatedCosmonauts);
            
            // Sprawdzamy ktory kosmonauta w tej 'turze' petli while byl najlepszy dla danego skillseta
            int tempCounter = 0;
            int bestCosmonautIndex = 0;
            for (Map.Entry<Integer, Integer> entry : aggregatedCosmonauts.entrySet()) {
                if (entry.getValue() > tempCounter) {
                    tempCounter = entry.getValue();
                    bestCosmonautIndex = entry.getKey();
                }
            }

            // Zmien skillset biezacej zalogi i dodaj go do cosmonautsSquad arraylist.
            for (int k = 0; k < cosmonauts[bestCosmonautIndex].length; k++) {
                if (cosmonauts[bestCosmonautIndex][k] == 1) {
                    skills[k] = 1;
                }
            }

            // Dodaje wybranego w tej turze kosmonaute do arraylisty
            cosmonautsSquadArrayList.add(bestCosmonautIndex);

            // Wykonuj petle dopoki kazdy bool w tablicy skills nie bedzie 1;
            if (!Arrays.equals(skills, targetSkills)) {
                continue;
            } else {
                System.out.println("Wybralem kosmonautow: ");
                for (Integer cosmonautsIndex : cosmonautsSquadArrayList) {
                    System.out.println("k" + (cosmonautsIndex + 1));
                }
                // Wylacz petle while
                continueWhile = false;
            }
        }

    }
}
