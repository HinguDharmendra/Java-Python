import java.util.Scanner;

public class DFT_Naive_Approach 
{
    double real,  img;
    public DFT_Naive_Approach() 
    {
        this.real = 0.0;
        this.img = 0.0;
    }
    public static void main(String args[])
    {
        int N = 10;
        Scanner sc = new Scanner(System.in);
        System.out.println("Disd=crete Fourier Transform using naive method");
        System.out.println("Enter the coefficient of simple linear funtion:");
        System.out.println("ax + by = c");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        
        double []function = new double[N];
        for(int i=0; i<N; i++)
        {
            function[i] = (((a*(double)i) + (b*(double)i)) - c);
        }
        
        System.out.println("Enter the max K value: ");
        int k = sc.nextInt();
        
        DFT_Naive_Approach []dft_val = new DFT_Naive_Approach[k];
        
        System.out.println("The coefficients are: ");
        for(int j=0; j<k; j++)
        {            
            dft_val[j] = new DFT_Naive_Approach();            
            for(int i=0; i<N; i++)
            {
                dft_val[j].real += function[i] * Math.cos((2 * i * j * Math.PI) / N);;
                dft_val[j].img += function[i] * Math.sin((2 * i * j * Math.PI) / N);;            
            }
            System.out.println("("+dft_val[j].real + ") - " + "("+dft_val[j].img + " i)");
        }
        sc.close();
    }
}
