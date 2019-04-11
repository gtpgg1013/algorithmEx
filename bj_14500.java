package algorithmEx;

import java.util.*;

public class bj_14500 {
	
	static int N,M;
	static int ans = -500;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		check1();
		check2();
		check3();
		check4();
		check5();
		System.out.println(ans);
	}
	
	public static void check1() { // ¦���
		for(int i=0;i<N;i++) { // �����ִ°�
			for(int j=0;j<M-3;j++) {
				int temp = map[i][j] + map[i][j+1] + map[i][j+2] + map[i][j+3];
				if(temp>ans) {
					ans = temp;
				}
			}
		}
		
		for(int i=0;i<N-3;i++) { // ���ִ°�
			for(int j=0;j<M;j++) {
				int temp = map[i][j] + map[i+1][j] + map[i+2][j] + map[i+3][j];
				if(temp>ans) {
					ans = temp;
				}
			}
		}
	}
	
	public static void check2() { // �׸�
		for(int i=0;i<N-1;i++) { 
			for(int j=0;j<M-1;j++) {
				int temp = map[i][j] + map[i][j+1] + map[i+1][j] + map[i+1][j+1];
				if(temp>ans) {
					ans = temp;
				}
			}
		}
	}
	
	public static void check3() { // �⿪
		for(int i=0;i<N-2;i++) { // ��
			for(int j=0;j<M-1;j++) {
				int temp = map[i][j] + map[i+1][j] + map[i+2][j] + map[i+2][j+1];
				int temp2 = map[i][j+1] + map[i+1][j+1] + map[i+2][j+1] + map[i+2][j];
				temp = Math.max(temp, temp2);
				if(temp>ans) {
					ans = temp;
				}
			}
		}
		
		for(int i=0;i<N-1;i++) { // 
			for(int j=0;j<M-2;j++) {
				int temp = map[i][j] + map[i+1][j] + map[i][j+1] + map[i][j+2];
				int temp2 = map[i][j] + map[i][j+1] + map[i][j+2] + map[i+1][j+2];
				temp = Math.max(temp, temp2);
				if(temp>ans) {
					ans = temp;
				}
			}
		}
		
		for(int i=0;i<N-2;i++) { // ��
			for(int j=0;j<M-1;j++) {
				int temp = map[i][j] + map[i][j+1] + map[i+1][j+1] + map[i+2][j+1];
				int temp2 = map[i][j] + map[i][j+1] + map[i+1][j] + map[i+2][j];
				temp = Math.max(temp, temp2);
				if(temp>ans) {
					ans = temp;
				}
			}
		}
		
		for(int i=0;i<N-1;i++) { // 
			for(int j=0;j<M-2;j++) {
				int temp = map[i+1][j] + map[i+1][j+1] + map[i+1][j+2] + map[i][j+2];
				int temp2 = map[i+1][j] + map[i+1][j+1] + map[i+1][j+2] + map[i][j];
				temp = Math.max(temp, temp2);
				if(temp>ans) {
					ans = temp;
				}
			}
		}
	}
	
	public static void check4() { // �������
		for(int i=0;i<N-2;i++) { // ���ִ�
			for(int j=0;j<M-1;j++) {
				int temp = map[i][j] + map[i+1][j] + map[i+1][j+1] + map[i+2][j+1];
				int temp2 = map[i][j+1] + map[i+1][j+1] + map[i+1][j] + map[i+2][j];
				temp = Math.max(temp, temp2);
				if(temp>ans) {
					ans = temp;
				}
			}
		}
		
		for(int i=0;i<N-1;i++) { // �����ִ�
			for(int j=0;j<M-2;j++) {
				int temp = map[i+1][j] + map[i+1][j+1] + map[i][j+1] + map[i][j+2];
				int temp2 = map[i][j] + map[i][j+1] + map[i+1][j+1] + map[i+1][j+2];
				temp = Math.max(temp, temp2);
				if(temp>ans) {
					ans = temp;
				}
			}
		}
	}
	
	public static void check5() { // ��
		for(int i=0;i<N-1;i++) { // ��
			for(int j=0;j<M-2;j++) {
				int temp = map[i][j] + map[i+1][j+1] + map[i][j+1] + map[i][j+2];
				if(temp>ans) {
					ans = temp;
				}
			}
		}
		for(int i=0;i<N-2;i++) { // ��
			for(int j=0;j<M-1;j++) {
				int temp = map[i][j] + map[i+1][j] + map[i+2][j] + map[i+1][j+1];
				if(temp>ans) {
					ans = temp;
				}
			}
		}
		for(int i=0;i<N-2;i++) { // ��
			for(int j=0;j<M-1;j++) {
				int temp = map[i][j+1] + map[i+1][j+1] + map[i+2][j+1] + map[i+1][j];
				if(temp>ans) {
					ans = temp;
				}
			}
		}
		for(int i=0;i<N-1;i++) { // ��
			for(int j=0;j<M-2;j++) {
				int temp = map[i+1][j] + map[i+1][j+1] + map[i+1][j+2] + map[i][j+1];
				if(temp>ans) {
					ans = temp;
				}
			}
		}
	}

}
