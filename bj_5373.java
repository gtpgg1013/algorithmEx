package algorithmEx;

import java.util.*;

public class bj_5373 {
	
	static int N;
	static char[][] up = new char[3][3];
	static char[][] down = new char[3][3];
	static char[][] front = new char[3][3];
	static char[][] back = new char[3][3];
	static char[][] left = new char[3][3];
	static char[][] right = new char[3][3];
	// 각 평면의 체크기준은 위에서 아래로! 밑면은 뒤에서 앞으로 !

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				up[i][j] = 'w';
				down[i][j] = 'y';
				front[i][j] = 'r';
				back[i][j] = 'o';
				left[i][j] = 'g';
				right[i][j] = 'b';
			}
		}
		
		for(int i=0;i<N;i++) {
			int num = sc.nextInt();
			for(int j=0;j<num;j++) {
				String dir = sc.next();
				spin(dir);
			}
		}
	}
	
	public static char[][] wholeclockwise(char[][] map){
		char[][] temp = new char[3][3];
		temp[0][0] = map[2][0];
		temp[0][1] = map[1][0];
		temp[0][2] = map[0][0];
		temp[1][0] = map[2][1];
		temp[1][1] = map[1][1];
		temp[1][2] = map[0][1];
		temp[2][0] = map[2][2];
		temp[2][1] = map[1][2];
		temp[2][2] = map[0][2];
		
		return temp;
	}
	
	public static char[][] wholecntclockwise(char[][] map){
		char[][] temp = new char[3][3];
		temp[0][0] = map[0][2];
		temp[0][1] = map[1][2];
		temp[0][2] = map[2][2];
		temp[1][0] = map[0][1];
		temp[1][1] = map[1][1];
		temp[1][2] = map[2][1];
		temp[2][0] = map[0][0];
		temp[2][1] = map[1][0];
		temp[2][2] = map[2][0];
		
		return temp;
	}
	
	public static void leftovers(char[][] map1, char[][] map2, char[][] map3, char[][] map4) { // 써주는 순서대로 방향이 됨
		char[] t = new char[3];
		t[0] = map1[0][0];
		t[1] = map1[0][1];
		t[2] = map1[0][2];
		map1[0][0] = map2[0][0];
		map1[0][1] = map2[0][1];
		map1[0][2] = map2[0][2];
		map2[0][0] = map3[0][0];
		map2[0][1] = map3[0][1];
		map2[0][2] = map3[0][2];
		map3[0][0] = map4[0][0];
		map3[0][1] = map4[0][1];
		map3[0][2] = map4[0][2];
		map4[0][0] = t[0];
		map4[0][1] = t[1];
		map4[0][2] = t[2];
	}
	
//	public static void leftoverscntclockwise(char[][] map1, char[][] map2, char[][] map3, char[][] map4) {
//		char[] t = new char[3];
//		t[0] = map1[0][0];
//		t[1] = map1[0][1];
//		t[2] = map1[0][2];
//		map1[0][0] = map2[0][0];
//		map1[0][1] = map2[0][1];
//		map1[0][2] = map2[0][2];
//		map2[0][0] = map3[0][0];
//		map2[0][1] = map3[0][1];
//		map2[0][2] = map3[0][2];
//		map3[0][0] = map4[0][0];
//		map3[0][1] = map4[0][1];
//		map3[0][2] = map4[0][2];
//		map4[0][0] = t[0];
//		map4[0][1] = t[1];
//		map4[0][2] = t[2];
//	}
	
	public static void spin(String dir) { // + 바라보는거 기준 시계방향
		if(dir.equals("U+")) {
			char[][] temp = wholeclockwise(up); // 배열하나 만들고
			
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					up[i][j] = temp[i][j];
				}
			}
			
			leftovers(front,right,back,left);
			
//			char[] t = new char[3];
//			t[0] = front[0][0];
//			t[1] = front[0][1];
//			t[2] = front[0][2];
//			front[0][0] = right[0][0];
//			front[0][1] = right[0][1];
//			front[0][2] = right[0][2];
//			right[0][0] = back[0][0];
//			right[0][1] = back[0][1];
//			right[0][2] = back[0][2];
//			back[0][0] = left[0][0];
//			back[0][1] = left[0][1];
//			back[0][2] = left[0][2];
//			left[0][0] = t[0];
//			left[0][1] = t[1];
//			left[0][2] = t[2];
		}
		if(dir.equals("U-")) {
			char[][] temp = wholecntclockwise(up); // 배열하나 만들고
			
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					up[i][j] = temp[i][j];
				}
			}
			
			leftovers(front,left,back,right);
		}
		if(dir.equals("D+")) {
			
		}
		if(dir.equals("D-")) {
			
		}
		if(dir.equals("F+")) {
			
		}
		if(dir.equals("F-")) {
			
		}
		if(dir.equals("B+")) {
			
		}
		if(dir.equals("B-")) {
			
		}
		if(dir.equals("L+")) {
			
		}
		if(dir.equals("L-")) {
			
		}
		if(dir.equals("R+")) {
			
		}
		if(dir.equals("R-")) {
			
		}
	}

}
