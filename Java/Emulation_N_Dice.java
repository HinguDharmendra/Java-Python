
import java.util.Random;
import java.util.Scanner;


public class Emulation_N_Dice 
{
    public static void main(String args[])
    {
        System.out.println("Enter the number of dice: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Random rand = new Random();
        do 
        {
            System.out.println("THe values on dice are: ");
        	for(int i=0; i<n; i++)
                System.out.println(rand.nextInt(6)+1);
            
            System.out.println("Continue: true/false");
        } while (sc.nextBoolean() == true);
        sc.close();
    }
}
