import java.util.Random;
import java.util.Scanner;

public class N_Password_M_Length 
{
    static void permute(int []a, int k)
    {
        if(k==a.length)
        {
            for(int i=0; i<a.length; i++)
            {
                System.out.print(a[i]);
            }
            System.out.println();	
        }
        else
        {
            for (int i = k; i<a.length; i++) 
            {
                int temp=a[k];
                a[k]=a[i];
                a[i]=temp;
				
                permute(a,k+1);
				
                temp=a[k];
                a[k]=a[i];
                a[i]=temp;
            }
        }	

    }
    public static void main(String args[])
    {
        System.out.println("Enter the length of the password: ");
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        Random random = new Random();
        int []a = new int[m];
        for(int i=0; i<m; i++)
        {
            a[i] = random.nextInt(10);
        }
		
        System.out.println("The Passwords are: ");
        N_Password_M_Length.permute(a, 0);
		
        input.close();
    }
}
