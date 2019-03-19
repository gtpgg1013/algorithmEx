package algorithmEx;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

class count_x{
	int count;
	int x;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public count_x(int count, int x) {
		super();
		this.count = count;
		this.x = x;
	}
	public count_x() {}
}

public class bj_1463 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		
		int[] list = new int[1000001];
		for(int i=0;i<list.length;i++) {
			list[i]=-1;
		}
		list[1] = 0;
		
		Queue<count_x> q = new LinkedList<count_x>();
		count_x front = new count_x(0,1);
		q.offer(front);
		
		while(!q.isEmpty()) {
			count_x cx = q.poll();
			int nowcount = cx.getCount();
			int nowx = cx.getX();
			if(nowx+1>=1 && nowx+1<=1000000 && list[nowx+1]==-1) {
				count_x temp = new count_x(nowcount+1,nowx+1);
				list[nowx+1] = nowcount+1;
				q.offer(temp);
			}
			if(nowx*2>=1 && nowx*2<=1000000 && list[nowx*2]==-1) {
				count_x temp = new count_x(nowcount+1, nowx*2);
				list[nowx*2] = nowcount+1;
				q.offer(temp);
			}
			if(nowx*3>=1 && nowx*3<=1000000 && list[nowx*3]==-1) {
				count_x temp = new count_x(nowcount+1, nowx*3);
				list[nowx*3] = nowcount+1;
				q.offer(temp);
			}
			if(nowx==m) {
				System.out.print(nowcount);
				break;
			}
		}
		
	}

}
