package algorithmEx;

import java.util.*;

public class bj_15683_re {
	
	static int N,M;
	static int[][] map;
	static int ans = 100000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				int temp = sc.nextInt();
				map[i][j] = temp;
			}
		}
//		print(map);
//		down(3,3,map);
//		print(map);
		dfs(0,0,map);
		if(ans==100000)
			System.out.println(0);
		else {
		System.out.println(ans);
		}
	}
	
	public static void dfs(int y, int x, int[][] m) {
//		System.out.println(x);
//			print(m);
//			System.out.println(y+" "+x);
		if(x==M && y==N-1) {
//			System.out.println("AA");
			mapcheck(m);
			return;			
		}
		if(x==M) {
			y = y + 1;
			x = 0;
//			System.out.println(y+" "+x);
//			System.out.println();
		}
		
		int[][] tempm = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				tempm[i][j] = m[i][j];
			}
		}
		
//		for(int i=y;i<N;i++) {
//			for(int j=x;j<M;j++) {
//				print(tempm);
//				System.out.println(j);
				if(m[y][x]==1) {
					right(y,x,m);
//					print(m);
					dfs(y,x+1,m);
					for(int a=0;a<N;a++) {
						for(int b=0;b<M;b++) {
							m[a][b] = tempm[a][b];
						}
					}
					left(y,x,m);
					dfs(y,x+1,m);
					for(int a=0;a<N;a++) {
						for(int b=0;b<M;b++) {
							m[a][b] = tempm[a][b];
						}
					}
					up(y,x,m);
					dfs(y,x+1,m);
					for(int a=0;a<N;a++) {
						for(int b=0;b<M;b++) {
							m[a][b] = tempm[a][b];
						}
					}
					down(y,x,m);
					dfs(y,x+1,m);
					for(int a=0;a<N;a++) {
						for(int b=0;b<M;b++) {
							m[a][b] = tempm[a][b];
						}
					}
				}
				else if(tempm[y][x]==2) {
					left(y,x,m);
					right(y,x,m);
					dfs(y,x+1,m);
					for(int a=0;a<N;a++) {
						for(int b=0;b<M;b++) {
							m[a][b] = tempm[a][b];
						}
					}
					up(y,x,m);
					down(y,x,m);
					dfs(y,x+1,m);
					for(int a=0;a<N;a++) {
						for(int b=0;b<M;b++) {
							m[a][b] = tempm[a][b];
						}
					}
				}
				else if(tempm[y][x]==3) {
					right(y,x,m);
					down(y,x,m);
					dfs(y,x+1,m);
					for(int a=0;a<N;a++) {
						for(int b=0;b<M;b++) {
							m[a][b] = tempm[a][b];
						}
					}
					down(y,x,m);
					left(y,x,m);
					dfs(y,x+1,m);
					for(int a=0;a<N;a++) {
						for(int b=0;b<M;b++) {
							m[a][b] = tempm[a][b];
						}
					}
					left(y,x,m);
					up(y,x,m);
					dfs(y,x+1,m);
					for(int a=0;a<N;a++) {
						for(int b=0;b<M;b++) {
							m[a][b] = tempm[a][b];
						}
					}
					up(y,x,m);
					right(y,x,m);
					dfs(y,x+1,m);
					for(int a=0;a<N;a++) {
						for(int b=0;b<M;b++) {
							m[a][b] = tempm[a][b];
						}
					}
				}
				else if(tempm[y][x]==4) {
					right(y,x,m);
					down(y,x,m);
					left(y,x,m);
					dfs(y,x+1,m);
					for(int a=0;a<N;a++) {
						for(int b=0;b<M;b++) {
							m[a][b] = tempm[a][b];
						}
					}
					up(y,x,m);
					down(y,x,m);
					left(y,x,m);
					dfs(y,x+1,m);
					for(int a=0;a<N;a++) {
						for(int b=0;b<M;b++) {
							m[a][b] = tempm[a][b];
						}
					}
					right(y,x,m);
					left(y,x,m);
					up(y,x,m);
					dfs(y,x+1,m);
					for(int a=0;a<N;a++) {
						for(int b=0;b<M;b++) {
							m[a][b] = tempm[a][b];
						}
					}
					up(y,x,m);
					right(y,x,m);
					down(y,x,m);
					dfs(y,x+1,m);
					for(int a=0;a<N;a++) {
						for(int b=0;b<M;b++) {
							m[a][b] = tempm[a][b];
						}
					}
				}
				else if(tempm[y][x]==5) {
					up(y,x,m);
					right(y,x,m);
					down(y,x,m);
					left(y,x,m);
					dfs(y,x+1,m);
					for(int a=0;a<N;a++) {
						for(int b=0;b<M;b++) {
							m[a][b] = tempm[a][b];
						}
					}
				} else {
					dfs(y,x+1,m);
				}
//			}
//		}
	}
	
	public static void right(int y, int x, int[][] m) {
		int nx = x + 1;
		while(true) {
			if(y<0 || y>N || nx>M-1 || m[y][nx]==6) {
				break;
			}
			if(m[y][nx]==0) {
				m[y][nx] = -1;
			}
			nx++;
		}
	}
	
	public static void left(int y, int x, int[][] m) {
		int nx = x - 1;
		while(true) {
			if(y<0 || y>N || nx<0 || m[y][nx]==6) {
				break;
			}
			if(m[y][nx]==0) {
				m[y][nx] = -1;
			}
			nx--;
		}
	}
	
	public static void up(int y, int x, int[][] m) {
		int ny = y - 1;
		while(true) {
			if(x<0 || x>M || ny<0 || m[ny][x]==6) {
				break;
			}
			if(m[ny][x]==0) {
				m[ny][x] = -1;
			}
			ny--;
		}
	}
	
	public static void down(int y, int x, int[][] m) {
		int ny = y + 1;
		while(true) {
			if(x<0 || x>M || ny>N-1 || m[ny][x]==6) {
				break;
			}
			if(m[ny][x]==0) {
				m[ny][x] = -1;
			}
			ny++;
		}
	}
	
	public static void mapcheck(int[][] m) {
		int n = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(m[i][j]==0) {
					n++;
				}
			}
		}
		ans = Math.min(n, ans);
	}
	
	public static void print(int[][] m) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(m[i][j]+ " ");
			}
			System.out.println();
		}
	}

}
