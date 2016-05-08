import java.util.Scanner;

public class DFT_Coefficient 
{
    double real,  img;
    public DFT_Coefficient() 
    {
        this.real = 0.0;
        this.img = 0.0;
    }
    public static void main(String args[])
    {
        int N = 10;
        Scanner sc = new Scanner(System.in);
        System.out.println("Calculation DFT Coefficients");
        System.out.println("Enter the coefficient of simple linear funtion:");
        System.out.println("ax + by = c");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
		
        double []function = new double[N];
        for(int i=0; i<N; i++)
        {
            function[i] = (((a*(double)i) + (b*(double)i)) - c);
			//System.out.print( "  "+function[i] + "  ");
        }
		
        System.out.println("Enter the max K value: ");
        int k = sc.nextInt();
		
        double []cos = new double[N];
        double []sin = new double[N];
		
        for(int i=0; i<N; i++)
        {
            cos[i] = Math.cos((2 * i * k * Math.PI) / N);
            sin[i] = Math.sin((2 * i * k * Math.PI) / N);
        }
		
        DFT_Coefficient dft_val = new DFT_Coefficient();
        System.out.println("The coefficients are: ");
		
        for(int i=0; i<N; i++)
        {
            dft_val.real += function[i] * cos[i];
            dft_val.img += function[i] * sin[i];	
        }
        System.out.println("("+dft_val.real + ") - " + "("+dft_val.img + " i)");
        sc.close();
    }
}
