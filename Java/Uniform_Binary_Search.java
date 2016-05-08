import java.util.Random;
import java.util.Scanner;

public class Uniform_Binary_Search 
{
    static int N = 10;
    static int[] sequence = new int[N];
    static int[] delta = new int[42];

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
    }

    public static void make_delta(int N) 
    {
        System.out.println();
        int power = 1;
        int i = 0;
        do 
        {
            int half = power;
            power <<= 1;
            delta[i] = (N + half) / power;
        } while (delta[i++] != 0);
    }

    public static int unisearch(int key) 
    {
        int i = delta[0] - 1; /* midpoint of array */
        int d = 0;

        while (true) 
        {
            if (key == sequence[i])
                return i;
            else if (delta[d] == 0)
                return -1;
            else 
            {
                if (key < sequence[i])
                    i -= delta[++d];
                else
                    i += delta[++d];
            }
        }
    }

    public static void main(String args[]) 
    {
        Random random = new Random();

        for (int i = 0; i < N; i++)
            sequence[i] = Math.abs(random.nextInt(100));
        System.out.println("The sequence is :");
        sort();
        for (int i = 0; i < N; i++)
            System.out.print(sequence[i] + " ");
        //sort();
        make_delta(N);

        System.out.println("Enter the element to be searched: ");
        Scanner sc = new Scanner(System.in);
        int key = sc.nextInt();
        int p = unisearch(key);
        if (p > 0)
            System.out.println("Element found at position " + p);
        else
            System.out.println("Element doesn't exist");
        sc.close();
    }
}
