import java.util.Scanner;

public class Schonhage_Strassen_Algorithm 
{
    public static int noOfDigit(long a)
    {
        int n=0;
        while(a>0)
        {
            a /= 10; 
            n++;
        }
        return n;
    }
    public static void schonhageStrassenMultiplication(long x, long y, int n, int m)
    {
        
        int []linearConvolution = new int[n+m-1];
        for(int i=0; i<(n+m-1); i++)
            linearConvolution[i] = 0;
        
        long p=x;
        for(int i=0; i<m; i++)
        {
            x = p;
            for(int j=0; j<n; j++)
            {
                linearConvolution[i+j] += (y%10) * (x%10);
                x /= 10;
            }
            y /= 10;
        }
        System.out.print("The Linear Convolution is: ( ");
        for(int i=(n+m-2); i>=0; i--)
        {
            System.out.print(linearConvolution[i] +" ");
        }
        System.out.println(")");
               
        long product = 0;
        int nextCarry=0, base=1;;
        for(int i=0; i<n+m-1; i++)
        {
            linearConvolution[i] += nextCarry;
            product = product + (base * (linearConvolution[i]%10));
            nextCarry = linearConvolution[i]/10;
            base *= 10;
        }
        System.out.println("The Product of the numbers is: " + product);

    }
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the numbers:");
        long a = input.nextLong();
        long b = input.nextLong();
        int n = noOfDigit(a);
        int m = noOfDigit(b);
        schonhageStrassenMultiplication(a, b, n, m);
        
        input.close();
    }
}
