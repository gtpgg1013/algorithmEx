package algorithmEx;

import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

class xy {
	int row;
	int col;
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	
}


public class bj_14502_re {

	static Scanner sc = new Scanner(System.in);
	static int N, M;
	static int[][] map;
	static int[][] temp_map;
	static int ori_wall;
	static Queue<xy> q = new LinkedList<xy>();
	static int drow[] = {0,1,0,-1};
	static int dcol[] = {1,0,-1,0};
	static int ans = -100;
	final static int EMPTY = 0;
	final static int WALL = 1;
	final static int VIRUS = 2;
	
	public static void main(String[] args) {
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		temp_map = new int[N][M];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				temp_map[i][j] = map[i][j];
				if(temp_map[i][j]==WALL)
					ori_wall++;
			}
		}
		bulidWall();
		System.out.println(ans);
	}
	
	public static void printMap(int[][] a) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}

	}
	
	public static void bfs() {
		
		// VIRUS 체크한 곳 체크하는 칸
		boolean check[][] = new boolean[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				check[i][j]=false;
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==VIRUS) {
					xy temp = new xy();
					temp.setRow(i);
					temp.setCol(j);
					check[i][j]=true;
					q.offer(temp);
				}
			}
		}
		
		while(!q.isEmpty()) {
			xy front = new xy();
			front.setRow(q.peek().getRow());
			front.setCol(q.peek().getCol());
			
			for(int i=0;i<4;i++) {
				if(front.getRow()+drow[i]>-1&&front.getRow()+drow[i]<N
					&&front.getCol()+dcol[i]>-1&&front.getCol()+dcol[i]<M) {
					if(map[front.getRow()+drow[i]][front.getCol()+dcol[i]]==EMPTY
						&&check[front.getRow()+drow[i]][front.getCol()+dcol[i]]==false) {
						xy temp = new xy();
						int temp_row = front.getRow()+drow[i];
						int temp_col = front.getCol()+dcol[i];
						temp.setRow(temp_row);
						temp.setCol(temp_col);
						map[temp_row][temp_col]=VIRUS;
						check[temp_row][temp_col]=true;
						q.offer(temp);
					}
				}
			}
			q.poll();
		}
	}
	
	public static void bulidWall() {
		for(int a=0;a<N;a++) {
			for(int b=0;b<M;b++) {
				for(int c=0;c<N;c++) {
					for(int d=0;d<M;d++) {
						for(int e=0;e<N;e++) {
							for(int f=0;f<M;f++) {
								if(map[a][b]!=EMPTY || map[c][d]!=EMPTY || map[e][f]!=EMPTY) {
									for(int i=0;i<N;i++) {
										for(int j=0;j<M;j++) {
											map[i][j] = WALL;
										}
									}
								}
								if(map[a][b]==EMPTY) {
									map[a][b]=WALL; 
								}
								if(map[c][d]==EMPTY) {
									map[c][d]=WALL;
								}
								if(map[e][f]==EMPTY) {
									map[e][f]=WALL;
								}
								if((a==c&&b==d) || (a==e&&b==f) || (c==e&&d==f)) {
									for(int i=0;i<N;i++) {
										for(int j=0;j<M;j++) {
											map[i][j] = WALL;
										}
									}
								}
								bfs();
								if(countEmpty(map)>ans) {
									ans=countEmpty(map);
								}
								clearmap();
							}
						}
					}
				}
			}
		}
	}
	
	public static void clearmap() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				map[i][j] = temp_map[i][j];
			}
		}
	}
	
	public static int countEmpty(int[][] a) {
		int count = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==EMPTY) {
					count++;
				}
			}
		}
		return count;
	}
}
