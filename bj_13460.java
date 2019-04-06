package algorithmEx;

import java.util.*;

public class bj_13460 {
	
	static int N, M;
	static String[][] map;
	
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	
	// 각 좌표 비교해서 어떤 걸 먼저 굴릴지 결정
	static int Rx;
	static int Ry;
	static int Bx;
	static int By;
	static int Hx;
	static int Hy;
	static boolean Rend = false;
	static boolean Bend = false;
	
	static int count = 10000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new String[N][M];
		
		for(int i=0;i<N;i++) {
			String temp = sc.next();
			String templist[] = temp.split("");
			for(int j=0;j<M;j++) {
//				System.out.println(temp);
				map[i][j] = templist[j];
				if(templist[j].equals("R")) {
					Ry = i;
					Rx = j;
				} 
				if(templist[j].equals("B")) {
					By = i;
					Bx = j;
				}
				if(templist[j].equals("O")) {
					Hy = i;
					Hx = j;
				}
			}
		}
		for(int i=0;i<4;i++) {
			move(i,0);
//			System.out.println("here2");
//			System.out.println(count);
//			print(map);
		}
		
		if(count==10000) {
			System.out.println(-1);
		} else {
			System.out.println(count);
		}
		
	}
	public static void move(int dir, int depth) { // 오 - 아 - 왼 - 위 순서 (0 - 1 - 2 - 3)
		Rend = false;
		Bend = false;
		int TempRx = Rx;
		int TempRy = Ry;
		int TempBx = Bx;
		int TempBy = By;
		String[][] tempmap = new String[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				tempmap[i][j] = map[i][j];
			}
		}
		if(dir==0) {
			if(Rx>Bx) {
				// R먼저 굴리기
				rollR(dir);
				rollB(dir);

			} else {
				rollB(dir);
				rollR(dir);
			}
		} else if(dir==1) {
			if(Ry>By) {
				rollR(dir);
				rollB(dir);
			} else {
				rollB(dir);
				rollR(dir);
			}
		} else if(dir==2) {
			if(Rx<Bx) {
				rollR(dir);
				rollB(dir);
			} else {
				rollB(dir);
				rollR(dir);
			}
		} else {
			if(Ry<By) {
				rollR(dir);
				rollB(dir);
			} else {
				rollB(dir);
				rollR(dir);
			}
		}
		
		if(Bend==true) return;
		if(Rend==true) {
			if(count>depth+1) {
				count = depth + 1;
			}
			return;
		}
		if(depth+1==10) {
			return;
		}
		
		move(0,depth+1);
		Bx = TempBx;
		By = TempBy;
		Rx = TempRx;
		Ry = TempRy;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				map[i][j] = tempmap[i][j];
			}
		}
		
		move(1,depth+1);
		Bx = TempBx;
		By = TempBy;
		Rx = TempRx;
		Ry = TempRy;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				map[i][j] = tempmap[i][j];
			}
		}
		
		move(2,depth+1);
		Bx = TempBx;
		By = TempBy;
		Rx = TempRx;
		Ry = TempRy;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				map[i][j] = tempmap[i][j];
			}
		}
		
		move(3,depth+1);
		Bx = TempBx;
		By = TempBy;
		Rx = TempRx;
		Ry = TempRy;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				map[i][j] = tempmap[i][j];
			}
		}
	}
	
	public static void rollR(int dir) {
		while(true) {
			int nextRy = Ry + dy[dir];
			int nextRx = Rx + dx[dir];
//			System.out.println(map[nextRy][nextRx]);
//			System.out.println(map[Ry][Rx]);
			if(map[nextRy][nextRx].equals("#") || map[nextRy][nextRx].equals("B")) {
				break;
			}
			if(map[nextRy][nextRx].equals("O")) {
				map[Ry][Rx] = ".";
				Rx = nextRx;
				Ry = nextRy;
				Rend = true;
				break;
			} 
				map[nextRy][nextRx] = "R";
				map[Ry][Rx] = ".";
				Ry = nextRy;
				Rx = nextRx;
//				print(map);
		}
			
		
	}
	
	public static void rollB(int dir) {
		while(true) {
			int nextBx = Bx + dx[dir];
			int nextBy = By + dy[dir];
//			System.out.println(map[nextBy][nextBx]);
			if(map[nextBy][nextBx].equals("#") || map[nextBy][nextBx].equals("R")) {
				break;
			}
			if(map[nextBy][nextBx].equals("O")) {
				map[By][Bx] = ".";
				Bx = nextBx;
				By = nextBy;
				Bend = true;
				break;
			}
				map[nextBy][nextBx] = "B";
				map[By][Bx] = ".";
				By = nextBy;
				Bx = nextBx;
//				print(map);
		}
			
		
	}
	
	public static void print(String[][] map) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(map[i][j]+ "");
			}
			System.out.println();
		}
		System.out.println();
	}

}
