import java.util.Scanner;

public class RCM_Algorithm 
{
	public static void main(String args[])
	{
		System.out.println("Enter the dimension of the matrix:");
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		double [][]mat = new double[n][n];
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
				mat[i][j] = input.nextDouble();
		
		
		input.close();
	}
}
