import java.util.ArrayList;

public class A19AZ4 {
    
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
        int start = 0;
        int end = 8;
        
        int totalDistance = 0;
        boolean[] visited = new boolean[graph.length];
        int currentCity = start;

        ArrayList<String> citesList = new ArrayList<>();
        citesList.add(cities[currentCity]);
        visited[start] = true;

        System.out.println(citesList);

        while (currentCity != end) {
            int tempDistance = Integer.MAX_VALUE;
            int nextCity = -1;

            for (int i = 0; i < graph[currentCity].length; i++) {
                System.out.println(graph[currentCity][i]);
                if (!visited[i] && graph[currentCity][i] != -1 && graph[currentCity][i] < tempDistance) {
                    tempDistance = graph[currentCity][i];
                    nextCity = i;
                }
            }

            if (nextCity == -1) {
                System.out.println("Couldnt find any route");
                break;
            }

            visited[nextCity] = true;
            totalDistance += tempDistance;
            citesList.add(cities[nextCity]);            
            currentCity = nextCity;

        }

        System.out.println(citesList);


    }


}
