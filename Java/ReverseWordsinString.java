package com.hinguapps.java;

import java.util.Scanner;

public class ReverseWordsinString {
	public static String reverse(String tempInput) {
		int length = tempInput.length();
		char[] reverse = new char[length];
		for (int i = 0; i < length; i++) {
			reverse[i] = tempInput.charAt(length - 1 - i);
		}
		return new String(reverse);
	}

	public static String reverseWords(String tempInput) {
		String reverseInput = reverse(tempInput);
		String[] wordSet = reverseInput.split(" ");
		String output = "";
		for (String word : wordSet) {
			output += reverse(word) + " ";
		}
		return output.substring(0, output.length() - 1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		System.out.println(reverseWords(input));
		sc.close();
	}

}
