import java.util.Random;
import java.util.function.DoubleUnaryOperator;

public class Figura {
    final static int N = 1000;    
    final static int AREA = 4;
    // Okreslam funkcje jako statyczne lambdy.
    final static DoubleUnaryOperator FUNCTION_A = x -> Math.sin(2 * x - Math.PI / 2);
    final static DoubleUnaryOperator FUNCTION_B = x -> Math.sin(2 * x + Math.PI / 2);

    static boolean isInArea(float x, float y) {
        return y >= FUNCTION_A.applyAsDouble(x) && y <= FUNCTION_B.applyAsDouble(x);
    }

    public static void main(String[] args) {
        Random random = new Random();
        int hits = 0;

        for (int i = 0; i < N; i++) {
            // https://stackoverflow.com/questions/40431966/what-is-the-best-way-to-generate-a-random-float-value-included-into-a-specified
            // float random = min + r.nextFloat() * (max - min);
            float x = -1 + random.nextFloat() * 2;
            float y = -1 + random.nextFloat() * 2;

            if (isInArea(x, y))
                hits++;
        }

        float result = Float.valueOf(hits) / N * AREA;
        System.out.println("Wynik to: " + result);
    }
}
