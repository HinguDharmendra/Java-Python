package com.sanfoundry.combinatorial;

import java.util.Arrays;
import java.util.Scanner;

public class HeapsPermutation
{
    private static void swap(int[] v, int i, int j)
    {
        int t = v[i];
        v[i] = v[j];
        v[j] = t;
    }

    public void permute(int[] v, int n)
    {
        if (n == 1)
        {
            System.out.println(Arrays.toString(v));
        }
        else
        {
            for (int i = 0; i < n; i++)
            {
                permute(v, n - 1);
                if (n % 2 == 1)
                {
                    swap(v, 0, n - 1);
                }
                else
                {
                    swap(v, i, n - 1);
                }
            }
        }
    }

    public static void main(String[] args)
    {
        System.out.println("Enter the number of elements in a sequence: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Enter the sequence: ");
        int sequence[] = new int[n];
        for (int i = 0; i < n; i++)
        {
            sequence[i] = sc.nextInt();
        }
        new HeapsPermutation().permute(sequence, n);
        sc.close();
    }
}
