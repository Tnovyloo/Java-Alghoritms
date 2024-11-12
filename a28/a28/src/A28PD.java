import java.util.ArrayList;

public class A28PD {
    static final int[] NOMINALS = {500, 200, 100, 50, 20, 10, 5, 2, 1};
    static final int[] LIMITS = {1, 2, 0, 7, 2, 2, 5, 2, 10};

    public static void main(String[] args) {
        
        int[] reserve = LIMITS;
        int sum = 0;
        int input = 1300;
        ArrayList<Integer> usedNominals = new ArrayList<>();

        while (sum < input) {
            for (int i = 0; i < reserve.length; i++) {
                if (reserve[i] > 0 && NOMINALS[i] + sum <= input) {
                    usedNominals.add(NOMINALS[i]);
                    sum += NOMINALS[i];
                    reserve[i]--;
                    i--;
                }
            }

            System.out.println(usedNominals);

            break;
        }

    }
}
