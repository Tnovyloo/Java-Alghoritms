import java.util.ArrayList;
import java.util.Arrays;

public class A21DZ {

    static double polandGDP = 6000;
    static double polandIncrease = 1.06;

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        // Zad 1
        countDestinatedGDP(polandGDP, polandGDP * 2, 0);
        
    }

    // Funkcja wypisze nam kazdy rok oraz PKB na dany rok.
    public static double countDestinatedGDP(double gdp, double gdpEnd, int years) {
        System.out.println("Rok " + years + ": " + gdp + " " + gdpEnd);
        if (gdp >= gdpEnd) {
            return 1;
        }
        return countDestinatedGDP(gdp * polandIncrease, gdpEnd, years + 1);
    }

}
