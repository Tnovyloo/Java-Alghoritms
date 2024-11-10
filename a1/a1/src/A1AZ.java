import java.util.ArrayList;

public class A1AZ {
    static int[] idx = {0, 1, 2, 3, 4, 5};
    static int[] v = {6, 2, 3, 2, 3, 1};
    static int[] w = {6, 4, 5, 7, 10, 2};

    public static void main(String[] args) {
        // Implementacja problemu plecakowego poprzez algorytm zachlanny
        double[] valuePerWeight = new double[idx.length];

        for (int i = 0; i < idx.length; i++) {
            valuePerWeight[i] = (double) w[i] / v[i];
        }

        for (double d : valuePerWeight) {
            System.out.print(d + ", ");
        }
        System.out.println("");

        int tempSizeOfItems = 0;
        int maxSizeOfItems = 10;
        ArrayList<Integer> allSelectedItemsArraylist = new ArrayList();

        for (int i = 0; i < valuePerWeight.length; i++) {
            double tempValue = 0;
            int bestValueIndex = 0;
            for (int j = 0; j < valuePerWeight.length; j++) {
                if (valuePerWeight[j] > tempValue) {
                    tempValue = valuePerWeight[j];
                    bestValueIndex = j;
                }
            }
            
            valuePerWeight[bestValueIndex] = -1;
            System.out.print("Wartosci w tablicy: ");
            for (double d : valuePerWeight) {
                System.out.print(d + ", ");
            }
            System.out.println(" Najlepsza wartosc: " + tempValue + " Jej indeks: " + bestValueIndex);
            
            if ((tempSizeOfItems < maxSizeOfItems) && ((tempSizeOfItems + v[bestValueIndex]) <= maxSizeOfItems )) {
                allSelectedItemsArraylist.add(bestValueIndex);
                tempSizeOfItems += v[bestValueIndex];
            }

        }

        System.out.println(allSelectedItemsArraylist);
        

    }    
}
