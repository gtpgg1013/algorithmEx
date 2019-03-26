package algorithmEx;

import java.util.*;

public class bj_14503 {
	
	static int N,M;
	static int nowy,nowx;
	static int dir;
	static int[][] list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		list = new int[N][M];
		nowy = sc.nextInt();
		nowx = sc.nextInt();
		dir = sc.nextInt();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				list[i][j] = sc.nextInt();
			}
		}
		printlist();
		cleanup();
		printlist();
		System.out.println();
		System.out.println(ans());
	}
	
	public static void cleanup() {
		list[nowy][nowx] = 2;
		printlist();
		while(true) {
			int cnt = 0;
			printlist();
			System.out.println();
			while(true) {
				if(list[nowy][nowx]==0) {
					list[nowy][nowx] = 2;
					printlist();
				}
				if(cnt==4) {
					break;
				}
				if(dir==0) {
					if(nowx-1>=0 && list[nowy][nowx-1]==0) {
						list[nowy][nowx-1] = 2;
						printlist();
						nowx = nowx-1;
						cnt = 0;
					} else {
						cnt++;
					}
					dir = 3;
				} else if(dir==1) {
					if(nowy-1>=0 && list[nowy-1][nowx]==0) {
						list[nowy-1][nowx] = 2;
						printlist();
						nowy = nowy-1;
						cnt = 0;
					} else {
						cnt++;
					}
					dir = 0;
				} else if(dir==2) {
					if(nowx+1<=M && list[nowy][nowx+1]==0) {
						list[nowy][nowx+1] = 2;
						printlist();
						nowx = nowx+1;
						cnt = 0;
					} else {
						cnt++;
					}
					dir = 1;
				} else {
					if(nowy+1<=N && list[nowy+1][nowx]==0) {
						list[nowy+1][nowx] = 2;
						printlist();
						nowy = nowy+1;
						cnt = 0;
					} else {
						cnt++;
					}
					dir = 2;
				}
			}
			if(dir==0) {
				if(list[nowy+1][nowx]==1) {
					break;
				} else {
					nowy = nowy+1;
				}
			} else if(dir==1) {
				if(list[nowy][nowx-1]==1) {
					break;
				} else {
					nowx = nowx-1;
				}
			} else if(dir==2) {
				if(list[nowy-1][nowx]==1) {
					break;
				} else {
					nowy = nowy-1;
				}
			} else {
				if(list[nowy][nowx+1]==1) {
					break;
				} else {
					nowx = nowx+1;
				}
			}
		}
	}
	
	public static void printlist() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(list[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static int ans() {
		int temp = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(list[i][j]==2) temp++;
			}
		}
		return temp;
	}

}
