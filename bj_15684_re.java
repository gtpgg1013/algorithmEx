package algorithmEx;

// ����ġ�� �����ָ� �ð��ʰ���
// Ʋ�������� 64��° ���� ���ÿ�

import java.util.*;

public class bj_15684_re {
	
	static int N,M,H;
	static int[][] map;
	static int ans = 1000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		H = sc.nextInt();
		map = new int[H+2][N+2];
		
		for(int i=0;i<H+2;i++) {
			for(int j=0;j<N+2;j++) {
				map[i][j] = 0;
			}
		}
		
		for(int i=0;i<M;i++) { // �⺻ �� ����
			int a = sc.nextInt();
			int b = sc.nextInt();
			map[a][b] = 1;
			map[a][b+1] = 2;
		}
		dfs(0);
		if(ans==1000) {
			ans = -1;
		}
		System.out.println(ans);
	}
	
	public static boolean checkm() {
		boolean ck = true;
		for(int i=1;i<N+1;i++) {
			int start = i;
			int end = i;
			int y = 1;
			while(y<H+1) {
				if(map[y][end]==0) {
					y++;
				} else if(map[y][end]==1) {
					end++;
					y++;
				} else { // 2�϶�
					end--;
					y++;
				}
			}
			if(start!=end) {
				ck = false;
				break;
			}
		}
		return ck;
	}
	
	public static void dfs(int depth) {
		if(depth>=ans) { // ��ó���� ���ڸ��� || depth==3�� �־��µ�, �׸��ϸ� ������ 3�϶��� ans�� �߰����� ����
			return;
		}
		if(checkm()==true) { // �׷��� ���� ���� depth�� 3�ε� ������ ans�� �ʱ갪�̰� check�� ����Ѵٸ�
			if(ans>depth) {
				ans = depth; // ���� 3���� �������� ������
			}
		}
		if(depth==3) { // 3�Ѿ�� ������ �����ʵ��� ����������
			return; 
		}
		
		for(int i=1;i<H+1;i++) {
			for(int j=1;j<N;j++) {
				if(map[i][j]==0 && map[i][j+1]==0) {
					map[i][j] = 1;
					map[i][j+1] = 2;
					dfs(depth+1);
					map[i][j] = 0;
					map[i][j+1] = 0;
				}
			}
		}
	}

}
