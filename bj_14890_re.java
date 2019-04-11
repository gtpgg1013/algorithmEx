package algorithmEx;

// �� ������ Ǯ�鼭 ������� �ð��� ���� ����� ���� : ������ �ʹ� �����ϰ� «
// ���� �ʱ�ȭ ��Ű�� �� if���ȿ� ���� ���ƶ� - visited�迭�� �ʱ�ȭ ���� �ʾƼ� ���� ��� Ʋ��

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
		for(int i=0;i<N;i++) { // ���� ����
			boolean disable = false;
			for(int j=0;j<N-1;j++) { // ���� ����
				int nj = j+1;
				if(map[i][j]==map[i][nj]) continue;
				if(map[i][j]-map[i][nj]>1) { // ������ 2 �̻�
					disable = true;
					break;
				}
				if(map[i][j]-map[i][nj]==1) { // ������ 1
					for(int k=0;k<L;k++) {
						if(nj+k>N-1) { // �����밡 �����
							disable = true;
							for(int a=0;a<N;a++) {
								visited[a] = false;
							}
							break;
						}
						if(map[i][nj+k]!=map[i][nj]) { // ���ƾ��� �� ���̰� �������� ������
							disable = true;
							for(int a=0;a<N;a++) {
								visited[a] = false;
							}
							break;
						}
						if(map[i][nj+k]==map[i][nj]) { // �����ϸ�
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
			
			for(int j=N-1;j>=1;j--) { // ������ ����
				if(disable==true) break;
				int nj = j-1;
				if(map[i][j]==map[i][nj]) continue;
				if(map[i][j]-map[i][nj]>1) { // ������ 2 �̻�
					disable = true;
					break;
				}
				if(map[i][j]-map[i][nj]==1) { // ������ 1
					for(int k=0;k<L;k++) {
						if(nj-k<0) { // �����밡 �����
							disable = true;
							for(int a=0;a<N;a++) {
								visited[a] = false;
							}
							break;
						}
						if(map[i][nj-k]!=map[i][nj]) { // ���ƾ��� �� ���̰� �������� ������
							disable = true;
							for(int a=0;a<N;a++) {
								visited[a] = false;
							}
							break;
						}
						if(map[i][nj-k]==map[i][nj]) { // �����ϸ�
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
		for(int i=0;i<N;i++) { // ����
			boolean disable = false;
			for(int j=0;j<N-1;j++) { // ���� ����
				int nj = j+1;
				if(map[j][i]==map[nj][i]) continue;
				if(map[j][i]-map[nj][i]>1) { // ������ 2 �̻�
					disable = true;
					break;
				}
				if(map[j][i]-map[nj][i]==1) { // ������ 1
					for(int k=0;k<L;k++) {
						if(nj+k>N-1) { // �����밡 �����
//							printvis();
							disable = true;
							for(int a=0;a<N;a++) {
								visited[a] = false;
							}
							break;
						}
						if(map[nj+k][i]!=map[nj][i]) { // ���ƾ��� �� ���̰� �������� ������
							disable = true;
							for(int a=0;a<N;a++) {
								visited[a] = false;
							}
							break;
						}
						if(map[nj+k][i]==map[nj][i]) { // �����ϸ�
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
			
			for(int j=N-1;j>=1;j--) { // ������ ����
				if(disable==true) break;
				int nj = j-1;
				if(map[j][i]==map[nj][i]) continue;
				if(map[j][i]-map[nj][i]>1) { // ������ 2 �̻�
					disable = true;
					break;
				}
				if(map[j][i]-map[nj][i]==1) { // ������ 1
					for(int k=0;k<L;k++) {
						if(nj-k<0) { // �����밡 �����
							disable = true;
							for(int a=0;a<N;a++) {
								visited[a] = false;
							}
							break;
						}
						if(map[nj-k][i]!=map[nj][i]) { // ���ƾ��� �� ���̰� �������� ������
							disable = true;
							for(int a=0;a<N;a++) {
								visited[a] = false;
							}
							break;
						}
						if(map[nj-k][i]==map[nj][i]) { // �����ϸ�
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
