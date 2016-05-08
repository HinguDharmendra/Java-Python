import java.util.Random;

public class Minimum_Using_Sequential 
{
    static int N = 20;
    static int []sequence = new int[N];

    public static int minSequential()
    {
        int min = sequence[0];
        for(int i=0; i<N; i++)
            if(min > sequence[i])
                min = sequence[i];
        
        return min;
    }
    public static void main(String args[])
    {
        Random random = new Random();
    
        for(int i=0; i<N; i++)
            sequence[i] = Math.abs(random.nextInt(100));
        System.out.println("The sequence is :");
        for(int i=0; i<N; i++)
            System.out.print(sequence[i] + " ");     
                
        System.out.println("\nThe minimum element in the sequence is : " + minSequential());
    }
}
