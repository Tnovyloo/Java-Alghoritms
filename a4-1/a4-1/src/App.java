import java.util.ArrayList;

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

        // Najpierw znajdziemy tego kosmonaute (indeks na ktorym jest w danychKosmonautow) ktory ma najwiecej umiejetnosci.
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
            
            // W tym przypadku wybierzemy ostatniego najlepszego kosmonaute.
            if (sumOfSkills >= theBestFirstCosmonautSkillCount) {
                theBestFirstCosmonautSkillCount = sumOfSkills;    
                firstBestCosmonautIndex = index;
                firstBestCosmonaut = i;
                // Usuwamy poniewaz dodalibysmy wszystkie przypdaki 'najlepszych' a nam chodzi poki co o wziecie tylko pierwszego
                cosmonautsSquadArrayList.clear();
                cosmonautsSquadArrayList.add(index);
            }

            System.out.println("koniec " + sumOfSkills);
            index++;
        }
        System.out.println("Zaczne od kosmonauty: k" + (firstBestCosmonautIndex + 1) + " "  + firstBestCosmonaut + " " + theBestFirstCosmonautSkillCount + " " );

        // podejscie pierwsze
        // Teraz pasuje wyrzucic kosmonaute kx z przeszukiwanych do nastepnych.
        
        // Sprawdz jakie umiejetnosci sa puste (na ktorych indeksach)

        // Majac puste umiejetnosci sprawdz po kolei kazdego kosmonaute czy akurat jest taki 

        // Majac tablice kosmonautow nalezy przeiterowac przez nia w celu 



        // podejscie drugie
        // wyrzuc kosmonaute (wyrzuce go poprzez to ze nie bede uwzglednial go w iterowaniu przy porownywaniu )

        // Aktualizujemy liste umiejetnosci naszych kosmonautow
        skills = firstBestCosmonaut;
        // Sprawdzamy kazdego kosmite z ktorym bedzie najmniej zer!!!
        while (true) {
            // Zmienna dla maksymalnej ilosci zapelnienia zer
            int maxZeroToOne = 0;

            for (int i = 0; i < cosmonauts.length; i++) {
                
                // Gdy aktualny kosmonauta bedzie rowny z tym ktory jest juz w zalodze, wtedy go nie bierzemy pod uwage.
                for (Integer indexInteger : cosmonautsSquadArrayList) {
                    if (i == indexInteger) {
                        break;
                    }
                }
                
                // PODEJSCIE 1 
                // Sprawdz najmniejsza ilosc 0 w tempSkills, dla kazdego kosmonauty, zapisz jego indeks jesli 
                // int[] tempSkills = {};
                // int[] currentCosmonautSkillSet = cosmonauts[i];

                // PODEJSCE 2
                // Zapisz indeksy w nowej tablicy gdzie w skills sa wartosci 0;
                ArrayList<Integer> whereIsZeros = new ArrayList<>();
                
                for (int k = 0; k < skills.length; k++) {
                    if (skills[k] == 0) {
                        whereIsZeros.add(k);
                    }
                }
                
                // Sprawdz ile cosmonauta[i] zapelni zer (te ktore sa na potrzebnych miejscach)
                int tempCounter = 0;
                // Wchodzimy w petle sprawdzajaca kazdy pojedynczy skill cosmonauty[i]
                for (int j = 0; j < cosmonauts[i].length; j++) {
                    // Sprawdz czy pojedynczy skill jest jedynka
                    if (cosmonauts[i][j] == 1) {
                        // Sprawdz czy ten skill jest na liscie whereIsZero
                        for (Integer zeroSkillIndexInteger : whereIsZeros) {
                            if (zeroSkillIndexInteger == j) {
                                tempCounter += 1;
                            }
                        }
                    }
                }

                if (tempCounter > maxZeroToOne) {
                    // ZAPISZ TEGO CO PRZEBIL maxZeroToOne
                    // jest on pod indeksem 'i' (zapisz go w liscie cosmonautsSquadArrayList)
                    cosmonautsSquadArrayList.add(i);
                    // Nastepnie zapisz biezacy skillset z nim
                    System.out.println("Wzialem k" + i);
                    for (int j = 0; j < cosmonauts[i].length; j++) {
                        if (cosmonauts[i][j] == 1) {
                            skills[j] = 1;
                        }
                    }
                    maxZeroToOne = tempCounter;
                }

                // Zapisz pierwszego lepszego ze jest najlepszy.
                // w petli sprawdzaj ile zer uzupelnia sposrod tych ktore sa na indeksach brakujacych
                
                // ABY UNIKNAC NIESKONCZNEJ PETLI KONIECZNIE ZAPISZ SKILLS GDY ZNAJDZIESZ JUZ NAJLEPSZEG KANDYDATA
                
            }

            // Wykonuj petle dopoki kazdy bool w tablicy skills nie bedzie 1;
            if (skills != targetSkills) {
                continue;
            } else {
                System.out.println(skills + " job is done." +  cosmonautsSquadArrayList);
                break;
            }
        }

    }
}
