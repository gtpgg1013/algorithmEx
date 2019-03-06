package algorithmEx;

import java.util.Scanner;

public class bj_9095 {

	static Scanner sc = new Scanner(System.in);
	static int[] list_input;
	static int[] list_memo;
	
	public static void main(String[] args) {
		int m = sc.nextInt();
		list_input = new int[m];
		for(int i=0;i<m;i++) {
			int a = sc.nextInt();
			list_input[i] = a;
		}
		for(int i=0;i<list_input.length;i++) {
		list_memo = new int[getMax(list_input)];
		System.out.println(sol(list_input[i]-1));
		}
		
	}
	
	public static int sol(int a) { // 이걸 이제 list_memo에 넣어서 dp화만 시켜주면됨
		if(list_memo[a]==0) {
			if(a==0) {
				list_memo[a]=1;
			}
			else if(a==1) {
				list_memo[a]=2;
			}
			else if(a==2) {
				list_memo[a]=4;
			} else {
				list_memo[a]=sol(a-1)+sol(a-2)+sol(a-3);
			}
			return list_memo[a];
		} else {
			return list_memo[a];
		}
}
	
	public static int getMax(int[] a) {
		int ans=0;
		for(int i=0;i<a.length;i++) {
			if(a[i]>ans) {
				ans = a[i];
			}
		}
		return ans;
	}

}
