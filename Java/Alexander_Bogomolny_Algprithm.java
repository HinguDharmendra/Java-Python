import java.util.Random;


public class Alexander_Bogomolny_Algprithm 
{
    static int level = -1;
    static void print(int []sequence, int N)
    {
        for (int i = 0; i < N; i++) {
          System.out.println(sequence[i] + " ");
        }
        System.out.println();
    }

    static void visit(int []sequence, int N, int k)
    {
      
      level = level+1; 
      sequence[k] = level;

      if (level == N)
        print(sequence, N);
      else
        for (int i = 0; i < N; i++)
          if (sequence[i] == 0)
            visit(sequence, N, i);

      level = level-1; 
      sequence[k] = 0;
    }
    
    public static void main(String args[])
    {
        Random random = new Random();
        int N = 4;
        int [] sequence = new int[N];
        for(int i=0; i<N; i++)
            sequence[i] = Math.abs(random.nextInt(100));
       
        System.out.println("The Sequence is: ");
        for(int i=0; i<N; i++)
            System.out.print(sequence[i] + " ");
        
        visit(sequence, N, 0);
    }
}
