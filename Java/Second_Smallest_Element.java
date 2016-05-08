import java.util.Random;

public class Second_Smallest_Element 
{
    static int kthminimum(int[] sequence, int k) 
    {
        // Bubble Sort for length of sequence minus k times
        for (int i = 0; i < (sequence.length - k); i++)
            for (int j = 0; j < sequence.length - 1; j++)
                if (sequence[j] > sequence[j + 1]) 
                {
                    sequence[j] = sequence[j] + sequence[j + 1];
                    sequence[j + 1] = sequence[j] - sequence[j + 1];
                    sequence[j] = sequence[j] - sequence[j + 1];
                }
        return sequence[k - 1];
    }

    public static void main(String args[]) 
    {
        Random random = new Random();
        int N = 20;
        int[] sequence = new int[N];

        for (int i = 0; i < N; i++)
            sequence[i] = Math.abs(random.nextInt(1000));

        System.out.println("Original Sequence: ");
        for (int i = 0; i < N; i++)
            System.out.print(sequence[i] + " ");

        System.out.println("\nSecond smallest element :\n"
                + kthminimum(sequence, 2));
    }
}
