package algorithmEx;

import java.util.ArrayList;
import java.util.*;

class xyd{
	private int x;
	private int y;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public xyd(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

public class bj_15865 {
	
	static int[][] list = new int[101][101];
	static ArrayList<xyd> dcl = new ArrayList<xyd>();
	static int M;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		for(int i=0;i<M;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int d = sc.nextInt();
			int g = sc.nextInt();
			makeDC(x, y, d, g);
//			System.out.println();
//			System.out.println();
//			printxy();
			for(int j=0;j<dcl.size();j++){
				xyd temp = dcl.get(j);
				list[temp.getY()][temp.getX()] = 1;
			}
			dcl.clear();
		}
		for(int i=0;i<101;i++) {
			for(int j=0;j<101;j++) {
				if(list[i][j]==1 && list[i+1][j]==1 && list[i][j+1]==1 && list[i+1][j+1]==1) {
					ans++;
				}
			}
		}
		System.out.println(ans);
	}
	
	public static void makeDC(int x, int y, int d, int g) {
		if(g-1>=0) {
			makeDC(x,y,d,g-1);
			int size = dcl.size();
			xyd temps = dcl.get(size-1);
			int tx = temps.getX();
			int ty = temps.getY();
			for(int i=0;i<size-1;i++) {
				xyd tempd = dcl.get(size-2-i);
				int dx = tempd.getX();
				int dy = tempd.getY();
				int newx = ty - dy + tx;
				int newy = ty - (tx - dx);
				dcl.add(new xyd(newx, newy));
			}
			return;
		} else {
			if(g==0) {
				dcl.add(new xyd(x,y));
				if(d==0) {
					dcl.add(new xyd(x+1,y));
				} else if(d==1) {
					dcl.add(new xyd(x,y-1));
				} else if(d==2) {
					dcl.add(new xyd(x-1,y));
				} else {
					dcl.add(new xyd(x,y+1));
				}
			}
		}
	}
	
	public static void printxy() {
		for(int i=0;i<dcl.size();i++) {
			xyd temp = dcl.get(i);
			int x = temp.getX();
			int y = temp.getY();
			System.out.println(x+" "+y);
		}
	}

}
