package algorithmEx;

import java.util.Scanner;

public class bj_11047 {
	
	static Scanner sc = new Scanner(System.in);
	static int M, N;
	static int count = 0;
	static int[] list;
	
	public static void main(String[] args) {
		M = sc.nextInt();
		N = sc.nextInt();
		makelist();
		sol();
		System.out.println(count);
	}
	
	public static void printlist() {
		for(int i=0;i<list.length;i++) {
			System.out.print(list[i]+" ");
		}
	}
	
	public static void makelist() {
		list = new int[M];
		for(int i=0;i<list.length;i++) {
			list[i] = sc.nextInt();
		}
	}
	
	public static void sol() {
		for(int i=list.length-1;i>=0;i--) { // i>=0임을 기억해야!!!
			while(N>=list[i]) {
				N = N -list[i];
				count++;
			}
		}
	}
	
}
