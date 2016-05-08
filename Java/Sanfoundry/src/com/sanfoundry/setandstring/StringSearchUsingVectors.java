package com.sanfoundry.setandstring;

import java.util.Scanner;
import java.util.Vector;

public class StringSearchUsingVectors
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the main string: ");
        Vector<String> text = new Vector<String>();
        text.add(sc.nextLine());
        System.out.println("Enter the pattern string: ");
        Vector<String> pattern = new Vector<String>();
        pattern.add(sc.nextLine());
        for (int i = 0; i <= text.elementAt(0).length()
                - pattern.elementAt(0).length(); i++)
        {
            if (text.elementAt(0)
                    .substring(i, i + pattern.elementAt(0).length())
                    .equalsIgnoreCase(pattern.elementAt(0)))
            {
                System.out.println(pattern.elementAt(0)
                        + " is substring of main string, match found at: "
                        + ++i);
            }
        }
        sc.close();
    }
}
