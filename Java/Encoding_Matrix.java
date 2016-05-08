import java.util.Scanner;

public class Encoding_Matrix 
{
    public static void main(String args[])
    {
        int n;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the base of squared matrices");
        n = input.nextInt();
        int [][] a = new int[n][n];
        int [][] b = new int[n][n];
        int [][] c = new int[n][n];
        System.out.println("Enter the elements of matrix to be encoded: ");
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                a[i][j] = input.nextInt();
		
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                b[i][j] = i+j;
		
        for (int i = 0; i < n; i++) 
        {
            for (int j = 0; j < n; j++) 
            {
                for (int k = 0; k < n; k++)
                {	 
                    c[i][j] = c[i][j] + a[i][k] * b[k][j];
                }
            }
        }

        System.out.println("The Encoded matrix is:");
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
        input.close();
    }
}