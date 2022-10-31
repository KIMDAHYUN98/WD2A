package 실습.스택;

import java.util.Scanner;

class IntStack {
	
	private int[] stk; // 스택용 배열
	private int capacity; // 스택의 크기
	private int ptr; // 스택 포인터
//--- 실행시 예외: 스택이 비어있음 ---//

	public class EmptyIntStackException extends RuntimeException {
		public EmptyIntStackException() {
			System.out.println("김다현");
		} 
	}

//--- 실행시 예외: 스택이 가득 참 ---//
	public class OverflowIntStackException extends RuntimeException {
		public OverflowIntStackException() {
		}
	}

//--- 생성자(constructor) ---//
	public IntStack(int maxlen) {
		ptr = 0;
		capacity = maxlen;
		try {
			stk = new int[capacity]; // 스택 본체용 배열을 생성
		} catch (OutOfMemoryError e) { // 생성할 수 없음
			capacity = 0;
		}
	}

//--- 스택에 x를 푸시 ---//
	public int push(int x) throws OverflowIntStackException {
		if (ptr >= capacity) // 스택이 가득 참
			throw new OverflowIntStackException();
		return stk[ptr++] = x;
	}

//--- 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄) ---//
	public int pop() throws EmptyIntStackException {
		if (ptr <= 0) // 스택이 빔
			throw new EmptyIntStackException();
		return stk[--ptr];
	}

	
	public int peek() throws EmptyIntStackException {
		if(ptr <= 0)
			throw new EmptyIntStackException();
		return stk[ptr-1];
	}
	
	public static void main(String[] args) {
		IntStack stack = new IntStack(10);

		for (;;) {
			Scanner input = new Scanner(System.in);
			System.out.print("(1)푸시 (2)팝 (3)피크 (0)종료 선택하세요 : ");
			int menu = input.nextInt();
			int x = 0;
			if (menu == 0)
				return;
			
			switch (menu) {
			case 1:
				System.out.print("데이터 : ");
				x = input.nextInt();
				stack.push(x);
				break;
			case 2:
				try {
					x = stack.pop();					
				} catch(IntStack.EmptyIntStackException e) {
					e.printStackTrace();
					System.out.println("스택이 비어있어서 팝을 할 수 없다.");
				}
				System.out.println("핍한 데이터는 " + x + " 입니다.");
				break;
			
			case 3:
				try {
					x = stack.peek();
					System.out.println("피크한 데이터는 " + x + " 입니다.");
				} catch (IntStack.EmptyIntStackException e) {
					System.out.println("스택이 비어있습니다.");
				}
				break;
			}
		}
	}

}
