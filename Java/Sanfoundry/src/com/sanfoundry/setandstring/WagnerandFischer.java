package com.sanfoundry.setandstring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WagnerandFischer
{
    public int getLevenshteinDistance(String str1, String str2)
    {
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] arr = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++)
            arr[i][0] = i;
        for (int i = 1; i <= len2; i++)
            arr[0][i] = i;
        for (int i = 1; i <= len1; i++)
        {
            for (int j = 1; j <= len2; j++)
            {
                int m = (str1.charAt(i - 1) == str2.charAt(j - 1)) ? 0 : 1;
                arr[i][j] = Math.min(
                        Math.min(arr[i - 1][j] + 1, arr[i][j - 1] + 1),
                        arr[i - 1][j - 1] + m);
            }
        }
        return arr[len1][len2];
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter string 1 :");
        String str1 = br.readLine();
        System.out.println("Enter string 2 :");
        String str2 = br.readLine();
        WagnerandFischer wf = new WagnerandFischer();
        int lDist = wf.getLevenshteinDistance(str1, str2);
        System.out.println("Edit (Levenshtein) Distance between two strings = "
                + lDist);
        br.close();
    }
}
