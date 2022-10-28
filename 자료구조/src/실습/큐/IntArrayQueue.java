package 실습.큐;

public class IntArrayQueue {
	private int[] que; // 큐 본체
	private int capacity; // 큐의 용량
	private int num; // 현재 데이터 개수
	
	// 생성자
	public IntArrayQueue(int maxlen) {
		num = 0;
		capacity = maxlen;
		
		try {
			que = new int[capacity];
		} catch (OutOfMemoryError e) {
			capacity = 0;
		}
	}
	
	// 실행시 예외: 큐가 비어있음 
		public class EmptyIntArrayQueueException extends RuntimeException {
			public EmptyIntArrayQueueException() {
			}
		}
	
	// 실행시 예외: 큐가 비어있음 
		public class OverflowIntArrayQueueException extends RuntimeException {
			public OverflowIntArrayQueueException() {
			}
		}
	
	// 큐에 데이터를 인큐
	public int enque(int x) throws OverflowIntArrayQueueException {
		if(num >= capacity)                            // 데이터 갯수가 넘칠 때
			throw new OverflowIntArrayQueueException();
		que[num++] = x;
		return x;
	}
	// 큐에 데이터를 디큐
	public int deque() throws EmptyIntArrayQueueException {
		if (num <= 0)                                  // 데이터가 없을 때
			throw new EmptyIntArrayQueueException();   // 예외 처리 발생
		
		int x = que[0]; 					           // que 첫번째 배열에 뺴내는 값을 변수 x에 담는다. => 디큐
		for(int i = 0; i < num - 1; i++) 	           // 데이터 갯수가 1씩 감소하므로 num - 1 만큼 반복해서
			que[i] = que[i + 1];			           // 각각 큐의 이전 위치에다가 다음 위치의 값을 담는다.
		num--; 								           // 총 데이터 갯수를 1만큼 줄인다.
		return x;
	}
}
