import java.util.Random;

public class Heap_Algorithm_Permutation {
    public static void print(int[] a) {
        for (int i = 0; i < a.length; i++)
            System.out.print(" " + a[i] + " ");
        System.out.println();
    }

    public static void generate(int N, int[] data) {
        if (N == 1)
            print(data);
        else {
            for (int c = 1; c <= N; c++) {
                generate(N - 1, data);
                int index = ((N%2 != 0) ? 1 : c);
                int temp = data[index];
                data[index] = data[N-1];
                data[N-1] = temp;
            }
        }
    }

    public static void main(String args[]) 
    {
        Random random = new Random();
        int N = 3;
        int []sequence = new int[N];
        for(int i=0; i<N; i++)
            sequence[i] = Math.abs(random.nextInt(100));
        
        System.out.println("The Sequence is: ");
        for(int i=0; i<N; i++)
            System.out.print(sequence[i] + " ");
        System.out.println("\nThe permutations are: ");
        generate(N, sequence);
    }

}
