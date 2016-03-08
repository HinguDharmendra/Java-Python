package com.hinguapps.java;

import java.util.Scanner;

public class LargestCircularArray {
	public static int binarySearch(int[] sequence, int l, int u) {
		if (u < l)
			return -1;
		if (u == l)
			return l;
		int mid = (l + u) / 2;

		if (mid < u && sequence[mid] > sequence[mid + 1])
			return mid;
		if (mid > l && sequence[mid] < sequence[mid - 1])
			return mid - 1;
		if (sequence[l] > sequence[mid])
			return binarySearch(sequence, l, mid - 1);
		else
			return binarySearch(sequence, mid + 1, u);
	}

	public static void main(String[] args) {
		int N = 10;
		Scanner sc = new Scanner(System.in);
		int[] sequence = new int[N];
		for (int i = 0; i < N; i++) {
			sequence[i] = sc.nextInt();
		}
		int index = binarySearch(sequence, 0, N - 1);
		System.out.println("\nLargest element: " + sequence[index]);
		sc.close();
	}
}
