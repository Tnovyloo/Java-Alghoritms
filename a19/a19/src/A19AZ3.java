import java.util.ArrayList;

public class A19AZ3 {
    static int[][] graph = {
        {0, 300, 402, 356, -1, -1, -1, -1, -1},
        {300, 0, -1, -1, 440, 474, -1, -1, -1},
        {402, -1, 0, -1, -1, 330, -1, -1, -1},
        {356, -1, -1, 0, -1, -1, 823, -1, -1},
        {-1, 440, -1, -1, 0, -1, -1, 430, -1},
        {474, 330, -1, 823, -1, 0, 813, 365, -1},
        {-1, -1, -1, 823, -1, 813, 0, -1, 403},
        {-1, -1, -1, -1, 430, 365, -1, 0, 768},
        {-1, -1, -1, -1, -1, 774, 403, 768, 0}
    };

    static String[] cities = {
            "Warszawa",
            "Katowice",
            "Zakopane",
            "Lwów",
            "Wiedeń",
            "Budapeszt",
            "Bukareszt",
            "Zagreb",
            "Sofia"
    };

    public static void main(String[] args) {
        
        boolean[] visited = new boolean[graph.length];

        int start = 0;
        int end = 8;

        int currentCity = start;
        int totalDistance = 0;

        visited[currentCity] = true;
        ArrayList<String> citiesList = new ArrayList<>();
        citiesList.add(cities[start]);

        while (currentCity != end) {
            visited[currentCity] = true;

            System.out.println("Jestem w " + cities[currentCity]);
            int tempDistance = Integer.MAX_VALUE;
            int nextCity = -1;
            for (int i = 0; i < graph[currentCity].length; i++) {
                System.out.println(graph[currentCity][i]);
                if (graph[currentCity][i] != -1 && graph[currentCity][i] != 0 && graph[currentCity][i] < tempDistance && !visited[i]) {
                    nextCity = i;
                    tempDistance = graph[currentCity][i];
                    // totalDistance += graph[currentCity][i];
                }
            }
            
            if (nextCity == -1) {
                System.out.println("Nie odnaleziono sciezki");
                break;
            }

            if (nextCity == end) {
                System.out.println(totalDistance);
                System.out.println("Zakonczono w " + cities[nextCity]);
            }

            if (nextCity != -1) {
                citiesList.add(cities[nextCity]);
                visited[currentCity] = true;
                visited[nextCity] = true;
                totalDistance += graph[currentCity][nextCity];
                currentCity = nextCity;   
            }

        }

        for (String string : citiesList) {
            System.out.print(string + " --> ");
        }
    }
}
