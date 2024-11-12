import java.util.ArrayList;
import java.util.Scanner;

public class A28AZ2 {
    static final int[] NOMINALS = {500, 200, 100, 50, 20, 10, 5, 2, 1};
    static final int[] LIMITS = {1, 2, 0, 7, 2, 2, 5, 2, 10};
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbe w groszach: ");
        int input = scanner.nextInt();

        int sum = 0;

        ArrayList<Integer> usedNominals = new ArrayList<>();
        int[] reserve = LIMITS;

        while (sum < input) {
            for (int i = 0; i < NOMINALS.length; i++) {
                if (reserve[i] > 0 && sum + NOMINALS[i] <= input) {
                    reserve[i]--; // Usun banknot z resetwy
                    usedNominals.add(NOMINALS[i]); // Doadj uzyty nominal do listy uzytych nominalow
                    sum += NOMINALS[i]; // Dodaj uzyty nominal do sumy
                    i--; // Sprawdz czy mozesz ponownie
                }
            }

            System.out.println(usedNominals);
        }
    }
}
