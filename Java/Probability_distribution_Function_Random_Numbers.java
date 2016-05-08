import java.util.Random;

public class Probability_distribution_Function_Random_Numbers 
{
    static int N = 10;
    public static void main(String args[])
    {
        Random random = new Random();
        int p=0;
        for(int i=0; i<N; i++)
        {
            p = random.nextInt(400);
            if(p > 360)
                System.out.println(1 + " ");
            else if(p < 0)
                System.out.println(0 + " ");
            else
                System.out.println(p*0.1/360 + " ");
        }			
    }
}
