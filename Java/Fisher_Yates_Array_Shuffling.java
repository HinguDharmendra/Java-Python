import java.util.Random;
import java.util.Scanner;


public class Fisher_Yates_Array_Shuffling 
{
    static int[] fisherYatesShuffling(int []arr, int n)
    {
        int []a = new int[n];
        int []ind = new int[n];
        for(int i=0; i<n; i++)
            ind[i] = 0;
        int index;
        Random rand = new Random();
        for(int i=0; i<n; i++)
        {
            do
            {
                index = rand.nextInt(n);
            } while(ind[index] != 0);
			
            ind[index] = 1;
            a[i] = arr[index];
        }
        return a;
    }
	
    public static void main(String agrs[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the array size: ");
        int n = sc.nextInt();
        System.out.println("Enter the array elements: ");
        int []a = new int[n];
        int []res = new int[n];
        for(int i=0; i<n; i++)
        {
            a[i] = sc.nextInt();
        }
        res = fisherYatesShuffling(a, n);
        for(int i=0; i<n; i++)
        {
            System.out.print(res[i]+" ");
        }
        sc.close();
    }
}
