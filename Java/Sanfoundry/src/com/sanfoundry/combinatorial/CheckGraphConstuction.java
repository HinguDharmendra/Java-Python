package com.sanfoundry.combinatorial;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CheckGraphConstuction
{
    public static Integer sum(List<Integer> list)
    {
        Integer sum = 0;
        for (Integer integer : list)
        {
            sum += integer;
        }
        return sum;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices: ");
        Integer n = sc.nextInt();
        System.out
                .println("Enter the Degree Sequence: <Degree sequence is always in non-increasing order>");
        List<Integer> sequence = new ArrayList<Integer>();
        while (n > 0)
        {
            sequence.add(sc.nextInt());
            n--;
        }
        System.out.println(sequence.toString());
        if (sum(sequence) % 2 == 0)
        {
            System.out
                    .println("Graph can be constructed using the given sequence G=("
                            + sequence.size()
                            + ", "
                            + (sum(sequence) / 2)
                            + ").");
        }
        sc.close();
    }
}
