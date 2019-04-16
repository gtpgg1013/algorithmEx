package algorithmEx;

// 가지치기 안해주면 시간초과남
// 틀린이유는 64번째 줄을 보시오

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
		
		for(int i=0;i<M;i++) { // 기본 맵 설정
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
				} else { // 2일때
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
		if(depth>=ans) { // 맨처음에 이자리에 || depth==3을 넣었는데, 그리하면 정답이 3일때를 ans에 추가하지 못함
			return;
		}
		if(checkm()==true) { // 그래서 먼저 만약 depth가 3인데 아직도 ans가 초깃값이고 check를 통과한다면
			if(ans>depth) {
				ans = depth; // 값을 3으로 수정해준 다음에
			}
		}
		if(depth==3) { // 3넘어서는 루프가 돌지않도록 리턴쳐주자
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
