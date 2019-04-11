package algorithmEx;

//틀렸던 이유 : 4방향 탐색할때 k 아니라 i 넣어서, visited 배열 초기화 잘못해서(초기화문을 if문에 넣음)

import java.util.*;

class nation {
	int y;
	int x;
	int pop;
	int union;
	public nation(int y, int x, int pop, int union) {
		this.y = y;
		this.x = x;
		this.pop = pop;
		this.union = union;
	}
}

public class bj_16234 {
	
	static int N,L,R;
	static nation[][] map;
	static boolean[][] visited;
	static int cnt = 0;
	static boolean isend = false;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static ArrayList<Integer> nationpoplist = new ArrayList<Integer>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();
		map = new nation[N][N];
		visited = new boolean[N][N];
		for(int i=0;i<N;i++) { // 초기 맵 설정
			for(int j=0;j<N;j++) {
				map[i][j] = new nation(i,j,sc.nextInt(),0);
				visited[i][j] = false;
			}
		}
//		System.out.println(L+" "+R);
		while(!isend) {
			move();
//			printunion();
			check();
//			printpop();
			cnt++;
		}
		System.out.println(cnt-1);
	}
	
	public static void move() {
		int unionnum = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(visited[i][j]==false) {
//					printv();
					boolean ismove = false;
					visited[i][j] = true;
					Queue<nation> q = new LinkedList<>();
					int totalpop = 0;
					int numOfunion = 0;
					boolean ok = false;
					q.offer(map[i][j]);
					while(!q.isEmpty()) {
						nation n = q.poll();
						int y = n.y;
						int x = n.x;
						int pop = n.pop;
						totalpop += pop;
						numOfunion++;
						for(int k=0;k<4;k++) {
							int ny = y + dy[k];
							int nx = x + dx[k];
//							if(nx>=0 && nx<N && ny>=0 && ny<N)
//								System.out.println(Math.abs(map[y][x].pop-map[ny][nx].pop));
							if(nx>=0 && nx<N && ny>=0 && ny<N && visited[ny][nx]==false 
									&& Math.abs(map[y][x].pop-map[ny][nx].pop)>=L && Math.abs(map[y][x].pop-map[ny][nx].pop)<=R) {
//								System.out.println("here");
								if(ok==false) {
									ismove = true;
									ok = true;
									unionnum++;
									map[y][x].union = unionnum; // 처음 시작지점 union 넘버
								}
								map[ny][nx].union = unionnum;
								q.offer(map[ny][nx]);
								visited[ny][nx] = true;
							}
						}
					}
					int popAftermove = totalpop/numOfunion;
					if(ismove==true) {
						nationpoplist.add(popAftermove);
					}
				}
			}
		}
		if(unionnum==0) {
			isend = true;
		}
		
	}
	
	public static void check() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j].union>0) {
					map[i][j].pop = nationpoplist.get(map[i][j].union-1);
				}
				visited[i][j] = false;
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j].union = 0;
			}
		}
		nationpoplist.clear();
	}
	
	public static void printpop() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(map[i][j].pop+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void printunion() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(map[i][j].union+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void printv() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(visited[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
