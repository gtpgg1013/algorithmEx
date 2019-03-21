package algorithmEx;

import java.util.*;

public class bj_6603_re {
	
	static int N;
	static int[] list, check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			N = sc.nextInt();
			list = new int[N];
			check = new int[N];
			if(N==0) break;
			for(int i=0;i<N;i++) {
				list[i] = sc.nextInt();
			}
			dfs(0,0);
			System.out.println();
		}
	}
	
	public static void dfs(int start, int depth) {
		if(depth==6) {
			print();
		}
		for(int i=start;i<N;i++) {
			check[i] = 1;
			dfs(i+1,depth+1);
			check[i] = 0;
		}
	}
	
	public static void print() {
		for(int i=0;i<N;i++) {
			if(check[i]==1) {
				System.out.print(list[i]+" ");
			}
		}
		System.out.println();
	}

}
