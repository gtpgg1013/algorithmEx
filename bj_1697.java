package algorithmEx;

import java.util.Scanner;

public class bj_1697 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int s = 0;
		
		System.out.println(time(m,n));
		
	}
	public static int time(int m, int n) {
		if(m==n) {
			return 0;
		}
		int a = time(m, n-1);
		int b = time(m, n+1);
		int c = 100000;
		if(n%2==0) {
			c = time(m,n/2);
		}
		if(a<=b && a<=c) {
			return a+1;
		}
		else if(b<=a && b<=c) {
			return b+1;
		}
		else {
			return c+1;
		}
	}

}
