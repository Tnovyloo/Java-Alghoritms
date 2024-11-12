import java.util.ArrayList;
import java.util.Scanner;

public class A28AZ1 {
    static final int[] NOMINALS = {500, 200, 100, 50, 20, 10, 5, 2, 1};
    static final int[] LIMITS = {1, 2, 0, 7, 2, 2, 5, 2, 10};

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbe w groszach: ");

        int sum = 0;
        int[] reserve = LIMITS;
        ArrayList<Integer> usedNominals = new ArrayList<>();

        int input = scanner.nextInt();
        scanner.close();

        while (sum < input) {
            for (int i = 0; i < NOMINALS.length; i++) {
                if (reserve[i] > 0 && sum + NOMINALS[i] <= input) {
                    reserve[i] --; // odejmij z rezerwy
                    usedNominals.add(NOMINALS[i]); // dodaj nominal do listy
                    sum += NOMINALS[i]; // dodaj do sumy nominal
                    i--; // sprawdz czy mozesz uzyc ten sam nominal jeszcze raz
                }
            }

            System.out.println(usedNominals);
            break;
        }

    }
}
