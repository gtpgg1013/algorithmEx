package algorithmEx;

// Ʋ�� ���� : ���� ����ġ�⸦ �Ѵٰ� stop ���������� �����ߴٰ� �߸��� ��� ���� - ��, ���࿡ 3�� ������ stop�� true�� ���������� ������
// dfs�� �����ϴٰ� �� ���� ���ڰ� ��������� �����ع��ȱ� ������ ���� Ʋ�ȴ�.

import java.util.*;

class Po {
	int y;
	int x;
	int isOccupied;
	public Po(int y, int x, int isOccupied) { // isO = 0 �����, 1 ��������������, ������
		this.y = y;
		this.x = x;
		this.isOccupied = isOccupied;
	}
}

public class bj_15684 {
	
	static int N,M,H;
	static Po[][] map;
	static boolean ck0 = false;
	static boolean ck1 = false;
	static boolean ck2 = false;
	static boolean ck3 = false;
	static boolean stop = false;
			
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		H = sc.nextInt();
		map = new Po[H+2][N+2]; // ������ �����°� �����Ƽ�
		for(int i=0;i<H+2;i++) { // �����δ� 1~H / 1~N�� ������!
			for(int j=0;j<N+2;j++) { // N+1 �����ϸ� �������°� ����
				map[i][j] = new Po(i,j,0);
			}
		}
		for(int i=0;i<M;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			map[a][b].isOccupied = 1;
			map[a][b+1].isOccupied = 2;
		}
//		printOc(map);
		System.out.println(solve());
	}
	public static int solve() {
		
//		for(int i=1;i<H+1;i++) { // 1���� ���� ��
//			for(int j=1;j<N;j++) {
//				if(map[i][j].isOccupied==0 && map[i][j+1].isOccupied==0) {
//					Po[][] tempmap = new Po[H+2][N+2];
//					for(int a=0;a<H+2;a++) {
//						for(int b=0;b<N+2;b++) {
//							tempmap[a][b] = new Po(map[a][b].y,map[a][b].x,map[a][b].isOccupied);
//						}
//					}
//					tempmap[i][j].isOccupied = 1;
//					tempmap[i][j+1].isOccupied = 2;
//					if(check(tempmap)==true) {
//						return 1;
//					}
//				}
//			}
//		}
//		
		dfs(0,map); // 2�� ���� ��
		
		if(ck0==true) { // �ƹ��͵� �ȳ�����
			return 0;
		}
		if(ck1==true) {
			return 1;
		}
		if(ck2==true) {
			return 2;
		}
		if(ck3==true) {
			return 3;
		}
		
		return -1;
	}
	
	public static void dfs(int depth, Po[][] tmap) {
//		if(stop==true) return;
//		System.out.println(depth);
//		printOc(tmap);
		if(depth==0) {
			if(check(tmap)==true) {
				ck0 = true;
//				stop = true;
				return;
			}
		}
		if(ck0==true) return;
		if(depth==1) {
			if(check(tmap)==true) {
				ck1 = true;
//				stop = true;
				return;
			}
		}
		if(ck1==true) return;
		if(depth==2) {
			if(check(tmap)==true) {
				ck2 = true;
//				stop = true;
				return;
			}
		}
		if(ck2==true) return;
		if(depth==3) {
			if(check(tmap)==true) {
				ck3 = true;
//				stop = true;
			}
			return;
		}		
		if(ck3==true) return;
		
		for(int i=1;i<H+1;i++) {
			for(int j=1;j<N;j++) {
				if(tmap[i][j].isOccupied==0 && tmap[i][j+1].isOccupied==0) {
//					Po[][] tempmap = new Po[H+2][N+2];
//					for(int a=0;a<H+2;a++) {
//						for(int b=0;b<N+2;b++) {
//							tempmap[a][b] = new Po(tmap[a][b].y,tmap[a][b].x,tmap[a][b].isOccupied);
//						}
//					}
//					tempmap[i][j].isOccupied = 1;
//					tempmap[i][j+1].isOccupied = 2;
					tmap[i][j].isOccupied = 1;
					tmap[i][j+1].isOccupied = 2;
					dfs(depth+1, tmap);
					tmap[i][j].isOccupied = 0;
					tmap[i][j+1].isOccupied = 0;
				}
			}
		}
	}
	
	public static boolean check(Po[][] tmap) { // ����ϸ� true
//		printOc(tmap);
		boolean ans = true;
		for(int i=1;i<N+1;i++) {
			Po temp = tmap[1][i];
			while(temp.y<H+1) {
				if(temp.isOccupied==0) {
					temp = tmap[temp.y+1][temp.x];
				} else {
					if(temp.isOccupied==1) {
						temp = tmap[temp.y+1][temp.x+1];
					} else {
						temp = tmap[temp.y+1][temp.x-1];
					}
				}
			}
			if(i!=temp.x) {
				ans = false;
				break;
			}
		}
		return ans;
	}
	
	public static void printOc(Po[][] tmap) {
		for(int i=0;i<H+2;i++) { // �����δ� 1~H / 1~N�� ������!
			for(int j=0;j<N+2;j++) { // N+1 �����ϸ� �������°� ����
				System.out.print(tmap[i][j].isOccupied+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	

}
