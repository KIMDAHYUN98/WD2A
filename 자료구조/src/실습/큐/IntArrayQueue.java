package 실습.큐;

public class IntArrayQueue {
	 int[] que; // 큐용 배열
	   int capacity; // 큐의 킉
	   int front; // 맨 처음 요소 커서
	   int rear; // 맨 끝 요소 커서
	   int num; // 현재 데이터 개수

	   // --- 생성자 ---//
	   public IntArrayQueue(int maxlen) {
	      num = front = rear = 0;
	      capacity = maxlen;
	      try {
	         que = new int[capacity]; // 큐 본체용 배열 생성
	      } catch (OutOfMemoryError e) { // 생성 불가
	         capacity = 0;
	      }
	   }

	   // --- 실행시 예외: 큐가 비어있음 ---//
	   public class EmptyIntQueueException extends RuntimeException {
	      public EmptyIntQueueException() {
	      }
	   }

	   // --- 실행시 예외: 큐가 가득 참 ---//
	   public class OverflowIntQueueException extends RuntimeException {
	      public OverflowIntQueueException() {
	      }
	   }

	   // --- 큐에 데이터를 삽입 ---//
	   public int enque(int x) throws OverflowIntQueueException {
	      if (num >= capacity)
	         throw new OverflowIntQueueException();
	      que[rear++] = x;
	      num++;
	      if (rear == capacity)
	         rear = 0;
	      return x;
	   }

	   // 큐에 데이터를 디큐
	   public int deque() throws EmptyIntQueueException  {
	      if (num <= 0) // 데이터가 없을 때
	         throw new EmptyIntQueueException (); // 예외 처리 발생

	      int x = que[0]; // que 첫번째 배열에 뺴내는 값을 변수 x에 담는다. => 디큐
	      for (int i = 0; i < num - 1; i++) // 데이터 갯수가 1씩 감소하므로 num - 1 만큼 반복해서
	         que[i] = que[i + 1]; // 각각 큐의 이전 위치에다가 다음 위치의 값을 담는다.
	      num--; // 총 데이터 갯수를 1만큼 줄인다.
	      return x;
	   }

	   // --- 큐에서 데이터를 피크(출력할 데이터를 확인) ---//
	   public int peek() throws EmptyIntQueueException {
	      if (num <= 0)
	         throw new EmptyIntQueueException();
	      return que[num - 1];
	   }

	   // --- 큐에서 x를 검색하여 인덱스 반환 (발견 못할시 -1 반환 ---//
	   public int indexOf(int x) {
	      for (int i = 0; i < num; i++)
	         if (que[i] == x)
	            return i;
	      return -1;
	   }

	   // --- 큐를 비운다 ---//
	   public void clear() {
	      num = 0;
	   }

	   // --- 큐의 용량 반환 ---//
	   public int capacity() {
	      return capacity;
	   }

	   // --- 큐에 쌓인 데이터 수 반환 ---//
	   public int size() {
	      return num;
	   }

	   // --- 큐가 비었는지 확인 ---//
	   public boolean isEmpty() {
	      return num <= 0;
	   }

	   // --- 큐가 가득찼는지 확인 ---//
	   public boolean isFull() {
	      return num >= capacity;
	   }

	   // --- 큐 안의 모든 데이터를 맨앞 → 맨끝의 순서로 출력 ---//
	   public void dump() {
	      if (num <= 0)
	         System.out.println("큐가 비어 있습니다.");
	      else {
	         for (int i = 0; i < num; i++)
	            System.out.print(que[i] + " ");
	         System.out.println();
	      }
	   }

}
