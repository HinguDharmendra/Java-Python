import java.util.Random;
import java.util.Scanner;


public class Randomized_Sequence_Random_Numbers
{
    public static void main(String args[])
    {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the starting and ending of the sequence: ");
        int start = sc.nextInt();
        int end = sc.nextInt();
		
        for(int i=0; i<15; i++)
        {
            System.out.print(rand.nextInt(end-start+1)+start + ", ");
        }
        System.out.print("...");
        sc.close();
    }
}
