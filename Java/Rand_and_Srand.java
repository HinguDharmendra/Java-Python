import java.util.Random;
import java.util.UUID;


public class Rand_and_Srand 
{
    public static void main(String args[])
    {
        System.out.println("The numbers using rand");
        for(int i=0; i<5; i++)
        {
            Random rand = new Random();
            System.out.println(Math.abs(rand.nextInt()));
        }
        
        System.out.println("The numbers using srand");
        for(int i=0; i<5; i++)
        {
            System.out.println(Math.abs(UUID.randomUUID().getMostSignificantBits()));
        }
    }
}
