package com.hinguapps.linkedlist;

public class LinkedList {
	private Node start, end;
	private int size;

	public LinkedList() {
		start = null;
		end = null;
		size = 0;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int p) {
		size = p;
	}

	public void insert(Node nptr) {
		if (start == null) {
			start = nptr;
			end = nptr;
		} else {
			end.setLink(nptr);
			end = nptr;
		}
		size++;
	}

	public Node getEnd() {
		return end;
	}

	public void setEnd(Node end) {
		this.end = end;
	}

	public void setStart(Node start) {
		this.start = start;
	}

	public void traverse() {
		Node next = start;
		if (next != null) {
			do {
				System.out.print(next.getData() + " ");
				next = next.getLink();
				size++;
			} while (next.getLink() != null);
			System.out.println(next.getData());
			size++;
		} else {
			System.out.println("No element found");
		}
	}

	public Node traverseTillNthNode(int n) {
		Node next = start;

		if (next != null) {
			if (next.getLink() == null)
				return next;
			else {
				while (next.getLink() != null && --n >= 0) {
					next = next.getLink();
				}
				return next;
			}
		} else {
			System.out.println("No element found");
		}
		return next;
	}

	public Node getStart() {
		return start;
	}
}
