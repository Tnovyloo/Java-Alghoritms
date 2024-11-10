public class A19AZ {
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

    public static void shortestPath(int start, int end) {
        boolean[] visited = new boolean[graph.length];
        int currentCity = start;
        int totalDistance = 0;

        visited[currentCity] = true;
        System.out.println("Trasa: " + cities[currentCity]);

        while(currentCity != end) {
            int nextCity = -1;
            int shortestDistance = Integer.MAX_VALUE;

            for(int i = 0; i < graph[currentCity].length; i++) {
                if(!visited[i] && graph[currentCity][i] != -1 && graph[currentCity][i] < shortestDistance) {
                    shortestDistance = graph[currentCity][i];
                    nextCity = i;
                }
            }

            if(nextCity == -1) {
                System.out.println("Nie znaleziono trasy.");
                return;
            }

            totalDistance += shortestDistance;
            visited[nextCity] = true;
            currentCity = nextCity;
            System.out.println("-> " + cities[nextCity] + " odległość: " + shortestDistance + " km.");
        }
        System.out.println("Calkowita odleglosc: " + totalDistance + " km.");
    }

    public static void main(String[] args) {
        shortestPath(0, 8);
    }
}