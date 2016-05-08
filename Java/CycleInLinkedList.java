package com.hinguapps.linkedlist;

public class CycleInLinkedList {
	public static void main(String[] args) {
		LinkedList l1 = new LinkedList();
		for (int i = 0; i < 5; i++) {
			l1.insert(new Node(i, null));
		}
		LinkedList l2 = new LinkedList();
		for (int i = 0; i < 5; i++) {
			l2.insert(new Node(i, null));
		}
		l2.setEnd(l2.getStart());

		l2.traverse();

	}
}
