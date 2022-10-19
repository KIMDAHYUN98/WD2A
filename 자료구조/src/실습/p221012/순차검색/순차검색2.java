package 실습.p221012.순차검색;

import java.util.Scanner;

public class 순차검색2 {
	static int binSearch(int []a, int n, int key) {
	      int pl = 0;    // 배열 시작 0
	      int pr = n - 1; // 배열 끝 6
	      System.out.print("   |");
	      for (int i = 0; i < n; i++)
	         System.out.printf("%4d", i);
	      System.out.println();
	      System.out.print("---+");
	      for (int i = 0; i < n * 4 + 2; i++)
	         System.out.print("-");
	      System.out.println();
	      
	      do {
	         int pc = (pl + pr) / 2; // 배열 중간 3
	         System.out.print("   |");
	         if (pl != pc)
	            System.out.printf(String.format("%%%ds<-%%%ds+", (pl * 4) + 1, (pc - pl) * 4), "", "");
	         else
	            System.out.printf(String.format("%%%ds<-+", pc * 4 + 1), "");
	         if (pc != pr)
	            System.out.printf(String.format("%%%ds->\n", (pr - pc) * 4 - 2), "");
	         else
	            System.out.println("->");
	         System.out.printf("%3d|", pc);
	         for (int k = 0; k < n; k++)
	            System.out.printf("%4d", a[k]);
	         System.out.println("\n   |");
	                  
	         if (a[pc] == key)
	            return pc;   // 탐색 성공
	         else if (a[pc] < key)
	            pl = pc + 1;
	         else
	            pr = pc - 1;
	      } while (pl <= pr);
	      return -1;   // 탐색 실패
	   }

	   public static void main(String[] args) {
	      // TODO Auto-generated method stub
	      Scanner stdIn = new Scanner (System.in);
	      
	      System.out.print("요솟수: ");
	      int num = stdIn.nextInt();
	      int[] x = new int[num];            // 요솟수가 num인 배열
	      
	      System.out.println("오름차순으로 입력하시오.");
	      
	      System.out.print("x[0]: ");         // 첫 요소 입력
	      x[0] = stdIn.nextInt();
	      
	      for (int i = 1; i < num; i++) {
	         do {
	            System.out.print("x[" + i + "]: ");
	            x[i] = stdIn.nextInt();
	         } while (x[i] < x[i - 1]);      // 바로 앞의 요소보다 작으면 다시 입력
	      }
	      
	      System.out.print("검색할 값: ");       // 키 값을 입력
	      int ky = stdIn.nextInt();
	      
	      int idx = binSearch(x, num, ky);   // 배열 x에서 키 값이 ky인 요소를 검색
	      
	      if (idx == -1)
	         System.out.println("그 값의 요소가 없습니다.");
	      else
	         System.out.println(ky + "은(는) x[" + idx + "]에 있습니다.");
	      

	   }

}
