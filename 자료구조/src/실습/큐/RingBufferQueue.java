package 실습.큐;

public class RingBufferQueue {
	private int[] que;
	private int capacity;
	private int front; // 맨 처음 요소 커서
	private int rear; // 맨 마지막 요소 커서
	private int num; // 현재 데이터 개수

	// 생성자
	public RingBufferQueue(int maxlen) {
		num = front = rear = 0;
		capacity = maxlen;

		try {
			que = new int[capacity]; // 용량 만큼 que 배열 생성
		} catch (OutOfMemoryError e) { // 생성할 수 없을 때
			capacity = 0; // 용량 0으로 설정
		}
	}

	// 실행시 예외: 큐가 비어있음
	public class EmptyIntArrayQueueException extends RuntimeException {
		public EmptyIntArrayQueueException() {
		}
	}

	// 실행시 예외: 큐가 비어있음
	public class OverflowIntQueueException extends RuntimeException {
		public OverflowIntQueueException() {
		}
	}

	// 큐에 데이터를 인큐
	public int enque(int x) throws OverflowIntQueueException {
		
		if(num >= capacity) 					 	// 큐가 가득 찼다면
			throw new OverflowIntQueueException();
		que[rear++] = x; 							// 마지막 요소에 위치한 큐 배열에 x값을 담고 후위 연산자로 rear 값을 하나씩 증가
		num++;										// 갯수 크기를 1씩 증가 => 큐의 배열에 값을 하나 추가했으므로
		if(rear == capacity)						// 마지막 커서와 용량이 같다면
			rear = 0;								// 마지막 커서를 0으로 위치한다.
		return x;									

	}
	
	// 큐에 데이터를 디큐
	public int deque() throws EmptyIntArrayQueueException {
		if(num <= 0) 								// 큐가 비어있다면
			throw new EmptyIntArrayQueueException();
		int x = que[front++]; 						// front 커서에 위치한 값을 변수 x에 담고 front 커서 위치를 1로 증가한다.
		num--;										// 디큐를 했으므로 데이터 갯수 하나 감소
		if(front == capacity)						// front 커서 위치와 용량이 같다면
			front = 0;								// front 커서를 맨앞으로 위치한다.
		return x;									// 디큐한 값을 반환한다.
	}
	
	
	
	

	
	
	
	
	
	
	

}
