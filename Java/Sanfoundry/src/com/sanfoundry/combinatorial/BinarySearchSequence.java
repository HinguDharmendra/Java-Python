package com.sanfoundry.combinatorial;

import java.util.Random;
import java.util.Scanner;

public class BinarySearchSequence
{
    public static void searchSequence(int[] array, int[] search)
    {
        int first, last, middle;
        first = 0;
        last = array.length - 1;
        boolean flag = true;
        for (int i = 0; i < search.length; i++)
        {
            middle = (first + last) / 2;
            while (first <= last && flag == true)
            {
                if (array[middle] < search[i])
                {
                    first = middle + 1;
                }
                else if (array[middle] == search[i])
                {
                    System.out.println(search[i] + " found at location "
                            + (middle + 1) + ".");
                    first = 0;
                    last = array.length - 1;
                    break;
                }
                else
                {
                    last = middle - 1;
                }
                middle = (first + last) / 2;
            }
            if (first > last)
            {
                System.out
                        .println(search[i] + " is not present in the list.");
                flag = false;
            }
        }
    }

    public static void main(String args[])
    {
        int c, n, search[], array[];
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        n = in.nextInt();
        array = new int[n];
        Random rand = new Random();
        for (c = 0; c < n; c++)
        {
            array[c] = rand.nextInt(100);
        }
        System.out.println("Elements: ");
        for (int i = 0; i < array.length; i++)
        {
            System.out.print(array[i] + " ");
        }
        System.out.println("\nEnter length of sequence to find: ");
        int m = in.nextInt();
        search = new int[m];
        System.out.println("Enter the sequence to find: ");
        for (int i = 0; i < m; i++)
        {
            search[i] = in.nextInt();
        }
        searchSequence(array, search);
        in.close();
    }
}
