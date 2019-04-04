package algorithmEx;

import java.util.*;

class direction {
	int sec;
	String dir;
	public direction(int sec, String dir) {
		this.sec = sec;
		this.dir = dir;
	}
}

class endxy {
	int x;
	int y;
	public endxy(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class bj_3190 {
	
	static final int EMPTY = 0;
	static final int SNAKE = 1;
	static final int APPLE = 2;
	static int N;
	static int dir = 0; // 오-아-왼-위 순서대로 0,1,2,3
	static int nowtime = 0;
	static int nextchangetime;
	static String nextchangedir;
	static int nowx;
	static int nowy;
	static int endx;
	static int endy;
	static int[][] map;
	static Queue<direction> q = new LinkedList<direction>();
	static Queue<endxy> xyq = new LinkedList<endxy>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j] = EMPTY;
			}
		}
		map[0][0] = SNAKE;
//		map[0][1] = SNAKE;
		
		int numOfapple = sc.nextInt();
		for(int i=0;i<numOfapple;i++) {
			int tempy = sc.nextInt();
			int tempx = sc.nextInt();
			map[tempy-1][tempx-1] = APPLE;
		}
		
		int numOfdirChange = sc.nextInt();
		for(int i=0;i<numOfdirChange;i++) {
			int tempsec = sc.nextInt();
			String tempdir = sc.next();
			q.add(new direction(tempsec, tempdir));
		}
		direction tempdir = q.poll();
		nextchangetime  = tempdir.sec;
		nextchangedir = tempdir.dir;
		nowx = 0;
		nowy = 0;
		
//		xyq.add(new endxy(1,0));
		endx = 0;
		endy = 0;
		
		while(true) {
			if(dir==0) {
				if(nowx+1>N-1 || map[nowy][nowx+1]==SNAKE) {
					break;
				}
			} else if(dir==1) {
				if(nowy+1>N-1 || map[nowy+1][nowx]==SNAKE) {
					break;
				}
			} else if(dir==2) {
				if(nowx-1<0 || map[nowy][nowx-1]==SNAKE) {
					break;
				}
			} else {
				if(nowy-1<0 || map[nowy-1][nowx]==SNAKE) {
					break;
				}
			}
			move();
//			printmap();
//			System.out.println("nowtime : " + nowtime);
//			System.out.println();
//			System.out.print(nowx+" "+nowy);
//			System.out.println();
//			System.out.println(endx+" "+endy);
//			System.out.println("-----");
		}
		System.out.println(nowtime+1);
	}
	
	public static void move() {
		if(dir==0) {
			xyq.add(new endxy(nowx+1,nowy));
			if(map[nowy][nowx+1]==APPLE) {
				map[nowy][nowx+1] = SNAKE;
				nowx = nowx + 1;
			} else {
				map[nowy][nowx+1] = SNAKE;
				nowx = nowx + 1;
				map[endy][endx] = EMPTY;
				endxy tempxy = xyq.poll();
				endx = tempxy.x;
				endy = tempxy.y;
			}
		} else if(dir==1) {
			xyq.add(new endxy(nowx,nowy+1));
			if(map[nowy+1][nowx]==APPLE) {
				map[nowy+1][nowx] = SNAKE;
				nowy = nowy + 1;
			} else {
				map[nowy+1][nowx] = SNAKE;
				nowy = nowy + 1;
				map[endy][endx] = EMPTY;
				endxy tempxy = xyq.poll();
				endx = tempxy.x;
				endy = tempxy.y;
			}
		} else if(dir==2) {
			xyq.add(new endxy(nowx-1,nowy));
			if(map[nowy][nowx-1]==APPLE) {
				map[nowy][nowx-1] = SNAKE;
				nowx = nowx - 1;
			} else {
				map[nowy][nowx-1] = SNAKE;
				nowx = nowx - 1;
				map[endy][endx] = EMPTY;
				endxy tempxy = xyq.poll();
				endx = tempxy.x;
				endy = tempxy.y;
			}
		} else {
			xyq.add(new endxy(nowx,nowy-1));
			if(map[nowy-1][nowx]==APPLE) {
				map[nowy-1][nowx] = SNAKE;
				nowy = nowy - 1;
			} else {
				map[nowy-1][nowx] = SNAKE;
				nowy = nowy - 1;
				map[endy][endx] = EMPTY;
				endxy tempxy = xyq.poll();
				endx = tempxy.x;
				endy = tempxy.y;
			}
		}
		nowtime++;
		if(nowtime==nextchangetime && nextchangedir.equals("D")) {
			if(dir==3) {
				dir = 0;
			} else {
				dir = dir + 1;
			}
			if(!q.isEmpty()) {
				direction tempdir = q.poll();
				nextchangetime = tempdir.sec;
				nextchangedir = tempdir.dir;
			}
		} else if(nowtime==nextchangetime && nextchangedir.equals("L")){
			if(dir==0) {
				dir = 3;
			} else {
				dir = dir - 1;
			}
			if(!q.isEmpty()) {
				direction tempdir = q.poll();
				nextchangetime = tempdir.sec;
				nextchangedir = tempdir.dir;
			}
		} else {
			
		}
	}
	
	public static void printmap(){
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}
