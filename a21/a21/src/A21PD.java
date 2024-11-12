import java.util.ArrayList;
import java.util.Arrays;

public class A21PD {
    static double polandGDP = 6000;
    static double polandIncrease = 1.06;
    public static void main(String[] args) {
        // Zad 2
        int years = 20;
        double germanyGDP = 12000;
        double germanyIncrease = 1.012;
        ArrayList<Double> gdpGermanyList = new ArrayList<>(Arrays.asList(germanyGDP));
        ArrayList<Double> gdpPolandList = new ArrayList<>(Arrays.asList(polandGDP));
        
        // uzupelniam listy poszczegolnych lat wzrostu pkb dla Polski i Niemiec
        for (int i = 1; i < years; i++) {
            double newYearGDPPoland = gdpPolandList.get(i - 1) * polandIncrease;
            double newYearGDPGermany = gdpGermanyList.get(i - 1) * germanyIncrease;

            gdpPolandList.add(newYearGDPPoland);
            gdpGermanyList.add(newYearGDPGermany);
            
            if (newYearGDPPoland >= newYearGDPGermany) {
                System.out.println("PKB dorówna lub przekroczy pkb Niemiec po: " + i + " latach");
                // Nie potrzeba sprawdzac kolejnych lat poniewaz one z automatu beda wieksze niz niemieckie PKB.
                break;
            }
        }
        
        System.out.println("Wzrost PKB Polksi (nastepne lata): " + gdpPolandList + "\nWzrost PKB Niemiec (nastepne lata): " + gdpGermanyList);
    }    
}
