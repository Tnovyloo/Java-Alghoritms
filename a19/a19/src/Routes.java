import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

public class Routes {
    private static final Map<Integer, String> CITIES = new HashMap<>();

    static {
        CITIES.put(0, "Warszawa");
        CITIES.put(1, "Katowice");
        CITIES.put(2, "Zakopane");
        CITIES.put(3, "Lwow");
        CITIES.put(4, "Wieden");
        CITIES.put(5, "Budapeszt");
        CITIES.put(6, "Bukareszt");
        CITIES.put(7, "Zagrzeb");
        CITIES.put(8, "Sofia");
    }

    final static int[][] PATHS = {
        { 0, 300, 402, 356, -1, -1, -1, -1, -1 },
        { 300, 0, -1, -1, 440, 474, -1, -1, -1 },
        { 402, -1, 0, -1, -1, 330, -1, -1, -1 },
        { 356, -1, -1, 0, -1, -1, 823, -1, -1 },
        { -1, 440, -1, -1, 0, -1, -1, 430, -1 },
        { -1, 474, 330, -1, -1, 0, 813, 365, 774 },
        { -1, -1, -1, 823, -1, 813, 0, -1, 403 },
        { -1, -1, -1, -1, 430, 365, -1, 0, 768 },
        { -1, -1, -1, -1, -1, 774, 403, 768, 0 },
    };

    final static int MAX_RESTARTS = 8;
    // Ilosc wygenerowanych sciezek
    final static int N = 100;

    public static String getCity(int index) {
        return CITIES.get(index);
    }

