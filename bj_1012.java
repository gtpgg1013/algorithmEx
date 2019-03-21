// Queue에 중복되지 않게 하는 게 중요함! line 98!

package algorithmEx;

import java.util.*;

class xyb {
	int y;
	int x;
	public xyb(int y, int x) {
		super();
		this.y = y;
		this.x = x;
	}
}

public class bj_1012 {
	
	static int t;
	static int[][] list;
	static boolean[][] visitlist;
	static int a,b;
	static int num;
	static int wormcount = 0;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static ArrayList<Integer> answer = new ArrayList<Integer>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		for(int i=0;i<t;i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			list = new int[b][a];
			visitlist = new boolean[b][a];
			num = sc.nextInt();
			for(int j=0;j<num;j++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				list[y][x] = 1;
			}
			for(int u=0;u<b;u++) {
				for(int v=0;v<a;v++) {
					if(list[u][v]==1 && visitlist[u][v]==false) {
						bfs(u,v);
						wormcount++;
					}
				}
			}
			answer.add(wormcount);
			wormcount = 0;
		}
		for(int i=0;i<answer.size();i++) {
			System.out.println(answer.get(i));
		}
	}
	
	public static void clearlist() {
		for(int i=0;i<list.length;i++) {
			for(int j=0;j<list[0].length;j++) {
				list[i][j] = 0;
			}
		}
	}
	
	public static void cleartemplist() {
		for(int i=0;i<visitlist.length;i++) {
			for(int j=0;j<visitlist[0].length;j++) {
				visitlist[i][j] = false;
			}
		}
	}
	
	public static void printlist() {
		for(int i=0;i<list.length;i++) {
			for(int j=0;j<list[0].length;j++) {
				System.out.print(list[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	
	public static void bfs(int u, int v) {
		Queue<xyb> q = new LinkedList<xyb>();
		q.add(new xyb(u,v));
		visitlist[u][v] = true;
		while(!q.isEmpty()) {
			xyb temp = q.poll();
			int x = temp.x;
			int y = temp.y;
			for(int i=0;i<dx.length;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx>=0 && ny>=0 && nx<a && ny<b) {
					if(list[ny][nx]==1 && visitlist[ny][nx]==false) {
						visitlist[ny][nx]=true;
						q.add(new xyb(ny,nx));
					}
				}
			}
		}
	}
}
