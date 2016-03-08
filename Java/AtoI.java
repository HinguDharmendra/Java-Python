package com.hinguapps.java;

import java.util.Scanner;

public class AtoI {
	public static int MyAtoI(String stringInt) {
		int negative = 1;
		int i = 0;
		int integerValue = 0;
		if (stringInt.charAt(0) == '-') {
			negative = -1;
			i = 1;
		}

		for (; i < stringInt.length(); i++) {
			integerValue = integerValue * 10
					+ Integer.parseInt("" + stringInt.charAt(i));
		}

		return integerValue * negative;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the string integer: ");
		System.out.println(MyAtoI(sc.nextLine()));
		sc.close();
	}

}
