public class A1PD1 {
    static int[] idx = {0, 1, 2, 3, 4, 5};
    static int[] volumes = {6, 2, 3, 2, 3, 1};
    static int[] values = {6, 4, 5, 7, 10, 2};

    final static int MAX_V = 10;

    public static void main(String[] args) {
        
        int[][] tab = new int[idx.length][MAX_V + 1];

        // Inicjalizuj pierwszy wiersz 
        for (int i = 0; i <= MAX_V; i++) {
            if (volumes[0] > i) {
                tab[0][i] = 0;
            } else {
                tab[0][i] = values[0];
            }
        }


        for (int i = 1; i < idx.length; i++) {
            for (int j = 0; j <= MAX_V; j++) {
                if (volumes[i] > j) {
                    tab[i][j] = tab[i - 1][j];
                } else {
                    int pBezI = tab[i - 1][j];
                    int pI = values[i] + tab[i - 1][j - volumes[i]];
                    tab[i][j] = Math.max(pBezI, pI);
                }
            }
        }

        System.out.println("v =\t0    1    2    3    4    5    6    7    8    9   10");
        /**/
        System.out.println("-----------------------------------------------------------");

        for (int i = 0; i < idx.length; i++) {
            /**/
            System.out.print("i = " + i + "|");
            for (int j = 0; j <= MAX_V; j++) {
                int val = tab[i][j];
                if (val < 100) System.out.print(" ");
                if (val < 10) System.out.print(" ");
                System.out.print(val + "  ");
            }
            System.out.println();
        }
    }
}
