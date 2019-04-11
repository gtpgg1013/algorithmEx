package algorithmEx;

import java.util.*;

class house{
	int y;
	int x;
	public house(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class bj_15686 {
	
	static int N,M;
	static int[][] map;
	static int answer = 100000;
	static ArrayList<house> houselist = new ArrayList<house>();
	static ArrayList<house> chickenstorelist = new ArrayList<house>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int temp = sc.nextInt();
				map[i][j] = temp;
				if(temp==1) {
					houselist.add(new house(i,j));
				}
				if(temp==2) {
					chickenstorelist.add(new house(i,j));
				}
			}
		}
//		printlist(houselist);
//		printlist(chickenstorelist);
		
		for(int i=0;i<chickenstorelist.size();i++) {
			ArrayList<house> initlist = new ArrayList<house>();
			initlist.add(chickenstorelist.get(i));
			dfs(0,initlist,i);
		}
		System.out.println(answer);
	}
	
	public static void dfs(int depth, ArrayList<house> list, int num) {
		if(depth==M-1) { // 깊이가 다다르면
			int tempval = 0;
			for(int i=0;i<houselist.size();i++) { // 집에서 (치킨거리는 집당 1개임!)
				int shortest = 10000;
				for(int j=0;j<list.size();j++) { // 치킨집까지 각거리 잰다음
					int tempx = Math.abs(list.get(j).x - houselist.get(i).x);
					int tempy = Math.abs(list.get(j).y - houselist.get(i).y);
//					System.out.println(tempy+" "+tempx);
					if(shortest>tempx+tempy) { // 그 거리가 최솟값이면 유지 (치킨거리 찾기)
						shortest = tempx + tempy;
//						System.out.println(shortest);
					}
				}
				tempval += shortest; // 그리고 그걸 전체 도시치킨거리에 더해줌
			}
//			System.out.println("tempval:"+tempval);
			if(answer>tempval) {
				answer = tempval;
			}
			return;
		}
		for(int i=num+1;i<chickenstorelist.size();i++) {
			ArrayList<house> templist = new ArrayList<house>(); // 제발 선언을 이 안에서 해줘라!
			for(int j=0;j<list.size();j++) {
				templist.add(list.get(j));
			}
			templist.add(chickenstorelist.get(i));
			dfs(depth+1,templist,i);
		}
		
	}
	
	public static void printlist(ArrayList<house> list) {
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).y+" "+list.get(i).x);
		}
	}

}
