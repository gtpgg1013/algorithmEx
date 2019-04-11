package algorithmEx;

// 이 문제를 풀면서 어려웠고 시간이 많이 들었던 이유 : 루프를 너무 복잡하게 짬
// 제발 초기화 시키는 식 if문안에 넣지 말아라 - visited배열이 초기화 되지 않아서 문제 계속 틀림

import java.util.*;

public class bj_14890_re {
	
	static int N,L;
	static int[][] map;
	static boolean[] visited;
	
	static int ans = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		map = new int[N][N];
		visited = new boolean[N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j] = sc.nextInt();
			}
			visited[i] = false;
		}
		checkg();
		checks();
		System.out.println(ans);
	}
	
	public static void checkg() {
		for(int i=0;i<N;i++) { // 가로 시작
			boolean disable = false;
			for(int j=0;j<N-1;j++) { // 왼쪽 시작
				int nj = j+1;
				if(map[i][j]==map[i][nj]) continue;
				if(map[i][j]-map[i][nj]>1) { // 높이차 2 이상
					disable = true;
					break;
				}
				if(map[i][j]-map[i][nj]==1) { // 높이차 1
					for(int k=0;k<L;k++) {
						if(nj+k>N-1) { // 지지대가 벗어나면
							disable = true;
							for(int a=0;a<N;a++) {
								visited[a] = false;
							}
							break;
						}
						if(map[i][nj+k]!=map[i][nj]) { // 놓아야할 곳 높이가 균일하지 않으면
							disable = true;
							for(int a=0;a<N;a++) {
								visited[a] = false;
							}
							break;
						}
						if(map[i][nj+k]==map[i][nj]) { // 균일하면
							if(visited[nj+k] == true) {
								for(int a=0;a<N;a++) {
									visited[a] = false;
								}
								disable = true;
								break;
							}
							visited[nj+k] = true;
						}
					}
				}
			}
			
			for(int j=N-1;j>=1;j--) { // 오른쪽 시작
				if(disable==true) break;
				int nj = j-1;
				if(map[i][j]==map[i][nj]) continue;
				if(map[i][j]-map[i][nj]>1) { // 높이차 2 이상
					disable = true;
					break;
				}
				if(map[i][j]-map[i][nj]==1) { // 높이차 1
					for(int k=0;k<L;k++) {
						if(nj-k<0) { // 지지대가 벗어나면
							disable = true;
							for(int a=0;a<N;a++) {
								visited[a] = false;
							}
							break;
						}
						if(map[i][nj-k]!=map[i][nj]) { // 놓아야할 곳 높이가 균일하지 않으면
							disable = true;
							for(int a=0;a<N;a++) {
								visited[a] = false;
							}
							break;
						}
						if(map[i][nj-k]==map[i][nj]) { // 균일하면
							if(visited[nj-k] == true) {
								for(int a=0;a<N;a++) {
									visited[a] = false;
								}
								disable = true;
								break;
							}
							visited[nj-k] = true;
						}
					}
				}
			}
			if(disable==false) {
				ans++;
//				System.out.println(i);
			}
			for(int a=0;a<N;a++) {
				visited[a] = false;
			}
		}
	}
	
	public static void checks() {
		for(int i=0;i<N;i++) { // 세로
			boolean disable = false;
			for(int j=0;j<N-1;j++) { // 왼쪽 시작
				int nj = j+1;
				if(map[j][i]==map[nj][i]) continue;
				if(map[j][i]-map[nj][i]>1) { // 높이차 2 이상
					disable = true;
					break;
				}
				if(map[j][i]-map[nj][i]==1) { // 높이차 1
					for(int k=0;k<L;k++) {
						if(nj+k>N-1) { // 지지대가 벗어나면
//							printvis();
							disable = true;
							for(int a=0;a<N;a++) {
								visited[a] = false;
							}
							break;
						}
						if(map[nj+k][i]!=map[nj][i]) { // 놓아야할 곳 높이가 균일하지 않으면
							disable = true;
							for(int a=0;a<N;a++) {
								visited[a] = false;
							}
							break;
						}
						if(map[nj+k][i]==map[nj][i]) { // 균일하면
							if(visited[nj+k] == true) {
								for(int a=0;a<N;a++) {
									visited[a] = false;
								}
								disable = true;
								break;
							}
							visited[nj+k] = true;
						}
					}
				}
			}
			
			for(int j=N-1;j>=1;j--) { // 오른쪽 시작
				if(disable==true) break;
				int nj = j-1;
				if(map[j][i]==map[nj][i]) continue;
				if(map[j][i]-map[nj][i]>1) { // 높이차 2 이상
					disable = true;
					break;
				}
				if(map[j][i]-map[nj][i]==1) { // 높이차 1
					for(int k=0;k<L;k++) {
						if(nj-k<0) { // 지지대가 벗어나면
							disable = true;
							for(int a=0;a<N;a++) {
								visited[a] = false;
							}
							break;
						}
						if(map[nj-k][i]!=map[nj][i]) { // 놓아야할 곳 높이가 균일하지 않으면
							disable = true;
							for(int a=0;a<N;a++) {
								visited[a] = false;
							}
							break;
						}
						if(map[nj-k][i]==map[nj][i]) { // 균일하면
							if(visited[nj-k] == true) {
								for(int a=0;a<N;a++) {
									visited[a] = false;
								}
								disable = true;
								break;
							}
							visited[nj-k] = true;
						}
					}
				}
			}
			if(disable==false) {
				ans++;
//				System.out.println(i);
			}
			for(int a=0;a<N;a++) {
				visited[a] = false;
			}
		}
	}
	
	public static void printvis() {
		for(int i=0;i<N;i++) {
			System.out.print(visited[i]+" ");
		}
		System.out.println();
	}

}
