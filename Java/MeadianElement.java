package com.hinguapps.java;

import java.util.Random;
import java.util.Scanner;

public class MeadianElement {
	public static int medianElement(int arr[], int l, int r, int k) {
		if (k > 0 && k <= r - l + 1) {
			int pos = partition(arr, l, r);

			if (pos - l == k - 1)
				return arr[pos];
			if (pos - l > k - 1)
				return medianElement(arr, l, pos - 1, k);

			return medianElement(arr, pos + 1, r, k - pos + l - 1);
		}
		return Integer.MIN_VALUE;
	}

	public static int partition(int arr[], int l, int r) {
		int x = arr[r], i = l, temp;
		for (int j = l; j <= r - 1; j++) {
			if (arr[j] <= x) {
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
			}
		}
		temp = arr[i];
		arr[i] = arr[r];
		arr[r] = temp;
		return i;
	}

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		int n = 9;
		int[] arr = new int[n];
		System.out.print("The random sequence is: ");
		for (int i = 0; i < n; i++) {
			arr[i] = rand.nextInt(100);
			System.out.print(arr[i] + " ");
		}

		System.err.println("The median element is: "
				+ medianElement(arr, 0, n - 1, (n + 1) / 2));

		sc.close();
	}
}
