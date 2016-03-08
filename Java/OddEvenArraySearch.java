package com.hinguapps.java;

public class OddEvenArraySearch {

	public int oddEvenSearch(int[] sequence, int key) {
		int start = 0;
		int end = sequence.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;

			if (key == sequence[mid]) {
				return mid;
			} else if (mid + 1 <= end && key == sequence[mid + 1]) {
				return mid + 1;
			} else if (mid - 1 >= start && key == sequence[mid - 1]) {
				return mid - 1;
			}

			if (key < sequence[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}

		}
		return -1;
	}

	public static void main(String[] args) {
		OddEvenArraySearch mbs = new OddEvenArraySearch();
		int[] arr = { 2, 1, 10, 3, 100, 201, 204, 203, 208, 205 };
		for (int i = 0; i < arr.length; i++) {
			System.out.println("Key " + arr[i] + " is at position: "
					+ mbs.oddEvenSearch(arr, arr[i]));
		}
		System.out.println();
		System.out.println("Key " + 2736 + " is at position: "
				+ mbs.oddEvenSearch(arr, 2736));

	}

}
