public class A19AZ1 {
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
        searchRouters(0, 8);
    }

    public static void searchRouters(int start, int end) {
        int startCity = start;
        int endCity = end;

        boolean[] visitedCities = new boolean[graph.length];
        visitedCities[startCity] = true;

        int currentCity = startCity;
        // int nextCity = 0;

        int totalDistance = 0;

        while (currentCity != endCity) {
            int tempDistance = Integer.MAX_VALUE;
            int nextCity = -1;
            for (int i = 0; i < graph[currentCity].length; i++) {
                System.out.println("Od: " + cities[currentCity] + " do miasta " + cities[i] + " jest " + graph[currentCity][i] + " czy odwiedzilem?: " + visitedCities[i]);
                if (!visitedCities[i] && graph[currentCity][i] != -1 && graph[currentCity][i] < tempDistance) {
                    tempDistance = graph[currentCity][i];
                    nextCity = i;
                }                 
            }

            if (nextCity == endCity) {
                System.out.println("Udalo sie znalezc droge do " + cities[endCity]);
            }

            if (nextCity == -1) {
                System.out.println("Nie da sie znalezc nastepnej drogi");
                break;
            }

            visitedCities[currentCity] = true;
            visitedCities[nextCity] = true;
            System.out.println("Jedziemy z " + cities[currentCity] + " do " + cities[nextCity] + " z dystansem " + tempDistance);
            currentCity = nextCity;

            totalDistance += tempDistance;
            System.out.println();
        }
    }
}
