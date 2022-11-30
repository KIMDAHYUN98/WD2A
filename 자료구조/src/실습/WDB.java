package 실습;

import java.util.Comparator;
import java.util.Scanner;

class Student {
	private int hakbun;
	private String name;
	private String mobile;

	public Student(int hakbun, String name, String mobile) {
		this.hakbun = hakbun;
		this.name = name;
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return this.hakbun + " " + this.name + " " + this.mobile;
	}

	public String toHakbun() {
		return Integer.toString(this.hakbun);
	}

	public String toName() {
		return this.name;
	}

	public String toMobile() {
		return this.mobile;
	}
}

class LinkedList<E> {
	class Node<E> {
		private E data;
		private Node<E> next;

		public Node(int hakbun, String name, String mobile, Node<E> next) {
			this.data = (E) new Student(hakbun, name, mobile);
			this.next = next;
		}
	}

	private Node<E> head;
	private Node<E> current;

	public LinkedList() {
		head = current = null;
	}

	public void addFirst(int hakbun, String name, String mobile) {
		Node<E> ptrNew = new Node<E>(hakbun, name, mobile, null);
		ptrNew.next = head;
		head = ptrNew;
	}

	public void dump() {
		current = head;
		while (current != null) {
			System.out.println(current.data.toString());
			current = current.next;
		}
	}

	public E search(int num, E obj, Comparator<? super E> c) {
		Node<E> current = head;
		while (current != null) {
			if (num == 1) {
				if (c.compare(obj, (E) ((Student) current.data).toHakbun()) == 0) {
					return (E) current.data.toString();
				}
			} else if (num == 2) {
				if (c.compare(obj, (E) ((Student) current.data).toName()) == 0) {
					return (E) current.data.toString();
				}
			} else {
				if (c.compare(obj, (E) ((Student) current.data).toMobile()) == 0) {
					return (E) current.data.toString();
				}
			}
			current = current.next;
		}
		return null;
	}

	public void addLast(int hakbun, String name, String mobile) {
		if (head == null)
			addFirst(hakbun, name, mobile);
		else {
			Node<E> current = head;
			while (current.next != null)
				current = current.next;
			current.next = current = new Node<E>(hakbun, name, mobile, null);
		}
	}
}

class hakbunComparator implements Comparator<String> {
	@Override
	public int compare(String o1, String o2) {
		int result = o1.compareTo(o2);
		return result;
	}
}
	
class nameComparator implements Comparator<String> {
	@Override
	public int compare(String o1, String o2) {
		int result = o1.compareTo(o2);
		return result;
	}
}

class mobileComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		int result = o1.compareTo(o2);
		return result;
	}
}

public class WDB {
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		Scanner scan = new Scanner(System.in);
		hakbunComparator hc = new hakbunComparator();
		nameComparator nc = new nameComparator();
		mobileComparator mc = new mobileComparator();
		list.addLast(1, "김다현", "010-3390-9817");
		list.addLast(2, "이미금", "010-3549-4896");
		list.addFirst(3, "김준근", "010-9020-9062");
		list.dump();

		int n1 = 0;
		String n2 = "";
		while (true) {
			System.out.println("검색하고 싶은 항목의 숫자을 선택하시오.");
			System.out.println("1. 학번");
			System.out.println("2. 이름");
			System.out.println("3. 전화번호검색");
			System.out.println();
			n1 = scan.nextInt();
			if (n1 >= 1 && n1 <= 3)
				break;
		}
		while (true) {
			System.out.print("탐색 값 : ");
			n2 = scan.next();
			break;
		}
		String result;
		if (n1 == 1) {
			result = list.search(n1, n2, hc);
		} else if (n1 == 2) {
			result = list.search(n1, n2, nc);
		} else {
			result = list.search(n1, n2, mc);
		}
		System.out.println(result);
	}
}
