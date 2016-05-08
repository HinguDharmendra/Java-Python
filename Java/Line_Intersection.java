import java.util.Random;

public class Line_Intersection
{
    public static void main(String args[])
    {
        Random random = new Random();
        
        int x1, x2, y1, y2;
        x1 = random.nextInt(10);
        x2 = random.nextInt(10);
        y1 = random.nextInt(10);
        y2 = random.nextInt(10);
        
        System.out.println("The Equation of the 1st line is : (" + (y2 - y1)
                + ")x+(" + (x1 - x2) + ")y+(" + (x2 * y1 - x1 * y2) + ") = 0");
        
        int p1, p2, q1, q2;
        p1 = random.nextInt(10);
        p2 = random.nextInt(10);
        q1 = random.nextInt(10);
        q2 = random.nextInt(10);
        
        System.out.println("The Equation of the 2nd line is : (" + (q2 - q1)
                + ")x+(" + (p1 - p2) + ")y+(" + (p2 * q1 - p1 * q2) + ") = 0");
        
        int s1 = (y2 - y1) * p1 + (x1 - x2) * q1 + (x2 * y1 - x1 * y2);
        if (s1 < 0)
        {
            int s2 = (y2 - y1) * p2 + (x1 - x2) * q2 + (x2 * y1 - x1 * y2);
            if (s2 >= 0)
                System.out.println("The lines intersect");
            else if (s2 < 0)
                System.out.println("The lines doesn't intersect");
            
        }
        else if (s1 > 0)
        {
            int s2 = (y2 - y1) * p2 + (x1 - x2) * q2 + (x2 * y1 - x1 * y2);
            if (s2 <= 0)
                System.out.println("The lines intersect");
            else if (s2 > 0)
                System.out.println("The lines doesn't intersect");
        }
        else
            System.out.println("The point lies on the line");
    }
}
