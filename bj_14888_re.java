package algorithmEx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class bj_14888_re {
	
	static int M;
	static ArrayList<Integer> answer = new ArrayList<Integer>();
	static int[] list; 
	static int[] app = new int[4];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		list = new int[M];
		for(int i=0;i<list.length;i++) {
			list[i] = sc.nextInt();
		}
		for(int i=0;i<4;i++) {
			app[i] = sc.nextInt();
		}
		dfs(list[0],1);
		Collections.sort(answer);
		System.out.println(answer.get(answer.size()-1));
		System.out.println(answer.get(0));
	}
	
	public static void dfs(int sum, int x) {
		for(int i=0;i<4;i++) {
			if(app[i]!=0) {
				app[i]--;
				if(i==0) {
					dfs(sum+list[x],x+1);
	;			} else if(i==1) {
					dfs(sum-list[x],x+1);
				} else if(i==2) {
					dfs(sum*list[x],x+1);
				} else {
					dfs(sum/list[x],x+1);
				}
				app[i]++;
			}
		}
		if(x==M)
			answer.add(sum);
	}

}
