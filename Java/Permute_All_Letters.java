import java.util.Scanner;

public class Permute_All_Letters 
{
    static void permute(char[] a, int k) 
    {
        if (k == a.length) 
        {
            for (int i = 0; i < a.length; i++) 
            {
                System.out.print(a[i]);
            }
            System.out.println();
        } 
        else 
        {
            for (int i = k; i < a.length; i++) 
            {
                char temp = a[k];
                a[k] = a[i];
                a[i] = temp;

                permute(a, k + 1);

                temp = a[k];
                a[k] = a[i];
                a[i] = temp;
            }
        }
    }

    public static void main(String args[]) 
    {
        System.out.println("Enter the length of character string: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        char[] sequence = new char[n];
        System.out.println("Enter the original string: ");
        for (int i = 0; i < n; i++)
            sequence[i] = sc.next().charAt(0);
        System.out.println("The permuted strings are: ");
        permute(sequence, 0);

        sc.close();
    }
}
