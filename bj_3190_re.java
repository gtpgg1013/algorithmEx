package algorithmEx;

import java.util.*;

class xydot{
	int x;
	int y;
	public xydot(int x, int y) {
		this.x=x;
		this.y=y;
	}
}

class direc{
	int time;
	String dirchange;
	public direc(int time, String dirchange) {
		this.time = time;
		this.dirchange = dirchange;
	}
}

public class bj_3190_re {
	
	static int N;
	static Queue<xydot> baam = new LinkedList<xydot>();
	static Queue<direc> q = new LinkedList<direc>();
	static int[][] map;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	
	static final int EMPTY = 0;
	static final int SNAKE = 1;
	static final int APPLE = 2;
	
	static int nowx = 0;
	static int nowy = 0;
	static int tailx = 0;
	static int taily = 0;
	
	static int nowtime = 0;
	static int dir = 0;
	static int changetime;
	static String changedir;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j] = EMPTY;
			}
		}
		
		int numOfapple = sc.nextInt();
		for(int i=0;i<numOfapple;i++) {
			map[sc.nextInt()-1][sc.nextInt()-1] = APPLE;
		}
		
		int changeOfdir = sc.nextInt();
		for(int i=0;i<changeOfdir;i++) {
			int temptime = sc.nextInt();
			String tempdirchange = sc.next();
			q.add(new direc(temptime, tempdirchange));
		}
		
		direc firstchange = q.poll();
		changetime = firstchange.time;
		changedir = firstchange.dirchange;
		
		map[0][0] = SNAKE;
		
		while(true) {
			int nextx = nowx + dx[dir];
			int nexty = nowy + dy[dir];
			if(nextx<0 || nextx>N-1 || nexty<0 || nexty>N-1 || map[nexty][nextx]==SNAKE) {
				break;
			}
			move();
		}
		
		System.out.println(nowtime+1);
		
	}
	
	public static void move() {
		int nextx = nowx + dx[dir];
		int nexty = nowy + dy[dir];
		baam.add(new xydot(nextx, nexty));
		
		if(map[nexty][nextx]==APPLE) {
			map[nexty][nextx] = SNAKE;
			nowx = nextx;
			nowy = nexty;
		} else {
			map[nexty][nextx] = SNAKE;
			nowx = nextx;
			nowy = nexty;
			map[taily][tailx] = EMPTY;
			xydot temptail = baam.poll();
			tailx = temptail.x;
			taily = temptail.y;
		}
		
		nowtime++;
		
		if(nowtime==changetime) {
			if(changedir.equals("D")) {
				if(dir==3) {
					dir = 0;
				} else {
					dir = dir + 1;
				}
			} else {
				if(dir==0) {
					dir = 3;
				} else {
					dir = dir - 1;
				}
			}
			if(!q.isEmpty()) {
				direc nextchange = q.poll();
				changetime = nextchange.time;
				changedir = nextchange.dirchange;
			}
		}
	}

}
