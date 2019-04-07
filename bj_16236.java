package algorithmEx;

import java.util.*;

class shark {
	int y;
	int x;
	int size;
	int exp;
	public shark(int y, int x, int size, int exp) {
		this.y = y;
		this.x = x;
		this.size = size;
		this.exp = exp;
	}
}

class target {
	int y;
	int x;
	int size;
	int length;
	public target(int y, int x, int size, int length) {
		this.y = y;
		this.x = x;
		this.size = size;
		this.length = length;
	}
}

public class bj_16236 {
	
	static int N;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int[][] map;

	public static void main(String[] args) {
		// 포문돌렸는데 타겟 후보들이 없다 -> 종료(엄마상어)
		// 맨 처음 포문돌려서 타겟 후보들을 큐에 떄려넣음 -> 후보 1을 향해 퍼트림 -> 닿으면(boolean) 먹음 (그리고 최소시간 체크-요시간들을 다합쳐야함) -> 그후 다시 그자리에서 타겟 후보들 큐에 때려넣음
		// 맨 처음 포문돌려서 타겟 후보들을 큐에 떄려넣음 -> 후보 1을 향해 퍼트림 -> 안닿으면 다음 큐에있는거 꺼내서 퍼트림 -> 반복 -> 만약 다꺼내졌다? -> 엄마상어 호출
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		shark s_init = null;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int temp = sc.nextInt();
				map[i][j] = temp;
				if(temp==9) {
					s_init = new shark(i,j,2,0);
				}
			}
		}
	}
	// 사냥 타깃 고르는 법 -> 1. 거리 가까운애들 싹다 찾고(순서대로) -> 2. 그다음 만약에 나보다 사이즈 크면 큐에서 제거
	public static void hunt(shark s) {
		int sx = s.x;
		int sy = s.y;
		int ssize= s.size;
		int sexp = s.exp;
		int[][] tempmap = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]>ssize) {
					tempmap[i][j] = -1; // 벽 설정
				} else {
					tempmap[i][j] = 0; // 흘려보낼 수 있는 곳 설정
				}
			}
		}
		
		Queue<target> q = new LinkedList<target>();
		
		q.offer(new target(sy,sx,ssize,0));
		
		while(!q.isEmpty()) {
			target t = q.poll();
			int tx = t.x;
			int ty = t.y;
			int tlength = t.length;
			tempmap[ty][tx] = t.length;
			tlength++;
			for(int i=0;i<4;i++) {
				int nextx = tx + dx[i];
				int nexty = ty + dy[i];
				if(nextx>=0 && nextx<N && nexty>=0 && nexty<N && tempmap[nexty][nextx]==0) {
					q.add(new target(nextx,nexty,map[nexty][nextx],tlength));
				}
			} // 일케하면 tempmap에 숫자로 꽉 참			
		}		
		
		int minlength = 10000;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(minlength>tempmap[i][j] && map[i][j]>0 && map[i][j]<ssize) {
					minlength = tempmap[i][j];
				}
			}
		}
		if(minlength==10000) return;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(tempmap[i][j]==minlength && map[i][j]>0 && map[i][j]<ssize) {
					tempmap[i][j] = 9;
					sexp++;
				}
			}
		}
		
	}
	
	public static void bfs() {
		
	}

}
