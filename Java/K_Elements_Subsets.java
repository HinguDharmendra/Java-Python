import java.util.Random;
import java.util.Scanner;

public class K_Elements_Subsets 
{
    public static void main(String args[]) 
    {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the set: ");
        int N = sc.nextInt();
        int[] sequence = new int[N];
        for (int i = 0; i < N; i++)
            sequence[i] = Math.abs(random.nextInt(100));

        System.out.println("The elements in the set : ");
        for (int i = 0; i < N; i++)
            System.out.print(sequence[i] + " ");

        System.out.println("\nEnter the number of elements in the subsets: ");
        int n = sc.nextInt();

        int[] binary = new int[(int) Math.pow(2, N)];
        for (int i = 0; i < Math.pow(2, N); i++) 
        {
            int b = 1;
            binary[i] = 0;
            int num = i, count = 0;
            while (num > 0) 
            {
                if (num % 2 == 1)
                    count++;
                binary[i] += (num % 2) * b;
                num /= 2;
                b = b * 10;
            }
            if (count == n) 
            {
                System.out.print("{ ");
                for (int j = 0; j < N; j++) 
                {
                    if (binary[i] % 10 == 1)
                        System.out.print(sequence[j] + " ");
                    binary[i] /= 10;
                }
                System.out.println("}");
            }
        }
        sc.close();
    }
}