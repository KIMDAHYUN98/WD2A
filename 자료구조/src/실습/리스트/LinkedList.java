package 실습.리스트;

import java.util.Comparator;

class Node<E> {
	E data;
	Node<E> next;

	public Node(E data, Node<E> next) {
		this.data = data;
		this.next = next;
	}
}

class LinkedList<E> {
	Node<E> head;
	Node<E> current;

	public LinkedList() {
		head = current = null;
	}

	public void addFirst(E obj) {
		Node<E> ptrNew = new Node<E>(obj, null);
		ptrNew.next = head;

		head = ptrNew;
	}

	public void dump() {
		current = head;
		while (current != null) {
			System.out.println("현재 데이터: " + current.data);
			current = current.next;
		}
	}

	public E search(E obj, Comparator<? super E> c) {
		current = head;
		while (current != null) {
			if (c.compare(obj, current.data) == 0) {
				return current.data;
			}
			current = current.next;
		}
		return null;
	}

	public void addLast(E obj) {
		if (head == null)
			addFirst(obj);
		else {
			Node<E> ptr = head;
			while (ptr.next != null)
				ptr = ptr.next;
			ptr.next = current = new Node<E>(obj, null);
		}
	}

	public void removeFirst() {
		if (head != null)
			head = current = head.next;
	}

	public void removeLast(E obj) {
		if (head != null) {
			if (head.next == null)
				removeFirst();
			else {
				Node<E> ptr = head;
				Node<E> pre = head;

				while (ptr.next != null) {
					pre = ptr;
					ptr = ptr.next;
				}
				pre.next = null;
				current = pre;
			}
		}
	}
}

class StringCompareator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		int result = o1.compareTo(o2);
		return result;
	}

}
