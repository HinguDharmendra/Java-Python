import java.util.Random;
import java.util.Scanner;

public class Random_Partition 
{
    public static void main(String args[]) 
    {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        int noc = random.nextInt(2);
        // if noc is equal to generate numbers
        if (noc == 1) 
        {
            int N = 10;
            int[] sequence = new int[N];
            System.out.print("The Original set of numbers are:\n  ");
            for (int i = 0; i < N; i++) 
            {
                sequence[i] = Math.abs(random.nextInt(100));
                System.out.print(sequence[i] + " ");
            }

            int partition_index = random.nextInt(11);
            System.out.println("\nThe two sequemces are: ");
            System.out.print("{ ");
            for (int i = 0; i < N; i++) 
            {
                if (i == partition_index)
                    System.out.print(" } and { ");
                System.out.print(sequence[i] + " ");
            }
            System.out.print("}");
            System.out
                    .println("\nPartitioning around index " + partition_index);

        }
        // else generate characters
        else
        {
            int N = 10;
            char[] sequence = new char[N];
            System.out.print("The Original set of characters are:\n  ");
            for (int i = 0; i < N; i++) 
            {
                sequence[i] = (char) Math.abs(random.nextInt(123 - 97) + 97);
                System.out.print(sequence[i] + " ");
            }

            int partition_index = random.nextInt(11);
            System.out.println("\nThe two sequemces are: ");
            System.out.print("{ ");
            for (int i = 0; i < N; i++) 
            {
                if (i == partition_index)
                    System.out.print(" } and { ");
                System.out.print(sequence[i] + " ");
            }
            System.out.print("}");
            System.out
                    .println("\nPartitioning around index " + partition_index);

        }
        sc.close();
    }
}
