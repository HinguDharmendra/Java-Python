import java.util.Random;
import java.util.Scanner;

public class Position_Point_WRT_Line
{
    public static void main(String args[])
    {
        Random random = new Random();
        int x1, x2, y1, y2;
        x1 = random.nextInt(10);
        x2 = random.nextInt(10);
        y1 = random.nextInt(10);
        y2 = random.nextInt(10);
        
        System.out.println("The Equation of the line is : (" + (y2 - y1)
                + ")x+(" + (x1 - x2) + ")y+(" + (x2 * y1 - x1 * y2) + ") = 0");
        
        System.out.println("Enter the point : <x>,<y>");
        Scanner scan = new Scanner(System.in);
        int x, y;
        x = scan.nextInt();
        y = scan.nextInt();
        
        int s = (y2 - y1) * x + (x1 - x2) * y + (x2 * y1 - x1 * y2);
        if (s < 0)
            System.out
                    .println("The point lies below the line or left side of the line");
        else if (s > 0)
            System.out
                    .println("The point lies above the line or right side of the line");
        else
            System.out.println("The point lies on the line");
        scan.close();
    }
}
