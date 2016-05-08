package com.sanfoundry.combinatorial;

import java.util.Scanner;

public class AlexanderBogomolnyPermutation
{
    static int level = -1;

    public static void print(int[] value, int n)
    {
        if (value.length != 0)
        {
            for (int i = 0; i < value.length; i++)
            {
                System.out.print(value[i] + " ");
            }
            System.out.println();
        }
    }

    public static void visit(int[] Value, int N, int k)
    {
        level = level + 1;
        Value[k] = level;
        if (level == N)
            print(Value, N);
        else
            for (int i = 0; i < N; i++)
                if (Value[i] == 0)
                    visit(Value, N, i);
        level = level - 1;
        Value[k] = 0;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the sequence:");
        int n = sc.nextInt();
        int sequence[] = new int[n];
        for (int i = 0; i < n; i++)
        {
            sequence[i] = 0;
        }
        System.out.println("The permutations are: ");
        visit(sequence, n, 0);
        sc.close();
    }
}