    public static void main(String[] args) throws Exception {
        // Zmienne do zapisania najlepszych tras
        ArrayList<Integer> bestRouteArrayList = new ArrayList<>();
        int bestLength = 0;

        // Zmienne do zaczecia algorytmu
        int start = 0; // Warszawka
        int end = 8; // Sofia
        
        Random random = new Random();
        int countRestarts = 0;

        for (int i = 0; i < N; i++) {
            ArrayList<Integer> route = new ArrayList<>();
            // Dodajemy Warszawe jako nasz pierwszy przystanek
            route.add(start);

            // Dlugosc = 0, jeszcze nasz algorytm nigdzie nie dotarl
            int length = 0;
            // Zmienna do przechowywania booleana odnoscie poprawnosci naszej sciezki
            boolean isValid = true;

            // Zaczynamy od Warszawy
            int current = start;
            int next = start;

            // Dopoki Aktualne miasto -> sophia dystans < 1
            while (PATHS[current][end] < 1) {
                // Sprawdzamy czy udalo sie wygenerowac jakakolwiek trase
                if (countRestarts > MAX_RESTARTS) {
                    System.out.println("Nie udalo sie wygenerowac zadnej trasy");
                    return;   
                }
                
                // Zgodnie z metoda montecarlo bierzemy losowa zmienna, tzn losowe miasto.
                next = random.nextInt(CITIES.size());

                // Sprawdzamy czy trasa od akutalnego miasta do nastepnego jest wieksza niz 0 (czyli sprawdzamy czy istnieje)
                if (PATHS[current][next] > 0) {
                    // Dodajemy dlugosc trasy od miasta A do miasta B do ogolnej trasy
                    length += PATHS[current][next];
                    // Dodajemy przystanek
                    route.add(next);
                    current = next;

                    // Jesli ilosc przystankow jest za duza, to ignoruje juz ta trase. 
                    if (route.size() > 5) {
                        isValid = false;
                        break;
                    }
                }
            }

            // Jesli negacja isValid to zwiekszamy ilosc Restartow petli
            if (!isValid) {
                countRestarts++;
                i--; // Dekrementujemy i
                continue;
            }

            // Dodajemy do calej trasy ostatni przystanek, czyli Sofie
            route.add(end);
            // Dodajemy dystans od osteniego przystanku do Sophie
            length += PATHS[current][end];
            countRestarts = 0;

            System.out.println(route);
            // Sprawdzamy czy cala droga byla lepsza od poprzedniej.
            if (length < bestLength || bestLength == 0) {
                bestRouteArrayList = route;
                bestLength = length;
            }
        }

        System.out.println("Najlepsza wylosowana droga");
        for (Integer city : bestRouteArrayList) {
            System.out.println(getCity(city));
        }


        // Drugi sposob (TODO) - Djikstra alghoritm, BEZ MONTE CARLO
        int numNodes = PATHS.length; 
        ArrayList<Integer> unvisitedNodes = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8));
        HashMap<Integer, Integer> distanceTrackHashMap = new HashMap<>();
        HashMap<Integer, Integer> predecessors = new HashMap<>();
        
        // Set initial distances to "infinity" (Integer.MAX_VALUE) except for the start vertex
        int startV = 0; // Warszawka
        int destinationV = 8; // Sofia
        
        // Ustawiamy Nieskonczonosc dla kazdego wierzcholka droge 'nieskonczonosc'.
        for (int i = 0; i < numNodes; i++) {
            distanceTrackHashMap.put(i, Integer.MAX_VALUE);
        }
        // Droga do punktu startowego wynosi 0 (czyli od Warszawy do Warszawy jest 0 kilometrow.)
        distanceTrackHashMap.put(startV, 0); // Distance to start vertex is 0
        
        // Dopoki lista odwiedzonych wierzcholkow w grafie nie jest pusta.
        while (!unvisitedNodes.isEmpty()) {
            // Znajdz, najkrotsza droge do wierzcholka nieodwiedzonego
            int currentNode = getNodeWithMinDistance(unvisitedNodes, distanceTrackHashMap);

            // Zatrzymaj jesli dystans jest nieskonczony, badz wierzcholek jest celem
            if (currentNode == -1 || currentNode == destinationV) break; 

            // Zmien liste odwiedzonych wierzcholkow
            unvisitedNodes.set(unvisitedNodes.indexOf(currentNode), -1);
            
            for (int i = 0; i < numNodes; i++) {
                // Wez droge z miasta do miasta, czyli wage krawedzi pomiedzy dwoma wierzcholkami
                int edgeWeight = PATHS[currentNode][i];
                // Sprawdzamy czy waga krawedzi jest wieksza od zera oraz sprawdzamy czy nieodwiedzone wierzcholki zawieraja 'i'
                if (edgeWeight > 0 && unvisitedNodes.contains(i)) {
                    // Ustawiamy nowy dystans w trackHashMapie.
                    int newDist = distanceTrackHashMap.get(currentNode) + edgeWeight;
                    // Jesli nowy dystans jest mniejszy od tego zapisanego w hashmapie to aktualizujemy distanceTrackHashMape.
                    if (newDist < distanceTrackHashMap.get(i)) {
                        distanceTrackHashMap.put(i, newDist);
                        // Dodajemy do naszych odwiedzonych punktow.
                        predecessors.put(i, currentNode);
                    }
                }
            }
        }
        
        // Uzywamy funkcji do wyswietlnia drogi w grafie.
        printPath(predecessors, destinationV);

        System.out.println("Najkrotsza droga wierzcholku: " + startV + " do wierzcholka " + destinationV + " to: " + distanceTrackHashMap.get(destinationV));
    }
    
    private static int getNodeWithMinDistance(ArrayList<Integer> unvisitedNodes, HashMap<Integer, Integer> distanceTrackHashMap) {
        // Znajdujemy wierzcholek z najmniejsza odlegloscia do niego.
        int minDistance = Integer.MAX_VALUE;
        int minNode = -1;
        for (Integer node : unvisitedNodes) {
            if (node != -1 && distanceTrackHashMap.get(node) < minDistance) {
                minDistance = distanceTrackHashMap.get(node);
                minNode = node;
            }
        }
        return minNode;
    }

    private static void printPath(HashMap<Integer, Integer> predecessors, int destinationV) {
        LinkedList<String> path = new LinkedList<>();
        Integer step = destinationV;

        // Przejdz od tlu z punktu porzadanego do poczatkowego uzywajac mapy ktora zapisalismy.
        while (step != null) {
            path.addFirst(CITIES.get(step));
            step = predecessors.get(step);
        }
        
        // Wyswietlamy nasza podroz
        System.out.println(String.join(" -> ", path));
    }
}
