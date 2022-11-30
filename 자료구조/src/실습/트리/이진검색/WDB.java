package 실습.트리.이진검색;

import java.util.Comparator;

class Node<K, V> {
	K key;
	V data;
	
	Node<K, V> left;
	Node<K, V> right;
	

	
	Node(K key, V data, Node<K, V> left, Node<K, V> right) {
		this.key = key;
		this.data = data;
		this.left = left;
		this.right = right;
	}

	K getKey() {
		return key;
	}
	
	V getData() {
		return data;
	}
	
	void print() {
		System.out.println(data);
	}
}

class BinTree<K, V> {
	private Node<K, V> root;
	
	private Comparator<? super K> comparator = null;
	
	public BinTree() {
		root = null;
	}
	
	public BinTree(Comparator<? super K> c) {
		this();
		this.comparator = c;
	}
	
	
	// 두 키 값을 비교
	public int comp(K key1, K key2) {
		return (comparator == null) ?
				((Comparable<K>) key1).compareTo(key2) :
					comparator.compare(key1, key2);
	}
	
	// 키 값으로 검색하는 메서드 search
	public V search(K key) { // 키 값을 받아서 데이터를 반환
		Node<K, V> p;
		p = this.root; // root로 초기화
		
		while(true) {
			if(p == null)
				return null;
			int cond = this.comp(key, p.getKey());
			if(cond == 0)
				return p.getData();
			else if (cond < 0)
				p = p.left; // 왼쪽 서브트리에서 검색해 p에 그 값을 담는다
			else
				p = p.right;
		}
		
	}
	
	// 노드를 생성하여 서브트리에 삽입
	public void addNode(Node<K, V> node, K key, V data) {
		int cond = this.comp(key, node.getKey());
		if (cond == 0)
			return;
		else if(cond < 0) {
			if(node.left == null)
				node.left= new Node<K, V>(key, data, null, null);
			else 
				addNode(node.left, key, data);
		} else { // 삽입할 값이 클 경우
			if(node.right == null)
				node.right = new Node<K, V>(key, data, null, null);
			else
				addNode(node.right, key, data);
		}
	}
	
	// 노드 삽입
	void add(K key, V data) {
		if(root == null)
			root = new Node<K, V>(key, data, null, null);
		else
			addNode(root, key, data);
	}
}

public class WDB {
	public static void main(String[] args) {
		BinTree<Integer, String> tree = new BinTree<Integer, String>();
		tree.add(1, "홍길동1");
		tree.add(2, "홍길동2");
		tree.add(3, "홍길동3");
		tree.add(4, "홍길동4");
		tree.add(5, "홍길동5");
		
		String result = tree.search(2);
		System.out.println(result);
		
	}

}
