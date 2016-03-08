package com.hinguapps.linkedlist;

public class Node {
	private int data;
	private Node link;

	Node() {
		data = 0;
		link = null;
	}

	Node(int data, Node next) {
		this.data = data;
		this.link = next;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getLink() {
		return link;
	}

	public void setLink(Node link) {
		this.link = link;
	}

}
