package algorithmEx;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class bj_2583 {
	
	static int[][] flist;
	static int cnt = 0;
	static ArrayList<Integer> spacelist = new ArrayList<Integer>();

	public static void main(String[] args) {
		// ¸ğ´« Á¦ÀÛ
		// »öÄ¥x : 0, »öÄ¥O : 1
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		flist = new int [n][m];
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				flist[j][i] = 0;
			}
		}
		// Á÷»ç°¢Çü ±ò±â
		int k = sc.nextInt();
		for(int i=0; i<k; i++) {
			int[] list = new int[4];
			for(int j=0; j<list.length; j++) {
				int temp = sc.nextInt();
				list[j] = temp;
			}
			for(int a=list[0]; a<list[2]; a++) {
				for(int b=list[1]; b<list[3]; b++) {
					flist[a][b] = 1;
				}
			}
		}
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				cnt = 0;
				flist = change(j,i,flist);
				if(cnt != 0) {
					spacelist.add(cnt);
				}
			}
		}
		
		System.out.println(spacelist.size());
		Collections.sort(spacelist);
		for(int text : spacelist) {
			System.out.print(text);
			System.out.print(" ");
		}
		
	}
	
	public static int[][] change(int x, int y, int[][] list) {
		if(list[x][y] == 0) {
			list[x][y] = 1;
			cnt++;
			 	if(x+1<list.length && list[x+1][y] == 0)
					change(x+1,y,list);
				if(y+1<list[0].length && list[x][y+1] == 0)
					change(x,y+1,list);
				if(x-1>=0 && list[x-1][y] == 0)	
					change(x-1,y,list);
				if(y-1>=0 && list[x][y-1] == 0)
					change(x,y-1,list);
		}
		return list;
	}
	

}
