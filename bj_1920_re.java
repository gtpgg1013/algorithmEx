package algorithmEx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class bj_1920_re {
	
	static int N = 0;
	static int M = 0;
	static ArrayList<Integer> answer = new ArrayList<Integer>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int[] list = new int[N];
		for(int i=0;i<N;i++) {
			list[i] = sc.nextInt();
		}
		int[] templist = list;
		Arrays.sort(templist);
		M = sc.nextInt();
		int[] target = new int[M];
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
		if(mid>=0 && mid<N && start<=end) {
			int value = templist[mid];
			if(target==value) { 
				answer.add(1);
				return;
			} else if(target>value) {
				dfs(mid+1,end,target,templist);
			} else {
				dfs(start,mid-1,target,templist);
			}
		} else {
			answer.add(0);
		}
	}

}
