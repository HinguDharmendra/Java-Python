package com.hinguapps.java;

public class ExtendedStack {
	private int maxSize;
	private long[] stackArray;
	private long[] minStackArray;
	private int minTop;
	private int top;

	public ExtendedStack(int s) {
		maxSize = s;
		stackArray = new long[maxSize];
		minStackArray = new long[maxSize];
		top = -1;
		minTop = -1;
	}

	public void push(long j) {
		stackArray[++top] = j;
		if (minTop == -1) {
			minStackArray[++minTop] = j;
		} else if (minStackArray[minTop] > j) {
			minStackArray[++minTop] = j;
		}
	}

	public long pop() {
		if (minTop > 0) {
			if (stackArray[top] == minStackArray[minTop]) {
				minTop--;
			}
		}
		return stackArray[top--];
	}

	public long peek() {
		return stackArray[top];
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public boolean isFull() {
		return (top == maxSize - 1);
	}

	public long getMinimum() {
		return minStackArray[minTop--];
	}

	public static void main(String[] args) {
		ExtendedStack extendedStack = new ExtendedStack(10);
		extendedStack.push(50);
		extendedStack.push(10);
		extendedStack.push(23);
		extendedStack.push(30);
		extendedStack.push(41);
		extendedStack.push(5);

		System.out.println("Minimum : " + extendedStack.getMinimum());

		System.out.println("Popped: " + extendedStack.pop());
		System.out.println("Minimum: " + extendedStack.getMinimum());
		System.out.println("Popping All");
		while (!extendedStack.isEmpty()) {
			long value = extendedStack.pop();
			System.out.print(value);
			System.out.print(" ");
		}
		System.out.println("");
	}
}
