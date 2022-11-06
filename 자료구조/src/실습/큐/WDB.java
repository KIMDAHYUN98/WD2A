package 실습.큐;

import java.util.Scanner;

// 링버퍼를 이용한 큐를 사용하여 100보다 작은 정수 100개를 랜덤하게 생성하여 인큐하고,
// 풀이 나면 디큐를 시작하시오. empty 나면 인큐를 진행하시오.
// 코드와 실행결과를 A4 용지에 출력하여 제출
// 학번과 이름은 첫장 맨 위쪽에 작성할 것

/*
 * [1] 10 인큐 (front = 0, rear = 1, num = 1) [2] 20 인큐 (frotn = 0, rear = 2, num
 * = 2) . . . [20] 99 인큐 full 발생 10 디큐 20 디큐 . . empty 발생 [21] 20 인큐
 */

public class WDB {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in); 
		IntArrayQueue2 s = new IntArrayQueue2(64); // 최대 64개를 푸시할 수 있는 큐

		while (true) {
			System.out.println("현재 데이터 개수 : " + s.size() + " / " + s.capacity());
			System.out.print("(1) 인큐　(2) 디큐　(3) 피크　" + "(4) 덤프　(0) 종료 : ");

			int menu = stdIn.nextInt();
			if (menu == 0)
				break;

			int x = 0;
			switch (menu) {
			case 1: // 인큐
				System.out.print("데이터 : ");
				x = stdIn.nextInt();
				try {
					s.enque(x);
				} catch (IntArrayQueue.OverflowIntQueueException e) {
					System.out.println("큐가 가득 찼습니다.");
				}
				break;

			case 2: // 디큐
				try {
					x = s.deque();
					System.out.println(" 디큐한 데이터는 " + x + "입니다.");
				} catch (IntArrayQueue.EmptyIntQueueException e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;

			case 3: // 피크
				try {
					x = s.peek();
					System.out.println("피크한 데이터는 " + x + "입니다.");
				} catch (IntArrayQueue.EmptyIntQueueException e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;

			case 4: // 덤프
				s.dump();
				break;
			}
		}
	}
}

class IntArrayQueue2 {
	private int[] que; // 큐의 본체
	private int capacity; // 큐의 용량
	private int num; // 현재 데이터 개수

// --- 생성자 ---//
	public IntArrayQueue2(int maxlen) {
		num = 0;
		capacity = maxlen;
		try {
			que = new int[capacity]; // 큐 본체용 배열을 생성
		} catch (OutOfMemoryError e) { // 생성할 수 없음
			capacity = 0;
		}
	}

// --- 실행 시 예외 : 큐가 비어 있음 ---//
	public class EmptyIntArrayQueueException extends RuntimeException {
		public EmptyIntArrayQueueException() {
		}
	}

// --- 실행 시 예외 : 큐가 가득 참 ---//
	public class OverflowIntArrayQueueException extends RuntimeException {
		public OverflowIntArrayQueueException() {
		}
	}

// --- 큐에 데이터를 인큐 ---//
	public int enque(int x) throws OverflowIntArrayQueueException {
		if (num >= capacity)
			throw new OverflowIntArrayQueueException(); // 큐가 가득 참
		que[num++] = x;
		return x;
	}

// --- 큐에서 데이터를 디큐 ---//
	public int deque() throws EmptyIntArrayQueueException {
		if (num <= 0)
			throw new EmptyIntArrayQueueException(); // 큐가 비어 있음
		int x = que[0];
		for (int i = 0; i < num - 1; i++)
			que[i] = que[i + 1];
		num--;
		return x;
	}

// --- 큐에서 데이터를 피크(맨앞 데이터를 들여다봄 ) ---*/
	public int peek() throws EmptyIntArrayQueueException {
		if (num <= 0)
			throw new EmptyIntArrayQueueException(); // 큐가 비어 있음
		return que[num - 1];
	}

// --- 큐에서 x를 검색하여 인덱스(발견하지 못하면 -1)를 반환합니다---//
	public int indexOf(int x) {
		for (int i = 0; i < num; i++)
			if (que[i] == x) // 검색 성공
				return i;
		return -1; // 검색 실패
	}

// --- 큐를 비웁니다 ---//
	public void clear() {
		num = 0;
	}

// --- 큐의 용량을 반환합니다 ---//
	public int capacity() {
		return capacity;
	}

// --- 큐에 쌓여있는 데이터수를 반환합니다 ---//
	public int size() {
		return num;
	}

// --- 큐가 비어 있는가? ---//
	public boolean isEmpty() {
		return num <= 0;
	}

// --- 큐가 가득 찼는가? ---//
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
