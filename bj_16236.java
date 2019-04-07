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
		// �������ȴµ� Ÿ�� �ĺ����� ���� -> ����(�������)
		// �� ó�� ���������� Ÿ�� �ĺ����� ť�� �������� -> �ĺ� 1�� ���� ��Ʈ�� -> ������(boolean) ���� (�׸��� �ּҽð� üũ-��ð����� �����ľ���) -> ���� �ٽ� ���ڸ����� Ÿ�� �ĺ��� ť�� ��������
		// �� ó�� ���������� Ÿ�� �ĺ����� ť�� �������� -> �ĺ� 1�� ���� ��Ʈ�� -> �ȴ����� ���� ť���ִ°� ������ ��Ʈ�� -> �ݺ� -> ���� �ٲ�������? -> ������� ȣ��
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
	// ��� Ÿ�� ���� �� -> 1. �Ÿ� �����ֵ� �ϴ� ã��(�������) -> 2. �״��� ���࿡ ������ ������ ũ�� ť���� ����
	public static void hunt(shark s) {
		int sx = s.x;
		int sy = s.y;
		int ssize= s.size;
		int sexp = s.exp;
		int[][] tempmap = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]>ssize) {
					tempmap[i][j] = -1; // �� ����
				} else {
					tempmap[i][j] = 0; // ������� �� �ִ� �� ����
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
			} // �����ϸ� tempmap�� ���ڷ� �� ��			
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
