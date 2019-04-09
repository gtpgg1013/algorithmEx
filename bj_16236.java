package algorithmEx;

// ���⼭ ����Ʈ - ���� ��� ����� 9 �̻��� �Ǹ� ������ ����!

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
	
	static int time = 0;

	public static void main(String[] args) {
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
					map[i][j] = -1; // ���� -1��
				}
			}
		}
		
		while(s_init!=null) {
			shark nextshark = hunt(s_init);
			s_init = nextshark;
		}
		System.out.print(time);
	}
	// ��� Ÿ�� ���� �� -> 1. �Ÿ� �����ֵ� �ϴ� ã��(�������) -> 2. �״��� ���࿡ ������ ������ ũ�� ť���� ����
	public static shark hunt(shark s) {
		int sx = s.x;
		int sy = s.y;
		int ssize= s.size;
		int sexp = s.exp;
		int[][] tempmap = new int[N][N];
		boolean[][] isvisited = new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]>ssize || map[i][j]==-1) {
					tempmap[i][j] = -1; // �� ����
					isvisited[i][j] = true;
				} else {
					tempmap[i][j] = -2; // ������� �� �ִ� �� ����
					isvisited[i][j] = false;
				}
			}
		}
		
		Queue<target> q = new LinkedList<target>();
		
		q.offer(new target(sy,sx,ssize,0));
		isvisited[sy][sx] = true;
		
		while(!q.isEmpty()) {
			target t = q.poll();
			int tx = t.x;
			int ty = t.y;
			int tlength = t.length;
			tempmap[ty][tx] = tlength;
//			isvisited[ty][tx] = true;
			tlength++;
			for(int i=0;i<4;i++) {
				int nextx = tx + dx[i];
				int nexty = ty + dy[i];
				if(nextx>=0 && nextx<N && nexty>=0 && nexty<N && tempmap[nexty][nextx]==-2 && isvisited[nexty][nextx]==false) {
					isvisited[nexty][nextx] = true;
					q.offer(new target(nexty,nextx,map[nexty][nextx],tlength));
				}
			} // �����ϸ� tempmap�� ���ڷ� �� ��	
		}
		
		int minlength = 10000;
		for(int i=0;i<N;i++) { // �ּڰ��� ����
			for(int j=0;j<N;j++) {
				if(minlength>tempmap[i][j] && map[i][j]>0 && map[i][j]<ssize && tempmap[i][j]>0) {
					minlength = tempmap[i][j];
				}
			}
		}
		if(minlength==10000) return null; // �ּڰ��� ������ ���� (������ ����)
		int flag = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(tempmap[i][j]==minlength && map[i][j]>0 && map[i][j]<ssize) {
					map[sy][sx] = 0;
					map[i][j] = -1;
					sy = i;
					sx = j;
					sexp++;
					flag = 1;
					int temp = minlength;
					time = time + temp;
					break;
				}
			}
			if(flag==1) break;
		}
		
		if(sexp==ssize) {
			ssize++;
			sexp = 0;
		}
		
		shark nextshark  = new shark(sy,sx,ssize,sexp);
		
		return nextshark;
	}
	
	public static void printmap() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void printtempmap(int[][] tempmap) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(tempmap[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
