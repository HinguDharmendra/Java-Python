package com.sanfoundry.setandstring;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class LongestCommonSubsequencetoSequences
{
    public static String lcs(String[] strings)
    {
        if (strings.length == 0)
            return "";
        if (strings.length == 1)
            return strings[0];
        int max = -1;
        int cacheSize = 1;
        for (int i = 0; i < strings.length; i++)
        {
            cacheSize *= strings[i].length();
            if (strings[i].length() > max)
                max = strings[i].length();
        }
        String[] cache = new String[cacheSize];
        int[] indexes = new int[strings.length];
        for (int i = 0; i < indexes.length; i++)
            indexes[i] = strings[i].length() - 1;
        return lcsBack(strings, indexes, cache);
    }

    public static String lcsBack(String[] strings, int[] indexes, String[] cache)
    {
        for (int i = 0; i < indexes.length; i++)
            if (indexes[i] == -1)
                return "";
        boolean match = true;
        for (int i = 1; i < indexes.length; i++)
        {
            if (strings[0].charAt(indexes[0]) != strings[i].charAt(indexes[i]))
            {
                match = false;
                break;
            }
        }
        if (match)
        {
            int[] newIndexes = new int[indexes.length];
            for (int i = 0; i < indexes.length; i++)
                newIndexes[i] = indexes[i] - 1;
            String result = lcsBack(strings, newIndexes, cache)
                    + strings[0].charAt(indexes[0]);
            cache[calcCachePos(indexes, strings)] = result;
            return result;
        }
        else
        {
            String[] subStrings = new String[strings.length];
            for (int i = 0; i < strings.length; i++)
            {
                if (indexes[i] <= 0)
                    subStrings[i] = "";
                else
                {
                    int[] newIndexes = new int[indexes.length];
                    for (int j = 0; j < indexes.length; j++)
                        newIndexes[j] = indexes[j];
                    newIndexes[i]--;
                    int cachePos = calcCachePos(newIndexes, strings);
                    if (cache[cachePos] == null)
                        subStrings[i] = lcsBack(strings, newIndexes, cache);
                    else
                        subStrings[i] = cache[cachePos];
                }
            }
            String longestString = "";
            int longestlength = 0;
            for (int i = 0; i < subStrings.length; i++)
            {
                if (subStrings[i].length() > longestlength)
                {
                    longestString = subStrings[i];
                    longestlength = longestString.length();
                }
            }
            cache[calcCachePos(indexes, strings)] = longestString;
            return longestString;
        }
    }

    public static int calcCachePos(int[] indexes, String[] strings)
    {
        int factor = 1;
        int pos = 0;
        for (int i = 0; i < indexes.length; i++)
        {
            pos += indexes[i] * factor;
            factor *= strings[i].length();
        }
        return pos;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Longest Common Subsequence Algorithm Test");
        System.out.println("Enter string 1");
        String str1 = br.readLine();
        System.out.println("Enter string 2");
        String str2 = br.readLine();
        System.out.println("Enter string 3");
        String str3 = br.readLine();
        System.out.println("Enter string 4");
        String str4 = br.readLine();
        String[] str = new String[] { str1, str2, str3, str4 };
        System.out.println(lcs(str));
    }
}
