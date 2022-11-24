package 실습.리스트;

public class WDB {

	class LinkedList<E> {
		class Node<E> {
			private E data; // 데이터
			private Node<E> next; // 뒤쪽 포인터(다음 노드에 대한 참조)
			
			// 생성자
			Node(E data, Node<E> next) {
				this.data = data;
				this.next = next;
			}
		}
		
		private Node<E> head; // 머리 포인터
		private Node<E> crnt; // 선택 포인터
	}
}
