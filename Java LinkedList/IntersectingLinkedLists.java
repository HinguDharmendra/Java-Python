package com.hinguapps.linkedlist;

public class IntersectingLinkedLists {
	public static void main(String[] args) {

		LinkedList l1 = new LinkedList();
		for (int i = 0; i < 5; i++) {
			l1.insert(new Node(i, null));
		}
		System.out.println(l1.getSize());
		l1.traverse();

		LinkedList l2 = new LinkedList();
		for (int i = 10; i < 12; i++) {
			l2.insert(new Node(i, null));
		}
		l2.insert(l1.traverseTillNthNode(4));
		System.out.println(l2.getSize());
		l2.traverse();

		System.out.println(checkIntersecting(l1, l2));
	}

	private static boolean checkIntersecting(LinkedList l1, LinkedList l2) {
		int lengthOfL1 = l1.getSize();
		int lengthOfL2 = l2.getSize();
		Node list1, list2;
		int hopDiff = 0;
		if (lengthOfL1 > lengthOfL2) {
			hopDiff = 2;
			System.out.println(hopDiff);
			list1 = l1.traverseTillNthNode(hopDiff);
			list2 = l2.getStart();

			while (list1.getLink() != list2.getLink()) {
				list1 = list1.getLink();
				list2 = list2.getLink();
			}
			System.out.println("Common List element: "
					+ list2.getLink().getData());

		} else if (lengthOfL1 < lengthOfL2) {
			hopDiff = lengthOfL2 - lengthOfL1;
			list2 = l1.traverseTillNthNode(hopDiff);
			list1 = l1.getStart();
		}

		return false;
	}
}
