import java.util.*;

class Area_polygon_Slicker
{
    static final int MAXPOLY = 200;
    static final double EPSILON = 0.000001;
    
    static class Point
    {
        double x, y;
    }
    
    static class Polygon
    {
        Point p[] = new Point[MAXPOLY];
        int n;
        
        Polygon()
        {
            for (int i = 0; i < MAXPOLY; i++)
                p[i] = new Point();
        }
    }
    
    static double area(Polygon p)
    {
        double total = 0;
        for (int i = 0; i < p.n; i++)
        {
            int j = (i + 1) % p.n;
            total += (p.p[i].x * p.p[j].y) - (p.p[j].x * p.p[i].y);
        }
        return total / 2;
    }
    
    static public void main(String[] args)
    {
        Polygon p = new Polygon();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of points in Polygon: ");
        p.n = sc.nextInt();
        System.out.println("Enter the coordinates of each point: <x> <y>");
        for (int i = 0; i < p.n; i++)
        {
            p.p[i].x = sc.nextDouble();
            p.p[i].y = sc.nextDouble();
        }
        
        double area = area(p);
        if (area > 0)
            System.out.print("The Area of Polygon with " + p.n
                    + " points using Slicker Algorithm is : " + area(p));
        else
            System.out.print("The Area of Polygon with " + p.n
                    + " points using Slicker Algorithm is : " + (area(p) * -1));
        sc.close();
    }
}