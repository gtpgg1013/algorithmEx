package algorithmEx;

import java.util.*;

public class bj_14499 {
	
	static int N, M, nowx, nowy, K;
	static int[][] map;
	static int[] dx = {1,-1,0,0}; // 동 - 서 - 북 - 남 // 아래가 남쪽, 오른쪽이 동쪽
	static int[] dy = {0,0,-1,1};
	static int d1, d2, d3, d4, d5, d6 = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][M];
		
		// x, y에 속지 말자!!! 분명 문제에는 r, c라고 써있었움...ㅠㅠㅠ
		nowy = sc.nextInt();
		nowx = sc.nextInt();
		K = sc.nextInt();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				int temp = sc.nextInt();
				map[i][j] = temp;
			}
		}
		
		for(int i=0;i<K;i++) {
			int tempdir = sc.nextInt();
			roll(tempdir);
		}
		
	}
	
	public static void roll(int dir) {
		int nextx = nowx + dx[dir-1];
		int nexty = nowy + dy[dir-1];
		if(nextx<0 || nextx>M-1 || nexty<0 || nexty>N-1) {
			return;
		}
		nowx = nextx;
		nowy = nexty;
		if(dir==1) {
			if(map[nexty][nextx]==0) {
				map[nexty][nextx] = d3;
			} else {
				d3 = map[nexty][nextx];
				map[nexty][nextx] = 0;
			}
		int[] templist = {d3, d2, d6, d1, d5, d4};
		d1 = templist[0];
		d2 = templist[1];
		d3 = templist[2];
		d4 = templist[3];
		d5 = templist[4];
		d6 = templist[5];
		System.out.println(d6);
		}
		
		if(dir==2) {
			if(map[nexty][nextx]==0) {
				map[nexty][nextx] = d4;
			} else {
				d4 = map[nexty][nextx];
				map[nexty][nextx] = 0;
			}
		int[] templist = {d4, d2, d1, d6, d5, d3};
		d1 = templist[0];
		d2 = templist[1];
		d3 = templist[2];
		d4 = templist[3];
		d5 = templist[4];
		d6 = templist[5];
		System.out.println(d6);
		}
		
		if(dir==3) {
			if(map[nexty][nextx]==0) {
				map[nexty][nextx] = d2;
			} else {
				d2 = map[nexty][nextx];
				map[nexty][nextx] = 0;
			}
		int[] templist = {d2, d6, d3, d4, d1, d5};
		d1 = templist[0];
		d2 = templist[1];
		d3 = templist[2];
		d4 = templist[3];
		d5 = templist[4];
		d6 = templist[5];
		System.out.println(d6);
		}
		
		if(dir==4) {
			if(map[nexty][nextx]==0) {
				map[nexty][nextx] = d5;
			} else {
				d5 = map[nexty][nextx];
				map[nexty][nextx] = 0;
			}
		int[] templist = {d5, d1, d3, d4, d6, d2};
		d1 = templist[0];
		d2 = templist[1];
		d3 = templist[2];
		d4 = templist[3];
		d5 = templist[4];
		d6 = templist[5];
		System.out.println(d6);
		}
	}

}
