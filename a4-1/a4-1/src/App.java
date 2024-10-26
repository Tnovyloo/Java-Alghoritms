import java.util.ArrayList;
import java.util.HashMap;

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
            HashMap<Integer, Integer> aggregatedCosmonauts = new HashMap<>();

            for (int i = 0; i < cosmonauts.length; i++) {
                
                // Gdy aktualny kosmonauta bedzie rowny z tym ktory jest juz w zalodze, wtedy go nie bierzemy pod uwage.
                for (Integer indexInteger : cosmonautsSquadArrayList) {
                    if (i == indexInteger) {
                        break;
                    }
                }
                
                // PODEJSCIE 2.1 
                // Sprawdz najmniejsza ilosc 0 w tempSkills, dla kazdego kosmonauty, zapisz jego indeks jesli 
                // int[] tempSkills = {};
                // int[] currentCosmonautSkillSet = cosmonauts[i];

                // PODEJSCE 2.2
                // Zapisz indeksy w nowej tablicy gdzie w skills sa wartosci 0
                // tl;dr - tablica z indeksami gdzie skill == 0;
                ArrayList<Integer> whereIsZeros = new ArrayList<>();
                
                for (int k = 0; k < skills.length; k++) {
                    if (skills[k] == 0) {
                        whereIsZeros.add(k);
                    }
                }
                
                // Sprawdz ile cosmonauta[i] zapelni zer (te ktore sa na potrzebnych miejscach)
                // w sumie to by pasowalo sprawdzic ile kazdy z osobna zapelni zer na potrzebnych miejscach, po prostu ich zaagregowac i wybrac najlepszego

                // Ten kawałek kodu sprawdza nam ILE cosmonauta[i] zapelnia potrzebnych umiejetnosci swoimi umiejetnosciami
                int tempCounter = 0;
                // Wchodzimy w petle sprawdzajaca kazdy pojedynczy skill cosmonauty[i]
                for (int j = 0; j < cosmonauts[i].length; j++) {
                    // Sprawdz czy pojedynczy skill jest jedynka
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

                aggregatedCosmonauts.put(i, tempCounter);

                // Musimy zaagregowac wszystkich dostepnych kosmonautow wzgledem tego ile zapelnili umiejetnosci swoimi umiejetnosciami.
                // - musimy to robic przed petlą dla 'i', tzn tam zapisywac 



                // W tym if'ie musimy wybrac najlepszego z nich wszystkich i dodac go do cosmonautsSquadu.
                if (tempCounter > maxZeroToOne) {
                    // ZAPISZ TEGO CO PRZEBIL maxZeroToOne
                    // ale jesli zapisze tego co przebil maxZeroToOne to wezme tak narpawde nie najlepszego ale pierwszego ktory to zrobil
                    // czyli musze wziac tak naprawde goscia z najwieksza iloscia skill pointow 
                    // jest on pod indeksem 'i' (zapisz go w liscie cosmonautsSquadArrayList)
                    cosmonautsSquadArrayList.add(i);
                    // Nastepnie zapisz biezacy skillset z nim
                    // TUTAJ WYSTEPUJE JAKIS PROBLEM, PRZEANALIZUJ GO.
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
                
            }

            // Przed zaczeciem nowej iteracji z nowymi zapelnienionymi skillami, sprawdz ich zaagregowanych i wybierz najlepszego i zaaktualizuj skillsy

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
