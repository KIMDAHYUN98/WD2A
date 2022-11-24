package 실습.리스트;


public class LinkedListTest {
	public static void main(String[] args) {
		LinkedList<String> linkedList = new LinkedList<String>();

		linkedList.addFirst("a");
		linkedList.addFirst("b");
		linkedList.addFirst("c");

		linkedList.dump();
		StringCompareator compare = new StringCompareator();
		String result = linkedList.search("b", compare);
		System.out.println("검색 결과: " + result);

		System.out.println("삽입한 꼬리 노드: ");
		linkedList.addLast("d");
		linkedList.dump();

		System.out.println("삭제 후 머리노드: ");
		linkedList.removeFirst();
		linkedList.dump();

		System.out.println("삭제 후 꼬리노드: ");
		linkedList.removeLast("");
		linkedList.dump();
	}
}
