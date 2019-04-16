package algorithmEx;

import java.util.*;

class Pt{
	int y;
	int x;
	int cnt;
	public Pt(int y, int x, int cnt) {
		this.y = y;
		this.x = x;
		this.cnt = cnt;
	}
}

public class bj_16236_re {
	
	static int N;
	static boolean cont = true;
	static int sharky;
	static int sharkx;
	static int size = 2;
	static int exp = 0;
	static int[][] map;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	
	static int ans = 0;
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int temp = sc.nextInt();
				map[i][j] = temp;
				if(temp==9) {
					sharky = i;
					sharkx = j;
				}
			}
		}
		while(cont) {
			BFS();
		}
		System.out.println(ans);
	}
	
	public static void BFS() {
		int[][] tempmap = new int[N][N];
		boolean[][] visited = new boolean[N][N];
 		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]>size || map[i][j]==9) { // 아기상어이거나 못지나가는 놈이면
					tempmap[i][j] = -1;
					visited[i][j] = true;
				} else {
					tempmap[i][j] = 0;
					visited[i][j] = false;
				}
			}
		}
 		
 		Pt firstshark = new Pt(sharky,sharkx,0);
 		Queue<Pt> q = new LinkedList<Pt>();
 		q.offer(firstshark);
 		
 		while(!q.isEmpty()) { // q로 쫙 뿌려주고
// 			print(tempmap);
 			Pt front = q.poll();
 			int y = front.y;
 			int x = front.x;
 			int cnt = front.cnt;
 			cnt++;
 			for(int i=0;i<4;i++) {
 				int nexty = y + dy[i];
 				int nextx = x + dx[i];
 				if(nextx>=0 && nextx<N && nexty>=0 && nexty<N && visited[nexty][nextx]==false
 						&& tempmap[nexty][nextx]!=-1) {
 					tempmap[nexty][nextx] = cnt;
 					visited[nexty][nextx] = true;
 					q.offer(new Pt(nexty,nextx,cnt));
 				}
 			}
 		}
 		
 		int min = 100000; // 여기부터 밑에를 하나로 찾을 수 없나? 흘리는건 괜찮은데 거기에서 최솟값 찾는게 너무 귀찮다.... 복잡하고 보기 싫음
 		for(int i=0;i<N;i++) {
 			for(int j=0;j<N;j++) {
 				if(tempmap[i][j]>0 && min>tempmap[i][j] && map[i][j]>0 && map[i][j]<size) { // 최소거리 찾기
 					min = tempmap[i][j];
// 					System.out.println(min);
 				}
 			}
 		}
 		
 		boolean ck = false;
 		for(int i=0;i<N;i++) {
 			for(int j=0;j<N;j++) {
 				if(tempmap[i][j]==min && map[i][j]>0 && map[i][j]<size) { // 최소거리이면서 사이즈 조건 만족하는 거 찾기
 					map[sharky][sharkx] = 0;
 					sharky = i;
 					sharkx = j;
 					map[sharky][sharkx] = 9;
 					ans += tempmap[i][j];
 					exp++;
 					ck = true;
 					if(exp==size) {
 						size++;
 						exp = 0;
 					}
 					break;
 				}
 			}
 			if(ck==true) break;
 		}
 		if(ck==false) cont = false;
	}
	
	public static void print(int[][] m) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(m[i][j]+ " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
