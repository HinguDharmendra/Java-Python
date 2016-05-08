import java.util.Random;
import java.util.Scanner;

public class Linear_Search_Nearest
{
    public static void main(String args[])
    {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        int datasetSize = 10;
        double[][] data = new double[10][2];
        
        for (int i = 0; i < datasetSize; i++)
            for (int j = 0; j < 2; j++)
                data[i][j] = random.nextDouble() * 10;
        
        System.out.println("Randomly generated Data set: ");
        for (int i = 0; i < datasetSize; i++)
            for (int j = 0; j < 2; j++)
                System.out.println(data[i][j++] + " ," + data[i][j]);
        
        System.out.println();
        System.out.println("Enter the co-ordinates of the point: <x> <y>");
        double x = sc.nextDouble();
        double y = sc.nextDouble();
        
        double xmin = data[0][0], ymin = data[0][1], xclose = 0, yclose = 0;
        for (int i = 0; i < datasetSize; i++)
        {
            if (Math.abs(data[i][0] - x) < xmin)
            {
                xmin = data[i][0] - x;
                xclose = data[i][0];
            }
        }
        
        for (int i = 0; i < datasetSize; i++)
        {
            if (Math.abs(data[i][1] - y) < ymin)
            {
                ymin = data[i][1] - x;
                yclose = data[i][1];
            }
        }
        
        System.out.println("The nearest neighbor is : (" + xclose + ", "
                + yclose + ")");
        
        sc.close();
    }
}
