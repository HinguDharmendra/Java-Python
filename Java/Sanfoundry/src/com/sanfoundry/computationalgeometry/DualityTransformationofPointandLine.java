package com.sanfoundry.computationalgeometry;

import java.util.Scanner;

public class DualityTransformationofPointandLine
{
    public static void performLineTransformation(double a, double b)
    {
        System.out.println("X: " + (b / a) + ", Y: " + (b * -1));
    }

    public static void performPointTransformation(double x, double y)
    {
        System.out.println("y=" + (-1 * y / x) + "x +" + (-1 * y));
    }

    public static void main(String[] args)
    {
        System.out
                .println("Perform what transformation.\n1. Line Transformation\n2. Point Transformation");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        switch (option)
        {
            case 1:
                System.out.println("Enter the coefficients of line <y=ax-b>");
                double a = sc.nextDouble();
                double b = sc.nextDouble();
                performLineTransformation(a, b);
                break;
            case 2:
                System.out.println("Enter the coordinate of point <x, y>");
                double x = sc.nextDouble();
                double y = sc.nextDouble();
                performPointTransformation(x, y);
                break;
            default:
                break;
        }
        sc.close();
    }
}
