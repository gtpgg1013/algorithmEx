// 시간초과 난 건 백준에 있음

package algorithmEx;

import java.util.*;

class dot {
	int z;
	int y;
	int x;
	int day;
	public dot(int z, int y, int x, int day) {
		super();
		this.z = z;
		this.y = y;
		this.x = x;
		this.day = day;
	}
}

public class bj_7569 {

	static Queue<dot> q = new LinkedList<dot>();
	static int[][][] box;
	static int[][][] temp;
	static int dx[] = {0,0,1,-1,0,0};
	static int dy[] = {0,0,0,0,-1,1};
	static int dz[] = {-1,1,0,0,0,0};
	static int ans = 0;
	static int m, n, h;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		h = sc.nextInt();
		box = new int[h][n][m];
		temp = new int[h][n][m];
		for(int i=0;i<h;i++) {
			for(int j=0;j<n;j++) {
				for(int k=0;k<m;k++) {
					box[i][j][k] = sc.nextInt();
					temp[i][j][k] = -1;
				}
			}
		}
		
		for(int i=0;i<box.length;i++) {
			for(int j=0;j<box[0].length;j++) {
				for(int k=0;k<box[0][0].length;k++) {
					if(box[i][j][k]==1) {
						q.add(new dot(i,j,k,0));
					}
				}
			}
		}
		
		bfs();

		if(checkend(box)==false)
			ans = -1;
		System.out.println(ans);
	}
	
	// bfs 반복 종료조건 : 전의것과 다음것이 같으면
	public static void bfs() {
		while(!q.isEmpty()) {
			dot tempdot = q.poll();
			int x = tempdot.x;
			int y = tempdot.y;
			int z = tempdot.z;
			int day = tempdot.day;
			for(int i=0;i<6;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				int nz = z + dz[i];
				
				if(nx>=0 && ny>=0 && nz>=0 && nx<m && ny<n && nz<h) {
					if(box[nz][ny][nx]==0) {
						box[nz][ny][nx]=1;
						if(day+1>ans)
							ans = day+1;
						q.add(new dot(nz,ny,nx,day+1));
						printbox(box);
					}
				}
			}
			
		}
		
	}
	
	public static boolean checkend(int[][][] box) {
		boolean check = true;
		for(int i=0;i<box.length;i++) {
			for(int j=0;j<box[0].length;j++) {
				for(int k=0;k<box[0][0].length;k++) {
					if(box[i][j][k]==0) {
						check = false;
						break;
					}
				}
				if(check!=true) break;
			}
			if(check!=true) break;
		}
		return check;
	}
	
	public static void printbox(int[][][] box) {
		for(int i=0;i<box.length;i++) {
			for(int j=0;j<box[0].length;j++) {
				for(int k=0;k<box[0][0].length;k++) {
					System.out.print(box[i][j][k]+" ");
				}
				System.out.println();
			}
		}
		System.out.println();
	}
	
	public static boolean same(int[][][] a, int[][][] b) {
		boolean check = true;
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[0].length;j++) {
				for(int k=0;k<a[0][0].length;k++) {
					if(a[i][j][k]!=b[i][j][k]) {
						check = false;
						break;
					}
				}
				if(check!=true) break;
			}
			if(check!=true) break;
		}
		return check;
	}

}
