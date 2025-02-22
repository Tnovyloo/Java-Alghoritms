import java.util.ArrayList;
import java.util.Scanner;

public class A28AZ {
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
                if (reserve[i] > 0 && NOMINALS[i] + sum <= input) { // sprawdz czy mamy w rezerwie i czy nie przekroczymy dodajac ten nominal inputu.
                    usedNominals.add(NOMINALS[i]); // dodaj do listy uzytych bankotow
                    reserve[i]--; // wez nominal z rezerwy
                    sum += NOMINALS[i]; // dodaj nominal do sumy
                    i--; // sprawdz czy mozesz jeszcze raz uzyc tego samego nominalu
                }
            }
            
            System.out.println(usedNominals);
            for (Integer integer : reserve) {
                System.out.print(integer + ", ");
            }

            break;
        }


    }
}
