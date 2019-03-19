package algorithmEx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class bj_14888 {

	static int[] list;
	static int[] calc = new int[4];
	static int m;
	static ArrayList<Integer> answer = new ArrayList<Integer>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		list = new int[m];
		
		for(int i=0;i<m;i++) {
			list[i] = sc.nextInt();
		}
		for(int i=0;i<4;i++) {
			calc[i] = sc.nextInt();
		}
		dfs(list[0],1);
		Collections.sort(answer);
		System.out.println(answer.get(answer.size()-1));
		System.out.println(answer.get(0));
	}
	
	public static void dfs(int sum, int x) {
		for(int i=0;i<4;i++) {
			if(calc[i]!=0) {
				calc[i]--;
				if(i==0) {
					dfs(sum+list[x],x+1);
				}else if(i==1) {
					dfs(sum-list[x],x+1);
				}else if(i==2) {
					dfs(sum*list[x],x+1);
				}else if(i==3) {
					dfs(sum/list[x],x+1);
				}
				calc[i]++;
			}
		}
		if(x==m) {
			answer.add(sum);
		}
	}

}
