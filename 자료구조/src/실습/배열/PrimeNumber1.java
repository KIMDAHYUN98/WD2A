package 실습.배열;
// 22-09-28
public class PrimeNumber1 {
	public static void main(String[] args) {
		// 2에서 1000까지 소수 나열하기
		// 2에서 1000까지 바깥 for문으로 돌기
		// 안쪽 for문에서 2부터 자신의 수 -1 까지 나누어서 떨어지면 소수가 아니다
		int counter = 0;

		for (int n = 2; n <= 1000; n++) {
			int i;
			for (i = 2; i < n; i++) {
				counter++;
				if (n % i == 0)
					break;
			}

			if (n == i)
				System.out.println(n);
		}

		System.out.println("나눗셈을 수행한 횟수 : " + counter);
		

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
			if ((j + 2) == n) {
				System.out.print(n + ", ");
			}

//			if (isPrime) {
//				System.out.print((n + 2) + ", ");
//			}
		}
		System.out.println("\n나눗셈 횟수는 " + count);
	}
}
