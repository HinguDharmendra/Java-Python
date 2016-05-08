import java.util.Random;

public class Maximum_Using_Binary 
{
    static int N = 20;
    static int []sequence = new int[N];

    public static void sort()
    {
       int i, j, temp;
        for (i = 1; i< N; i++) 
        {
            j = i;
            temp = sequence[i];    
            while (j > 0 && temp < sequence[j-1])
            {
                sequence[j] = sequence[j-1];
                j = j-1;
            }
            sequence[j] = temp;            
        }        
    }
    
    public static void main(String args[])
    {
        Random random = new Random();
        
        for(int i=0; i<N; i++)
            sequence[i] = Math.abs(random.nextInt(100));
        System.out.println("The sequence is :");
        for(int i=0; i<N; i++)
            System.out.print(sequence[i] + " ");     
        
        sort();
        
        System.out.println("\nThe minimum element in the sequence is : " + sequence[N-1]);
    }
}
