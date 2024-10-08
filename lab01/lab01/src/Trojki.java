public class Trojki {
    int MAX = 30;

    public void check() {
        System.out.println("Hello");

        int MAX = 30;

        for (int a = 1; a < MAX; a++) {
            for (int b = a; b < MAX; b++) {
                for (int c = b; c < MAX; c++) {
                    if (a * a + b * b == c * c) {
                        System.out.println("A: " + a + " B:" + b + " C: " + c);
                    }
                }
            }
        }

    }
}
