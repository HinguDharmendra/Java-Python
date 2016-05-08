import java.util.Random;
import java.util.Scanner;

public class Interpolation_Search 
{
    public static int N = 20;
    public static int[] sequence = new int[N];

    public static int interpolationSearch(int[] sequence, int toFind) 
    {
        int low = 0;
        int high = sequence.length - 1;
        int mid;

        while (sequence[low] <= toFind && sequence[high] >= toFind) 
        {
            mid = low + ((toFind - sequence[low]) * (high - low))
                    / (sequence[high] - sequence[low]);

            if (sequence[mid] < toFind)
                low = mid + 1;
            else if (sequence[mid] > toFind)
                high = mid - 1;
            else
                return mid;
        }

        if (sequence[low] == toFind)
            return low;
        else
            return -1;
    }

    public static void sort() 
    {
        int i, j, temp;
        for (i = 1; i < N; i++) 
        {
            j = i;
            temp = sequence[i];
            while (j > 0 && temp < sequence[j - 1]) 
            {
                sequence[j] = sequence[j - 1];
                j = j - 1;
            }
            sequence[j] = temp;
        }
        System.out.println("The Sequence is: ");
        for (int p = 0; p < N; p++)
            System.out.print(sequence[p] + " ");
    }

    public static void main(String args[]) 
    {
        Random random = new Random();

        for (int i = 0; i < N; i++)
            sequence[i] = Math.abs(random.nextInt(100));

        sort();
        System.out.println("\nEnter the key to be searched:");
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        int loc = interpolationSearch(sequence, k);
        if (loc < 0)
            System.out.println("Key does not exist");
        else
            System.out.println("Key found at position " + (loc + 1));
        sc.close();
    }
}
