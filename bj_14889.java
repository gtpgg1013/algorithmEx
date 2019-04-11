package algorithmEx;

// 이문제 할때 실수했던 점 : 1. 문제자체를 잘못 이해함 -> 팀을 싹 나눠준다음에 값을 다 더했어야 함
// 2. 배열이나 list는 절대 통짜로 대입하지 마라 -> 만약 dfs에서 계속 쓸거면 새로운 배열을 만들어서 거기에 값을 넣어주는 방식으로 진행해야 함!

import java.util.*;

public class bj_14889 {
	
	static int N;
	static int[][] map;
	
	static int answer = 1000000000;
	static int totalability = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N+1][N+1];
		for(int i=1;i<N+1;i++) {
			for(int j=1;j<N+1;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int i=1;i<N+1;i++) { // 양쪽 합쳐주기
			for(int j=1;j<N+1;j++) {
				map[i][j] += map[j][i];
			}
		}
		
		for(int i=1;i<N+1;i++) {
			ArrayList<Integer> templist = new ArrayList<Integer>();
			templist.add(i);
			dfs(0,i,templist);
		}
		
		System.out.println(answer);
	}
	
	public static void dfs(int depth, int me, ArrayList<Integer> list) {
		if(depth==N/2-1) {
			int coability = 0;
			ArrayList<Integer> totallist = new ArrayList<Integer>(); // 다른쪽애들
			for(int i=0;i<N;i++) {
				totallist.add(i+1);
			}
			for(int i=0;i<list.size();i++) {
				if(totallist.contains(list.get(i))) {
					totallist.remove(list.get(i));
				}
			}
//			printlist(list);
//			printlist(totallist);
//			System.out.println("aa");
			int sval = calcval(list);
			int lval = calcval(totallist);
			int tempval = Math.abs(sval - lval);
//			System.out.println(tempval);
			if(answer>tempval) {
				answer = tempval;
			}
//			System.out.println(answer);
			return;
		}
		for(int i=me+1;i<N+1;i++) {
			ArrayList<Integer> templist = new ArrayList<Integer>(); // 이렇게 리스트를 하나 더 만들어서 거기다가 값을 넣어줘야 함
			for(int j=0;j<list.size();j++) {
				templist.add(list.get(j));
			}
			templist.add(i);
			dfs(depth+1,i,templist);
		}
	}
	
	public static int calcval(ArrayList<Integer> list) {
		int ans = 0;
		for(int i=0;i<list.size();i++) {
			for(int j=i+1;j<list.size();j++) {
				ans += map[list.get(i)][list.get(j)];
			}
		}
		return ans;
	}
	
	public static void printlist(ArrayList<Integer> list) {
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i)+" ");
		}
		System.out.println();
	}

}
