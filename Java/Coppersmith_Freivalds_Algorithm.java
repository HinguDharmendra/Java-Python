import java.util.Random;
import java.util.Scanner;

public class Coppersmith_Freivalds_Algorithm 
{
    public static void main(String args[])
    {
        System.out.println("Enter the dimesion of the matrices: ");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println("Enter the 1st matrix: ");
        double a[][] = new double[n][n];
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                a[i][j] = input.nextDouble();
            }
        }
		
        System.out.println("Enter the 2st matrix: ");
        double b[][] = new double[n][n];
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                b[i][j] = input.nextDouble();
            }
        }
		
        System.out.println("Enter the result matrix: ");
        double c[][] = new double[n][n];
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                c[i][j] = input.nextDouble();
            }
        }
		
		//random generation of the r vector containing only 0/1 as its elements
        double [][]r = new double[n][1];
        Random random = new Random();
        for(int i=0; i<n; i++)
        {
            r[i][0] = random.nextInt(2);
        }
		
		//test A * (b*r) - (C*) = 0
        double br[][] = new double[n][1];
        double cr[][] = new double[n][1];
        double abr[][] = new double[n][1];
        br = multiplyVector(b, r, n);
        cr = multiplyVector(c, r, n);
        abr = multiplyVector(a, br, n);
        
        //check for all zeros in abr
        boolean falg = true; 
        for(int i=0; i<n; i++)
        {
            if(abr[i][0] == 0)
                continue;
            else
                falg = false;
        }
        if(falg == true)
            System.out.println("Yes");
        else
            System.out.println("No");
        
        input.close();
    }
	
    public static double[][] multiplyVector(double[][] a, double[][] b, int n)
    {
        double result[][] = new double[n][1];
        for (int i = 0; i < n; i++) 
        {
            for (int j = 0; j < 1; j++) 
            {
                for (int k = 0; k < n; k++)
                {	 
                    result[i][j] = result[i][j] + a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }
}
