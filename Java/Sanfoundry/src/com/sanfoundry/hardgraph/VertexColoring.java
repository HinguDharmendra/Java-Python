package com.sanfoundry.hardgraph;

import java.io.IOException;
import java.util.Scanner;

public class VertexColoring
{
    void colournext(int k, int colour[], int n, int m, int edge[][])
    {
        int flag = 0, j;
        do
        {
            flag = 0;
            colour[k] = (colour[k] + 1) % (m + 1);
            if (colour[k] == 0)
                return;
            for (j = 0; j < n; j++)
            {
                if ((edge[k][j] == 1) && (colour[k] == colour[j]))
                    flag = 1;
            }
        }
        while (flag == 1);
    }

    public static void main(String args[]) throws IOException
    {
        int i, t, j, h, n, m, k, maxclique = 0;
        System.out.println("Enter the no. of vertices in the graph");
        Scanner br = new Scanner(System.in);
        n = br.nextInt();
        VertexColoring g = new VertexColoring();
        int edge[][] = new int[n][n];
        int colour[] = new int[n];
        for (i = 0; i < n; i++)
            colour[i] = 0;
        for (i = 0; i < n; i++)
        {
            for (j = 0; j < n; j++)
                edge[i][j] = 0;
        }
        for (i = 0; i < n; i++)
        {
            t = 0;
            System.out.println("enter number of adjacent nodes from node " + i);
            t = br.nextInt();
            if (t > maxclique)
                maxclique = t;
            System.out.println("enter those adjacent nodes");
            for (j = 0; j < t; j++)
            {
                h = br.nextInt();
                edge[i][h] = 1;
            }
        }
        m = maxclique;
        k = 0;
        do
        {
            g.colournext(k, colour, n, m, edge);
            if (colour[k] == 0)
            {
                k--;
                colour[k] = colour[k + 1] % (m + 1);
            }
            else
                k++;
        }
        while (k < n);
        System.out.println("\tnode\tcolor no.");
        for (i = 0; i < n; i++)
        {
            System.out.println("\t" + i + "\t " + colour[i]);
        }
        br.close();
    }
}
