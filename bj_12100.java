package algorithmEx;

import java.util.*;

public class bj_12100 {
	
	static int N;
	static int answer;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int temp = sc.nextInt();
				map[i][j] = temp;
			}
		}
		
		for(int i=0;i<4;i++) {
			move(i,0);
		}
		System.out.println(answer);
	}
	
	public static void move(int dir, int depth) {
		if(depth>=5) { // depth를 5 이상까지 해줘야 하는 거시다.
			calc();
			return;
		}
		
		if(dir==0) { // 왼 - 위 - 오 - 아 순서 // 그리고 이동시키고 merge 해야 함
			int[][] tempmap = save();
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					int cnt = 0;
					while(j-cnt-1>=0 && j-cnt-1<N && map[i][j-cnt-1]==0) {
						 map[i][j-cnt-1] = map[i][j-cnt];
						 map[i][j-cnt] = 0;
						 cnt++;
					}
				}
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(j+1<N && map[i][j]!=0 && map[i][j]==map[i][j+1]) {
						map[i][j] = 2*map[i][j];
						map[i][j+1] = 0;
					}
				}
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					int cnt = 0;
					while(j-cnt-1>=0 && j-cnt-1<N && map[i][j-cnt-1]==0) {
						 map[i][j-cnt-1] = map[i][j-cnt];
						 map[i][j-cnt] = 0;
						 cnt++;
					}
				}
			}
			move(0,depth+1);
			move(1,depth+1);
			move(2,depth+1);
			move(3,depth+1);
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j] = tempmap[i][j];
				}
			}
			
		} else if(dir==1) {
			int[][] tempmap = save();
			for(int j=0;j<N;j++) {
				for(int i=0;i<N;i++) {
					int cnt = 0;
					while(i-cnt-1>=0 && i-cnt-1<N && map[i-cnt-1][j]==0) {
						 map[i-cnt-1][j] = map[i-cnt][j];
						 map[i-cnt][j] = 0;
						 cnt++;
					}
				}
			}
			for(int j=0;j<N;j++) {
				for(int i=0;i<N;i++) {
					if(i+1<N && map[i][j]!=0 && map[i][j]==map[i+1][j]) {
						map[i][j] = 2*map[i][j];
						map[i+1][j] = 0;
					}
				}
			}
			for(int j=0;j<N;j++) {
				for(int i=0;i<N;i++) {
					int cnt = 0;
					while(i-cnt-1>=0 && i-cnt-1<N && map[i-cnt-1][j]==0) {
						 map[i-cnt-1][j] = map[i-cnt][j];
						 map[i-cnt][j] = 0;
						 cnt++;
					}
				}
			}
			move(0,depth+1);
			move(1,depth+1);
			move(2,depth+1);
			move(3,depth+1);
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j] = tempmap[i][j];
				}
			}
			
		} else if(dir==2) {
			int[][] tempmap = save();
			for(int i=0;i<N;i++) {
				for(int j=N-1;j>=0;j--) {
					int cnt = 0;
					while(j+cnt+1>=0 && j+cnt+1<N && map[i][j+cnt+1]==0) {
						 map[i][j+cnt+1] = map[i][j+cnt];
						 map[i][j+cnt] = 0;
						 cnt++;
					}
				}
			}
			for(int i=0;i<N;i++) {
				for(int j=N-1;j>=0;j--) {
					if(j-1>=0 && map[i][j]!=0 && map[i][j]==map[i][j-1]) {
						map[i][j] = 2*map[i][j];
						map[i][j-1] = 0;
					}
				}
			}
			for(int i=0;i<N;i++) {
				for(int j=N-1;j>=0;j--) {
					int cnt = 0;
					while(j+cnt+1>=0 && j+cnt+1<N && map[i][j+cnt+1]==0) {
						 map[i][j+cnt+1] = map[i][j+cnt];
						 map[i][j+cnt] = 0;
						 cnt++;
					}
				}
			}
			move(0,depth+1);
			move(1,depth+1);
			move(2,depth+1);
			move(3,depth+1);
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j] = tempmap[i][j];
				}
			}
			
		} else {
			int[][] tempmap = save();
			for(int j=0;j<N;j++) {
				for(int i=N-1;i>=0;i--) {
					int cnt = 0;
					while(i+cnt+1>=0 && i+cnt+1<N && map[i+cnt+1][j]==0) {
						 map[i+cnt+1][j] = map[i+cnt][j];
						 map[i+cnt][j] = 0;
						 cnt++;
					}
				}
			}
			for(int j=0;j<N;j++) {
				for(int i=N-1;i>=0;i--) {
					if(i-1>=0 && map[i][j]!=0 && map[i][j]==map[i-1][j]) {
						map[i][j] = 2*map[i][j];
						map[i-1][j] = 0;
					}
				}
			}
			for(int j=0;j<N;j++) {
				for(int i=N-1;i>=0;i--) {
					int cnt = 0;
					while(i+cnt+1>=0 && i+cnt+1<N && map[i+cnt+1][j]==0) {
						 map[i+cnt+1][j] = map[i+cnt][j];
						 map[i+cnt][j] = 0;
						 cnt++;
					}
				}
			}
			move(0,depth+1);
			move(1,depth+1);
			move(2,depth+1);
			move(3,depth+1);
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j] = tempmap[i][j];
				}
			}
		}
	}
	
	public static int[][] save() {
		int[][] tempmap = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				tempmap[i][j] = map[i][j];
			}
		}
		return tempmap;
	}
	
	public static void calc() {
		int val = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j] > val) {
					val = map[i][j];
				}
			}
		}
		if(val>answer) {
			answer = val;
		}
	}
	
	public static void merge() {
		
	}
}
