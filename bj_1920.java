package algorithmEx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class bj_1920 {
	
	static int N, M;
	static int[] list, target;
	static ArrayList<Integer> answer = new ArrayList<Integer>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		list = new int[N];
		for(int i=0;i<N;i++) {
			list[i] = sc.nextInt();
		}
		int[] templist = list;
		Arrays.sort(templist);
		M = sc.nextInt();
		target = new int[M];
		for(int i=0;i<M;i++) {
			target[i] = sc.nextInt();
		}
		for(int i=0;i<M;i++) {
			int temp = target[i];
			int num = N;
			dfs(0,num,temp,templist);
		}
		for(int i=0;i<answer.size();i++) {
			System.out.println(answer.get(i));
		}
	}
	
	public static void dfs(int start, int end, int target, int[] templist) {
		int mid = (start + end) / 2;
		if(mid>=0 && mid<N) {
			if(target==templist[mid]) { 
				answer.add(1);
			} else if(target>templist[mid]) {
				dfs(mid+1,end,target,templist);
			} else if(target<templist[mid]) {
				dfs(start,mid-1,target,templist);
			} else {}
		} else {
			answer.add(0);
		}
	}

}
