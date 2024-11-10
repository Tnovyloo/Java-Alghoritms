/*
 Rozwiazanie decyzyjnego problemu plecakowego
 Metoda programowania dynamicznego
*/

public class A1PD {
    final static int LICZBA_PRZEDMIOTÓW = 6;                // liczba przedmiotów
    final static int MAX_V = 10;           // objetość plecaka

    final static int[] OBJĘTOŚCI_PRZEDMIOTÓW = {6, 2, 3, 2, 3, 1};  // objetości przedmiotów
    final static int[] W = {6, 4, 5, 7, 10, 2}; // wartości przedmiotów


    public static void main(String[] args) {
        int[][] tab = new int[LICZBA_PRZEDMIOTÓW][MAX_V + 1]; // Tablica DP przechowująca maksymalną wartość dla objętości 0...MAX_V

        // Inicjalizacja pierwszego wiersza - uwzględniamy tylko pierwszy przedmiot
        for (int v = 0; v <= MAX_V; v++) {
            if (OBJĘTOŚCI_PRZEDMIOTÓW[0] > v) tab[0][v] = 0; // Nie mieści się, wartość 0
            else tab[0][v] = W[0]; // Mieści się, wartość pierwszego przedmiotu
        }

        // Wypełnianie pozostałych wierszy dla każdego kolejnego przedmiotu
        for (int i = 1; i < LICZBA_PRZEDMIOTÓW; i++) {
            for (int v = 0; v <= MAX_V; v++) {
                if (OBJĘTOŚCI_PRZEDMIOTÓW[i] > v) {
                    tab[i][v] = tab[i - 1][v]; // i-ty przedmiot się nie mieści, bierzemy poprzednie rozwiązanie
                } else {
                    int pBezI = tab[i - 1][v]; // Rozwiązanie bez i-tego przedmiotu
                    int pI = W[i] + tab[i - 1][v - OBJĘTOŚCI_PRZEDMIOTÓW[i]]; // Rozwiązanie z i-tym przedmiotem
                    tab[i][v] = Math.max(pBezI, pI); // Uzupełniamy tablicę większą wartością
                }
            }
        }


        //Wypisanie tablicy z rozwiazaniami
        /**/
        System.out.println("\tv =\t0    1    2    3    4    5    6    7    8    9   10");
        /**/
        System.out.println("-----------------------------------------------------------");

        for (int i = 0; i < LICZBA_PRZEDMIOTÓW; i++) {
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
