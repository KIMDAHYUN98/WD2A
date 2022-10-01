package 실습.p220928;

public class PrimeNumber2 {
	public static void main(String[] args) {
		// 2에서 1000까지의 소수 나열
		method01(); 
		method02(); // 홀수만 검사
		method03(); // 자신보다 작은 소수로 나누어 떨어지지 않으면 소수
	}
	
	private static void method03() {
		int n;
		boolean isPrime;
		int[] prime = new int[500]; // 소수를 저장할 배열
		int count = 0;
		int i, j;
		int ptr=0; 					// 저장된 소수의 개수
//		System.out.print("2, ");
//		초기에 2를 소수 배열에 넣는다
		prime[ptr++] = 2;
		for (i = 3; i < 1000; i=i+2) {
			isPrime = true;
			for (j = 0; j < ptr; j++) {
				count++;
				if (i % prime[j] == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				prime[ptr++] = i;
			}
		}
		for(i=0; i < ptr; i++) {
			System.out.print(prime[i] + ", ");
		}
		System.out.println("\n나눗셈 횟수는 " + count);
	}

	private static void method02() {
		int n;
		boolean isPrime;
		int count = 0;
		int i, j;
		System.out.print("2, ");
		for (i = 3; i < 1000; i=i+2) {
			isPrime = true;
			for (j = 0; j < i - 2; j++) {
				count++;
				if (i % (j + 2) == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				System.out.print(i + ", ");
			}
		}

		System.out.println("\n나눗셈 횟수는 " + count);
	}

	private static void method01() {
		int n;
		boolean isPrime;
		int count = 0;
		int i, j;

		for (i = 0; i < 999; i++) {
			n = i + 2;
			isPrime = true;
			for (j = 0; j < n - 2; j++) {
				count++;
				if (n % (j + 2) == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				System.out.print((n + 2) + ", ");
			}
		}

		System.out.println("\n나눗셈 횟수는 " + count);
	}
}