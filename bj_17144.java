package algorithmEx;

import java.util.*;

public class bj_17144 {
	
	static int R,C,T;
	static int map[][];
	static int ucr, ucc, dcr, dcc;
	static int[] dr = {1,0,-1,0};
	static int[] dc = {0,1,0,-1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		T = sc.nextInt();
		map = new int[R][C];
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				int temp = sc.nextInt();
				map[i][j] = temp;
				if(temp==-1) {
					ucr = i-1;
					ucc = j;
					dcr = i;
					dcc = j;
				}
			}
		}
		
		int time = 0;
		while(time<T) {
			int[][] tempmap = new int[R][C];
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					int remain = map[i][j];
					int spreaded = remain/5;
					if(remain>=5) {
						for(int k=0;k<4;k++) {
							int nexti = i + dr[k];
							int nextj = j + dc[k];
							if(nexti>=0 && nexti<=R-1 && nextj>=0 && nextj<=C-1 && map[nexti][nextj]!=-1) {
								tempmap[nexti][nextj] = tempmap[nexti][nextj] + spreaded;
								remain = remain - spreaded;
							}
						}
						tempmap[i][j] += remain;
					}
					else if(remain>=0 && remain<5) {
						tempmap[i][j] += map[i][j];
					}
					else if(remain==-1) {
						tempmap[i][j] = -1;
					}
				}
			}
			
//			printmap(tempmap);
			
			int tempr = 0;
			int tempc = 0;
			tempr = ucr;
			while(tempr-2>=0) {
				tempmap[tempr-1][0] = tempmap[tempr-2][0];
				tempr--;
			}
			
//			printmap(tempmap);
//			System.out.println("here");
			tempc = 0;
			while(tempc+1<C) {
				tempmap[0][tempc] = tempmap[0][tempc+1];
				tempc++;
			}
			
//			printmap(tempmap);
			
			tempr = 0;
			while(tempr<ucr) {
				tempmap[tempr][C-1] = tempmap[tempr+1][C-1];
				tempr++;
			}
			
//			printmap(tempmap);
			
			tempc = C-1;
			while(tempc-1>0) {
				tempmap[ucr][tempc] = tempmap[ucr][tempc-1];
				tempc--;
			}
			
//			printmap(tempmap);
			
			tempr = dcr;
//			System.out.println("real");
			while(tempr+2<R) {
				tempmap[tempr+1][0] = tempmap[tempr+2][0];
				tempr++;
			}
//			printmap(tempmap);
			tempc = 0;
			while(tempc+1<C) {
				tempmap[R-1][tempc] = tempmap[R-1][tempc+1];
				tempc++;
			}
//			printmap(tempmap);
			tempr = R-1;
			while(tempr>dcr) {
				tempmap[tempr][C-1] = tempmap[tempr-1][C-1];
				tempr--;
			}
//			printmap(tempmap);
			tempc = C-1;
			while(tempc-1>0) {
				tempmap[dcr][tempc] = tempmap[dcr][tempc-1];
				tempc--;
			}
//			printmap(tempmap);
			tempmap[ucr][ucc+1] = 0;
			tempmap[dcr][dcc+1] = 0;
//			printmap(tempmap);
			
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					map[i][j] = tempmap[i][j];
				}
			}
			
//			System.out.println(time+1+"end");
			time++;
		}
		
		int ans = 0;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]!=-1) {
					ans += map[i][j];
				}
			}
		}
		
		System.out.println(ans);
	}
	
	public static void printmap(int[][] m) {
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				System.out.print(m[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
