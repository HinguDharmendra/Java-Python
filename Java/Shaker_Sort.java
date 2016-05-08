import java.util.Random;


public class Shaker_Sort 
{
    public static void printSequence(int[] sorted_sequence) 
    {
        for (int i = 0; i < sorted_sequence.length; i++)
            System.out.print(sorted_sequence[i] + " ");
    }
    
    public static int[] shakerSort(int[] array) {
        for (int i = 0; i < array.length/2; i++) {
            boolean swapped = false;
            for (int j = i; j < array.length - i - 1; j++) {
                if (array[j] < array[j+1]) {
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
            for (int j = array.length - 2 - i; j > i; j--) {
                if (array[j] > array[j-1]) {
                    int tmp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = tmp;
                    swapped = true;
                }
            }
            if(!swapped) break;
        }
        return array;
    }
    public static void main(String args[]) 
    {
        System.out
                .println("Sorting of randomly generated numbers using Shaker SORT");
        Random random = new Random();
        int N = 20;
        int[] sequence = new int[N];

        for (int i = 0; i < N; i++)
            sequence[i] = Math.abs(random.nextInt(100));

        System.out.println("\nOriginal Sequence: ");
        printSequence(sequence);

        System.out.println("\nSorted Sequence: ");
        printSequence(shakerSort(sequence));
    }

}
