public class A19AZ2 {
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
        searchRoutes(0, 8);
    }

    public static void searchRoutes(int start, int end) {
        boolean[] visited = new boolean[graph[start].length];
        visited[start] = true;

        int currentCity = start;
        int totalDistance = 0;

        while (currentCity != end) {
            int nextCity = -1;
            int tempDistance = Integer.MAX_VALUE;
            for (int i = 0; i < graph[currentCity].length; i++) {
                System.out.println("Od: " + cities[currentCity] + " do miasta " + cities[i] + " jest " + graph[currentCity][i] + " czy odwiedzilem?: " + visited[i]);
                if (!visited[i] && graph[currentCity][i] < tempDistance && graph[currentCity][i] != -1) {
                    nextCity = i;
                    tempDistance = graph[currentCity][i];
                }
            }
            
            if (nextCity == -1) {
                System.out.println("Nie da sie znalezc drogi");
                break;
            }

            if (nextCity == end) {
                System.out.println("Udalo sie znalezc droge do " + cities[end]);
            }

            visited[currentCity] = true;
            visited[nextCity] = true;
            currentCity = nextCity;
            totalDistance += tempDistance;
        }
    }
}
