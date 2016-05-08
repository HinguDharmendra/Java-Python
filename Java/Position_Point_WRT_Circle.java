import java.util.Random;
import java.util.Scanner;

public class Position_Point_WRT_Circle
{
    public static void main(String args[])
    {
        Random random = new Random();
        
        int x1, y1, x2, y2, x3, y3;
        double m1, m2, c1, c2, r;
        
        x1 = random.nextInt(10);
        y1 = random.nextInt(10);
        x2 = random.nextInt(10);
        y2 = random.nextInt(10);
        x3 = random.nextInt(10);
        y3 = random.nextInt(10);
        
        m1 = (y1 - y2) / (x1 - x2);
        m2 = (y3 - y2) / (x3 - x2);
        
        c1 = ((m1 * m2 * (y3 - y1)) + (m1 * (x2 + x3)) - (m2 * (x1 + x2)))
                / (2 * (m1 - m2));
        c2 = ((((x1 + x2) / 2) - c1) / (-1 * m1)) + ((y1 + y2) / 2);
        r = Math.sqrt(((x3 - c1) * (x3 - c1)) + ((y3 - c2) * (y3 - c2)));
        
        System.out.println("The points on the circle are: (" + x1 + ", " + y1
                + "), (" + x2 + ", " + y2 + "), (" + x3 + ", " + y3 + ")");
        System.out.println("The centre of the circle is (" + c1 + ", " + c2
                + ") and radius is " + r);
        
        System.out.println("Enter the point : <x>,<y>");
        Scanner scan = new Scanner(System.in);
        int x, y;
        x = scan.nextInt();
        y = scan.nextInt();
        
        double s = ((x - c1) * (x - c1)) + ((y - c2) * (y - c1)) - (r * r);
        if (s < 0)
            System.out.println("The point lies inside the circle");
        else if (s > 0)
            System.out.println("The point lies outside the circle");
        else
            System.out.println("The point lies on the circle");
        scan.close();
    }
}
