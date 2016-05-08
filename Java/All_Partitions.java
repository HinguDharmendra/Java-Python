import java.util.Random;
import java.util.Scanner;


public class All_Partitions 
{
    static void printCombinations(int[] sequence, int N) 
    {
        int[] data = new int[N];
        for (int r = 0; r < sequence.length; r++)
            combinations(sequence, data, 0, N - 1, 0, r);
    }

    static void combinations(int[] sequence, int[] data, int start, int end,
            int index, int r) 
    {

        if (index == r) 
        {
            for (int j = 0; j < r; j++)
                System.out.print(data[j] + " ");
            System.out.println();
        }

        for (int i = start; i <= end && ((end - i + 1) >= (r - index)); i++) 
        {
            data[index] = sequence[i];
            combinations(sequence, data, i + 1, end, index + 1, r);
        }
    }

    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in set: ");
        int n = sc.nextInt();
        
        Random random = new Random();
        int[] sequence = new int[n];

        for (int i = 0; i < n; i++)
            sequence[i] = Math.abs(random.nextInt(1000));

        for (int i = 0; i < sequence.length; i++)
            System.out.print(sequence[i] + " ");
        System.out.println();
        
        printCombinations(sequence, sequence.length);
        
        sc.close();       
    }
}
