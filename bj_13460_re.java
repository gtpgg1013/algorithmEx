package algorithmEx;

// 파라미터로 해서 푸는 법 연습하자

import java.util.*;

class Point{
	int x;
	int y;
	public Point(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class bj_13460_re {
	
	static int N, M;
	static int[] dx = {1,0,-1,0}, dy = {0,1,0,-1};
	static int answer = 10000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		Point R = null;
		Point B = null;
		char[][] map = new char[N][M];
		for(int i=0;i<N;i++) {
			String temp = sc.next();
			for(int j=0;j<M;j++) {
				map[i][j] = temp.charAt(j);
				if(map[i][j]=='R') R = new Point(i,j);
				if(map[i][j]=='B') B = new Point(i,j);
			}
		}
		
		for(int i=0;i<4;i++) {
			tilt(i,0,map,R,B);
		}
		
		if(answer==10000) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}
	}
	
	public static void tilt(int dir, int depth, char[][] map, Point R, Point B) {
		if(depth>9) return;
		char[][] tempmap = new char[N][M];
		boolean endR = false;
		boolean endB = false;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				tempmap[i][j] = map[i][j];
			}
		}
		int first = 1; // R먼저
		if(dir==0 && B.x>R.x) first = 0;
		if(dir==1 && B.y>R.y) first = 0;
		if(dir==2 && B.x<R.x) first = 0;
		if(dir==3 && B.y<R.y) first = 0;
		
		int Rx = R.x;
		int Ry = R.y;
		int Bx = B.x;
		int By = B.y;
		
		if(first==1) { // R먼저
			while(true) {
				int nextRx = Rx + dx[dir];
				int nextRy = Ry + dy[dir];
				if(tempmap[nextRy][nextRx]=='#' || tempmap[nextRy][nextRx]=='B') {
					break;
				} else if(tempmap[nextRy][nextRx]=='O') {
					tempmap[Ry][Rx] = '.';
					endR = true;
					break;
				}
				tempmap[nextRy][nextRx] = 'R';
				tempmap[Ry][Rx] = '.';
				Rx = nextRx;
				Ry = nextRy;
			}
			while(true) {
				int nextBx = Bx + dx[dir];
				int nextBy = By + dy[dir];
				if(tempmap[nextBy][nextBx]=='#' || tempmap[nextBy][nextBx]=='R') {
					break;
				} else if(tempmap[nextBy][nextBx]=='O') {
					tempmap[By][Bx] = '.';
					endB = true;
					break;
				}
				tempmap[nextBy][nextBx] = 'B';
				tempmap[By][Bx] = '.';
				Bx = nextBx;
				By = nextBy;
			}
		} else { // B먼저
			while(true) {
				int nextBx = Bx + dx[dir];
				int nextBy = By + dy[dir];
				if(tempmap[nextBy][nextBx]=='#' || tempmap[nextBy][nextBx]=='R') {
					break;
				} else if(tempmap[nextBy][nextBx]=='O') {
					tempmap[By][Bx] = '.';
					endB = true;
					break;
				}
				tempmap[nextBy][nextBx] = 'B';
				tempmap[By][Bx] = '.';
				Bx = nextBx;
				By = nextBy;
			}
			while(true) {
				int nextRx = Rx + dx[dir];
				int nextRy = Ry + dy[dir];
				if(tempmap[nextRy][nextRx]=='#' || tempmap[nextRy][nextRx]=='B') {
					break;
				} else if(tempmap[nextRy][nextRx]=='O') {
					tempmap[Ry][Rx] = '.';
					endR = true;
					break;
				}
				tempmap[nextRy][nextRx] = 'R';
				tempmap[Ry][Rx] = '.';
				Rx = nextRx;
				Ry = nextRy;
			}
		}
		
		if(endB==true) return;
		if(endR==true) {
			if(answer>=depth+1) {
				answer = depth + 1;
			}
			return;
		}
		
		Point nextR = new Point(Ry, Rx);
		Point nextB = new Point(By, Bx);
		
		if(dir==0) {
			tilt(1,depth+1,tempmap,nextR,nextB);
			tilt(2,depth+1,tempmap,nextR,nextB);
			tilt(3,depth+1,tempmap,nextR,nextB);
		} else if(dir==1) {
			tilt(0,depth+1,tempmap,nextR,nextB);
			tilt(2,depth+1,tempmap,nextR,nextB);
			tilt(3,depth+1,tempmap,nextR,nextB);
		} else if(dir==2) {
			tilt(0,depth+1,tempmap,nextR,nextB);
			tilt(1,depth+1,tempmap,nextR,nextB);
			tilt(3,depth+1,tempmap,nextR,nextB);
		} else {
			tilt(0,depth+1,tempmap,nextR,nextB);
			tilt(1,depth+1,tempmap,nextR,nextB);
			tilt(2,depth+1,tempmap,nextR,nextB);
		}
		
//		for(int i=0;i<4;i++) {
//			tilt(i,depth+1,tempmap,nextR,nextB);
//		}
	}

}
