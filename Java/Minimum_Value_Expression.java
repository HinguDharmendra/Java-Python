import java.util.Scanner;

public class Minimum_Value_Expression 
{
	public static void main(String ares[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the degree: ");

		int degree = sc.nextInt();
		System.out.print("Enter "+(degree+1)+" coefficients: ");

		double[] C = new double[degree+1];
		for(int i=0; i<C.length;i++) {
		    C[i]=sc.nextDouble();
		}

		double derivative[] = new double[C.length-1];
		int l = derivative.length;
		for(int j=0; j<degree; j++)
		{
			for(int i=0;i<l;i++)
			{
			    derivative[i] = C[i]*(C.length - 1 -i -j);
			    C[i] = derivative[i];
			    System.out.println(derivative[i]);
			    //if(C.length - 1 -i -j == 1) // max/min value
			    //{
			    	
			    //}
			}
			System.out.println();l--;
		}
		if(derivative[1] > 0)
		{
			System.out.println("Expression has minimum value");
		}
		
		for(int i=0; i<degree; i++)
			System.out.println(derivative[i]);
	}
}
