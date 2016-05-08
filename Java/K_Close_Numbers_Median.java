import java.util.Random;
import java.util.Scanner;

public class K_Close_Numbers_Median 
{
    static int N = 25;
    static int[] sequence = new int[N];
    
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
    
    public static int median()
    {
        if(N%2 == 0)
            return ((sequence[N/2-1] + sequence[N/2])/2);
        else
            return sequence[N/2];
    }
    public static void main(String args[])
    {
        Random random = new Random();
        
        for(int i=0; i<N; i++)
            sequence[i] = Math.abs(random.nextInt(100));
        sort();
        System.out.println("The Sequence is: ");
        for(int i=0; i<N; i++)
            System.out.print(sequence[i] + " ");
        
        int median = median();
        System.out.println("\nEnter the number of elements close to meadian you want: ");
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int i, j;
        if(N%2 == 0)
        {
            i = N/2-1;
            j = N/2;
        }
        else
        {
            i = N/2-1;
            j = N/2+1;
        }
        boolean flag = false; int n;
        for(n=0; n<k; n++)
        {
            if(median-sequence[i] < sequence[j]-median)
            {
                System.out.print(sequence[i] + " ");
                i--;
                if(i == -1)
                {
                    n++;
                    flag = true;
                    break;
                }
            }
            else 
            {
                System.out.print(sequence[j] + " ");
                j++;
                if(j == N)
                {
                    n++;
                    break;
                }
            }
        }
        while(n < k)
        {
            if(flag == true)
            {
                System.out.print(sequence[j] + " ");
                j++;
                n++;
            }
            else
            {
                System.out.print(sequence[i] + " ");
                i--;
                n++;
            }
        }
        sc.close();
    }
}
